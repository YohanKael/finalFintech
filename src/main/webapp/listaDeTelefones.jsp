<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <title>FiapStore</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
  <div class="mt-5 ms-5 me-5">

    <div class="card mb-3">
      <div class="card-header">
        LISTA DE TELEFONES
      </div>
      <div class="card-body">
        <h5 class="card-title">Gestão de telefones</h5>
        <p class="card-text">Mantenha os dados das suas contas sempre atualizados e protegidos.</p>

        <c:if test="${not empty mensagem}">
          <div class="alert alert-success ms-2 me-2 m-auto mt-2">${mensagem}</div>
        </c:if>

        <c:if test="${not empty erro}">
          <div class="alert alert-danger ms-2 me-2 m-auto mt-2">${erro}</div>
        </c:if>
        <table class="table table-striped table-bordered">
          <thead>
          <tr>
            <th>ID do Telefone</th>
            <th class="text-end">Código do país</th>
            <th class="text-center">DDD</th>
            <th class="text-center">Numero do Telefone</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${telefones}" var="telefone">
            <tr>
              <td>${telefone.idTelefone}</td>
              <td>${telefone.nrCodigoPais}</td>
              <td>${telefone.nrDdd}</td>
              <td>${telefone.nrTelefone}</td>

              <td class="text-center">
                <c:url value="telefones" var="link">
                  <c:param name="acao" value="abrir-form-edicao"/>
                  <c:param name="idTelefone" value="${telefone.idTelefone}"/>
                  <c:param name="nrCodigoPais" value="${telefone.nrCodigoPais}"/>
                  <c:param name="nrDdd" value="${telefone.nrDdd}"/>
                  <c:param name="nrTelefone" value="${telefone.nrTelefone}"/>

                </c:url>
                <a href="${link}" class="btn btn-primary">Editar</a>

                <button
                        type="button"
                        class="btn btn-danger"
                        data-bs-toggle="modal"
                        data-bs-target="#excluirModal"
                        onclick="codigoExcluir.value = ${telefone.idTelefone}"
                >
                  Excluir
                </button>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        <a href="cadastroTelefones.jsp" class="btn btn-primary">Adicionar Telefone</a>
      </div>
    </div>
  </div>
</div>
<div
        class="modal fade"
        id="excluirModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1
                class="modal-title fs-5"
                id="exampleModalLabel">
          Confirmar Exclusão
        </h1>
        <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close">
        </button>
      </div>
      <div class="modal-body">
        <h4>Tem certeza que deseja excluir esse telefone?</h4>
        <p><strong>Atenção!</strong> Esta ação é irreversível.</p>
      </div>
      <div class="modal-footer">

        <form action="telefones" method="post">
          <input
                  type="hidden"
                  name="acao"
                  value="excluir">
          <input
                  type="hidden"
                  name="codigoExcluir"
                  id="codigoExcluir">
          <button
                  type="button"
                  class="btn btn-secondary"
                  data-bs-dismiss="modal">
            Não
          </button>
          <button
                  type="submit"
                  class="btn btn-danger">
            Sim
          </button>
        </form>

      </div>
    </div>
  </div>
</div>
<%@include file="footer.jsp"%>
<script src="js/bootstrap.bundle.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>