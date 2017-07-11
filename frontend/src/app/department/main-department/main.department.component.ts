import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Department} from './department';
import {Http} from '@angular/http';
@Component({
  selector: 'app-main-department-component',
  templateUrl: 'main.department.component.html',
  styleUrls: ['main.department.component.css']
})
export class MainDepartmentComponent implements OnInit {

  departmentForm: FormGroup;
  department: Department = new Department();

  departments: Department [] = [];

  formErrors = {
    name: '',
  };

  validationMessages = {
    name: {
      'required': 'обов*язкове поле'
    },
  };

  constructor(private fb: FormBuilder, private http: Http) {
  }

  ngOnInit() {
    this.buildForm();
    this.load();
  };

  load(): void {
    this.http.get('/api/departments').subscribe(
      result => this.departments = result.json(),
      error => console.log(error));
  }

  save(form) {
    const obj = {
      id: form.value.id,
      name: form.value.name
    };

    console.log('save');
    console.log(obj);

    this.http.post('/api/departments', obj).subscribe(
      result => {
        if (result.json() === 'OK') {
          this.department = new Department();
          this.buildForm();
          this.load();
        }
      },
      error => console.log(error)
    );
  }


  delete(id: number): void {
    this.http.delete('/api/departments/' + id).subscribe(
      result => {
        if (result.json() === 'OK') {
          this.load();
        }
      }
    );
  }

  loadDepartment(dep: Department): void {
    console.log(dep);
    this.department = dep;
    this.buildForm();
  }


  private buildForm() {
    this.departmentForm = this.fb.group({
      id: [this.department.id],
      name: [this.department.name, [
        Validators.required
      ]],
    });
    this.departmentForm.valueChanges.subscribe(data => this.onValueChange());
    this.onValueChange();
  }

  onValueChange() {
    if (!this.departmentForm) {
      return;
    }
    ;
    const form = this.departmentForm;

    for (const field in this.formErrors) {
      this.formErrors[field] = '';
      const control = form.get(field);

      if (control && control.dirty && !control.valid) {
        const message = this.validationMessages[field];
        for (const key in control.errors) {
          this.formErrors[field] += message[key] + '';
        }
      }
    }
  }

  cancel(): void {
    this.department = new Department();
    this.buildForm();
  }


}
