import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/model/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';
import { IEmpolyee } from 'src/app/interfaces/IEmployee';


@Component({
  selector: 'app-workers',
  templateUrl: './workers.component.html',
  styleUrls: ['./workers.component.css']
})
export class WorkersComponent implements OnInit {
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  workers: any;
  obs: Observable<any> | undefined;
  dataSorce: MatTableDataSource<Employee> = new MatTableDataSource<Employee>();

  startNumber: number= 8;
  size: number=0;
  constructor(private employeeSevice: EmployeeService) { }

  ngOnInit(): void {
    this.employeeSevice.getEmployees().subscribe(
      res=> { 
      
       
       this.workers= res; 
       this.dataSorce =  new MatTableDataSource<Employee>(this.workers);
   this.dataSorce.paginator =this.paginator;
    console.log(this.paginator);
    this.obs = this.dataSorce.connect();
       }

    )

  }
  ngAfterViewInit() {
     this.dataSorce.paginator =this.paginator;
    console.log(this.paginator);
    this.obs = this.dataSorce.connect();
  }
  readonly search= (event: any) => 
  console.log("search")

  readonly getEmployees =()=> {
    this.employeeSevice.getEmployees().subscribe(
       res=> { 
        this.workers =new MatTableDataSource<Employee>();
        
        this.workers= res;console.log(this.workers)
        this.workers.paginator = this.paginator;
        console.log(this.paginator)
       // this.size = this.workers.length
      })
  }

  readonly onPageChange=(event: PageEvent)=>{
    //this.startNumber = event.pageSize;
    this.getEmployees();
  }
}
