import { Post } from "./post";
import { User } from "./user";

export interface Like {
    user: User;
    post: Post;
}