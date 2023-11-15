package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entites.Bloc;
import tn.esprit.springproject.entites.Reservation;
import tn.esprit.springproject.repositories.ReservationRepositorie;

import java.util.List;
import java.util.Set;


public interface IReservation{

    List<Reservation> getAllReservation();
    Reservation getReservationById(String id);
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(String id, Reservation newReservation);
    void deleteReservation(String id);
    public Set<Reservation> getReservationsByEtudiantID(long idEtudiant);
    public Set<Reservation> getReservationsByEtudiantNom(String nomEtudiant);
    public List<Reservation> findRsvByStudentName();
}
