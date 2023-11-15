package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entites.Reservation;
import tn.esprit.springproject.repositories.ReservationRepositorie;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ReservationServiceImp implements IReservation{

    public final ReservationRepositorie reservationRepositorie;

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepositorie.findAll();
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepositorie.findById(id).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepositorie.save(reservation);
    }

    @Override
    public Reservation updateReservation(String id, Reservation updatedReservation) {
        Reservation oldReservation = getReservationById(id);
        if(oldReservation != null){
            updatedReservation.setIdReservation(id);

        }
        return null;
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepositorie.deleteById(id);
    }

    @Override
    public Set<Reservation> getReservationsByEtudiantID(long idEtudiant) {
        return reservationRepositorie.getReservationsByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public Set<Reservation> getReservationsByEtudiantNom(String nomEtudiant) {
        return reservationRepositorie.getReservationsByEtudiantsNom(nomEtudiant);
    }

    @Override
    public List<Reservation> findRsvByStudentName() {
        return reservationRepositorie.findRsvByStudentName();
    }

}
