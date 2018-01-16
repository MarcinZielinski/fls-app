package com.fls.profiles.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Programist implements IUser {
    private LongProperty id;
    private StringProperty login;
    private StringProperty password;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty birthdate;
    private StringProperty email;
    private StringProperty phone;
    private StringProperty address;
    private StringProperty city;
    private StringProperty country;
    private ObjectProperty<Set<String>> spokenLanguages;
    private ObjectProperty<Set<String>> programmingLanguages;
    private StringProperty experience;
    private StringProperty flsPoints;
    private StringProperty stackPoints;
    private StringProperty hackerrankPoints;
    private ObjectProperty<Image> image;
    private ArrayList<Long> friends;

    public Programist(long id, String login, String password, String firstname, String lastname, String birthdate, String email, String phone, String address,
                      String city, String country, Set<String> spoken, Set<String> programming, Integer experience,
                      Integer fls, Integer stack, Integer hacker, Image img, ArrayList<Long> friends) {
        this.id = new SimpleLongProperty(id);
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.birthdate = new SimpleStringProperty(birthdate);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.address = new SimpleStringProperty(address);
        this.city = new SimpleStringProperty(city);
        this.country = new SimpleStringProperty(country);
        this.spokenLanguages = new SimpleObjectProperty<>(spoken);
        this.programmingLanguages = new SimpleObjectProperty<>(programming);
        this.experience = new SimpleStringProperty(experience.toString());
        this.flsPoints = new SimpleStringProperty(fls.toString());
        this.stackPoints = new SimpleStringProperty(stack.toString());
        this.hackerrankPoints = new SimpleStringProperty(hacker.toString());
        this.image = new SimpleObjectProperty<>(img);
        this.friends = friends;
    }

    public Programist() {
        this.id = new SimpleLongProperty();
        this.login = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.firstname = new SimpleStringProperty();
        this.lastname = new SimpleStringProperty();
        this.birthdate = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.city = new SimpleStringProperty();
        this.country = new SimpleStringProperty();
        this.spokenLanguages = new SimpleObjectProperty<>(new HashSet<>());
        this.programmingLanguages = new SimpleObjectProperty<>(new HashSet<>());
        this.experience = new SimpleStringProperty();
        this.flsPoints = new SimpleStringProperty();
        this.stackPoints = new SimpleStringProperty();
        this.hackerrankPoints = new SimpleStringProperty();
        this.image = new SimpleObjectProperty<>();
        this.friends = new ArrayList<Long>();
    }

    @Override
    public void setID(int id) {
        this.id.set(id);
    }

    @Override
    public void setLogin(String login) {
        this.login.set(login);
    }

    @Override
    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public void setFirstname(String name) {
        this.firstname.set(name);
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    @Override
    public void setBirthdate(String bdate) {
        this.birthdate.set(bdate);
    }

    @Override
    public void setEmail(String email) {
        this.email.set(email);
    }

    @Override
    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    @Override
    public void setAddress(String address) {
        this.address.set(address);
    }

    @Override
    public void setCity(String city) {
        this.city.set(city);
    }

    @Override
    public void setCountry(String country) {
        this.country.set(country);
    }

    @Override
    public void setSpokenLanguages(Set<String> languages) {
        this.spokenLanguages.set(languages);
    }

    @Override
    public void setProgrammingLanguages(Set<String> languages) {
        this.programmingLanguages.set(languages);
    }

    @Override
    public void setExperience(Integer years) {
        this.experience.set(String.valueOf(years));
    }

    @Override
    public void setFlsPoints(Integer points) {
        this.flsPoints.set(String.valueOf(points));
    }

    @Override
    public void setStackPoints(Integer points) {
        this.stackPoints.set(String.valueOf(points));
    }

    @Override
    public void setHackerrankPoints(Integer points) {
        this.hackerrankPoints.set(String.valueOf(points));
    }

    @Override
    public void setImage(Image img) {
        this.image.set(img);
    }

    @Override
    public long getID() {
        return id.get();
    }

    @Override
    public String getLogin() {
        return login.get();
    }

    @Override
    public String getPassword() {
        return password.get();
    }

    @Override
    public String getFirstname() {
        return firstname.get();
    }

    @Override
    public String getLastname() {
        return lastname.get();
    }

    @Override
    public String getBirthdate() {
        return birthdate.get();
    }

    @Override
    public String getEmail() {
        return email.get();
    }

    @Override
    public String getPhone() {
        return phone.get();
    }

    @Override
    public String getAddress() {
        return address.get();
    }

    @Override
    public String getCity() {
        return city.get();
    }

    @Override
    public String getCountry() {
        return country.get();
    }

    @Override
    public Set<String> getSpokenLanguages() {
        return spokenLanguages.get();
    }

    @Override
    public Set<String> getProgrammingLanguages() {
        return programmingLanguages.get();
    }

    @Override
    public Integer getExperience() {
        return Integer.getInteger(experience.get());
    }

    @Override
    public Integer getFlsPoints() {
        return Integer.getInteger(flsPoints.get());
    }

    @Override
    public Integer getStackPoints() {
        return Integer.getInteger(stackPoints.get());
    }

    @Override
    public Integer getHackerrankPoints() {
        return Integer.getInteger(hackerrankPoints.get());
    }

    @Override
    public Image getImage() {
        return image.get();
    }

    @Override
    public ArrayList<Long> getFriends() {
        return friends;
    }

    @Override
    public StringProperty getLoginProperty() {
        return login;
    }

    @Override
    public StringProperty getPasswordProperty() {
        return password;
    }

    @Override
    public StringProperty getFirstnameProperty() {
        return firstname;
    }

    @Override
    public StringProperty getLastnameProperty() {
        return lastname;
    }

    @Override
    public StringProperty getBirthdateProperty() {
        return birthdate;
    }

    @Override
    public StringProperty getEmailProperty() {
        return email;
    }

    @Override
    public StringProperty getPhoneProperty() {
        return phone;
    }

    @Override
    public StringProperty getAddressProperty() {
        return address;
    }

    @Override
    public StringProperty getCityProperty() {
        return city;
    }

    @Override
    public StringProperty getCountryProperty() {
        return country;
    }

    @Override
    public ObjectProperty<Set<String>> getSpokenLanguagesProperty() {
        return spokenLanguages;
    }

    @Override
    public ObjectProperty<Set<String>> getProgrammingLanguagesProperty() {
        return programmingLanguages;
    }

    @Override
    public StringProperty getExperienceProperty() {
        return experience;
    }

    @Override
    public StringProperty getFlsPointsProperty() {
        return flsPoints;
    }

    @Override
    public StringProperty getStackPointsProperty() {
        return stackPoints;
    }

    @Override
    public StringProperty getHackerrankPointsProperty() {
        return hackerrankPoints;
    }

    @Override
    public ObjectProperty<Image> getImageProperty() {
        return image;
    }
}
