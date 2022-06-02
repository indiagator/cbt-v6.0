package pojo;

public class Human {

    private String username;
    private String phonenumber;
    private String emailid;
    private String password;

    private String name;
    private String city;
    private String country;

    private String company;

    private String usertype = "buyer"; //seller, both

    public void setUsertype(String type) {
        this.usertype = type;
    }

    public String getUsertype() {
        return usertype;
    }

    public Human()
    {

    }

    public Human(String username, String password)
    {
        this.username = username;
        this.password = password;
    }



    public Human(String username, String phonenumber, String password)
    {
        this.username =username;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public Human(String username, String phonenumber,String emailid, String password)
    {
        this.username =username;
        this.phonenumber = phonenumber;
        this.emailid = emailid;
        this.password = password;
    }

    public void setUsername(String username){

        this.username=username;

    }

    public String getUsername() {
        return username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
