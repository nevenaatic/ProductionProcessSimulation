import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FinalProcessService {
  private readonly failureUrl = `${environment.apiUrl}/final-production-processes`;

  constructor(private http: HttpClient) { }


  public readonly startProcess = (id: number) => {
    return this.http.post(`${this.failureUrl}/start-process`, id, { headers: this.headers() });
  }
  public readonly startFailedProcess = (id: number) => {
    return this.http.post(`${this.failureUrl}/start-failed-process`, id, { headers: this.headers() });
  }
  public readonly getAll = () => {
    return this.http.get<any>(`${this.failureUrl}/`,  { headers: this.headers() });
  }
  public readonly generateReport = (id: number) => {
    return this.http.post<any>(`${this.failureUrl}/report`, id, { headers: this.headers() });
  }
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken")});
  }
}
