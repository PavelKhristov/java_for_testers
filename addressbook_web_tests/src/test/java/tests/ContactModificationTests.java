package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ContactModificationTests extends TestBase {


    public static List<ContactData> emptyContact() {
        return List.of(new ContactData());
    }

    @Test
    void canModifyContact() {
        if (app.hbm().getCountContacts() == 0) {
            app.hbm().createContact(new ContactData()
                    .withLastName(CommonFunctions.randomString(10))
                    .withFirstName(CommonFunctions.randomString(10))
                    .withAddress(CommonFunctions.randomString(10))
                    .withNickName(CommonFunctions.randomString(10)));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData()
                .withFirstName("modified firstname")
                .withLastName("modified lastname")
                .withAddress("modified address")
                .withNickName("modified nickname");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @ParameterizedTest
    @MethodSource("emptyContact")
    void canAddGroupToContact(ContactData contact) {
        if (app.hbm().getCountContacts() == 0) {
            app.hbm().createContact(new ContactData()
                    .withLastName(CommonFunctions.randomString(10))
                    .withFirstName(CommonFunctions.randomString(10))
                    .withAddress(CommonFunctions.randomString(10))
                    .withNickName(CommonFunctions.randomString(10)));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().addGroupToContact(oldContacts.get(index), group);
        var newRelated = app.hbm().getContactsInGroup(group);
//        var maxId = newRelated.get(newRelated.size() - 1).id();
        var expectedRelated = new ArrayList<>(oldRelated);
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newRelated.sort(compareById);
        expectedRelated.add(oldContacts.get(index));
        expectedRelated.sort(compareById);
        Assertions.assertEquals(newRelated, expectedRelated);
    }

}
