package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserHelper extends BaseHelper{

    public UserHelper (ApplicationManager manager){super(manager);}


    public void startRegistration(String username, String email) {
        click(By.linkText("Signup for a new account"));
        type(By.id("username"), username);
        type(By.id("email-field"), email);
        click(By.cssSelector("input[value=\"Signup\"]"));
        click(By.linkText("Proceed"));
    }

    public void finishRegistration(String username, String password, String url){
        //Переход по URL
        openUrl(url);
        type(By.id("realname"), username);
        type(By.id("password"), password);
        type(By.id("password-confirm"), password);
        click(By.cssSelector("span.bigger-110"));

    }

}
