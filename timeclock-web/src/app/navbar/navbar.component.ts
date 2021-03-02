import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {

  constructor(public auth: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  logout() {
    this.auth.logOut();
    this.router.navigate(['login']);
  }

}
