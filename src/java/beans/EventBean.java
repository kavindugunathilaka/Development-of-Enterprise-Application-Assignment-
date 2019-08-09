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
import java.io.InputStream;
import java.sql.Blob;
import javax.servlet.http.Part;
public class EventBean implements java.io.Serializable{
    
    private int eventId;
    private String eventName;
    private String businessUsername;
    private String startDate;
    private String endDate;
    private String Category;
    private int eventContactNumber;
    private String eventContactPerson;
    private int eventPrice;
    private String eventCity;
    private String eventDetails;
    private Blob eventImage;
    private InputStream insertImage;
    private String eventBookDetail;
    
    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the businessUsername
     */
    public String getBusinessUsername() {
        return businessUsername;
    }

    /**
     * @param businessUsername the businessUsername to set
     */
    public void setBusinessUsername(String businessUsername) {
        this.businessUsername = businessUsername;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(String Category) {
        this.Category = Category;
    }

    /**
     * @return the eventContactNumber
     */
    public int getEventContactNumber() {
        return eventContactNumber;
    }

    /**
     * @param eventContactNumber the eventContactNumber to set
     */
    public void setEventContactNumber(int eventContactNumber) {
        this.eventContactNumber = eventContactNumber;
    }

    /**
     * @return the eventContactPerson
     */
    public String getEventContactPerson() {
        return eventContactPerson;
    }

    /**
     * @param eventContactPerson the eventContactPerson to set
     */
    public void setEventContactPerson(String eventContactPerson) {
        this.eventContactPerson = eventContactPerson;
    }

    /**
     * @return the eventPrice
     */
    public int getEventPrice() {
        return eventPrice;
    }

    /**
     * @param eventPrice the eventPrice to set
     */
    public void setEventPrice(int eventPrice) {
        this.eventPrice = eventPrice;
    }

    /**
     * @return the eventCity
     */
    public String getEventCity() {
        return eventCity;
    }

    /**
     * @param eventCity the eventCity to set
     */
    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    /**
     * @return the eventDetails
     */
    public String getEventDetails() {
        return eventDetails;
    }

    /**
     * @param eventDetails the eventDetails to set
     */
    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    /**
     * @return the eventImage
     */
    public Blob getEventImage() {
        return eventImage;
    }

    /**
     * @param eventImage the eventImage to set
     */
    public void setEventImage(Blob eventImage) {
        this.eventImage = eventImage;
    }

    /**
     * @return the eventId
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the insertImage
     */
    public InputStream getInsertImage() {
        return insertImage;
    }

    /**
     * @param insertImage the insertImage to set
     */
    public void setInsertImage(InputStream insertImage) {
        this.insertImage = insertImage;
    }

    /**
     * @return the eventBookDetail
     */
    public String getEventBookDetail() {
        return eventBookDetail;
    }

    /**
     * @param eventBookDetail the eventBookDetail to set
     */
    public void setEventBookDetail(String eventBookDetail) {
        this.eventBookDetail = eventBookDetail;
    }
    
    
    
}
