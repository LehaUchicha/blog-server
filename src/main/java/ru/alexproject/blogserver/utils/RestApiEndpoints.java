package ru.alexproject.blogserver.utils;

public final class RestApiEndpoints {

    public static class Common{
        public static final String ID = "/{id}";
    }

    public class Messages{
        public static final String API_MESSAGES = "/api/messages";
        public static final String MESSAGE_ID = "/message/{id}";
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
}
