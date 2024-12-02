package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void CanDeleteGroup() {
        if (!app.groups().IsGroupPresent()) {
            app.groups().CreateGroup(new GroupData("New group", "New header", "New footer"));
        }
        app.groups().DeleteGroup();
    }

}