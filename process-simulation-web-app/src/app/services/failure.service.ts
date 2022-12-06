import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Failure } from '../model/Failure.model';

@Injectable({
  providedIn: 'root'
})
export class FailureService {
  private readonly failureUrl = `${environment.apiUrl}/failures`;
  private readonly stepFailureUrl = `${environment.apiUrl}/step-failures`;
  
  constructor(private http: HttpClient) { }

  public readonly getFailures = ()=> {
    return this.http.get<Observable<Failure>>(`${this.failureUrl}/`, { headers: this.headers() })
  }

  public readonly newStepFailure = (failure: Failure)=> {
    return this.http.post(`${this.stepFailureUrl}/`, failure, { headers: this.headers() })
  }

  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken")});
  }
}
