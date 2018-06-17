package com.paigunna.api.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Arm
 */

@Entity
@Table(name = "Test")
public class Test implements Serializable {
    @Id
    @TableGenerator(
            name = "user",
            table = "sequence",
            pkColumnValue = "user",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            generator = "user",
            strategy = GenerationType.TABLE
    )
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(id, test.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
