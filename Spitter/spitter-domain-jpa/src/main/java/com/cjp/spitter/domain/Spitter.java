package com.cjp.spitter.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "spitter")
public class Spitter implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
    private String username;

    @Size(min = 6, max = 20, message = "The password must be at least 6 characters long.")
    private String password;

    @Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
    private String fullName;

    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message = "Invalid email address.")
    private String email;
    private boolean updateByEmail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "fullname")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "update_by_email")
    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spitter spitter = (Spitter) o;
        return updateByEmail == spitter.updateByEmail &&
                Objects.equals(id, spitter.id) &&
                Objects.equals(username, spitter.username) &&
                Objects.equals(password, spitter.password) &&
                Objects.equals(fullName, spitter.fullName) &&
                Objects.equals(email, spitter.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, fullName, email, updateByEmail);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Spitter{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", updateByEmail=").append(updateByEmail);
        sb.append('}');
        return sb.toString();
    }
}
