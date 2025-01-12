package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase{

    @Test
    void canRegisterUser(){
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

}
