import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private readonly baseUrl = `${environment.apiUrl}/auth`;

  constructor(private router: Router, private _http: HttpClient) { }

  public readonly login = (email: string, password: string) => {
    const body = {
      'email': email,
      'password': password
    };
    return this._http.post<any>(`${this.baseUrl}/login`, body).subscribe(res => {
      localStorage.setItem("accessToken", res.accessToken);
      localStorage.setItem("role", res.role);
      if(res.role == "ROLE_PROCESS_ENGINEER"){
      this.router.navigate(['homepage/process'])
    } 
    if(res.role == "ROLE_PRODUCTION_MANAGER"){
      this.router.navigate(['homepage/statistic'])
    }
    if(res.role == "ROLE_QUALITY_ENGINEER"){
      this.router.navigate(['homepage/product-revision'])
    }
    },
      err => {
        Swal.fire("Ooopss...", "Wrong credentials. Try again.")
      })
  }
  public readonly signOut = () => {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("role");
    this.router.navigate([''])
  }
}
