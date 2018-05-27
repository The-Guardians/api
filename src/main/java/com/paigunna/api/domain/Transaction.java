package com.paigunna.api.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author armme : 15/03/2018
 */

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable{

    @Id
    @TableGenerator(
            name = "transaction",
            table = "sequence",
            pkColumnValue = "transaction",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            generator = "transaction",
            strategy = GenerationType.TABLE
    )
    private Long id;


    @Column(name = "time_start", nullable = false, length = 20)
    private String transacionTimeStart;

    @Column(name = "time_finish", nullable = false, length = 20)
    private String transactionTimeFinish;

    @Column(name = "date", nullable = false, length = 20)
    private String transactionDate;

    @Column(nullable = false, insertable = false ,updatable = false)
    private User provider;

    @Column(nullable = false,insertable = false,updatable = false)
    private User passenger;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
