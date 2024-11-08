<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">Fiap Fintech</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <c:if test="${not empty sessionScope.user}">
          <li class="nav-item dropdown" id="cadastroDropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Cadastros
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="cadastroConta.jsp">Cadastro de Contas</a></li>
              <li><a class="dropdown-item" href="cadastroDespesas.jsp">Cadastro de Despesas</a></li>
              <li><a class="dropdown-item" href="cadastroReceitas.jsp">Cadastro de Receitas</a></li>
              <li><a class="dropdown-item" href="cadastroInvestimentos.jsp">Cadastro de Investimentos</a></li>
              <li><a class="dropdown-item" href="cadastroEnderecos.jsp">Cadastro de Enderecos</a></li>
              <li><a class="dropdown-item" href="cadastroTelefones.jsp">Cadastro de Telefones</a></li>
            </ul>
          </li>

          <li class="nav-item dropdown" id="visualizarDropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Visualizar dados
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="contas?acao=listar">Visualizar Contas</a></li>
              <li><a class="dropdown-item" href="despesas?acao=listar">Visualizar Despesas</a></li>
              <li><a class="dropdown-item" href="receitas?acao=listar">Visualizar Receitas</a></li>
              <li><a class="dropdown-item" href="investimentos?acao=listar">Visualizar Investimentos</a></li>
              <li><a class="dropdown-item" href="enderecos?acao=listar">Visualizar Enderecos</a></li>
              <li><a class="dropdown-item" href="telefones?acao=listar">Visualizar Telefones</a></li>
            </ul>
          </li>
        </c:if>
      </ul>
      <c:if test="${not empty sessionScope.user}">
        <div class="ms-auto">
          <a class="btn btn-outline-danger" href="logout">Encerrar Sessão</a>
        </div>
      </c:if>
    </div>

    <c:if test="${empty sessionScope.user}">
      <form class="form-inline my-lg-0" action="login" method="post">
        <div class="row">
          <div class="col">
            <input class="form-control mr-sm-2" type="text" name="email" placeholder="E-mail">
          </div>
          <div class="col">
            <input class="form-control mr-sm-2" type="password" name="senha" placeholder="Senha">
          </div>
          <div class="col">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
          </div>
        </div>
      </form>
    </c:if>
  </div>
</nav>

