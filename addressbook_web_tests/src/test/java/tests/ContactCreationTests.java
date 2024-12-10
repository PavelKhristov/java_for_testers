package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> ContactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "Not empty Contact firstname")) {
            for (var lastname : List.of("", "Not empty Contact lastname")) {
                result.add(new ContactData("", firstname, "", lastname, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
            }
        }
        for (int i = 1; i < 4; i++) {
            result.add(new ContactData("", randomString(i), randomString(i), randomString(i), randomString(i), randomString(i), randomString(i), randomString(i), "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("ContactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCounts = app.contacts().getCountContacts();
        app.contacts().createContact(contact);
        int newContactCounts = app.contacts().getCountContacts();
        Assertions.assertEquals(contactCounts + 1, newContactCounts);
    }

    /*@Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "title", "company", "address", "111", "222", "333", "444", "email1", "email2", "email3", "homepage", "1", "January", "2000", "2", "February", "2003", "[none]"));
    }

    @Test
    public void canCreateContactWithFirstNameAndLastName() {
        app.contacts().createContact(new ContactData().withFirstNameAndLastName("firstname", "lastname"));
    }
     */


}
