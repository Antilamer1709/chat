import { Component, OnInit } from '@angular/core';
import {DialogLoginComponent} from "./dialog-login/dialog-login.component";
import {MatDialog, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  dialogRef: MatDialogRef<DialogLoginComponent> | null;
  defaultDialogUserParams: any = {
    disableClose: true,
    data: {
      title: 'Log in'
    }
  };

  constructor(public dialog: MatDialog) {
  }

  ngOnInit() {
    setTimeout(() => {
      this.openUserPopup(this.defaultDialogUserParams);
    }, 0);
  }

  private openUserPopup(params): void {
    this.dialogRef = this.dialog.open(DialogLoginComponent, params);
    this.dialogRef.afterClosed().subscribe(paramsDialog => {

    });
  }

}
