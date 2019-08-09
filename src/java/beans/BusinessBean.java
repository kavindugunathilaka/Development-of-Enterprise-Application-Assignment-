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
public class BusinessBean implements java.io.Serializable {
    
    private String ownerFirstName;
    private String ownerLastName;
    private String businessEmail;
    private String username;
    private String password;
    private String businessName;
    private String addNo;
    private String addStreet1;
    private String addStreet2;
    private String city;
    private int postalCode;
    private String province;
    private String approvelStatus;
    
    public BusinessBean(){}

    /**
     * @return the ownerFirstName
     */
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    /**
     * @param ownerFirstName the ownerFirstName to set
     */
    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    /**
     * @return the ownerLastName
     */
    public String getOwnerLastName() {
        return ownerLastName;
    }

    /**
     * @param ownerLastName the ownerLastName to set
     */
    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    /**
     * @return the businessEmail
     */
    public String getBusinessEmail() {
        return businessEmail;
    }

    /**
     * @param businessEmail the businessEmail to set
     */
    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
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
     * @return the businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the approvelStatus
     */
    public String getApprovelStatus() {
        return approvelStatus;
    }

    /**
     * @param approvelStatus the approvelStatus to set
     */
    public void setApprovelStatus(String approvelStatus) {
        this.approvelStatus = approvelStatus;
    }
    
    
    
}
