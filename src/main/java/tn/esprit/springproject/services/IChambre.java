package tn.esprit.springproject.services;

import tn.esprit.springproject.entites.Chambre;
import tn.esprit.springproject.entites.Etudiant;

import java.util.List;
import java.util.Set;

public interface IChambre {
    public Set<Chambre> getChambresByBloc(long id);
    public Chambre addChambre(Chambre E);
    public Chambre updateChambre(long id,Chambre E);
    public List<Chambre> findAllChambre();
    public Chambre findChambre(long id);
    public void deleteChambre (long id);
}
