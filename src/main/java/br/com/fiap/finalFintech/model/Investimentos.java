package br.com.fiap.finalFintech.model;

import java.time.LocalDate;

public class Investimentos{

    private int cd_investimentos;

    private String ds_investimentos;

    private float qt_valor_investimento;

    private LocalDate dt_investimentos;

    private LocalDate dt_retirada_investimentos;

    public Investimentos(float qtValorInvestido, LocalDate dtInvestimentos) {
        this.qt_valor_investimento = qtValorInvestido;
        this.dt_investimentos = dtInvestimentos;
    }


    public int getCd_investimentos() {
        return cd_investimentos;
    }

    public void setCd_investimentos(int cd_investimentos) {
        this.cd_investimentos = cd_investimentos;
    }

    public String getDs_investimentos() {
        return ds_investimentos;
    }

    public void setDs_investimentos(String ds_investimentos) {
        this.ds_investimentos = ds_investimentos;
    }

    public float getQt_valor_investimento() {
        return qt_valor_investimento;
    }

    public void setQt_valor_investimento(float qt_valor_investimento) {
        this.qt_valor_investimento = qt_valor_investimento;
    }

    public LocalDate getDt_investimentos() {
        return dt_investimentos;
    }

    public void setDt_investimentos(LocalDate dt_investimentos) {
        this.dt_investimentos = dt_investimentos;
    }

    public LocalDate getDt_retirada_investimentos() {
        return dt_retirada_investimentos;
    }

    public void setDt_retirada_investimentos(LocalDate dt_retirada_investimentos) {
        this.dt_retirada_investimentos = dt_retirada_investimentos;
    }




    public Investimentos(int cd_investimentos, String ds_investimentos, float qt_valor_investido, LocalDate dt_investimentos, LocalDate dt_retirada_investimentos){
        this.cd_investimentos = cd_investimentos;
        this.ds_investimentos = ds_investimentos;
        this.qt_valor_investimento = qt_valor_investido;
        this.dt_investimentos = dt_investimentos;
        this.dt_retirada_investimentos = dt_retirada_investimentos;
    }

    public Investimentos(String ds_investimentos, float qt_valor_investido, LocalDate dt_investimentos, LocalDate dt_retirada_investimentos){
        this.ds_investimentos = ds_investimentos;
        this.qt_valor_investimento = qt_valor_investido;
        this.dt_investimentos = dt_investimentos;
        this.dt_retirada_investimentos = dt_retirada_investimentos;
    }


    public Investimentos(){

    }
}
