import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

const baseUrl = 'api/timeclock/user-states';

@Injectable({
  providedIn: 'root'
})
export class UserStateService {

  constructor(private http: HttpClient) { }

  getCurrentState(userId): Observable<any> {
    return this.http.get(`${baseUrl}/latest/${userId}`);
  }

  changeState(userId, newState): Observable<any> {
    return this.http.post(`${baseUrl}`, { userId: userId, userState: newState });
  }

}
