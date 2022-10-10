import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-new-worker-dialog',
  templateUrl: './new-worker-dialog.component.html',
  styleUrls: ['./new-worker-dialog.component.css']
})
export class NewWorkerDialogComponent implements OnInit {
 newWorker:FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required]),
    surname: new FormControl('', [Validators.required]),
    birthday: new FormControl<Date | undefined>(undefined),
    email: new FormControl('', [Validators.required, Validators.email]),
    telephone: new FormControl('', [Validators.required]),
    street: new FormControl('', [Validators.required]),
    number: new FormControl('', [Validators.required]),
    city: new FormControl('', [Validators.required]),
    country: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required]),
    gender: new FormControl('')
  })

  gender: any
createWorker() {
  this.snackbar.open("Novi radnik je zaposlen!")
   this.dialogRef.close();
}
onNoClick() {
  this.dialogRef.close();
}

  constructor(public dialogRef: MatDialogRef<NewWorkerDialogComponent>, private snackbar: MatSnackBar) { }

 

  ngOnInit(): void {
  }

}
