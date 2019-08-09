/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author sudhan
 */
public class TouristBean implements java.io.Serializable {
    
    private String firstName;
    private String lastName;
    private String emailAdd;
    private String username;
    private String password;
    private String dob;
    private int contactNumber;
    private String addNo;
    private String addStreet1;
    private String addStreet2;
    private String city;
    private int postalCode;
    private String country;
    
    public TouristBean(){}

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the emailAdd
     */
    public String getEmailAdd() {
        return emailAdd;
    }

    /**
     * @param emailAdd the emailAdd to set
     */
    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the contactNumber
     */
    public int getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the addNo
     */
    public String getAddNo() {
        return addNo;
    }

    /**
     * @param addNo the addNo to set
     */
    public void setAddNo(String addNo) {
        this.addNo = addNo;
    }

    /**
     * @return the addStreet1
     */
    public String getAddStreet1() {
        return addStreet1;
    }

    /**
     * @param addStreet1 the addStreet1 to set
     */
    public void setAddStreet1(String addStreet1) {
        this.addStreet1 = addStreet1;
    }

    /**
     * @return the addStreet2
     */
    public String getAddStreet2() {
        return addStreet2;
    }

    /**
     * @param addStreet2 the addStreet2 to set
     */
    public void setAddStreet2(String addStreet2) {
        this.addStreet2 = addStreet2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the postalCode
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
