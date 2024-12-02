package manager;

import org.openqa.selenium.By;

public class BaseHelper {
    final GroupHelper basemanager;

    public BaseHelper(GroupHelper basemanager) {
        this.basemanager = basemanager;
    }


    public void ClickButton(String button) {
        basemanager.manager.driver.findElement(By.name(button)).click();
    }

    void ClickLink(String link) {
        basemanager.manager.driver.findElement(By.linkText(link)).click();
    }

    void FillFieldByValue(String group_name, String group) {
        basemanager.manager.driver.findElement(By.name(group_name)).sendKeys(group);
    }
}
