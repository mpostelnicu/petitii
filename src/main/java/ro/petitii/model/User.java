package ro.petitii.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    public enum UserRole {
        ADMIN, USER, SUSPENDED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(DataTablesOutput.View.class)
    private Long id;

    @NotEmpty
    @Email
    @JsonView(DataTablesOutput.View.class)
    private String email;

    private String password;

    @Transient
    private String passwordCopy;

    @Transient
    private Boolean changePassword;

    @JsonView(DataTablesOutput.View.class)
    private String firstName;
    @JsonView(DataTablesOutput.View.class)
    private String lastName;

//    @NotEmpty
    @Enumerated(EnumType.STRING)
    @JsonView(DataTablesOutput.View.class)
    private UserRole role;

    @OneToMany(mappedBy = "responsible")
    private Collection<Petition> petition;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPasswordCopy() {
        return passwordCopy;
    }

    public void setPasswordCopy(String passwordCopy) {
        this.passwordCopy = passwordCopy;
    }

    public Boolean getChangePassword() {
        return changePassword;
    }

    public void setChangePassword(Boolean changePassword) {
        this.changePassword = changePassword;
    }

    public Collection<Petition> getPetition() {
        return petition;
    }

    public void setPetition(Collection<Petition> petition) {
        this.petition = petition;
    }
}
