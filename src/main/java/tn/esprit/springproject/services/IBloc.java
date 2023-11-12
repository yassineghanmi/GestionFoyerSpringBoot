package tn.esprit.springproject.services;

import tn.esprit.springproject.entites.Bloc;
import tn.esprit.springproject.entites.Foyer;
import tn.esprit.springproject.entites.TypeChambre;

import java.util.Set;

public interface IBloc  {
    public Set<Bloc> findByChamberTypeC(TypeChambre typeC);
}
