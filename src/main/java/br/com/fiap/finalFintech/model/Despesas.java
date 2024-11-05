package br.com.fiap.finalFintech.model;

import java.time.LocalDate;

public class Despesas {

    int idDespesa;

    String dsDespesa;

    LocalDate dtDespesa;

    float qtValorDespesa;

    public Despesas(int idDespesa, String dsDespesa, LocalDate dtDespesa, float qtValorDespesa) {
        this.idDespesa = idDespesa;
        this.dsDespesa = dsDespesa;
        this.dtDespesa = dtDespesa;
        this.qtValorDespesa = qtValorDespesa;
    }

    public Despesas(String dsDespesa, LocalDate dtDespesa, float qtValorDespesa) {
        this.dsDespesa = dsDespesa;
        this.dtDespesa = dtDespesa;
        this.qtValorDespesa = qtValorDespesa;
    }

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getDsDespesa() {
        return dsDespesa;
    }

    public void setDsDespesa(String dsDespesa) {
        this.dsDespesa = dsDespesa;
    }

    public LocalDate getDtDespesa() {
        return dtDespesa;
    }

    public void setDtDespesa(LocalDate dtDespesa) {
        this.dtDespesa = dtDespesa;
    }

    public float getQtValorDespesa() {
        return qtValorDespesa;
    }

    public void setQtValorDespesa(float qtValorDespesa) {
        this.qtValorDespesa = qtValorDespesa;
    }


}

