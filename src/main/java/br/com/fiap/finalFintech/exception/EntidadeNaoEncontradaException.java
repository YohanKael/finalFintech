package br.com.fiap.finalFintech.exception;


public class EntidadeNaoEncontradaException extends Exception{
    public EntidadeNaoEncontradaException() {
    }
    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}