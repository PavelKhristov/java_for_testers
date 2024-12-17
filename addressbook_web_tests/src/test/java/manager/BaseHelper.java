package manager;

import org.openqa.selenium.By;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseHelper {

    public final ApplicationManager manager;

    public BaseHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void сlick(By locator) {
        manager.driver.findElement(locator).click();
    }

    void type(By locator, String field) {
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(field);
    }

    void chooseElementFromSelector(By locator, String field) {
        manager.driver.findElement(locator).sendKeys(field);
    }

    void attach(By locator, String file) {
        manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }



}
