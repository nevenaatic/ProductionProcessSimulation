import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Failure } from 'src/app/model/Failure.model';
import { FailureService } from 'src/app/services/failure.service';
import { ProcessStepsService } from 'src/app/services/process-steps.service';

@Component({
  selector: 'app-new-failure-dialog',
  templateUrl: './new-failure-dialog.component.html',
  styleUrls: ['./new-failure-dialog.component.css']
})
export class NewFailureDialogComponent implements OnInit {

  newFailure: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.min(3) ]),
    probability: new FormControl('',[Validators.required]),
    processStepId: new FormControl(''),
    type: new FormControl('')
  });
  id: number=0;
  processSteps: any;
  constructor(private processStepService : ProcessStepsService,private failureService: FailureService,
     public dialogRef: MatDialogRef<NewFailureDialogComponent>, private snackbar: MatSnackBar) { }

  ngOnInit(): void {
    this.loadProcessSteps();
  }

  loadProcessSteps(){
    this.processStepService.getProcessSteps().subscribe( res=> {this.processSteps = res})
  }

addStep(idStep: number) {
this.id = idStep;
}

createFailure() {
const failure = new Failure();
failure.id = this.id;
failure.name = this.newFailure.controls['name'].value;
failure.probability = this.newFailure.controls['probability'].value
failure.type = this.newFailure.controls['type'].value;
console.log(failure)
this.failureService.newStepFailure(failure).subscribe( res=> {
  this.snackbar.open('New step failure added');
  this.dialogRef.close();
})

}
onNoClick() {
  this.dialogRef.close();
}

}
