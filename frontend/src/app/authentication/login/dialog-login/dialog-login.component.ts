import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthenticationService} from "../../authentication.service";
import {LoginService} from "../login.service";
import {UserDTO} from "../../authentication-model";
import {Router} from "@angular/router";

@Component({
  selector: 'dialog-login',
  templateUrl: './dialog-login.component.html',
  styleUrls: ['./dialog-login.component.css']
})
export class DialogLoginComponent implements OnInit {

  loginForm = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  public user: UserDTO;

  constructor(public dialogRef: MatDialogRef<DialogLoginComponent>,
              @Inject(MAT_DIALOG_DATA) public params: any,
              private authenticationService: AuthenticationService,
              private loginService: LoginService,
              private router: Router) {
  }

  ngOnInit() {
    this.user = new UserDTO();
  }

  public onLogIn(): void {
    console.log(this.loginForm);

    if (this.loginForm.valid) {
      this.loginService.authenticate(this.user).subscribe(
        (res) => {
          console.log(res);
          this.authenticationService.loggedUser = res;
          this.router.navigate(['/']);
          this.dialogRef.close({});
        }
      );
    }
  }
}
