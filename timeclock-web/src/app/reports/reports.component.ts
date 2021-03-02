import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user.service";
import {User} from "../domain/User";
import {UserLogService} from "../services/user-log.service";
import {UserLog} from "../domain/UserLog";

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html'
})
export class ReportsComponent implements OnInit {

  users: User[];
  userLogs: UserLog[];

  selectedUser: number = null;

  constructor(private userService: UserService,
              private userLogService: UserLogService) { }

  ngOnInit(): void {
    this.userService.getUsers().subscribe(users => this.users = users);

    this.onSelect(null);
  }

  onSelect(selectedUser) {
    console.log(selectedUser == null)
    if (selectedUser == null) {
      this.userLogService.getAllUserLogs().subscribe(userLogs => this.userLogs = userLogs);
    } else {
      this.userLogService.getUserLogs(selectedUser).subscribe(userLogs => this.userLogs = userLogs);
    }
  }

}
