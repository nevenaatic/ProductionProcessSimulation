import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { EngagementRequest } from '../model/EngagementRequest.model';

@Injectable({
  providedIn: 'root'
})
export class EngagementService {
  private readonly baseUrl = `${environment.apiUrl}/engagements`;

  constructor(private http: HttpClient) { }



  public readonly getEngagement = (req: EngagementRequest) => {
    return this.http.post<any>(`${this.baseUrl}/`, req, {headers: this.headers()})
  }


  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }
}
