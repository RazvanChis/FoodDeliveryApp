package model;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", unique = true, nullable = true)
    private int addressId;

    @Column(name = "country", nullable = true)
    private String country;

    @Column(name = "county", nullable = true)
    private String county;

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "street", nullable = true)
    private String street;

    @Column(name = "streetnumber", nullable = true)
    private int streetNumber;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

}
