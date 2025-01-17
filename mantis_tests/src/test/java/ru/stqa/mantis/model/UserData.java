package ru.stqa.mantis.model;

public record UserData(String username, String realName, String email, Boolean enabled) {

    public UserData (){
        this("", "", "", true);
    }

    public UserData withUsername(String username) {
        return new UserData(username, this.realName, this.email, this.enabled);
    }

    public UserData withRealName(String realName) {
        return new UserData(this.username, realName, this.email, this.enabled);
    }

    public UserData withEmail(String email) {
        return new UserData(this.username, this.realName, email, this.enabled);
    }

    public UserData withEnabled(Boolean enabled) {
        return new UserData(this.username, this.realName, this.email, enabled);
    }
}
