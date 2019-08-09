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
public class BookEventBean implements java.io.Serializable{
    
    private int eventBookId;
    private String touristFirstName;
    private String touristLastName;
    private String touristEmailAdd;
    private int mobileNumber;
    private String bookingDate;
    private String bookingTime;
    private int numberOfPerson;
    private int totalPrice;
    private String eventBookTable;

    /**
     * @return the eventBookId
     */
    public int getEventBookId() {
        return eventBookId;
    }

    /**
     * @param eventBookId the eventBookId to set
     */
    public void setEventBookId(int eventBookId) {
        this.eventBookId = eventBookId;
    }

    /**
     * @return the touristFirstName
     */
    public String getTouristFirstName() {
        return touristFirstName;
    }

    /**
     * @param touristFirstName the touristFirstName to set
     */
    public void setTouristFirstName(String touristFirstName) {
        this.touristFirstName = touristFirstName;
    }

    /**
     * @return the touristLastName
     */
    public String getTouristLastName() {
        return touristLastName;
    }

    /**
     * @param touristLastName the touristLastName to set
     */
    public void setTouristLastName(String touristLastName) {
        this.touristLastName = touristLastName;
    }

    /**
     * @return the touristEmailAdd
     */
    public String getTouristEmailAdd() {
        return touristEmailAdd;
    }

    /**
     * @param touristEmailAdd the touristEmailAdd to set
     */
    public void setTouristEmailAdd(String touristEmailAdd) {
        this.touristEmailAdd = touristEmailAdd;
    }

    /**
     * @return the bookingDate
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * @param bookingDate the bookingDate to set
     */
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * @return the numberOfPerson
     */
    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    /**
     * @param numberOfPerson the numberOfPerson to set
     */
    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    /**
     * @return the totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the bookingTime
     */
    public String getBookingTime() {
        return bookingTime;
    }

    /**
     * @param bookingTime the bookingTime to set
     */
    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    /**
     * @return the mobileNumber
     */
    public int getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the eventBookTable
     */
    public String getEventBookTable() {
        return eventBookTable;
    }

    /**
     * @param eventBookTable the eventBookTable to set
     */
    public void setEventBookTable(String eventBookTable) {
        this.eventBookTable = eventBookTable;
    }
    
}
