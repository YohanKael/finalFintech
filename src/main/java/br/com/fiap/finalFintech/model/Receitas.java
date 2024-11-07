package br.com.fiap.finalFintech.model;
import java.time.LocalDate;

public class Receitas {

    int idReceita;

    String dsReceita;

    LocalDate dtReceita;

    float qtValorReceita;

    public Receitas(int idReceita, String dsReceita, LocalDate dtReceita, float qtValorReceita) {
        this.idReceita = idReceita;
        this.dsReceita = dsReceita;
        this.dtReceita = dtReceita;
        this.qtValorReceita = qtValorReceita;
    }

    public Receitas(String dsReceita, LocalDate dtReceita, float qtValorReceita) {
        this.dsReceita = dsReceita;
        this.dtReceita = dtReceita;
        this.qtValorReceita = qtValorReceita;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public String getDsReceita() {
        return dsReceita;
    }

    public void setDsReceita(String dsReceita) {
        this.dsReceita = dsReceita;
    }

    public LocalDate getDtReceita() {
        return dtReceita;
    }

    public void setDtReceita(LocalDate dtReceita) {
        this.dtReceita = dtReceita;
    }

    public float getQtValorReceita() {
        return qtValorReceita;
    }

    public void setQtValorReceita(float qtValorReceita) {
        this.qtValorReceita = qtValorReceita;
    }


}

