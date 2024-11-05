package br.com.fiap.finalFintech.model;

public class Paises {


    int idPais;

    String nmPais;


    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNmPais() {
        return nmPais;
    }

    public void setNmPais(String nmPais) {
        this.nmPais = nmPais;
    }

    public Paises(int idPais, String nmPais) {
        this.idPais = idPais;
        this.nmPais = nmPais;
    }

    public Paises(String nmPais) {
        this.nmPais = nmPais;
    }
}


