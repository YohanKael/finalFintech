package br.com.fiap.finalFintech.model;

public class Telefones extends Usuario {

    private int idTelefone;
    private String nrCodigoPais;
    private String nrDdd;
    private String nrTelefone;

    public Telefones(int idTelefone, String nrCodigoPais, String nrDdd, String nrTelefone) {
        super();
        this.idTelefone = idTelefone;
        this.nrCodigoPais = nrCodigoPais;
        this.nrDdd = nrDdd;
        this.nrTelefone = nrTelefone;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNrDdd() {
        return nrDdd;
    }

    public void setNrDdd(String nrDdd) {
        this.nrDdd = nrDdd;
    }

    public String getNrCodigoPais() {
        return nrCodigoPais;
    }

    public void setNrCodigoPais(String nrCodigoPais) {
        this.nrCodigoPais = nrCodigoPais;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public Telefones(String nrCodigoPais, String nrDdd, String nrTelefone) {
        super();
        this.nrCodigoPais = nrCodigoPais;
        this.nrDdd = nrDdd;
        this.nrTelefone = nrTelefone;
    }

}