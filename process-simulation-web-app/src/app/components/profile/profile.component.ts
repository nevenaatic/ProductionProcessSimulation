import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'
import { ChangePasswordComponent } from './change-password/change-password.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
editMode: boolean= false;
  constructor( private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  readonly edit = () =>{
    this.editMode = true
  }
  readonly cancelChanges = () =>{
    this.editMode = false
  }
  readonly saveChanges = () =>{
    this.editMode = false
  }

  readonly openDialog=() => {
    const dialogRef =  this.dialog.open(ChangePasswordComponent, {
      height: '350px',
      width: '400px',
    })
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

}
