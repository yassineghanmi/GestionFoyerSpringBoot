package tn.esprit.springproject.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nom;
    private String prenomEtm;
    private long cin;
    private String ecole;

    @Temporal (TemporalType.DATE)
    private Date dateNaissance;
    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    private List<Reservation> reservations;
}
