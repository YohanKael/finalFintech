package br.com.fiap.finalFintech.view.contas;//package br.com.fintechfinal.view.contas;
//import br.com.fintechfinal.dao.ContasDaoImpl;
//import br.com.fiap.fintechfinal.exception.fintechfinal.EntidadeNaoEncontradaException;
//import br.com.fiap.fintechfinal.model.fintechfinal.Conta;
//
//import java.sql.SQLException;
//import java.time.LocalDate;
//
//public class AtualizarConta {
//    public static void main(String[] args) {
//        try {
//            ContasDaoImpl dao = new ContasDaoImpl();
//            Conta conta = dao.pesquisar(1);
//            LocalDate today = LocalDate.now();
//            LocalDate plusDays = today.plusDays(10);
//            LocalDate minusDays = today.minusDays(10);
//            conta.setDt_criacao_conta(minusDays);
//            conta.setDt_encerramento_conta(plusDays);
//            conta.setSaldo(5000);
//
//            dao.atualizar(conta);
//            dao.fecharConexao();
//            System.out.println("Conta Atualizada com sucesso!");
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        } catch (EntidadeNaoEncontradaException e) {
//            System.err.println("Nao foi possivel realizar a atualização dos dados");
//        }
//    }
//}
