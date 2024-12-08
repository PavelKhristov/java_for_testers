package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ContactDeletionTests extends TestBase {

    @Test
    public void canDeleteContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstNameAndLastName("firstname", "lastname"));
        }
        app.contacts().deleteContact();
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
