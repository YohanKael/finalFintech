package br.com.fiap.finalFintech.model;

public class Transacoes extends Conta {
    private int idTransacao;
    private float qtValor;
    private float qtSaldo;
    private float qtSaldoAtualizado;

    public Transacoes(float qtValor, float qtSaldo) {
        this.qtValor = qtValor;
        this.qtSaldo = qtSaldo;
    }

    public Transacoes(int idTransacao, float qtValor, float qtSaldo, float qtSaldoAtualizado) {
        super();
        this.idTransacao = idTransacao;
        this.qtValor = qtValor;
        this.qtSaldo = qtSaldo;
        this.qtSaldoAtualizado = qtSaldoAtualizado;
    }

    // Getters e Setters
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public float getQtValor() {
        return qtValor;
    }

    public void setQtValor(float qtValor) {
        this.qtValor = qtValor;
    }

    public float getQtSaldo() {
        return qtSaldo;
    }

    public void setQtSaldo(float qtSaldo) {
        this.qtSaldo = qtSaldo;
        this.qtSaldoAtualizado = qtSaldo + qtValor;
    }

    public void setQtSaldoAtualizado(float qtSaldoAtualizado) {
        this.qtSaldoAtualizado = qtSaldoAtualizado;
    }

    public float getQtSaldoAtualizado() {
        return qtSaldo + qtValor;
    }

}
