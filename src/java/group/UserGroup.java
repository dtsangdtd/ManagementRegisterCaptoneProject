/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import user.UserDTO;

/**
 *
 * @author Mai
 */
public class UserGroup {
    private Map<Integer , List<UserDTO>> userGroup;

    public UserGroup() {
    }

    public UserGroup(Map<Integer, List<UserDTO>> userGroup) {
        this.userGroup = userGroup;
    }

    public Map<Integer, List<UserDTO>> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(Map<Integer, List<UserDTO>> userGroup) {
        this.userGroup = userGroup;
    }
    public void add(int key, List<UserDTO> list){
        if (this.userGroup == null){
            this.userGroup = new HashMap<>();
        }
        //userGroup.put(list.get(list.size()-1).getGroupID(), list);
    }
}
