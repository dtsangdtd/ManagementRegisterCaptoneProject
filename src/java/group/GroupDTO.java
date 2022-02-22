/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

/**
 *
 * @author Mai
 */
public class GroupDTO {
    private int groupID;
    private String groupName;
    private int capstoneID;
    private int numOfPer;
    private int statusID;

    public GroupDTO() {
    }

    public GroupDTO(int groupID, String groupName, int capstoneID, int numOfPer, int statusID) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.capstoneID = capstoneID;
        this.numOfPer = numOfPer;
        this.statusID = statusID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getCapstoneID() {
        return capstoneID;
    }

    public void setCapstoneID(int capstoneID) {
        this.capstoneID = capstoneID;
    }

    public int getNumOfPer() {
        return numOfPer;
    }

    public void setNumOfPer(int numOfPer) {
        this.numOfPer = numOfPer;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    
}
