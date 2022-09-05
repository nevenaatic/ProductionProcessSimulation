import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Failure } from '../model/Failure.model';

@Injectable({
  providedIn: 'root'
})
export class FailureService {
  private readonly baseUrl = `${environment.apiUrl}/failure`;
  
  constructor(private http: HttpClient) { }

  public readonly getFailures = ()=> {
    return this.http.get<Observable<Failure>>(`${this.baseUrl}/failures`, { headers: this.headers() })
  }

  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }
}
