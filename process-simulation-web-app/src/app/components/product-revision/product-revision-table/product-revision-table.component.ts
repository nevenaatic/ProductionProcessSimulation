import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-revision-table',
  templateUrl: './product-revision-table.component.html',
  styleUrls: ['./product-revision-table.component.css']
})
export class ProductRevisionTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @Input() dataSource: any;

  displayedColumns: string[] = ['label', 'name','type','check'];


  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  check(id: any) {
    return this.productService.check(id).subscribe(res=> {
      console.log(res)
    })
  }
}
