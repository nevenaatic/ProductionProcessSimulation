import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../model/User.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly baseUrl = `${environment.apiUrl}/users`;

  constructor(private http: HttpClient) { }

  public readonly getProfileInfo = () => {
    return this.http.get<User>(`${this.baseUrl}/profile-info`, { headers: this.headers() });
  }

  public readonly updateUserInfo = (user: User) => {
    return this.http.put(`${this.baseUrl}/`, user, { headers: this.headers() });
  }

  public readonly checkPassword = (password: string) => {
    return this.http.post(`${this.baseUrl}/check-password`, password, { headers: this.headers()});
  }

  public readonly changePassword = (password: string) => {
    return this.http.post<any>(`${this.baseUrl}/password`, {password}, { headers: this.headers() });
  }
  private readonly headers = () => {
    return new HttpHeaders({ Authorization: "Bearer " + localStorage.getItem("accessToken") });
  }

  
}
