package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {
    private final ApplicationManager manager;

    private BaseHelper base;

    public BaseHelper base () {
        if (base == null){
            base = new BaseHelper(this);
        }
        return base;
    }



    public GroupHelper (ApplicationManager manager){
        this.manager = manager;
    }

    public void OpenGroupPage() {
        if (!manager.isElementPresent(By.name("new"))){
            ClickLink("groups");
        }
    }

    public void CreateGroup(GroupData group) {
        OpenGroupPage();
        ClickButton("new");
        ClickButton("group_name");
        FillFieldByValue("group_name", group.name());
        ClickButton("group_header");
        FillFieldByValue("group_header", group.header());
        ClickButton("group_footer");
        FillFieldByValue("group_footer", group.footer());
        ClickButton("submit");
        ClickLink("group page");
    }



    public boolean IsGroupPresent() {
        OpenGroupPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void DeleteGroup() {
        OpenGroupPage();
        ClickButton("selected[]");
        ClickButton("delete");
        ClickLink("group page");
    }

    public void ClickButton(String button) {
        manager.driver.findElement(By.name(button)).click();
    }

    private void ClickLink(String link) {
        manager.driver.findElement(By.linkText(link)).click();
    }

    private void FillFieldByValue(String group_name, String group) {
        manager.driver.findElement(By.name(group_name)).sendKeys(group);
    }
}
