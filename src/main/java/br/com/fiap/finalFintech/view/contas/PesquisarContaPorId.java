package br.com.fiap.finalFintech.view.contas;//package br.com.fintechfinal.view.contas;
//
//import br.com.fintechfinal.dao.ContasDaoImpl;
//import br.com.fiap.fintechfinal.exception.fintechfinal.EntidadeNaoEncontradaException;
//import br.com.fiap.fintechfinal.model.fintechfinal.Conta;
//
//import java.sql.SQLException;
//
//public class PesquisarContaPorId {
//    public static void main(String[] args) {
//        try {
//            ContasDaoImpl dao = new ContasDaoImpl();
//            Conta conta = dao.pesquisar(1);
//            System.out.println("Id da Conta:" + conta.getId_conta() + "," + " Saldo da conta: " + conta.getSaldo() + "," + " Data de crianção da conta: " + conta.getDt_criacao_conta() + "," + " Data encerramento da conta: " + conta.getDt_encerramento_conta());
//            dao.fecharConexao();
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        } catch (EntidadeNaoEncontradaException e) {
//            System.err.println("Codigo não existe na tabela de contas");
//        }
//    }
//}
