import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  message: string;

  constructor(private auth: AuthService,
              private http: HttpClient,
              private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.http.post('api/timeclock/login', { username: this.username, password: this.password },
      { responseType: 'text' }).subscribe(res => {
        if (res.startsWith("<")) {
          this.message = "Username or password is incorrect."
        } else {

          this.auth.authenticate(res).then(() => {
            this.router.navigate(['']);
          })
        }
    });
  }

}
