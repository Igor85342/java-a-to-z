package ru.moskalets.spring.section001.task001;

public class Configuration {
    private final String url = "jdbc:postgresql://localhost:5432/spring001002";
    private final String username = "postgres";
    private final String password = "password";

    public String getUrl() {
        return this.url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}