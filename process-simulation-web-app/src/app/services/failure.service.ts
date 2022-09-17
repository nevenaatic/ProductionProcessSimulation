import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Failure } from '../model/Failure.model';

@Injectable({
  providedIn: 'root'
})
export class FailureService {
  private readonly failureUrl = `${environment.apiUrl}/failure`;
  private readonly stepFailureUrl = `${environment.apiUrl}/stepFailure`;
  
  constructor(private http: HttpClient) { }

  public readonly getFailures = ()=> {
    return this.http.get<Observable<Failure>>(`${this.failureUrl}/failures`, { headers: this.headers() })
  }

  public readonly newStepFailure = (failure: Failure)=> {
    return this.http.post(`${this.stepFailureUrl}/failure`, failure, { headers: this.headers() })
  }

  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken")});
  }
}
