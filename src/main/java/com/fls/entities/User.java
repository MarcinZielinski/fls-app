package com.fls.entities;

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
    private Integer text;
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

    public User(String firstName, String lastName, Set<String> spokenLanguages, Set<String> programmingLanguages, Integer experience, Integer text, Integer stackPoints, Integer hackerrankPoints) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.spokenLanguages = spokenLanguages;
        this.programmingLanguages = programmingLanguages;
        this.experience = experience;
        this.text = text;
        this.stackPoints = stackPoints;
        this.hackerrankPoints = hackerrankPoints;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Set<String> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(Set<String> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public Set<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(Set<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getText() {
        return text;
    }

    public void setText(Integer text) {
        this.text = text;
    }

    public Integer getStackPoints() {
        return stackPoints;
    }

    public void setStackPoints(Integer stackPoints) {
        this.stackPoints = stackPoints;
    }

    public Integer getHackerrankPoints() {
        return hackerrankPoints;
    }

    public void setHackerrankPoints(Integer hackerrankPoints) {
        this.hackerrankPoints = hackerrankPoints;
    }
}
