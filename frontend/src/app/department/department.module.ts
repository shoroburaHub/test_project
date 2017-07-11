import {NgModule} from '@angular/core';
import {MainDepartmentComponent} from './main-department/main.department.component';
import {RouterModule} from '@angular/router';
import {routes} from './department.routes';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
@NgModule({
  declarations: [MainDepartmentComponent],
  imports: [RouterModule.forChild(routes), ReactiveFormsModule, FormsModule, BrowserModule],
  providers: []
})
export class DepartmentModule { }
