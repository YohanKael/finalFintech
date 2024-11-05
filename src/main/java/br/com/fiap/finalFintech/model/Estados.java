package br.com.fiap.finalFintech.model;

public class Estados {

    int idEstado;

    String nmEstado;

    public Estados(int idEstado, String nmEstado) {
        this.idEstado = idEstado;
        this.nmEstado = nmEstado;
    }

    public Estados( String nmEstado) {
        this.nmEstado = nmEstado;
    }


    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }


}
