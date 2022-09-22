import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { Observable } from 'rxjs';
import { FinalProcessService } from 'src/app/services/final-process.service';
import { ProcessService } from 'src/app/services/process.service';
import { NewProcessDialogComponent } from './new-process-dialog/new-process-dialog.component';

@Component({
  selector: 'app-process',
  templateUrl: './process.component.html',
  styleUrls: ['./process.component.css']
})
export class ProcessComponent implements OnInit, OnDestroy {
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  obs: Observable<any> | undefined;
  unfinishedList: any;
  showFinished: boolean= false;

  constructor(private processService: ProcessService,private dialog: MatDialog, 
    private finalProcessService: FinalProcessService, private snackbar: MatSnackBar) { }

  ngOnInit(): void {
    this.getUnfinishedProcesses();
  }

  ngOnDestroy(): void {
    if (this.unfinishedList) { 
      this.unfinishedList.disconnect(); 
    }
  }

  readonly createNewProcess=() => {
    const dialogRef =  this.dialog.open(NewProcessDialogComponent,{
      height: 'max-content',
      width: '400px',
    })
    dialogRef.afterClosed().subscribe(result => {
      this.getUnfinishedProcesses()
    });
  }
  
  public readonly getUnfinishedProcesses = () => this.processService.getUnfinishedProcesses()
    .subscribe(res => {
      const allProcesses = res;
      this.unfinishedList =  new MatTableDataSource<any>(allProcesses);;
      this.unfinishedList.paginator = this.paginator;
      this.obs = this.unfinishedList.connect();
    });

    public readonly showFinishedProcesses = () => this.showFinished = true;

    public readonly back = () => this.showFinished = false;

    public readonly startProcess = (id: number) => {
      this.finalProcessService.startProcess(id).subscribe( 
        res => { console.log(res); 
        this.snackbar.open('Simulation done!')});
    }
    public readonly startFailedProcess = (id: number) => {
      this.finalProcessService.startFailedProcess(id).subscribe( 
        res => { console.log(res); 
        this.snackbar.open('Simulation done!')});
    }
}
