import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import jwt_decode from "jwt-decode";
import {User} from "../domain/User";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  authenticate(token: string): Promise<void> {
    return new Promise<void>((resolve) => {
      sessionStorage.setItem('token', token);
      this.http.get(`api/timeclock/users/${this.getUsername()}`).subscribe(user => {
        sessionStorage.setItem('user', JSON.stringify(user));
        resolve();
      })
    });
  }

  isLoggedIn(): boolean {
    return sessionStorage.getItem('token') != null;
  }

  getUsername() {
    let token = jwt_decode(sessionStorage.getItem('token'));
    return token['sub'];
  }

  getUser(): User {
    return JSON.parse(sessionStorage.getItem('user'));
  }

  logOut() {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('user');
  }

  getToken(): string {
    return sessionStorage.getItem('token');
  }

}
