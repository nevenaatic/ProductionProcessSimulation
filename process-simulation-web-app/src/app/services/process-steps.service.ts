import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProcessStepsService {

  private readonly baseUri = `${environment.apiUrl}`;
  constructor(private http: HttpClient) { }


  public readonly getStepKinds = () => {
    return this.http.get(`${this.baseUri}/process-step-kinds/`, { headers: this.headers() });
  }

  public readonly getProcessSteps = () => {
    return this.http.get(`${this.baseUri}/process-steps/`, { headers: this.headers() });
  }

  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }
}
