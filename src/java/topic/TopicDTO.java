/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author PNKV
 */
public class TopicDTO implements Serializable{
    int capstoneID;
    String capstoneName;
    int groupID;
    String userName;
    Date registerDate;
    Date startTime;
    Date endTime;
    String semeterID;
    int statusID;

    public TopicDTO(int capstoneID, String capstoneName, int groupID, String semeterID, int statusID, String userName) {
        this.capstoneID = capstoneID;
        this.capstoneName = capstoneName;
        this.groupID = groupID;
        this.semeterID = semeterID;
        this.statusID = statusID;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TopicDTO() {
    }

    
    
    public int getCapstoneID() {
        return capstoneID;
    }

    public void setCapstoneID(int capstoneID) {
        this.capstoneID = capstoneID;
    }

    public String getCapstoneName() {
        return capstoneName;
    }

    public void setCapstoneName(String capstoneName) {
        this.capstoneName = capstoneName;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getSemeterID() {
        return semeterID;
    }

    public void setSemeterID(String semeterID) {
        this.semeterID = semeterID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    @Override
    public String toString() {
        return "TopicDTO{" + "capstoneID=" + capstoneID + ", capstoneName=" + capstoneName + ", groupID=" + groupID + ", userName=" + userName + ", registerDate=" + registerDate + ", startTime=" + startTime + ", endTime=" + endTime + ", semeterID=" + semeterID + ", statusID=" + statusID + '}';
    }

    
    
    
}
