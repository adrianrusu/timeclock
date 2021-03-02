import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const baseUrl = 'api/timeclock/user-logs';

@Injectable({
  providedIn: 'root'
})
export class UserLogService {

  constructor(private http: HttpClient) { }

  getAllUserLogs(): Observable<any> {
    return this.http.get(baseUrl);
  }

  getUserLogs(userId: Number): Observable<any> {
    return this.http.get(`${baseUrl}/user/${userId}`);
  }

}
