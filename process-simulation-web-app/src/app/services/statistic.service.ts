import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StatisticService {
  private readonly baseUrl = `${environment.apiUrl}/statistic`;
  constructor(private _http: HttpClient) { }


  public readonly getProcessNames =()=> {
    return this._http.get<any>(`${this.baseUrl}/processes`, {headers:this.headers()})
  }
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }

}
