import {Component, OnInit} from '@angular/core';
import {Employee} from './employee';
import {Http} from '@angular/http';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Department} from '../../department/main-department/department';
@Component({
  selector: 'app-main-employee-component',
  templateUrl: './main.employee.component.html',
  styleUrls: ['main.employee.component.css']
})
export class MainEmployeeComponent implements OnInit {

  employeeForm: FormGroup;

  employee: Employee = new Employee();

  employees: Employee [] = [];

  departments: Department [] = [];

  page = {
    currentPage: 1,
    size: 10,
    count: 0,
    search: ''
  };

  pages = [];

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

  ngOnInit(): void {
    this.buildForm();
    this.refresh();
    this.http.get('/api/departments').subscribe(
      result => this.departments = result.json(),
      error => console.log(error));
  }

  deleteEmployee(id: number): void {
    this.http.delete('/api/employees/' + id).subscribe(
      result => {
        if (result.json() === 'OK') {
          this.refresh();
        }
      },
      error => console.log(error)
    );
  }

  loadEmployee(empl: Employee): void {
    this.employee = empl;
    this.buildForm();
  }

  buildParam(): string {
    const param = '?page=' + this.page.currentPage + '&size=' + this.page.size;
    if (this.page.search) {
      return param + '&search=' + this.page.search;
    }
    return param;
  }

  refresh(): void {
    this.http.get('/api/employees' + this.buildParam()).subscribe(
      result => {
        const res = result.json();
        this.employees = res.content;
        this.page.count = res.totalPages;
        this.pages = [];
        for (let i = 1; i <= this.page.count; i++) {
          this.pages.push(i);
        }
      },
      error => console.log(error));
  }

  onPageChange(page: number): void {
    if (page > 0 && page <= this.page.count) {
      this.page.currentPage = page;
      this.refresh();
    }
  }

  save(form): void {
    const obj = {
      id: form.value.id,
      name : form.value.name,
      active : form.value.active,
      department : form.value.department
    }

    console.log(obj);

    this.http.post('/api/employees', obj).subscribe(
      result => {
        if (result.json() === 'OK') {
          this.refresh();
          this.employee = new Employee();
          this.buildForm();
        }
      },
      error => console.log(error));
  }

  private buildForm() {
    this.employeeForm = this.fb.group({
      id: [this.employee.id],
      name: [this.employee.name, [Validators.required]],
      active: [this.employee.active],
      department: [this.employee.department]
    });
    this.employeeForm.valueChanges.subscribe(data => this.onValueChange());
    this.onValueChange();
  }

  onValueChange() {
    if (!this.employeeForm) {
      return;
    }
    const form = this.employeeForm;

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
    this.employee = new Employee();
    this.buildForm();
  }
}
