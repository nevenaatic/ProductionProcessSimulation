import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Product } from '../model/Product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
 

  private readonly productUrl = `${environment.apiUrl}/product`
  private readonly finalProductUrl = `${environment.apiUrl}/finalProduct`
  constructor(private http: HttpClient) { }

  public readonly getAllProducts = () => {
    return this.http.get<any>(`${this.productUrl}/products`, { headers: this.headers() });
  }
  public readonly createNewProduct = (product: Product) =>  {
    return this.http.post(`${this.productUrl}/product`, product, {headers: this.headers()});
  } 
  deleteProduct(product: any) {
    return this.http.delete(`${this.productUrl}/delete/${product.id}`, {headers:this.headers()});
  }

  public readonly getRegularProducts = () => {
    return this.http.get<any>(`${this.finalProductUrl}/regular`, { headers: this.headers() });
  }
  public readonly getScrap = () => {
    return this.http.get<any>(`${this.finalProductUrl}/scrap`, { headers: this.headers() });
  }
  public readonly getUnchecked = () => {
    return this.http.get<any>(`${this.finalProductUrl}/unchecked`, { headers: this.headers() });
  }
  public readonly check = (id: number) => {
    return this.http.post<any>(`${this.finalProductUrl}/check`, id, { headers: this.headers() });
  }
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }  
}


