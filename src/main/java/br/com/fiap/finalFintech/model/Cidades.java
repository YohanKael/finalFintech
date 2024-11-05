package br.com.fiap.finalFintech.model;

public class Cidades {
    int idCidade;

    String nmCidade;

    public Cidades(int idCidade, String nmCidade) {
        this.idCidade = idCidade;
        this.nmCidade = nmCidade;
    }


    public Cidades(String nmCidade) {
        this.nmCidade = nmCidade;
    }


    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

}
