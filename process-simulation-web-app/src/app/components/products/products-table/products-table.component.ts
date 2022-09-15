import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products-table',
  templateUrl: './products-table.component.html',
  styleUrls: ['./products-table.component.css']
})
export class ProductsTableComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;

  productsList: any;
  displayedColumns: string[] = ['name', 'description', 'price',];
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getProducts()
  }

  public readonly getProducts = () => this.productService.getAllProducts()
    .subscribe(res => {
      const data = res;
      this.productsList = new MatTableDataSource<any>(data);
      this.productsList.paginator = this.paginator;
      this.productsList.sort = this.sort;
    })

  public readonly openDialog = () => { }
}
