package model;

public record ContactData(String id, String firstName, String middleName, String lastName, String nickName, String photo, String title,
                          String company, String address, String homePhone, String mobilephone, String workPhone,
                          String Fax, String e_mail, String e_mail2, String e_mail3, String homePage, String bDay,
                          String bMonth, String bYear, String aDay, String aMonth, String aYear, String newGroup) {
    public ContactData() {
        this ("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilephone, this.workPhone,
                this.Fax, this.e_mail, this.e_mail2, this.e_mail3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup);
    }
    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilephone, this.workPhone,
                this.Fax, this.e_mail, this.e_mail2, this.e_mail3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup);
    }
    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstName, this.middleName, lastname, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilephone, this.workPhone,
                this.Fax, this.e_mail, this.e_mail2, this.e_mail3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup);
    }
    public ContactData withMiddleName(String middlename) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilephone, this.workPhone,
                this.Fax, this.e_mail, this.e_mail2, this.e_mail3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, photo, this.title, this.company, this.address, this.homePhone, this.mobilephone, this.workPhone,
                this.Fax, this.e_mail, this.e_mail2, this.e_mail3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.photo, this.title, this.company, address, this.homePhone, this.mobilephone, this.workPhone,
                this.Fax, this.e_mail, this.e_mail2, this.e_mail3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup);
    }

    public ContactData withNickName(String nickname) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, nickname, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilephone, this.workPhone,
                this.Fax, this.e_mail, this.e_mail2, this.e_mail3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup);
    }

    public ContactData withFirstNameAndLastName(String firstname, String lastName) {
        return new ContactData(this.id, firstname, this.middleName, lastName, this.nickName, this.photo, this.title, this.company, this.address, this.homePhone, this.mobilephone, this.workPhone,
                this.Fax, this.e_mail, this.e_mail2, this.e_mail3, this.homePage, this.bDay, this.bMonth, this.bYear, this.aDay, this.aMonth, this.aYear, this.newGroup);
    }
}