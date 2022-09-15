import { Component, OnInit } from '@angular/core';
import { ProcessService } from 'src/app/services/process.service';

@Component({
  selector: 'app-process',
  templateUrl: './process.component.html',
  styleUrls: ['./process.component.css']
})
export class ProcessComponent implements OnInit {

  unfinishedList: any;
  showFinished: boolean= false;

  constructor(private processService: ProcessService) { }

  ngOnInit(): void {
    this.getUnfinishedProcesses()
  }

  public readonly getUnfinishedProcesses = () => this.processService.getUnfinishedProcesses()
    .subscribe(res => {
      this.unfinishedList = res;
      console.log(this.unfinishedList)
    });

    public readonly showFinishedProcesses = () => this.showFinished = true;

    public readonly back = () => this.showFinished = false;
}
