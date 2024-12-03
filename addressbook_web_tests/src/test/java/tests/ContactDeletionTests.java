package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactDeletionTests extends TestBase {

    @Test
    public void canDeleteContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstNameAndLastName("firstname", "lastname"));;
        }
        app.contacts().deleteContact();
    }

}
