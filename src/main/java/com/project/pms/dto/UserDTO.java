package com.project.pms.dto;

public class UserDTO {
    private String username;
    private int uid;
    private byte isOnline;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public byte getIsOnline() {
        return isOnline;
    }
    public void setIsOnline(byte isOnline) {
        this.isOnline = isOnline;
    }
    public int getId() {
        return uid;
    }
    public void setId(int uid) {
        this.uid = uid;
    }
    public UserDTO() {
    }
    public UserDTO(String username, int uid, byte isOnline) {
        this.username = username;
        this.uid = uid;
        this.isOnline = isOnline;
    }
}
