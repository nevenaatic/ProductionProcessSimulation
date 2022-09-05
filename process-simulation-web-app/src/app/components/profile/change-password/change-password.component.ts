import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import Validation from 'src/app/model/validation';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  falsePassword: boolean = false;
  passwordGroup: FormGroup = new FormGroup({
    newPassword: new FormControl('', [Validators.required, Validators.min(3)]),
    current: new FormControl('', [Validators.required, Validators.min(3)]),
    repeatedPassword: new FormControl('', [Validators.required, Validators.min(3)])
  }, {
    validators: [Validation.match('newPassword', 'repeatedPassword')]
  });
  submitted = false;
  constructor(public dialogRef: MatDialogRef<ChangePasswordComponent>, private snackbar: MatSnackBar, private userService: UserService) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.submitted = false;
    this.passwordGroup.reset();
    this.dialogRef.close();
  }
  readonly changePassword = () => {
    this.submitted = true;
    // if (this.passwordGroup.invalid) {
    //   return;
    // }
    return this.userService.changePassword(this.passwordGroup.controls['newPassword'].value!).subscribe(
      res => {
        localStorage.setItem("accessToken", res.accessToken);
        localStorage.setItem("role", res.role);
        this.snackbar.open('Password changed!');
        this.dialogRef.close();
      },
      err => {
        console.log(err)
      }
    );
  }

  readonly checkPassword = () => {
    this.userService.checkPassword(this.passwordGroup.controls['current'].value!).subscribe(
      res => {
        this.falsePassword = false;
      },
      err => {
        this.falsePassword = true;
        console.log(this.falsePassword)
      });
  }
}

