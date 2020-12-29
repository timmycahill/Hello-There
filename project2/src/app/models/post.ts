import { Time } from "@angular/common";
import { User } from "./user";

export interface Post {
    id: number;
    author: User;
    content: string;
    date: Date | null;
    time: Time | null;
    location: string | null;
    isFlagged: boolean;
}