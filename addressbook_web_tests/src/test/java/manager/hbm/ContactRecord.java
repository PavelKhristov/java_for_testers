package manager.hbm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    public int id;
    public String firstname;
    public String lastname;
    public String middlename;
    public String address;
    public String nickname;
    public String home;
    public String mobile;
    public String work;
    public String email;
    public String email2;
    public String email3;

    public String company = new String("");
    public String title = new String("");
    public String fax = new String("");
    public String homepage = new String("");
    public String phone2 = new String("");



    public ContactRecord(){}

    public ContactRecord(int id, String firstname, String lastname, String middlename,
                         String address, String nickname, String home, String mobile, String work, String email, String email2, String email3){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.address = address;
        this.nickname = nickname;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
    }
}
