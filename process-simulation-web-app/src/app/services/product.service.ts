import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly baseUrl = `${environment.apiUrl}/product`
  constructor(private http: HttpClient) { }

  public readonly getAllProducts = () => {
    return this.http.get<any>(`${this.baseUrl}/products`, { headers: this.headers() });
  }

  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }  
}


