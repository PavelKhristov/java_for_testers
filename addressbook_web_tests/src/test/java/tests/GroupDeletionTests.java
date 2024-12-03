package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void canDeleteGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupData("New group", "New header", "New footer"));
        }
        app.groups().deleteGroup();
    }

}