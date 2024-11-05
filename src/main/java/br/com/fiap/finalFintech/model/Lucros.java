package br.com.fiap.finalFintech.model;
import java.time.LocalDate;

public class Lucros {

    int idLucro;

    String dsLucro;

    LocalDate dtLucro;

    float qtValorLucro;

    public Lucros(int idLucro, String dsLucro, LocalDate dtLucro, float qtValorLucro) {
        this.idLucro = idLucro;
        this.dsLucro = dsLucro;
        this.dtLucro = dtLucro;
        this.qtValorLucro = qtValorLucro;
    }

    public Lucros(String dsLucro, LocalDate dtLucro, float qtValorLucro) {
        this.dsLucro = dsLucro;
        this.dtLucro = dtLucro;
        this.qtValorLucro = qtValorLucro;
    }

    public int getIdLucro() {
        return idLucro;
    }

    public void setIdLucro(int idLucro) {
        this.idLucro = idLucro;
    }

    public String getDsLucro() {
        return dsLucro;
    }

    public void setDsLucro(String dsLucro) {
        this.dsLucro = dsLucro;
    }

    public LocalDate getDtLucro() {
        return dtLucro;
    }

    public void setDtLucro(LocalDate dtLucro) {
        this.dtLucro = dtLucro;
    }

    public float getQtValorLucro() {
        return qtValorLucro;
    }

    public void setQtValorLucro(float qtValorLucro) {
        this.qtValorLucro = qtValorLucro;
    }


}

