package br.com.fiap.finalFintech.model;

public class Investimentos extends Conta {

    private int cd_investimentos;

    private String ds_investimentos;

    private float qt_valor_investido;

    private String dt_investimentos;

    private String dt_retirada_investimentos;

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

    public float getQt_valor_investido() {
        return qt_valor_investido;
    }

    public void setQt_valor_investido(float qt_valor_investido) {
        this.qt_valor_investido = qt_valor_investido;
    }

    public String getDt_investimentos() {
        return dt_investimentos;
    }

    public void setDt_investimentos(String dt_investimentos) {
        this.dt_investimentos = dt_investimentos;
    }

    public String getDt_retirada_investimentos() {
        return dt_retirada_investimentos;
    }

    public void setDt_retirada_investimentos(String dt_retirada_investimentos) {
        this.dt_retirada_investimentos = dt_retirada_investimentos;
    }




    public Investimentos(int cd_conta, int cd_investimentos, String ds_investimentos, float qt_valor_investido, String dt_investimentos, String dt_retirada_investimentos){
        super(cd_conta);
        this.cd_investimentos = cd_investimentos;
        this.ds_investimentos = ds_investimentos;
        this.qt_valor_investido = qt_valor_investido;
        this.dt_investimentos = dt_investimentos;
        this.dt_retirada_investimentos = dt_retirada_investimentos;
    }

    public Investimentos(String ds_investimentos, float qt_valor_investido, String dt_investimentos, String dt_retirada_investimentos){
        super();
        this.ds_investimentos = ds_investimentos;
        this.qt_valor_investido = qt_valor_investido;
        this.dt_investimentos = dt_investimentos;
        this.dt_retirada_investimentos = dt_retirada_investimentos;
    }

    public Investimentos(int cd_investimentos ,String ds_investimentos, float qt_valor_investido, String dt_investimentos, String dt_retirada_investimentos){
        super();
        this.cd_investimentos = cd_investimentos;
        this.ds_investimentos = ds_investimentos;
        this.qt_valor_investido = qt_valor_investido;
        this.dt_investimentos = dt_investimentos;
        this.dt_retirada_investimentos = dt_retirada_investimentos;
    }

    public Investimentos(){

    }
}
