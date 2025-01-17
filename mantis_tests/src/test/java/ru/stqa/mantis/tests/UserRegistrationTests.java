package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.DeveloperMailUser;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase{

    DeveloperMailUser user;

    //Добавлени юзера в James через CLI
    @Test
    void canRegisterUser1(){
        var username = CommonFunctions.randomString(8);
        var password = "password";
        var email = String.format("%s@localhost", username);
        //Создать пользователя (адрес) на почтовом сервере (JamesHelper)
        app.jamesCli().addUser(email,password);
        //Запоняем форму создания (браузер)
        app.user().startRegistration(username,email);
        //ждем почту (MailHelper)
        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
        //Извлекаем ссылку из письма
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        var url = "";
        if(matcher.find()){
            url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }
        //Проходим по ссылке и завершаем регистрацию (браузер)
        app.user().finishRegistration(username, password, url);
        //Проверяем что пользовтель может залогиниться (HttpSessionHelper)
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }

    //Добавлени юзера в James через API
    @Test
    void canRegisterUser2(){
        var username = CommonFunctions.randomString(8);
        var password = "password";
        var email = String.format("%s@localhost", username);
        app.jamesApi().addUser(email,password);
        app.user().startRegistration(username,email);

        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        var url = "";
        if(matcher.find()){
            url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }

        app.user().finishRegistration(username, password, url);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }

    //Задача19, начало регистрации юзера через API
    @Test
    void canRegisterUser3(){
        var username = CommonFunctions.randomString(8);
        var password = "password";
        var email = String.format("%s@localhost", username);
        app.jamesApi().addUser(email,password);
        app.rest().startRegistration(new UserData()
                .withUsername(username)
                .withRealName(username)
                .withEmail(email));

        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        var url = "";
        if(matcher.find()){
            url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }

        app.user().finishRegistration(username, password, url);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }


    //Работа с почтовым сервисом developermail.com. Приложение developermail.com в момент проверки было не доступно, не получилось проверить
    @Test
    void canRegisterUser4(){
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());
        app.user().startRegistration(user.name(),email);

        var message = app.developerMail().receive(user, Duration.ofSeconds(10));
        var text = message;
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        var url = "";
        if(matcher.find()){
            url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }

        app.user().finishRegistration(user.name(), password, url);
        app.http().login(user.name(), password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }


    //Для работы с почтовым сервисом developermail.com. Удаляем пользователя
//    @AfterEach
//    void deleteMailUser(){
//        app.developerMail().deleteUser(user);
//    }

}
