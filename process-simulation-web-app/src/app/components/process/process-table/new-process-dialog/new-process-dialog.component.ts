import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-new-process-dialog',
  templateUrl: './new-process-dialog.component.html',
  styleUrls: ['./new-process-dialog.component.css']
})
export class NewProcessDialogComponent implements OnInit {
  newProcess: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.min(3) ]),
    repeatedPassword: new FormControl('', [Validators.required, Validators.min(3) ]),
    current: new FormControl('', [Validators.required, Validators.min(3) ])
  });
  
  constructor(public dialogRef: MatDialogRef<NewProcessDialogComponent>,private snackbar: MatSnackBar) { }

  ngOnInit(): void {
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
  readonly createProcess = () => {
    console.log('Process created');
    this.snackbar.open('Process created!');
    this.dialogRef.close();
  }
}
