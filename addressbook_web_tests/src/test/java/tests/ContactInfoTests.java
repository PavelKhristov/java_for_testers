package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {


    //В данном тесте вытаскиваем все контакты из UI разом
    @Test
    void testPhones2() {
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
            Stream.of(contact.homePhone(), contact.mobilePhone(), contact.workPhone(), contact.secondaryPhone())
                    .filter(s -> s != null && ! "".equals(s))
                    .collect(Collectors.joining("\n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);
    }

    @Test
    void testPonesAddressesAndEmails() {
        if (app.hbm().getCountContacts() == 0) {
            app.hbm().createContact(new ContactData()
                    .withLastName(CommonFunctions.randomString(5))
                    .withHomePhone(CommonFunctions.randomPhoneNumber())
                    .withMobilePhone(CommonFunctions.randomPhoneNumber())
                    .withWorkPhone(CommonFunctions.randomPhoneNumber())
                    .withAddress(CommonFunctions.randomString(10))
                    .withEmail(CommonFunctions.randomEmail(5))
                    .withEmail2(CommonFunctions.randomEmail(5))
                    .withEmail3(CommonFunctions.randomEmail(5))
            );
            app.contacts().openHomePage();
        }
        var contacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(contacts.size());
        var contact = contacts.get(index);
        //Ниже закомменчена попытка достать информацию из БД
//        var expected = Stream.of(contact.address(), contact.email(), contact.email2(), contact.email3(), contact.homePhone(), contact.mobilePhone(), contact.workPhone(), contact.secondaryPhone())
//                .filter(s -> s != null && ! "".equals(s))
//                .collect(Collectors.joining("\n"));
        var contactInformationFromHomePage = app.contacts().getContactInformationFromHomePage(contact);
        app.contacts().openContactPage(contact);
        var expected = app.contacts().getInformationFromContactPage();
        Assertions.assertEquals(expected, contactInformationFromHomePage);
    }



      //В данном тесте вытаскиваем контакты из UI по одному в цикле. Сравниваются все контакты
//    @Test
//    void testPhones1() {
//        var contacts = app.hbm().getContactList();
//        for (var contact : contacts){
//            var phones = app.contacts().getPhones(contact);
//            var expected = Stream.of(contact.homePhone(), contact.mobilePhone(), contact.workPhone(), contact.secondaryPhone())
//                    .filter(s -> s != null && ! "".equals(s))
//                    .collect(Collectors.joining("\n"));
//            Assertions.assertEquals(expected, phones);
//        }
//    }

    //Проверка одного контакта
//    @Test
//    void testPhones3() {
//        if (app.hbm().getCountContacts() == 0) {
//            app.hbm().createContact(new ContactData()
//                    .withLastName(CommonFunctions.randomString(5))
//                    .withHomePhone(CommonFunctions.randomPhoneNumber())
//                    .withMobilePhone(CommonFunctions.randomPhoneNumber())
//                    .withWorkPhone(CommonFunctions.randomPhoneNumber())
//            );
//            app.contacts().openHomePage();
//        }
//        var contacts = app.hbm().getContactList();
//        var contact = contacts.get(0);
//        var phones = app.contacts().getPhones(contact);
//        var expected = Stream.of(contact.homePhone(), contact.mobilePhone(), contact.workPhone(), contact.secondaryPhone())
//                .filter(s -> s != null && ! "".equals(s))
//                .collect(Collectors.joining("\n"));
//        Assertions.assertEquals(expected, phones);
//    }

}
