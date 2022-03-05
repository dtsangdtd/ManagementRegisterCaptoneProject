/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone;

import user.UserDTO;

/**
 *
 * @author dtsang
 */
public class CapstoneDTO extends UserDTO{
    public String capstoneID, capstoneName, groupId, registerDate, startTime, endTime, semesterId, statusId;

    public CapstoneDTO() {
    }

    public CapstoneDTO(String capstoneName, String userID, String username, String gmail, String phone) {
        super(userID, username, gmail, phone);
        this.capstoneName = capstoneName;
    }

    public CapstoneDTO(String capstoneID, String capstoneName, String groupId, String registerDate, String startTime, String endTime, String semesterId, String statusId) {
        this.capstoneID = capstoneID;
        this.capstoneName = capstoneName;
        this.groupId = groupId;
        this.registerDate = registerDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.semesterId = semesterId;
        this.statusId = statusId;
    }

    public String getCapstoneID() {
        return capstoneID;
    }

    public void setCapstoneID(String capstoneID) {
        this.capstoneID = capstoneID;
    }

    public String getCapstoneName() {
        return capstoneName;
    }

    public void setCapstoneName(String capstoneName) {
        this.capstoneName = capstoneName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "CapstoneDTO{" + "capstoneID=" + capstoneID + ", capstoneName=" + capstoneName + ", groupId=" + groupId + ", registerDate=" + registerDate + ", startTime=" + startTime + ", endTime=" + endTime + ", semesterId=" + semesterId + ", statusId=" + statusId + '}';
    }
    
}