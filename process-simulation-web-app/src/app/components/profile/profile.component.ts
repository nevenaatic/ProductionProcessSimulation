import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog'
import { ChangePasswordComponent } from './change-password/change-password.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
editMode: boolean= false;
isImageSaved: boolean = false;
cardImageBase64: string = '';
  image: any;

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

  CreateBase64String(fileInput: any) {
    if (fileInput.target.files && fileInput.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        const image = new Image();
        image.src = e.target.result;
        image.onload = rs => {
          const imgBase64Path = e.target.result;
          this.cardImageBase64 = imgBase64Path;
          this.isImageSaved = true;
          console.log(imgBase64Path);
        //  this.image = imgBase64Path;
        };
      };
      reader.readAsDataURL(fileInput.target.files[0]);
    }
  }

}
