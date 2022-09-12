import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { IProces } from '../interfaces/IProcess';
import { NewProcess } from '../model/NewProcess.model';

@Injectable({
  providedIn: 'root'
})
export class ProcessService {

  private readonly baseUrl = `${environment.apiUrl}/productionProcess`;
  
  constructor(private http: HttpClient) { }

  public readonly getAllProcess = () => {
    return this.http.get<any>(`${this.baseUrl}/processes`, { headers: this.headers() });
  }

  public readonly createNewProcess = (newProcess: NewProcess) => {
    return this.http.post<any>(`${this.baseUrl}/process`,newProcess, { headers: this.headers()});
  }
  
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }

}
