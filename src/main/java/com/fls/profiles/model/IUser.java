package com.fls.profiles.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Set;

public interface IUser {

    void setID(int id);
    void setLogin(String login);
    void setPassword(String password);
    void setFirstname(String name);
    void setLastname(String lastname);
    void setBirthdate(String bdate);
    void setEmail(String email);
    void setPhone(String phone);
    void setAddress(String address);
    void setCity(String city);
    void setCountry(String country);
    void setSpokenLanguages(Set<String> languages);
    void setProgrammingLanguages(Set<String> languages);
    void setExperience(Integer years);
    void setFlsPoints(Integer points);
    void setStackPoints(Integer points);
    void setHackerrankPoints(Integer points);
    void setImage(Image img);


    long getID();
    String getLogin();
    String getPassword();
    String getFirstname();
    String getLastname();
    String getBirthdate();
    String getEmail();
    String getPhone();
    String getAddress();
    String getCity();
    String getCountry();
    Set<String> getSpokenLanguages();
    Set<String> getProgrammingLanguages();
    Integer getExperience();
    Integer getFlsPoints();
    Integer getStackPoints();
    Integer getHackerrankPoints();
    Image getImage();
    ArrayList<Long> getFriends();

    StringProperty getLoginProperty();
    StringProperty getPasswordProperty();
    StringProperty getFirstnameProperty();
    StringProperty getLastnameProperty();
    StringProperty getBirthdateProperty();
    StringProperty getEmailProperty();
    StringProperty getPhoneProperty();
    StringProperty getAddressProperty();
    StringProperty getCityProperty();
    StringProperty getCountryProperty();
    ObjectProperty<Set<String>> getSpokenLanguagesProperty();
    ObjectProperty<Set<String>> getProgrammingLanguagesProperty();
    StringProperty getExperienceProperty();
    StringProperty getFlsPointsProperty();
    StringProperty getStackPointsProperty();
    StringProperty getHackerrankPointsProperty();
    ObjectProperty<Image> getImageProperty();
}
