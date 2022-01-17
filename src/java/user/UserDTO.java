/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author mac
 */
public class UserDTO {
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

}
