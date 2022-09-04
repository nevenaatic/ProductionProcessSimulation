import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog'
import { MatSnackBar } from '@angular/material/snack-bar';
import { IUser } from 'src/app/model/IUser';
import { User } from 'src/app/model/User.model';
import { UserService } from 'src/app/services/user.service';
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
user = new User();
userForm = new FormGroup({
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
})
  constructor(private userService: UserService, private dialog: MatDialog, private snackbar: MatSnackBar) { }

  ngOnInit(): void {
    this.loadUserInfo();
  }

get controls(){
    return this.userForm.controls;
  }

  readonly loadUserInfo = () => this.userService.getProfileInfo().subscribe( res => { this.user = res;console.log(this.user);});

  
  private readonly patchForm = () => {
    this.controls.name.patchValue(this.user.name);
    this.controls.surname.patchValue(this.user.surname);
    this.controls.birthday.patchValue(this.user.birthday);
    this.controls.telephone.patchValue(this.user.telephone);
    this.controls.email.patchValue(this.user.email);
    this.controls.street.patchValue(this.user.address.street);
    this.controls.number.patchValue(this.user.address.number);
    this.controls.city.patchValue(this.user.address.city);
    this.controls.country.patchValue(this.user.address.country);
};

  readonly edit = () =>{
    this.editMode = true;
  this.patchForm();
  }
  readonly cancelChanges = () =>{
    this.editMode = false
  }
  readonly saveChanges = () =>{
   this.updateUserInfo();
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

  readonly CreateBase64String = (fileInput: any) => {
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
        this.user.profilePhoto = imgBase64Path;
        };
      };
      reader.readAsDataURL(fileInput.target.files[0]);
    }
  }

  public readonly updateUserInfo = () => {
    this.user.name = this.controls.name.value!;
    this.user.surname = this.controls.surname.value!;
    this.user.birthday = this.controls.birthday.value!;
    this.user.telephone = this.controls.telephone.value!;
    this.user.address.street = this.controls.street.value!;
    this.user.address.number = this.controls.number.value!;
    this.user.address.city = this.controls.city.value!;
    this.user.address.country = this.controls.country.value!;
    console.log(this.user)
   return this.userService.updateUserInfo(this.user).subscribe(
       res => { this.snackbar.open("Personal informations updated");
     this.editMode = false; console.log(res) },
     err=> {
      this.snackbar.open("Updating failed")
     });
  }
}
