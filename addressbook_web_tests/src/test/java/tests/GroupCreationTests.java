package tests;

import dev.failsafe.internal.util.Assert;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        int groupCounts=app.groups().getCount();
        app.groups().createGroup(new GroupData("New group", "New header", "New footer"));
        int newGroupCounts=app.groups().getCount();
        Assertions.assertEquals(groupCounts + 1, newGroupCounts);
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("OnlyWithName"));
    }

}
