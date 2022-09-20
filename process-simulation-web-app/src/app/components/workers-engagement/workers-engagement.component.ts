import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { EngagementService} from 'src/app/services/engagement.service'
import { ProcessService} from 'src/app/services/process.service'
import { EmployeeService} from 'src/app/services/employee.service';
import { EngagementRequest} from 'src/app/model/EngagementRequest.model';
import { Observable } from 'rxjs';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-workers-engagement',
  templateUrl: './workers-engagement.component.html',
  styleUrls: ['./workers-engagement.component.css']
})
export class WorkersEngagementComponent implements OnInit {
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  obs: Observable<any> | undefined;
  engagementGroup: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.min(3)]),
    from: new FormControl(''),
    to: new FormControl('')
  });
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource:any
  workersList: any;
  engagementsList: any;
  sizeList: number=0;
processesList: any;
engagementReq = new EngagementRequest();
  constructor(private processService: ProcessService, private employeeService: EmployeeService,
    private engagementService : EngagementService ) { }

  ngOnInit(): void {

    this.getProcesses();
    this.getWorkers();
  }


  setWorker(id: number) {
    this.engagementReq.idEmployee = id;
  }
  // setProcess(id: number) {
    
  // }
  getProcesses(){
    this.processService.getUnfinishedProcesses().subscribe(res=> {this.processesList = res;})
  }
  getWorkers(){
    this.employeeService.getEmployees().subscribe( res=> { this.workersList = res;})
  }

  checkEngagement() {
this.engagementReq.from = this.engagementGroup.controls['from'].value;
this.engagementReq.to =  this.engagementGroup.controls['to'].value;
this.engagementService.getEngagement(this.engagementReq).subscribe( res=>
   { const data = res;
    this.engagementsList =  new MatTableDataSource<any>(data); 
   this.engagementsList.paginator = this.paginator;
   this.obs = this.engagementsList.connect();
    console.log(this.engagementsList);
    this.sizeList = this.engagementsList.length;
  })
  }
}
