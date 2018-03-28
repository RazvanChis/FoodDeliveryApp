package model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "CNP", unique = true, nullable = false)
    private String cnp;

    @Column(name = "firstname", nullable = true, length = 30)
    private String firstName;

    @Column(name = "lastname", nullable = true, length = 30)
    private String lastName;

    @Column(name = "username", unique = false, nullable = true)
    private String username;

//    @OneToOne(optional = false, targetEntity = UserAddress.class)
//    private UserAddress address;

    @Column(name = "cardnumber", unique = false, nullable = true)
    private String cardNumber;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "email", unique = false, nullable = true)
    private String email;


    @Column(name = "type", nullable = true)
    private int type;

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public UserAddress getAddress() {
//        return address;
//    }
//
//    public void setAddress(UserAddress address) {
//        this.address = address;
//    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return username + " " + email;
    }
}
