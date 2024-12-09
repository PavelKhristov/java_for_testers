package manager;

import model.ContactData;
import org.openqa.selenium.By;

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
        type(By.name("firstname"), contact.firstName());
        //manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstName())
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("nickname"), contact.nickName());
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
        type(By.name("bday"), contact.bDay());
        type(By.name("bmonth"), contact.bMonth());
        type(By.name("byear"), contact.bYear());
        type(By.name("aday"), contact.aDay());
        type(By.name("amonth"), contact.aMonth());
        type(By.name("ayear"), contact.aYear());
        type(By.name("new_group"), contact.newGroup());
        сlick(By.name("submit"));
        сlick(By.linkText("home page"));
       // manager.driver.findElement(By.name("submit")).click();
        //manager.driver.findElement(By.linkText("home page")).click();
    }

    public void deleteContact() {
        openHomePage();
        selectContact();
        removeSelectedContacts();
    }

    private void removeSelectedContacts() {
        сlick(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectContact() {
        сlick(By.name("selected[]"));
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
}
