import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-revision',
  templateUrl: './product-revision.component.html',
  styleUrls: ['./product-revision.component.css']
})
export class ProductRevisionComponent implements OnInit {
  regularList: any;
  uncheckedList: any;
  scrapList: any;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getRegular();
    this.getScrap();
    this.getUnchecked();
  }

  getRegular() {
    return this.productService.getRegularProducts().subscribe(res => {
      this.regularList = res;
    })
  }
  getScrap() {
    return this.productService.getScrap().subscribe(res => {
      this.scrapList = res;
    })
  }
  getUnchecked() {
    return this.productService.getUnchecked().subscribe(res => {
      this.uncheckedList = res;
    })
  }
}
