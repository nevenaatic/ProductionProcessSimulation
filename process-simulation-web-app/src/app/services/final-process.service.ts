import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FinalProcessService {
  private readonly failureUrl = `${environment.apiUrl}/finalProductionProcess`;

  constructor(private http: HttpClient) { }


  public readonly startProcess = (id: number) => {
    return this.http.post(`${this.failureUrl}/startProcess`, id, { headers: this.headers() });
  }

  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken")});
  }
}
