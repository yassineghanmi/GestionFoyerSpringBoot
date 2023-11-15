package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entites.Chambre;
import tn.esprit.springproject.repositories.ChambreRepositorie;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ChamberServiceImp implements IChambre{

    private final ChambreRepositorie chambreRepositorie;

    @Override
    public Set<Chambre> getChambresByBloc(long id) {
        return chambreRepositorie.findChambresByBloc_IdBloc(id);
    }

    @Override
    public Chambre addChambre(Chambre E) {
        return chambreRepositorie.save(E);
    }

    @Override
    public Chambre updateChambre(long id, Chambre updatedChambre) {
        Chambre oldChamber = findChambre(id);
        if(oldChamber != null){
            updatedChambre.setIdChambre(id);
            return chambreRepositorie.saveAndFlush(updatedChambre);
        }
        return null;
    }

    @Override
    public List<Chambre> findAllChambre() {
        return chambreRepositorie.findAll();
    }

    @Override
    public Chambre findChambre(long id) {
        return chambreRepositorie.findById(id).orElse(null);
    }

    @Override
    public void deleteChambre(long id) {
        chambreRepositorie.deleteById(id);
    }
}
