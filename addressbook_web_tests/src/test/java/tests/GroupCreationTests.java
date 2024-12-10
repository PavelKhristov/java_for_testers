package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<String> groupNameProvider() {
        //Изначально задаем список со значениями "New P Group 1" и "New P Group 2"
        var result = new ArrayList<String>(List.of("New P Group 1", "New P Group 2"));
        //К списку добавляем 5 рандомных строк
        for (int i = 1; i < 5; i++) {
            result.add(randomString(i));
        }
        return result;
    }

    public static List<GroupData> groupProvider() {
        //Задаем список обьектов Группа
        var result = new ArrayList<GroupData>(List.of(
                /*Нижу мы напрямую задаем какие группы будут в списке
                new GroupData(),
                new GroupData().withName("OnlyWithName"),
                new GroupData("New P Group 1", "", ""),
                new GroupData("New P Group 2", "", "")*/
        ));
        //В данной конструкции мы перебираем все варианты для name/header/footer с пустыми и не пустыми значениями.
        // Это заменяет все выше описанные вручную указанные группы
        for (var name : List.of("", "Not empty Group name")) {
            for (var header : List.of("", "Not empty Group header")) {
                for (var footer : List.of("", "Not empty Group footer")) {
                    result.add(new GroupData()
                            .withName(name)
                            .withHeader(header)
                            .withFooter(footer));
                }
            }
        }
        for (int i = 1; i < 5; i++) {
            result.add(new GroupData()
                    .withName(randomString(i))
                    .withHeader(randomString(i))
                    .withFooter(randomString(i)));
        }
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(new GroupData("", "New P Group 1'", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupData group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newGroups.get(newGroups.size() - 1).id()).withHeader("").withFooter(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupData group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Assertions.assertEquals(newGroups, oldGroups);
    }


    /*Оставил для себя
    @ParameterizedTest
    @MethodSource("groupNameProvider")
    public void canCreateMultipleGroups2(String name) {
        int groupCounts = app.groups().getCountGroups();
        app.groups().createGroup(new GroupData("", name, "New header", "New footer"));
        int newGroupCounts = app.groups().getCountGroups();
        Assertions.assertEquals(groupCounts + 1, newGroupCounts);
    }

    @Test
    public void canCreateGroup() {
        int groupCounts = app.groups().getCountGroups();
        app.groups().createGroup(new GroupData("New group", "New header", "New footer"));
        int newGroupCounts = app.groups().getCountGroups();
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


    @Test
    public void canCreateMultipleGroupsWithConstantGroupNames() {
        var n = 5;
        int groupCounts = app.groups().getCountGroups();
        for (int i = 0; i < n; i++){
            app.groups().createGroup(new GroupData("New group " + i, "New header", "New footer"));
        }
        int newGroupCounts = app.groups().getCountGroups();
        Assertions.assertEquals(groupCounts + n, newGroupCounts);
    }

    @Test
    public void canCreateMultipleGroupsWithRandomGroupNames() {
        var n = 5;
        int groupCounts = app.groups().getCountGroups();
        for (int i = 0; i < n; i++){
            app.groups().createGroup(new GroupData(randomString(i), "New header", "New footer"));
        }
        int newGroupCounts = app.groups().getCountGroups();
        Assertions.assertEquals(groupCounts + n, newGroupCounts);
    }

    @ParameterizedTest
    @ValueSource (strings = {"New P Group 1", "New P Group 2"})
    public void canCreateGroupsWith(String name) {
        int groupCounts = app.groups().getCountGroups();
        app.groups().createGroup(new GroupData(name, "New header", "New footer"));
        int newGroupCounts = app.groups().getCountGroups();
        Assertions.assertEquals(groupCounts + 1, newGroupCounts);
    }
     */

}
