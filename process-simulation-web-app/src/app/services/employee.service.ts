import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { IEmpolyee } from '../interfaces/IEmployee';
import { Employee } from '../model/Employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private readonly baseUrl = `${environment.apiUrl}/employees`;

  constructor(private http: HttpClient) { }

  public readonly getEmployees = () => {
    return this.http.get<Observable<IEmpolyee>>(`${this.baseUrl}/`, { headers: this.headers() });
  }
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }

}
