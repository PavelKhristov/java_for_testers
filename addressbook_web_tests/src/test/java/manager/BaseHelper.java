package manager;

import org.openqa.selenium.By;

public class BaseHelper {

    public final ApplicationManager manager;

    public BaseHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void сlick(By locator) {
        manager.driver.findElement(locator).click();
    }

    void type(By locator, String field) {
        manager.driver.findElement(locator).sendKeys(field);
    }
}
