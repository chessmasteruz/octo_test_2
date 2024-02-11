package uz.rovshan.testtask2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String fio;

    private String email;

    private Long phone;

    private int status;

    @JsonFormat(pattern="dd.MM.yyyy")
    private Date dob;

    @Column(columnDefinition = "TIMESTAMP default current_timestamp")
    @CreationTimestamp
    private Timestamp dt;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Card> cards;
}
