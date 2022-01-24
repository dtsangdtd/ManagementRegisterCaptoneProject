/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.Serializable;

/**
 *
 * @author mac
 */
public class UserDTO implements Serializable{
    private String userID;
    private String username;
    private String password;
    private String roleID;
    private String gmail;
    private String phone;
    private String capstoneID;
    private String groupID;
    private String statusID;
    private String photoUrl;
    
    private String semesterName;
    private String capstoneName;
    
    public UserDTO() {
    }

    public UserDTO(String userID, String username, String password, String roleID, String gmail, String phone, String capstoneID, String groupID, String statusID, String photoUrl) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
        this.gmail = gmail;
        this.phone = phone;
        this.capstoneID = capstoneID;
        this.groupID = groupID;
        this.statusID = statusID;
        this.photoUrl = photoUrl;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getCapstoneName() {
        return capstoneName;
    }

    public void setCapstoneName(String capstoneName) {
        this.capstoneName = capstoneName;
    }

    public UserDTO(String userID, String username, String gmail, String phone, String photoUrl, String semesterName, String capstoneName) {
        this.userID = userID;
        this.username = username;
        this.gmail = gmail;
        this.phone = phone;
        this.photoUrl = photoUrl;
        this.semesterName = semesterName;
        this.capstoneName = capstoneName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCapstoneID() {
        return capstoneID;
    }

    public void setCapstoneID(String capstoneID) {
        this.capstoneID = capstoneID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", roleID=" + roleID + ", gmail=" + gmail + ", phone=" + phone + ", capstoneID=" + capstoneID + ", groupID=" + groupID + ", statusID=" + statusID + ", photoUrl=" + photoUrl + ", semesterName=" + semesterName + ", capstoneName=" + capstoneName + '}';
    }

}
