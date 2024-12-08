package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends BaseHelper{
    public GroupHelper (ApplicationManager manager){
        super(manager);
    }


    public void openGroupPage() {
        if (!manager.isElementPresent(By.name("new"))){
            сlick(By.linkText("groups"));
        }
    }

    public void createGroup(GroupData group) {
        openGroupPage();
        сlick(By.name("new"));
        сlick(By.name("group_name"));
        type(By.name("group_name"), group.name());
        сlick(By.name("group_header"));
        type(By.name("group_header"), group.header());
        сlick(By.name("group_footer"));
        type(By.name("group_footer"), group.footer());
        сlick(By.name("submit"));
        сlick(By.linkText("group page"));
    }



    public void deleteGroups() {
        openGroupPage();
        сlick(By.name("selected[]"));
        сlick(By.name("delete"));
        сlick(By.linkText("group page"));
    }

    public int getCount() {
        openGroupPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }



    public void DeletionAllGroups() {
        openGroupPage();
        selectAllGroups();
        deleteGroups();
    }

    private void selectAllGroups() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes){
            checkbox.click();
        }
    }


    /*Метод проверяет наличие чекбокса (метод уже не используется и находится в AppliationManager)
    public boolean isGroupPresent() {
        openGroupPage();
        return manager.isElementPresent(By.name("selected[]"));
    }*/
}
