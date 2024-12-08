package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void canDeleteGroup() {
        /*  Вариант с проверкой существования группы
        if (!app.groups().isGroupPresent()) {*/

        //Вариант с проверкой существования заданного количества групп
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("New group", "New header", "New footer"));
        }
        int groupCounts = app.groups().getCount();
        app.groups().deleteGroups();
        int newGroupCounts = app.groups().getCount();
        Assertions.assertEquals(groupCounts - 1, newGroupCounts);
    }

    @Test
    void canDeleteAllGroupsAtOnce() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("New group", "New header", "New footer"));
        }
        app.groups().DeletionAllGroups();
        Assertions.assertEquals(0, app.groups().getCount());
    }

}