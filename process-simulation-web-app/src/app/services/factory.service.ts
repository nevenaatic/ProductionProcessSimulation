import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FactoryService {
  private readonly baseUrl = `${environment.apiUrl}/factory`;
  constructor(private _http: HttpClient) { }

  public readonly getFactory = () => {
    return this._http.get(`${this.baseUrl}`, {headers:this.headers()});
  }
  public readonly editFactory = (factory: any) => {
    return this._http.post<any>(`${this.baseUrl}/`, factory, {headers:this.headers()});
  }
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }
}
