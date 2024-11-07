<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de produtos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container ms-0">
    <%
        Boolean loginSucesso = (Boolean) request.getAttribute("loginSucesso");
        if (loginSucesso != null && loginSucesso) {
    %>
    <script>
        alert("Login realizado com sucesso!");
    </script>
    <%
        }
    %>
    <div class="mt-5 ms-5 me-5">
        <h1>
            Bem vindo a Nossa Fintech!
        </h1>
        <h5 class="pt-5">
            Aqui oferecemos um serviço completo para cadastro, visualização, edição e exclusão de dados. <br>
            Esses recursos permitem gerenciar informações de forma prática e eficiente. <br>
        </h5>
        <h2>
            Para utilizar todas as funcionalidades disponíveis, é necessário realizar o login no sistema.
            Assim, você terá acesso total aos recursos e poderá gerenciar seus dados com segurança.
        </h2>


    </div>
</div>
<%@include file="footer.jsp" %>
<script src="./js/bootstrap.bundle.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>

</body>
</html>