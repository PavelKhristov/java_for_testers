package manager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupHelper extends BaseHelper{
    public GroupHelper (ApplicationManager manager){super(manager);}


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

    public void removeGroup(GroupData group) {
        openGroupPage();
        selectGroup(group);
        removeSelectedGroups();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData group, GroupData modifiedGroup) {
        openGroupPage();
        selectGroup(group);
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
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

    private void removeSelectedGroups() {
        сlick(By.name("delete"));
    }

    private void selectGroup(GroupData group) {
        сlick(By.cssSelector(String.format("input[value='%s']", group.id())));
    }

    public int getCountGroups() {
        openGroupPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void RemovalAllGroups() {
        openGroupPage();
        selectAllGroups();
        removeSelectedGroups();
    }

    private void selectAllGroups() {
        //Переписали в функциональном стиле
        manager.driver
                .findElements(By.name("selected[]"))
                .forEach(WebElement::click);
    }

//    public List<GroupData> getList() {
//        openGroupPage();
//        var groups = new ArrayList<GroupData>();
//        var spans = manager.driver.findElements(By.cssSelector("span.group"));
//        for (var span : spans){
//            var name = span.getText();
//            var checkbox = span.findElement(By.name("selected[]"));
//            var id = checkbox.getAttribute("value");
//            groups.add(new GroupData().withId(id).withName(name));
//        }
//        return groups;
//    }
    //Переписан в функционально стиле
    public List<GroupData> getList() {
        openGroupPage();
        var spans = manager.driver.findElements(By.cssSelector("span.group"));
        return spans.stream()
                .map(span -> {
                    var name = span.getText();
                    var checkbox = span.findElement(By.name("selected[]"));
                    var id = checkbox.getAttribute("value");
                    return new GroupData().withId(id).withName(name);
                })
                .collect(Collectors.toList());
    }

    private void submitGroupModification() {
        сlick(By.name("update"));
    }

    private void initGroupModification() {
        сlick(By.name("edit"));
    }



}
