<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.agencia.model.Cliente" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar e Cadastrar Clientes</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Agência de Viagens</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ClienteServlet?action=listar">Clientes</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container">
    <h1 class="mt-5 mb-4">Listar e Cadastrar Clientes</h1>
    <!-- Formulário para adicionar um cliente -->
    <form action="ClienteServlet" method="post">
        <input type="hidden" name="action" value="adicionar">
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" id="nome" name="nome" required>
        </div>
        <div class="form-group">
            <label for="sobrenome">Sobrenome:</label>
            <input type="text" class="form-control" id="sobrenome" name="sobrenome" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for "telefone">Telefone:</label>
            <input type="tel" class="form-control" id="telefone" name="telefone" required>
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar Cliente</button>
        
    </form>
    <a href="ClienteServlet?action=listar" class="btn btn-primary mt-3">Listar Clientes</a>

    <h2 class="mt-5">Clientes Cadastrados</h2>
    <c:if test="${not empty clientes}">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID do Cliente</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clientes}" var="cliente">
                    <tr>
                        <td>${cliente.ID_Cliente}</td>
                        <td>${cliente.nome}</td>
                        <td>${cliente.sobrenome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.telefone}</td>
                        <td><a href="ClienteServlet?action=detalhes&id=${cliente.ID_Cliente}">Detalhes</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <h2 class="mt-5">Detalhes do Cliente</h2>
    <c:if test="${not empty cliente}">
        <p>ID do Cliente: ${cliente.ID_Cliente}</p>
        <p>Nome: ${cliente.nome}</p>
        <p>Sobrenome: ${cliente.sobrenome}</p>
        <p>Email: ${cliente.email}</p>
        <p>Telefone: ${cliente.telefone}</p>
    </c:if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
