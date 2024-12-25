package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;


public class ContactDeletionTests extends TestBase {

    @Test
    public void canDeleteContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstNameAndLastName("firstname", "lastname"));
        }
        var oldContacts = app.contacts().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().deleteContact(oldContacts.get(index));
        var newContacts = app.contacts().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void canDeleteContactViaDB() {
        if (app.hbm().getCountContacts() == 0) {
            app.hbm().createContact(new ContactData()
                    .withLastName(CommonFunctions.randomString(10))
                    .withFirstName(CommonFunctions.randomString(10))
                    .withNickName(CommonFunctions.randomString(10))
                    .withAddress(CommonFunctions.randomString(10)));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().deleteContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }


    @Test
    void canRemoveAllContactsAtOnce() {
        if (app.contacts().getCountContacts() == 0) {
            app.contacts().createContact(new ContactData().withFirstNameAndLastName("firstname", "lastname"));
        }
        app.contacts().RemovalAllContacts();
        Assertions.assertEquals(0, app.contacts().getCountContacts());
    }

}
