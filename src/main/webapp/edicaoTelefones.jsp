<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Edição de telefones</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
  <div class="mt-5 ms-5 me-5">
    <div class="card mb-3">
      <div class="card-header">
        EDIÇÃO DE TELEFONES
      </div>

      <c:if test="${not empty mensagem}">
        <div
                class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem}
        </div>
      </c:if>

      <c:if test="${not empty erro}">
        <div
                class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}
        </div>
      </c:if>

      <div class="card-body">
        <form
                action="telefones"
                method="post">

          <input
                  type="hidden"
                  value="editar"
                  name="acao"
          >
          <input
                  type="hidden"
                  value="${param.idTelefone}"
                  name="idTelefone"
                  id="idTelefone"
          >

          <div class="form-group">
            <label
                    for="nrCodigoPais">Código do País
            </label>
            <input
                    type="text"
                    name="nrCodigoPais"
                    id="nrCodigoPais"
                    class="form-control"
                    value="${param.nrCodigoPais}"
                    placeholder="Digite os numeros do código do país"
                    required
                    maxlength="8"
            >
          </div>
          <div class="form-group">
            <label
                    for="nrDdd">DDD
            </label>
            <input
                    type="text"
                    name="nrDdd"
                    id="nrDdd"
                    class="form-control"
                    value="${param.nrDdd}"
                    required
            >
          </div>
          <div class="form-group">
            <label
                    for="nrTelefone">Número do Telefone
            </label>
            <input
                    type="text"
                    name="nrTelefone"
                    id="nrTelefone"
                    class="form-control"
                    value="${param.nrTelefone}"
                    required
            >
          </div>
          <input
                  type="submit"
                  value="Salvar"
                  class="btn btn-primary mt-3">
          <a
                  href="telefones?acao=listar"
                  class="btn btn-warning mt-3">Cancelar
          </a>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp" %>
<script src="js/bootstrap.bundle.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>