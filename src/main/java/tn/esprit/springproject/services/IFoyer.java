package tn.esprit.springproject.services;

import tn.esprit.springproject.entites.Foyer;

import java.util.List;

public interface IFoyer {
    public Foyer addFoyer(Foyer f);
    public Foyer updateFoyer(Foyer f);
    public List<Foyer>  findAllFoyer();
    public Foyer findFoyer(long idF);
    public void deleteFoyer(long idF);
    public Foyer findFoyerByName(String nomFoyer);

}
