package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {



    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "title", "company", "address", "111", "222", "333", "444", "email1", "email2", "email3", "homepage", "1", "January", "2000", "2", "February", "2003", "[none]"));
    }

    @Test
    public void canCreateContactWithFirstNameAndLastName() {
        app.contacts().createContact(new ContactData().withFirstNameAndLastName("firstname", "lastname"));
    }


}
