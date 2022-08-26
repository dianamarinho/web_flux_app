package com.poi.pointOfInterest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * The User model entity
 */
@Table("user_table")
public class User {

    @Id
    private Integer id;

    private String name;
    private String description;
    private String addressName;
    private String city;
    private String zipCode;
    private String userType;

    /**
     * Gets the id of the User
     *
     * @return the User id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the User
     *
     * @param id id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the User
     *
     * @return the Username
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the User
     *
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address name of the User
     *
     * @return the User address name
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * Sets the address name of the User
     *
     * @param addressName address name to set
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * Gets the city of the User
     *
     * @return the User city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the User
     *
     * @param city city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the zip code of the User
     *
     * @return the User zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code of the User
     *
     * @param zipCode zip code to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the type of the User
     *
     * @return the User type
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the type of the User
     *
     * @param userType type to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @see Object#equals(Object)
     *
     * @param o the object to compare
     * @return true or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(addressName, that.addressName) && Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && Objects.equals(userType, that.userType);
    }

    /**
     * @see Object#hashCode()
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, addressName, city, zipCode, userType);
    }

    /**
     * @see Object#toString()
     * @return the string
     */
    @Override
    public String toString() {
        return "PointOfInterest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", addressName='" + addressName + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
