package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void CanDeleteGroup() {
        app.OpenGroupPage();
        if (!app.IsGroupPresent()) {
            app.CreateGroup(new GroupData("New group", "New header", "New footer"));
        }
        app.DeleteGroup();
    }

}