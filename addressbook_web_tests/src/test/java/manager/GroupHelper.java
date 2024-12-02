package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends BaseHelper{
    public GroupHelper (ApplicationManager manager){
        super(manager);
    }


    public void OpenGroupPage() {
        if (!manager.isElementPresent(By.name("new"))){
            сlick(By.linkText("groups"));
        }
    }

    public void CreateGroup(GroupData group) {
        OpenGroupPage();
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

    public boolean IsGroupPresent() {
        OpenGroupPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void DeleteGroup() {
        OpenGroupPage();
        сlick(By.name("selected[]"));
        сlick(By.name("delete"));
        сlick(By.linkText("group page"));
    }
}
