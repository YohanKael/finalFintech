package br.com.fiap.finalFintech.model;

public class Enderecos {

    int idEndereco;

    String numeroCep;

    int numeroResidencia;

    String nomeRua;

    String complementoEndereco;

    public Enderecos() {

    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNumeroCep() {
        return numeroCep;
    }

    public void setNumeroCep(String numeroCep) {
        this.numeroCep = numeroCep;
    }

    public int getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(int numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }


    public Enderecos(String numeroCep, int numeroResidencia, String nomeRua, String complementoEndereco) {
        this.numeroCep = numeroCep;
        this.nomeRua = nomeRua;
        this.numeroResidencia = numeroResidencia;
        this.complementoEndereco = complementoEndereco;
    }

    public Enderecos(int idEndereco, String numeroCep, int numeroResidencia, String nomeRua, String complementoEndereco) {
        this.idEndereco = idEndereco;
        this.numeroCep = numeroCep;
        this.nomeRua = nomeRua;
        this.numeroResidencia = numeroResidencia;
        this.complementoEndereco = complementoEndereco;
    }


}
