import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Failure } from 'src/app/model/Failure.model';
import { FailureService } from 'src/app/services/failure.service';
@Component({
  selector: 'app-failures-table',
  templateUrl: './failures-table.component.html',
  styleUrls: ['./failures-table.component.css']
})
export class FailuresTableComponent implements OnInit {
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  failures: any;
  dataSource : any;
  displayedColumns=['name', 'type', 'probability']
  constructor(private dialog: MatDialog, private failureService: FailureService) { }

  ngOnInit(): void {
   this.loadFailures();
  }

  readonly loadFailures = ()=> {
    this.failureService.getFailures().subscribe(
      res => {
        this.failures = res;
        this.dataSource = new MatTableDataSource<Failure>(this.failures);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    )
  }
  openDialog(){}
}
