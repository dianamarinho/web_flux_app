package com.poi.pointOfInterest.dto;

import java.util.Objects;
import com.poi.pointOfInterest.domain.User;

/**
 * The {@link User} data transfer object
 */
public class UserDto {

    private Integer id;
    private String name;
    private String addressName;
    private String city;
    private String zipCode;
    private String userType;

    /**
     * Gets the id of the User DTO
     *
     * @return the User DTO id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id of the User DTO
     *
     * @param id id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the User DTO
     *
     * @return the User DTO name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the User DTO
     *
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address name of the User DTO
     *
     * @return the User DTO address name
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * Sets the address name of the User DTO
     *
     * @param addressName address name to set
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /**
     * Gets the city of the User DTO
     *
     * @return the User DTO city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the User DTO
     *
     * @param city city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the zip code of the User DTO
     *
     * @return the User DTO zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code of the User DTO
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
     * @see Object#toString()
     * @return the string
     */
    @Override
    public String toString() {
        return "PointOfInterestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressName='" + addressName + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", userType='" + userType + '\'' +
                '}';
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
        UserDto that = (UserDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(addressName, that.addressName) && Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && Objects.equals(userType, that.userType);
    }

    /**
     * @see Object#hashCode()
     *
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressName, city, zipCode, userType);
    }


}
