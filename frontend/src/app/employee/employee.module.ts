import {NgModule} from '@angular/core';
import {MainEmployeeComponent} from './main-employee/main-employee.component';
import {RouterModule} from '@angular/router';
import {routes} from './employee.routes';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
@NgModule({
  declarations: [MainEmployeeComponent],
  imports: [RouterModule.forChild(routes),ReactiveFormsModule, FormsModule, BrowserModule],
  providers: []
})
export class EmployeeModule {

}
