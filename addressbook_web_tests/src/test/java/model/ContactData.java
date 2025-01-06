package model;

public record ContactData(
        String id,
        String firstName,
        String middleName,
        String lastName,
        String nickName,
        String photo,
        String title,
        String company,
        String address,
        String homePhone,
        String mobilePhone,
        String workPhone,
        String Fax,
        String email,
        String email2,
        String email3,
        String homePage,
        String bDay,
        String bMonth,
        String bYear,
        String aDay,
        String aMonth,
        String aYear,
        String newGroup,
        String secondaryPhone) {

    public ContactData() {
        this ("", "", "", "", "", "", "", "", "", "", "",
                "", "", "", "", "", "", "", "", "", "", "", "",
                "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }
    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }
    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstName, this.middleName, lastname, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }
    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withHomePhone(String homephone) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, homephone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withMobilePhone(String mobilephone) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, mobilephone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withWorkPhone(String workphone) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, workphone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withSecondaryPhone(String secondaryphone) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, secondaryphone);
    }

    public ContactData withNickName(String nickname) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, nickname, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }

    public ContactData withFirstNameAndLastName(String firstname, String lastName) {
        return new ContactData(this.id, firstname, this.middleName, lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilePhone, this.workPhone,
                this.Fax, this.email, this.email2, this.email3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup, this.secondaryPhone);
    }
}