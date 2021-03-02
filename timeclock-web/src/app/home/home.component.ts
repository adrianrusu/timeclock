import {Component, OnInit} from '@angular/core';
import {UserLog} from '../domain/UserLog';
import {UserState} from '../domain/UserState';
import {UserStateService} from '../services/user-state.service';
import {AuthService} from "../services/auth.service";
import {User} from "../domain/User";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  user: User;
  currentState: UserLog;

  constructor(private userStateService: UserStateService,
              private auth: AuthService) {
  }

  ngOnInit(): void {
    this.user = this.auth.getUser();

    this.userStateService.getCurrentState(this.user.id).subscribe(state => {
      this.currentState = state;
      if (!this.currentState) {
        this.currentState = new UserLog();
        this.currentState.state = UserState.EXIT;
      }
    });
  }

  toggleState(): void {
    let newState = this.currentState.state == UserState.EXIT ? UserState.ENTRANCE : UserState.EXIT;

    this.userStateService.changeState(this.user.id, newState).subscribe(state => {
      this.currentState = state;
    });
  }

  getButtonText(): String {
    return UserState.EXIT == this.currentState?.state ? "Punch in" : "Punch out";
  }

}
