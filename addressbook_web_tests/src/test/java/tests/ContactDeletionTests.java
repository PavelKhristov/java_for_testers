package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;


public class ContactDeletionTests extends TestBase {

    @Test
    public void canDeleteContact() {
        if (!app.contacts().IsContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstNameAndLastName("firstname", "lastname"));;
        }
        app.contacts().DeleteContact();
    }

}
