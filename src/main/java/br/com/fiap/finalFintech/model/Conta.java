package br.com.fiap.finalFintech.model;

import java.time.LocalDate;

public class Conta {

    private int id_conta;

    private float saldo;

    private LocalDate dt_criacao_conta;

    private LocalDate dt_encerramento_conta;

    public Conta() {

    }


    public void setId_conta(int id_conta) {

        this.id_conta = id_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {

        this.saldo = saldo;
    }

    public LocalDate getDt_criacao_conta() {

        return dt_criacao_conta;
    }

    public void setDt_criacao_conta(LocalDate dt_criacao_conta) {

        this.dt_criacao_conta = dt_criacao_conta;
    }

    public LocalDate getDt_encerramento_conta() {

        return dt_encerramento_conta;
    }

    public void setDt_encerramento_conta(LocalDate dt_encerramento_conta) {
        this.dt_encerramento_conta = dt_encerramento_conta;
    }


    public int getId_conta() {
        return this.id_conta;
    }

    public Conta(int id_conta, float saldo, LocalDate dt_criacao_conta, LocalDate dt_encerramento_conta) {
        this.id_conta = id_conta;
        this.saldo = saldo;
        this.dt_criacao_conta = dt_criacao_conta;
        this.dt_encerramento_conta = dt_encerramento_conta;
    }
    public Conta(float saldo, LocalDate dt_criacao_conta, LocalDate dt_encerramento_conta) {
        this.saldo = saldo;
        this.dt_criacao_conta = dt_criacao_conta;
        this.dt_encerramento_conta = dt_encerramento_conta;
    }

    public Conta(float saldo, LocalDate dt_criacao_conta) {
        this.saldo = saldo;
        this.dt_criacao_conta = dt_criacao_conta;
        this.dt_encerramento_conta = null;
    }


    public Conta(int id_conta) {

        this.id_conta = id_conta;
    }

}
