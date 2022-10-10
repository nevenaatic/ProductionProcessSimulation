import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-revision-table',
  templateUrl: './product-revision-table.component.html',
  styleUrls: ['./product-revision-table.component.css']
})
export class ProductRevisionTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @Input() dataSource: any;
 // @Output() deleted = new EventEmitter();
  displayedColumns: string[] = ['label', 'name','type','check'];


  constructor(private productService: ProductService, private router: Router, private snack:MatSnackBar) { }

  ngOnInit(): void {
  }

  check(id: any) {
    return this.productService.check(id).subscribe(res=> {
    console.log(res)
     // this.deleted.emit(id);
     this.snack.open("Kontrola zavedena!")
   
    })
  }
}
