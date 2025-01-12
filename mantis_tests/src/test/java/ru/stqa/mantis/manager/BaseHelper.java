package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

import java.nio.file.Paths;

public class BaseHelper {

    public final ApplicationManager manager;

    public BaseHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void click(By locator) {
        manager.driver().findElement(locator).click();
    }

    protected void type(By locator, String field) {
        manager.driver().findElement(locator).clear();
        manager.driver().findElement(locator).sendKeys(field);
    }

    void chooseElementFromSelector(By locator, String field) {
        manager.driver().findElement(locator).sendKeys(field);
    }

    protected void attach(By locator, String file) {
        manager.driver().findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }

    protected boolean isElementPresent (By locator){
        return manager.driver().findElements(locator).size() > 0;
    }



    protected void openUrl (String url){
        manager.driver().get(url);
    }

}
