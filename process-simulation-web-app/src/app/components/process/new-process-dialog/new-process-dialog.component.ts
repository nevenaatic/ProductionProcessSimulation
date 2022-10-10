import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NewProcess } from 'src/app/model/NewProcess.model';
import { NewProcessStep } from 'src/app/model/NewProcessStep.model';
import { ProcessStep } from 'src/app/model/ProcessStep.model';
import { ProcessStepsService } from 'src/app/services/process-steps.service';
import { ProcessService } from 'src/app/services/process.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-new-process-dialog',
  templateUrl: './new-process-dialog.component.html',
  styleUrls: ['./new-process-dialog.component.css']
})
export class NewProcessDialogComponent implements OnInit {
  newProcess: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.min(3) ]),
    processDescription: new FormControl(''),
    stepDescription: new FormControl(''),
  });
  description: string=""
  stepKindList: any;
  productList: any;
  selectedStep: any;
  process = new NewProcess();

  constructor(public dialogRef: MatDialogRef<NewProcessDialogComponent>,
    private snackbar: MatSnackBar, 
    private processStepService: ProcessStepsService,
    private productService: ProductService, 
    private processService: ProcessService) { }

  ngOnInit(): void {
  this.getStepKinds();
  this.getProducts();
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
  readonly createProcess = () => {
    this.process.name = this.newProcess.controls['name'].value
    this.process.description = this.newProcess.controls['processDescription'].value
    this.processService.createNewProcess(this.process).subscribe(res=> {
       this.snackbar.open('Novi proces uspešno kreiran!');
        this.dialogRef.close();
    }, 
    err=>{
      console.log(err);
      this.snackbar.open('Something went wrong, try again later');
    } )
   
  }

  readonly getStepKinds = ()=>
    this.processStepService.getStepKinds().subscribe(res=> {this.stepKindList = res;})
  
  readonly getProducts = ()=> 
    this.productService.getAllProducts().subscribe(res=> {this.productList = res;})


  readonly addProcessStep = () => {
    console.log(this.newProcess.controls['stepDescription'].value)
    const step = new NewProcessStep(this.selectedStep.name, this.newProcess.controls['stepDescription'].value, this.selectedStep.id, this.selectedStep.number);
    this.process.processSteps.push(step);
    this.newProcess.controls['stepDescription'].setValue("")
  }

  readonly addStepKind = (selected: any) => this.selectedStep = selected;


  readonly addProduct=(id: number)=> this.process.productId = id; 
 
}
