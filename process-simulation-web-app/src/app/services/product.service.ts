import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Product } from '../model/Product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly baseUrl = `${environment.apiUrl}/product`
  constructor(private http: HttpClient) { }

  public readonly getAllProducts = () => {
    return this.http.get<any>(`${this.baseUrl}/products`, { headers: this.headers() });
  }
  public readonly createNewProduct = (product: Product) =>  {
    alert('alo')
    return this.http.post(`${this.baseUrl}/product`, product, {headers: this.headers()});
  }
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }  
}


