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
                EDIÇÃO DE RECEITAS
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
                        action="receitas"
                        method="post">

                    <input
                            type="hidden"
                            value="editar"
                            name="acao"
                    >
                    <input
                            type="hidden"
                            value="${param.idReceita}"
                            name="idReceita"
                    >

                    <div class="form-group">
                        <label
                                for="dsReceita">Descricao Receita
                        </label>
                        <input
                                type="text"
                                name="dsReceita"
                                id="dsReceita"
                                class="form-control"
                                value="${param.dsReceita}"
                                required
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="dtReceita">Data da Receita
                        </label>
                        <input
                                type="date"
                                name="dtReceita"
                                id="dtReceita"
                                class="form-control"
                                value="${param.dtReceita}"
                                required
                        >
                    </div>
                    <div class="form-group">
                        <label
                                for="qtValorReceita">Valor da receita
                        </label>
                        <input
                                type="text"
                                name="qtValorReceita"
                                id="qtValorReceita"
                                class="form-control"
                                value="${param.qtValorReceita}"
                                required
                        >
                    </div>
                    <input
                            type="submit"
                            value="Salvar"
                            class="btn btn-primary mt-3">
                    <a
                            href="receitas?acao=listar"
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