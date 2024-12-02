package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {
    public final ApplicationManager manager;

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
            base().ClickLink("groups");
        }
    }

    public void CreateGroup(GroupData group) {
        OpenGroupPage();
        base().ClickButton("new");
        base().ClickButton("group_name");
        base().FillFieldByValue("group_name", group.name());
        base().ClickButton("group_header");
        base().FillFieldByValue("group_header", group.header());
        base().ClickButton("group_footer");
        base().FillFieldByValue("group_footer", group.footer());
        base().ClickButton("submit");
        base().ClickLink("group page");
    }



    public boolean IsGroupPresent() {
        OpenGroupPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void DeleteGroup() {
        OpenGroupPage();
        base().ClickButton("selected[]");
        base().ClickButton("delete");
        base().ClickLink("group page");
    }

}
