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
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    private void fillGroupForm(GroupData group) {
        сlick(By.name("group_name"));
        type(By.name("group_name"), group.name());
        сlick(By.name("group_header"));
        type(By.name("group_header"), group.header());
        сlick(By.name("group_footer"));
        type(By.name("group_footer"), group.footer());
    }

    private void returnToGroupsPage() {
        сlick(By.linkText("group page"));
    }

    private void submitGroupCreation() {
        сlick(By.name("submit"));
    }

    private void initGroupCreation() {
        сlick(By.name("new"));
    }


    public void removeGroup() {
        openGroupPage();
        selectGroup();
        removeSelectedGroups();
        returnToGroupsPage();
    }

    private void removeSelectedGroups() {
        сlick(By.name("delete"));
    }

    private void selectGroup() {
        сlick(By.name("selected[]"));
    }



    public int getCount() {
        openGroupPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void RemovalAllGroups() {
        openGroupPage();
        selectAllGroups();
        removeSelectedGroups();
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
