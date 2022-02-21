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
    int requestID;
    String requestDetail;//Thông tin chi tiết tính sau đi
    String userID; //ID của người mời (LoginUser)
    int isSupervisor;

    public RequestDTO() {
    }

    public RequestDTO(int requestID, String requestDetail, String userID, int isSupervisor) {
        this.requestID = requestID;
        this.requestDetail = requestDetail;//ID của người được mời
        this.userID = userID;//ID của người mời
        this.isSupervisor = isSupervisor;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
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

    public int getIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(int isSupervisor) {
        this.isSupervisor = isSupervisor;
    }
}
