package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {
    public final ApplicationManager manager;
    public GroupHelper (ApplicationManager manager){
        this.manager = manager;
    }

    /*public final BaseHelper base;
    public GroupHelper (BaseHelper base){
        this.base = base;*/


    /*private BaseHelper base;
    public BaseHelper base () {
        if (base == null){
            base = new BaseHelper(this);
        }
        return base;
    }*/

    public void OpenGroupPage() {
        if (!isPesent("new")){
            ClickLink("groups");
        }
    }

    public void CreateGroup(GroupData group) {
        OpenGroupPage();
        ClickButton("new");
        ClickButton("group_name");
        FillInTheFieldByValue("group_name", group.name());
        ClickButton("group_header");
        FillInTheFieldByValue("group_header", group.header());
        ClickButton("group_footer");
        FillInTheFieldByValue("group_footer", group.footer());
        ClickButton("submit");
        ClickLink("group page");
    }



    public boolean IsGroupPresent() {
        OpenGroupPage();
        return isPesent("selected[]");
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

    void ClickLink(String link) {
        manager.driver.findElement(By.linkText(link)).click();
    }

    void FillInTheFieldByValue(String fieldName, String field) {
        manager.driver.findElement(By.name(fieldName)).sendKeys(field);
    }

    private boolean isPesent(String elementName) {
        return manager.isElementPresent(By.name(elementName));
    }

}
