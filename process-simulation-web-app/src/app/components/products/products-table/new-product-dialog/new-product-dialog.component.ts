import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Product } from 'src/app/model/Product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-new-product-dialog',
  templateUrl: './new-product-dialog.component.html',
  styleUrls: ['./new-product-dialog.component.css']
})
export class NewProductDialogComponent implements OnInit {
  product: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.min(3)]),
    description: new FormControl(''),
    price: new FormControl('', [Validators.required])
  });

  constructor(public dialogRef: MatDialogRef<NewProductDialogComponent>,
    private snackbar: MatSnackBar,
    private productService: ProductService) { }

  ngOnInit(): void {
  }


  public readonly onNoClick = () => {
    this.dialogRef.close();
  }

  readonly createProduct = () => {
    const productNew = new Product();
    productNew.name = this.product.controls['name'].value;
    productNew.finalPrice = this.product.controls['price'].value;
    productNew.description = this.product.controls['description'].value;
    this.productService.createNewProduct(productNew).subscribe(
      res => {
        this.snackbar.open('Product added!');
        this.dialogRef.close()
      },
      err => {
        this.snackbar.open('Something went wrong, try again later.')
      })
  }
}
