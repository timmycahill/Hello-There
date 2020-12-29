import { Time } from "@angular/common";
import { Post } from "./post";
import { User } from './user';

export interface Comment {
    comment_id: number;
    post: Post;
    author: User;
    content: string;
    date: Date;
    time: Time;
}