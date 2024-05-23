package com.project.pms.dto;

public class UserDTO {
    private String username;
    private int uid;
    private byte isOnline;
    private byte[] image;
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
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
    public UserDTO(String username, int uid, byte isOnline, byte[] image, String name) {
        this.username = username;
        this.uid = uid;
        this.isOnline = isOnline;
        this.image = image;
        this.name = name;
    }
}
