import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {HttpModule} from '@angular/http';
import {RouterModule} from  '@angular/router';
import {routes} from './app.routes';
import {WelcomeComponent} from './welcome/welcome.componet';
import {DepartmentModule} from './department/department.module';
import {EmployeeModule} from './employee/employee.module';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(routes),
    DepartmentModule,
    EmployeeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
