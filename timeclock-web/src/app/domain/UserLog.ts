import {User} from "./User";
import {UserState} from "./UserState";

export class UserLog {
    id: Number;
    state: UserState;
    creationDate: Date;
    user: User;
}
