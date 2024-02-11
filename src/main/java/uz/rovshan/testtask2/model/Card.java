package uz.rovshan.testtask2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "cards")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", nullable=false)
    @JsonIgnore
    private User user;

    @Column(name = "card_name")
    private String cardName;

    @Column(name="card_type", columnDefinition = "VARCHAR(3) CHECK(card_type in ('uz', 'hum'))")
    private String cardType;

    @Column(name = "card_number", length = 20)
    private String cardNumber;

    @Column(name = "card_expire", length = 7)
    private String cardExpire;

    private Long balance;

    private int status;

    @Column(columnDefinition = "TIMESTAMP default current_timestamp")
    @CreationTimestamp
    private Timestamp dt;

    @OneToMany(mappedBy="card", cascade = CascadeType.ALL)
    private List<CardTransaction> transactions;
}
