package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private ContactHelper contacts;


    public void init() {
        if (driver == null) {
            driver = new FirefoxDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1238, 993));
            session().login("admin", "secret");
        }
    }

    public LoginHelper session () {
        if (session == null){
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups () {
        if (groups == null){
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public ContactHelper contacts () {
        if (contacts == null){
            contacts = new ContactHelper(this);
        }
        return contacts;
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
