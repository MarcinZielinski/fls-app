package com.fls.entities;
import lombok.Data;

import java.util.Set; /**
 * Created by Marcin on 2017-12-12.
 */
public class User {
    private Long tokenId;
    private Long userId;
    private String firstName;
    private String lastName;
    private Set<String> spokenLanguages;
    private Set<String> programmingLanguages;
    private Integer experience;
    private Integer flsPoints;
    private Integer stackPoints;
    private Integer hackerrankPoints;
    private byte[] image;

    public User(Long tokenId, Long userId, String firstName, String lastName, byte[] image) {
        this.tokenId = tokenId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
    }

    public User(String firstName, String lastName, Set<String> spokenLanguages, Set<String> programmingLanguages, Integer experience, Integer flsPoints, Integer stackPoints, Integer hackerrankPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.spokenLanguages = spokenLanguages;
        this.programmingLanguages = programmingLanguages;
        this.experience = experience;
        this.flsPoints = flsPoints;
        this.stackPoints = stackPoints;
        this.hackerrankPoints = hackerrankPoints;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }
}
