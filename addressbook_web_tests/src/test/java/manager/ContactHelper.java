package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.name("searchstring"))){
            сlick(By.linkText("home"));
        }
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
        attach(By.name("photo"), contact.photo());
        type(By.name("title"), contact.title());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("home"), contact.homePhone());
        type(By.name("mobile"), contact.mobilephone());
        type(By.name("work"), contact.workPhone());
        type(By.name("fax"), contact.Fax());
        type(By.name("email"), contact.e_mail());
        type(By.name("email2"), contact.e_mail2());
        type(By.name("email3"), contact.e_mail3());
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


}
