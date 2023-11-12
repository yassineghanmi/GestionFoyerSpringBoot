package tn.esprit.springproject.entites;

public enum TypeChambre {
    SIMPLE("simple"),DOUBLE("double"),TRIPLE("triple");
    private String type;
    TypeChambre(String type){
        this.type = type;
    }
    public String getType() {
        return type;
    }

}
