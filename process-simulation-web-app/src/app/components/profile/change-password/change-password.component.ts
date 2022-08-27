import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  passwordGroup: FormGroup = new FormGroup({
    newPassword: new FormControl('', [Validators.required, Validators.min(3) ]),
    repeatedPassword: new FormControl('', [Validators.required, Validators.min(3) ]),
    current: new FormControl('', [Validators.required, Validators.min(3) ])
  });
  constructor(public dialogRef: MatDialogRef<ChangePasswordComponent>, private snackbar: MatSnackBar) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
  readonly changePassword = () => {
    console.log('Password changed');
    this.snackbar.open('Password changed!');
    this.dialogRef.close();
  }
}
