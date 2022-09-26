import { Component, OnInit } from '@angular/core';
import { FactoryService } from 'src/app/services/factory.service';

@Component({
  selector: 'app-factory',
  templateUrl: './factory.component.html',
  styleUrls: ['./factory.component.css']
})
export class FactoryComponent implements OnInit {

  factory: any;
editMode: boolean= false;
  constructor(private factoryService: FactoryService) { }

  ngOnInit(): void {
    this.getFactory();
  }

  public readonly getFactory=()=>{
     this.factoryService.getFactory().subscribe(res => {
       this.factory = res;
     })
  }

  edit(){
    this.editMode = true;
  }
}
