/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

import user.UserDTO;

/**
 *
 * @author Mai
 */
public class GroupDTO extends UserDTO{
    private String groupID;
    private String groupName;
    private int userGroupID;
    private String capstoneID;
    private int numOfPer;
    private int statusGroupID;

    public GroupDTO() {
    }

    public GroupDTO(String groupID, String groupName, String userID, String username, String password, String roleID, String gmail, String phone, String statusID, String photoUrl) {
        super(userID, username, password, roleID, gmail, phone, statusID, photoUrl);
        this.groupID = groupID;
        this.groupName = groupName;
    }
    
    @Override
    public String getGroupID() {
        return groupID;
    }

    @Override
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    @Override
    public String getGroupName() {
        return groupName;
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(int userGroupID) {
        this.userGroupID = userGroupID;
    }

    public String getCapstoneID() {
        return capstoneID;
    }

    public void setCapstoneID(String capstoneID) {
        this.capstoneID = capstoneID;
    }

    public int getNumOfPer() {
        return numOfPer;
    }

    public void setNumOfPer(int numOfPer) {
        this.numOfPer = numOfPer;
    }

    public int getStatusGroupID() {
        return statusGroupID;
    }

    public void setStatusGroupID(int statusID) {
        this.statusGroupID = statusID;
    }

    @Override
    public String toString() {
        return "GroupDTO{" + 
                "groupID=" + groupID + 
                ", groupName=" + groupName +
                ", userGroupID=" + userGroupID + 
                ", capstoneID=" + capstoneID + 
                ", numOfPer=" + numOfPer + 
                ", statusGroupID=" + statusGroupID + 
                ", userID=" + userID + 
                ", username=" + username + 
                ", phone=" + phone + 
                ", gmail=" + gmail + 
                ", statusID=" + statusID +'}';
    }

    
}
