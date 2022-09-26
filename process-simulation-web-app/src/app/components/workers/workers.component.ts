import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/model/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';
import { NewWorkerDialogComponent } from './new-worker-dialog/new-worker-dialog.component';


@Component({
  selector: 'app-workers',
  templateUrl: './workers.component.html',
  styleUrls: ['./workers.component.css']
})
export class WorkersComponent implements OnInit, OnDestroy {
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  workers: any;
  obs: Observable<any> | undefined;
  admin= false;
  dataSorce: MatTableDataSource<Employee> = new MatTableDataSource<Employee>();

  constructor(private employeeSevice: EmployeeService, private dialog: MatDialog,) { }
  ngOnDestroy(): void {
    if (this.dataSorce) { 
      this.dataSorce.disconnect(); 
    }
  }

  ngOnInit(): void {
    this.getEmployees();
    this.whoAmI()

  }
  ngAfterViewInit() {
  }

  readonly search = (event: Event) => {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSorce.filter = filterValue.trim().toLowerCase();
  }

  readonly getEmployees = () => {
    this.employeeSevice.getEmployees().subscribe(
      res => {
        this.workers = res;
        this.dataSorce = new MatTableDataSource<Employee>(this.workers);
        this.dataSorce.paginator = this.paginator;
        this.obs = this.dataSorce.connect();
      })
  }

  readonly whoAmI = () => {
if(localStorage.getItem("role")=='ROLE_ADMIN'){
  this.admin = true;
}
  }

  readonly openDialog=() => {
    const dialogRef =  this.dialog.open(NewWorkerDialogComponent)
    dialogRef.afterClosed().subscribe(() => {
      this.getEmployees();
    });
  }


}
