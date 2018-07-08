import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import {FormControl, FormGroup, Validators} from '@angular/forms';

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

  constructor(public dialogRef: MatDialogRef<DialogLoginComponent>,
              @Inject(MAT_DIALOG_DATA) public params: any) {
  }

  ngOnInit() {
  }

  public onLogIn(): void {
    console.log(this.loginForm);

    if (this.loginForm.valid) {
      this.dialogRef.close({
        username: this.params.username
      });
    }
  }
}
