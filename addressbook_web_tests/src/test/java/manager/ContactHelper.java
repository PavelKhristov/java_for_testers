package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {
    public final ApplicationManager manager;
    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }


    /*private BaseHelper base;
    public BaseHelper base () {
        if (base == null){
            base = new BaseHelper(this);
        }
        return base;
    }*/

    public void OpenHomePage() {
        if (!isPesent("searchstring")){
            ClickLink("home");
        }
    }

    public void OpenContactCreationPage() {
        if (!isPesent("submit")){
            ClickLink("add new");
        }
    }



    public void createContact(ContactData contact) {
        OpenContactCreationPage();
        FillInTheFieldByValue("firstname", contact.firstName());
        //manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstName())
        FillInTheFieldByValue("middlename", contact.middleName());
        FillInTheFieldByValue("lastname", contact.lastName());
        FillInTheFieldByValue("nickname", contact.nickName());
        FillInTheFieldByValue("title", contact.title());
        FillInTheFieldByValue("company", contact.company());
        FillInTheFieldByValue("address", contact.address());
        FillInTheFieldByValue("home", contact.homePhone());
        FillInTheFieldByValue("mobile", contact.mobilephone());
        FillInTheFieldByValue("work", contact.workPhone());
        FillInTheFieldByValue("fax", contact.Fax());
        FillInTheFieldByValue("email", contact.e_mail());
        FillInTheFieldByValue("email2", contact.e_mail2());
        FillInTheFieldByValue("email3", contact.e_mail3());
        FillInTheFieldByValue("homepage", contact.homePage());
        FillInTheFieldByValue("bday", contact.bDay());
        FillInTheFieldByValue("bmonth", contact.bMonth());
        FillInTheFieldByValue("byear", contact.bYear());
        FillInTheFieldByValue("aday", contact.aDay());
        FillInTheFieldByValue("amonth", contact.aMonth());
        FillInTheFieldByValue("ayear", contact.aYear());
        FillInTheFieldByValue("new_group", contact.newGroup());
        ClickButton("submit");
        ClickLink("home page");
       // manager.driver.findElement(By.name("submit")).click();
        //manager.driver.findElement(By.linkText("home page")).click();
    }

    public void DeleteContact() {
        OpenHomePage();
        ClickButton("selected[]");
        ClickByXpath("//input[@value=\'Delete\']");
    }

    public boolean IsContactPresent() {
        OpenHomePage();
        return isPesent("selected[]");
    }
    
    
    


    public void ClickButton(String button) {
        manager.driver.findElement(By.name(button)).click();
    }

    void ClickLink(String link) {
        manager.driver.findElement(By.linkText(link)).click();
    }

    void FillInTheFieldByValue(String fieldName, String field) {
        manager.driver.findElement(By.name(fieldName)).sendKeys(field);
    }

    private void ClickByXpath(String xPath) {
        manager.driver.findElement(By.xpath(xPath)).click();
    }

    private boolean isPesent(String elementName) {
        return manager.isElementPresent(By.name(elementName));
    }

}
