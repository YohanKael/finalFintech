<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edicao de contas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                EDIÇÃO DE ENDEREÇO
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
                        action="enderecos"
                        method="post">

                    <input
                            type="hidden"
                            value="editar"
                            name="acao"
                    >
                    <input
                            type="hidden"
                            value="${param.idEndereco}"
                            name="idEndereco"
                            id="idEndereco"
                    >

                    <div class="form-group">
                        <label
                                for="numeroCep">CEP
                        </label>
                        <input
                                type="text"
                                name="numeroCep"
                                id="numeroCep"
                                class="form-control"
                                value="${param.numeroCep}"
                                placeholder="Digite somente os numeros do CEP"
                                required
                                maxlength="8"
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="numeroResidencia">Numero Residencia
                        </label>
                        <input
                                type="text"
                                name="numeroResidencia"
                                id="numeroResidencia"
                                class="form-control"
                                value="${param.numeroResidencia}"
                                required
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="nomeRua">nomeRua
                        </label>
                        <input
                                type="text"
                                name="nomeRua"
                                id="nomeRua"
                                class="form-control"
                                value="${param.nomeRua}"
                                required
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="complementoEndereco">Complemento do Endereço
                        </label>
                        <input
                                type="text"
                                name="complementoEndereco"
                                id="complementoEndereco"
                                class="form-control"
                                value="${param.complementoEndereco}"
                                required
                        >
                    </div>
                    <input
                            type="submit"
                            value="Salvar"
                            class="btn btn-primary mt-3">
                    <a
                            href="enderecos?acao=listar"
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