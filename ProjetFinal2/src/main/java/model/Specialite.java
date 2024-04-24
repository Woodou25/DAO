package model;

public class Specialite {
    private int idCompte;
    private int idMatiere;

    public Specialite(int idCompte, int idMatiere) {
        this.idCompte = idCompte;
        this.idMatiere = idMatiere;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
}
