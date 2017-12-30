package com.fls.entities;

/**
 * Created by Marcin on 2017-12-12.
 */
public class User {
    private Long tokenId;
    private Long userId;
    private String firstName;
    private String lastName;
    private byte[] image;

    public User(Long tokenId, Long userId, String firstName, String lastName, byte[] image) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
