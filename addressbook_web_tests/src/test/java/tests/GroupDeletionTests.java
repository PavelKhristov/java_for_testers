package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupDeletionTests extends TestBase {

    @Test
    public void canDeleteGroup() {
        //  Вариант с проверкой существования группы
        //if (!app.groups().isGroupPresent()) {

        //Вариант с проверкой существования заданного количества групп
        if (app.groups().getCountGroups() == 0) {
            app.groups().createGroup(new GroupData("", "New group", "New header", "New footer"));
        }
        var oldGroups = app.groups().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.groups().getList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Assertions.assertEquals(newGroups, expectedList);
    }

    @Test
    public void canDeleteGroupViaDB() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "New group", "New header", "New footer"));
        }
        //Падает с ошибкой если есть deprecated в GroupRecord
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Assertions.assertEquals(newGroups, expectedList);
    }

    @Test
    void canRemoveAllGroupsAtOnce() {
        if (app.groups().getCountGroups() == 0) {
            app.groups().createGroup(new GroupData("", "New group", "New header", "New footer"));
        }
        app.groups().RemovalAllGroups();
        Assertions.assertEquals(0, app.groups().getCountGroups());
    }

}