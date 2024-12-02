package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        app.OpenGroupPage();
        app.CreateGroup(new GroupData("New group", "New header", "New footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.OpenGroupPage();
        app.CreateGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.OpenGroupPage();
        app.CreateGroup(new GroupData().withName("OnlyWithName"));
    }

}
