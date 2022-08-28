import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-workers',
  templateUrl: './workers.component.html',
  styleUrls: ['./workers.component.css']
})
export class WorkersComponent implements OnInit {
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;

  workers: any;
  constructor() { }

  ngOnInit(): void {
  }
  ngAfterViewInit() {
    this.workers.paginator = this.paginator;
    this.workers.sort = this.sort;
  }
  readonly search= (event: any) => 
  console.log("search")
}
