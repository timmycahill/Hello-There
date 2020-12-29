import { User } from './user';
import { Time } from "@angular/common";

export interface Message {
    message_id: number;
    fromUser: User;
    toUser: User;
    content: string;
    date: Date;
    time: Time;
}