package com.poly.Model;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")

public class Users {
    @Id
    @Column(name = "id")
    String username;
    String password;
    String fullname;
    String email;
    Boolean admin = true;

    @OneToMany(mappedBy = "users")
    List<Favorite> favorite;

    public Users() {

    }

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Users(String username, String password, String fullname, String email, Boolean admin) {
        super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.admin = admin;

    }
}