package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        app.groups().CreateGroup(new GroupData("New group", "New header", "New footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        app.groups().CreateGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        app.groups().CreateGroup(new GroupData().withName("OnlyWithName"));
    }

}
