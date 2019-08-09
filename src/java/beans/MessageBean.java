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
public class MessageBean implements java.io.Serializable{
    
    private int msgId;
    private String touristUser;
    private String businessUser;
    private int eventId;
    private String message;

    /**
     * @return the msgId
     */
    public int getMsgId() {
        return msgId;
    }

    /**
     * @param msgId the msgId to set
     */
    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    /**
     * @return the touristUser
     */
    public String getTouristUser() {
        return touristUser;
    }

    /**
     * @param touristUser the touristUser to set
     */
    public void setTouristUser(String touristUser) {
        this.touristUser = touristUser;
    }

    /**
     * @return the businessUser
     */
    public String getBusinessUser() {
        return businessUser;
    }

    /**
     * @param businessUser the businessUser to set
     */
    public void setBusinessUser(String businessUser) {
        this.businessUser = businessUser;
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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
