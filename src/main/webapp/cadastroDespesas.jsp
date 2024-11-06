<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cadastro de Despesas</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
  <div class="mt-5 ms-5 me-5">
    <div class="card mb-3">
      <div class="card-header">
        CADASTRO DE DESPESAS
      </div>
      <div class="card-body">
        <form action="despesas?acao=cadastrar" method="post">
          <div class="form-group">
            <label for="dsDespesa">descrição da despesa</label>
            <input type="text" name="dsDespesa" id="dsDespesa" class="form-control">
          </div>
          <div class="form-group">
            <label for="dtDespesa">Data de criacao da despesa</label>
            <input type="date" name="dtDespesa" id="dtDespesa" class="form-control">
          </div>
          <div class="form-group">
            <label for="qtValorDespesa">Valor da despesa</label>
            <input type="text" name="qtValorDespesa" id="qtValorDespesa" class="form-control">
          </div>
          <input type="submit" value="Salvar" class="btn btn-primary my-3">
          <a href="despesas?acao=listar" class="btn btn-secondary my-3">Visualizar lista de despesas</a>
          <a href="index.jsp" class="btn btn-warning my-3">Voltar ao início</a>
        </form>
        <c:if test="${not empty message}">
          <div class="alert alert-success" role="alert">
              ${message}
          </div>
        </c:if>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/bootstrap.bundle.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>

</body>
</html>