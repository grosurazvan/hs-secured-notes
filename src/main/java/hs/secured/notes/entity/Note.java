package hs.secured.notes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String ownerUsername;
}
