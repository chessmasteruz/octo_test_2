package uz.rovshan.testtask2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "cards_transactions")
@Data
public class CardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable=false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name="card_id", referencedColumnName = "id", nullable=false)
    @JsonIgnore
    private Card card;

    @Column(columnDefinition = "VARCHAR(6) CHECK(type in ('debit', 'credit'))")
    private String type;

    private Long amount;

    private Long old_balance;

    private Long new_balance;

    @Column(columnDefinition = "TIMESTAMP default current_timestamp")
    @CreationTimestamp
    private Timestamp dt;
}
