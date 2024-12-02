package manager;

import org.openqa.selenium.By;

public class LoginHelper extends BaseHelper{

    public LoginHelper (ApplicationManager manager){
        super(manager);
    }

    void login(String user, String password) {
        type(By.name("user"), user);
        type(By.name("pass"), password);
        сlick(By.xpath("//input[@value=\'Login\']"));
    }
}
