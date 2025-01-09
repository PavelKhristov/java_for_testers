package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactHelper extends BaseHelper {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openHomePage() {
//        if (!manager.isElementPresent(By.name("searchstring"))){
            сlick(By.linkText("home"));
//        }
    }

    public void openContactCreationPage() {
        if (!manager.isElementPresent(By.name("submit"))){
            сlick(By.linkText("add new"));
        }
    }

    public void createContact(ContactData contact) {
        openContactCreationPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
        // manager.driver.findElement(By.name("submit")).click();
        //manager.driver.findElement(By.linkText("home page")).click();
    }

    public void createContactWithGroup(ContactData contact, GroupData group) {
        openContactCreationPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToHomePage();
    }

    public void addGroupToContact(ContactData contact, GroupData group) {
        openHomePage();
        chooseNoneGroupInHomePage();
        selectContact(contact);
        chooseGroupForContactInHomePage(group);
        submitGropAddition();
        returnToHomePageAfterGropChanging(group);
    }

    public void removeGroupFromContact(ContactData contact, GroupData group) {
        openHomePage();
        chooseGroupInHomePage(group);
        selectContact(contact);
        removeContactsGroup();
        returnToHomePageAfterGropChanging(group);
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    private void chooseGroupForContactInHomePage(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void chooseGroupInHomePage(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void chooseNoneGroupInHomePage() {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue("[none]");
    }

    private void submitGropAddition() {
        сlick(By.name("add"));
    }

    private void removeContactsGroup() {
        сlick(By.name("remove"));
    }

    public void deleteContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContacts();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    private void submitContactModification() {
        сlick(By.name("update"));
    }

    private void returnToHomePageAfterGropChanging(GroupData group) {
        сlick(By.linkText(String.format("group page \"%s\"", group.name())));
//        сlick(By.cssSelector(String.format("a[href=\"edit.php?id=%s\"]",  group.id())));
    }

    private void initContactModification(ContactData contact) {
        сlick(By.cssSelector(String.format("a[href=\"edit.php?id=%s\"]",  contact.id())));
    }

    private void returnToHomePage() {
        сlick(By.linkText("home page"));
    }

    private void submitContactCreation() {
        сlick(By.name("submit"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        //manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstName())
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("nickname"), contact.nickName());
        if (contact.photo().isEmpty()){
        } else {attach(By.name("photo"), contact.photo());}
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.homePhone());
        type(By.name("mobile"), contact.mobilePhone());
        type(By.name("work"), contact.workPhone());
        type(By.name("fax"), contact.Fax());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        type(By.name("homepage"), contact.homePage());
        chooseElementFromSelector(By.name("bday"), contact.bDay());
        chooseElementFromSelector(By.name("bmonth"), contact.bMonth());
        chooseElementFromSelector(By.name("byear"), contact.bYear());
        chooseElementFromSelector(By.name("aday"), contact.aDay());
        chooseElementFromSelector(By.name("amonth"), contact.aMonth());
        chooseElementFromSelector(By.name("ayear"), contact.aYear());
        if (contact.newGroup().isEmpty()){
        } else {chooseElementFromSelector(By.name("new_group"), contact.newGroup());}

    }

    private void removeSelectedContacts() {
        сlick(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact(ContactData contact) {
        сlick(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCountContacts() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void RemovalAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectedContacts();
    }

    public void openContactPage(ContactData contact) {
        openHomePage();
        initContactModification(contact);
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes){
            checkbox.click();
        }
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.cssSelector("tr[name=\"entry\"]"));
        for (var tr : trs){
            var tdfirstname = tr.findElement(By.xpath("td[3]"));
            var firstname = tdfirstname.getText();
            var tdlastname = tr.findElement(By.xpath("td[2]"));
            var lastname = tdlastname.getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
        }
        return contacts;
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();    //  "/.." означает подъем на один уровень верх,
    }

    public String getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[4]", contact.id()))).getText();
    }

    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[5]", contact.id()))).getText();
    }

    public String getPhonesFromContactPage() {
        var home = manager.driver.findElement(By.name("home")).getAttribute("value");
        var mobile = manager.driver.findElement(By.name("mobile")).getAttribute("value");
        var work = manager.driver.findElement(By.name("work")).getAttribute("value");
        var result = home + "\n" + mobile + "\n" + work;
        return result;
    }

    public String getAddressFromContactPage() {
        var address = manager.driver.findElement(By.name("address")).getText();
        var result = address;
        return result;
    }

    public String getEmailsFromContactPage() {
        var email = manager.driver.findElement(By.name("email")).getAttribute("value");
        var email2 = manager.driver.findElement(By.name("email2")).getAttribute("value");
        var email3 = manager.driver.findElement(By.name("email3")).getAttribute("value");
        var result = email + "\n" + email2 + "\n" + email3;
        return result;
    }

    //Попытка вытащить всю информацию о контакте разом с главной страницы
    public String getContactInformationFromHomePage(ContactData contact) {
        var address = manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[4]", contact.id()))).getText();
        var emails = manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[5]", contact.id()))).getText();
        var phones = manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
        var result = address + "\n" + emails + "\n" + phones;
        return result;
    }

    //Попытка вытащить всю информацию о контакте разом со страницы контакта
    public String getInformationFromContactPage() {
        var address = manager.driver.findElement(By.name("address")).getText();
        var home = manager.driver.findElement(By.name("home")).getAttribute("value");
        var mobile = manager.driver.findElement(By.name("mobile")).getAttribute("value");
        var work = manager.driver.findElement(By.name("work")).getAttribute("value");
        var email = manager.driver.findElement(By.name("email")).getAttribute("value");
        var email2 = manager.driver.findElement(By.name("email2")).getAttribute("value");
        var email3 = manager.driver.findElement(By.name("email3")).getAttribute("value");
        var result = address + "\n" + email + "\n" + email2 + "\n" + email3 + "\n" + home + "\n" + mobile + "\n" + work;
        return result;
    }




}
