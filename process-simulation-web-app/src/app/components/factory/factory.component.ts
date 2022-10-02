import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FactoryService } from 'src/app/services/factory.service';

@Component({
  selector: 'app-factory',
  templateUrl: './factory.component.html',
  styleUrls: ['./factory.component.css']
})
export class FactoryComponent implements OnInit {

  factory: any;
editMode: boolean= false;
factoryForm = new FormGroup({
  name: new FormControl('', [Validators.required]),
  description: new FormControl('', [Validators.required]),
  email: new FormControl('', [Validators.required, Validators.email]),
  telephone: new FormControl('', [Validators.required]),
  street: new FormControl('', [Validators.required]),
  number: new FormControl('', [Validators.required]),
  city: new FormControl('', [Validators.required]),
  country: new FormControl('', [Validators.required]),
  pib : new FormControl('', [Validators.required]),
  year: new FormControl('', [Validators.required]),
})

  constructor(private factoryService: FactoryService, private snackbar: MatSnackBar) { }

  ngOnInit(): void {
    this.getFactory();
  }

  public readonly getFactory=()=>{
     this.factoryService.getFactory().subscribe(res => {
       this.factory = res;
     })
  }
showEdit(){
  this.editMode = true;
  this.patchForm()
}
  edit(){
    this.getValues()
    this.factoryService.editFactory(this.factory).subscribe( res => {
        this.factory = res;
        this.snackbar.open("Informacije izmenjene!");
        this.editMode = false;
    })
  }
  get controls(){
    return this.factoryForm.controls;
  }
  private readonly patchForm = () => {
    this.controls.name.patchValue(this.factory.name);
    this.controls.description.patchValue(this.factory.description);
    this.controls.telephone.patchValue(this.factory.telephone);
    this.controls.email.patchValue(this.factory.email);
    this.controls.street.patchValue(this.factory.address.street);
    this.controls.number.patchValue(this.factory.address.number);
    this.controls.city.patchValue(this.factory.address.city);
    this.controls.country.patchValue(this.factory.address.country);
    this.controls.pib.patchValue(this.factory.pib);
    this.controls.year.patchValue("1994.");
};
private readonly getValues = () => {
  this.factory.name = this.controls.name.value;
  this.factory.telephone= this.controls.telephone.value;
};

}
