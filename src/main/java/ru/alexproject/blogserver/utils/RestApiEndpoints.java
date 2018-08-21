package ru.alexproject.blogserver.utils;

public final class RestApiEndpoints {

    public static class Common{
        public static final String ID = "/{id}";
    }

    public class Messages{
        public static final String API_MESSAGES = "/api/messages";
        public static final String MESSAGE_ID = "/message/{id}";
        public static final String API_DIALOGS = "/api/dialogs";
        public static final String DIALOG_ID = "/dialog/{id}";
        public static final String USER_DIALOGS = "/users/{id}";
        public static final String USERS_FOR_DIALOG = "/dialog/{id}/users";
    }

    public static class Users{
        public static final String API_USERS = "/api/users";
        public static final String REGISTRATION = "/register";
    }

    public static class Comments{
        public static final String API_COMMENTS = "/api/comments";
    }

    public static class Posts{
        public static final String API_POSTS = "/api/posts";
        public static final String POST_ID = "post/{id}";
        public static final String POST_ID_COMMENTS = "post/{id}/comments";
    }

    public static class Likes{
        public static final String API_LIKES = "/api/likes";
        public static final String FOR_COMMENTS = "/comments";
        public static final String BY_COMMENT_ID = "/comments/comment/{id}";
        public static final String FOR_POSTS = "/posts";
        public static final String BY_POST_ID = "/posts/post/{id}";
    }
}
