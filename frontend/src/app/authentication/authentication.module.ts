import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import {LoginService} from "./login/login.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DialogLoginComponent} from "./login/dialog-login/dialog-login.component";
import {MaterialModule} from "../shared/material/material.module";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  declarations: [LoginComponent, DialogLoginComponent],
  providers: [LoginService],
  entryComponents: [DialogLoginComponent]
})
export class AuthenticationModule { }
