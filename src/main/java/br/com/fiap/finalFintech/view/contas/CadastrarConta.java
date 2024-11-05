package br.com.fiap.finalFintech.view.contas;//package br.com.fintechfinal.view.contas;
//
//import br.com.fintechfinal.dao.ContasDaoImpl;
//import br.com.fiap.fintechfinal.model.fintechfinal.Conta;
//
//import java.sql.SQLException;
//import java.time.LocalDate;
//
//public class CadastrarConta {
//    public static void main(String[] args) {
//        try {
//            LocalDate today = LocalDate.now();
//            LocalDate plusDays = today.plusDays(10);
//            LocalDate minusDays = today.minusDays(20);
//
//            ContasDaoImpl dao = new ContasDaoImpl();
//            Conta conta = new Conta(2000, minusDays, plusDays);
//            Conta conta2 = new Conta(3000, today, plusDays);
//            Conta conta3 = new Conta(1000, minusDays, plusDays);
//            Conta conta4 = new Conta(6000, minusDays, plusDays);
//            Conta conta5 = new Conta(9000, today, plusDays);
//
//
//            dao.cadastrar(conta);
//            dao.cadastrar(conta2);
//            dao.cadastrar(conta3);
//            dao.cadastrar(conta4);
//            dao.cadastrar(conta5);
//            dao.fecharConexao();
//            System.out.println("Cadastro de conta realizado com sucesso");
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//}
