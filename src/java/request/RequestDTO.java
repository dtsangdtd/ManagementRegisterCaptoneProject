/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

/**
 *
 * @author ASUS
 */
public class RequestDTO {
    String requestID;
    String requestDetail;
    String userID;
    String isSupervisor;

    public RequestDTO() {
    }

    public RequestDTO(String requestID, String requestDetail, String userID, String isSupervisor) {
        this.requestID = requestID;
        this.requestDetail = requestDetail;
        this.userID = userID;
        this.isSupervisor = isSupervisor;
    }
    
    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getRequestDetail() {
        return requestDetail;
    }

    public void setRequestDetail(String requestDetail) {
        this.requestDetail = requestDetail;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(String isSupervisor) {
        this.isSupervisor = isSupervisor;
    }
    
    
}
