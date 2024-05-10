package com.project.pms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    private String admID;
    private String password;

    Admin(){}

    Admin(String admID, String password){
        super();
        this.admID = admID;
        this.password = password;
    }
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getadmID() {
        return admID;
    }
    public void setadmID(String admID) {
        this.admID = admID;
    }
    @Override
	public String toString() {
		return "Admin [admID=" + admID +  ", password=" + password +" ]";
	}

}
