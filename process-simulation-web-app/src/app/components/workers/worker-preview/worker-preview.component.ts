import { Component, Input, OnInit } from '@angular/core';
import { Employee } from 'src/app/model/Employee.model';

@Component({
  selector: 'app-worker-preview',
  templateUrl: './worker-preview.component.html',
  styleUrls: ['./worker-preview.component.css']
})
export class WorkerPreviewComponent implements OnInit {

  @Input() worker = new Employee();
  constructor() { }

  ngOnInit(): void {

  
  }

}
