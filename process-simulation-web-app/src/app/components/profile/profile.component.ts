import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
editMode: boolean= false;
  constructor() { }

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
}
