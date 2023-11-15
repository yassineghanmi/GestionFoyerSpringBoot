package tn.esprit.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject.entites.Chambre;

import java.util.Set;

public interface ChambreRepositorie extends JpaRepository<Chambre, Long> {
    public Set<Chambre> findChambresByBloc_IdBloc(long idBlock);
}
