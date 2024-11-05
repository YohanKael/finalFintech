package br.com.fiap.finalFintech.model;

public class Bairros extends Enderecos {

    int idBairro;

    String dsBairro;

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public String getDsBairro() {
        return dsBairro;
    }

    public void setDsBairro(String dsBairro) {
        this.dsBairro = dsBairro;
    }

    public Bairros(int idBairro, String dsBairro){
        super();
        this.idBairro = idBairro;
        this.dsBairro = dsBairro;

    }
    public Bairros(String dsBairro){
        super();
        this.dsBairro = dsBairro;

    }

}
