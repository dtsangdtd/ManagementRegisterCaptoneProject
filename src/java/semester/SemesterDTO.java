/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semester;

import java.io.Serializable;

/**
 *
 * @author dtsang
 */
public class SemesterDTO  implements Serializable{
    public String semesterID;
    public String semesterName;

    public SemesterDTO() {
    }

    public SemesterDTO(String semesterID, String semesterName) {
        this.semesterID = semesterID;
        this.semesterName = semesterName;
    }

    public String getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(String semesterID) {
        this.semesterID = semesterID;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Override
    public String toString() {
        return "SemesterDTO{" + "semesterID=" + semesterID + ", semesterName=" + semesterName + '}';
    }
    
}
