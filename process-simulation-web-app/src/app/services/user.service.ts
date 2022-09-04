import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../model/User.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly baseUrl = `${environment.apiUrl}/user`;

  constructor(private http: HttpClient) { }

  public readonly getProfileInfo = () => {
    return this.http.get<User>(`${this.baseUrl}/userProfile`, { headers: this.headers() });
  }

  public readonly updateUserInfo = (user: any) => {
    alert("ALO")
    return this.http.post<User>(`${this.baseUrl}/updateProfile`, user, { headers: this.headers()});
  }
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }

}
