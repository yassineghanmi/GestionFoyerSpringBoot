package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject.entites.Reservation;

import java.util.List;
import java.util.Set;

public interface ReservationRepositorie extends JpaRepository<Reservation,String> {
    Set<Reservation> getReservationsByEtudiantsIdEtudiant(long idEtudiant);
    Set<Reservation> getReservationsByEtudiantsNom(String nomEtudiant);

    @Query("SELECT r FROM Reservation r JOIN r.etudiants s WHERE s.nom LIKE 'AB%'")
    List<Reservation> findRsvByStudentName();


}
