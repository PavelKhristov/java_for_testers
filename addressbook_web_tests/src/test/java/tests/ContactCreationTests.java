package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> ContactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "Not empty Contact firstname")) {
            for (var lastname : List.of("", "Not empty Contact lastname")) {
                result.add(new ContactData()
                        .withFirstName(firstname)
                        .withLastName(lastname)
//                        .withPhoto(randomFile("src/test/resources/images/"))
                );
            }
        }
        for (int i = 1; i < 2; i++) {
            result.add(new ContactData()
                    .withFirstName(CommonFunctions.randomString(i))
                    .withLastName(CommonFunctions.randomString(i))
            );
        }
        return result;
    }

    public static List<ContactData> ContactProviderFromGeneratedFile() throws IOException {
        var result = new ArrayList<ContactData>();

        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>(){});
        result.addAll(value);
        return result;
    }

    @ParameterizedTest
    @MethodSource("ContactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @ParameterizedTest
    @MethodSource("ContactProviderFromGeneratedFile")
    public void canCreateMultipleContactsFromFile(ContactData contact) {
        app.contacts().createContact(contact);
    }

//    @Test
//    public void canCreateContact() {
//        app.contacts().createContact(new ContactData("firstname", "middlename", "lastname", "nickname", "title", "company", "address", "111", "222", "333", "444", "email1", "email2", "email3", "homepage", "1", "January", "2000", "2", "February", "2003", "[none]"));
//    }
//
//    @Test
//    public void canCreateContactWithFirstNameAndLastName() {
//        app.contacts().createContact(new ContactData().withFirstNameAndLastName("firstname", "lastname"));
//    }


}
