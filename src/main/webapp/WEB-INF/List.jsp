<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 27/05/2025
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.web_action_house.model.Product" %>
<%@ page import="com.example.web_action_house.model.Category" %>
<%@ page import="com.example.web_action_house.model.Auction" %>
<html>
<head>
  <title>Listado de Productos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
  <h1 class="mb-4 text-center">Productos en Subasta</h1>

  <table class="table table-bordered table-hover bg-white">
    <thead class="table-primary">
    <tr>
      <th>Título</th>
      <th>Descripción</th>
      <th>Imagen</th>
      <th>Precio Inicial</th>
      <th>Precio Actual</th>
      <th>Precio Cierre</th>
      <th>Categoría</th>
      <th>Subasta</th>
      <th>ID Usuario</th>
    </tr>
    </thead>
    <tbody>
    <%
      List<Product> products = (List<Product>) request.getAttribute("products");
      if (products != null) {
        for (Product p : products) {
    %>
    <tr>
      <td><%= p.getTitle() %></td>
      <td><%= p.getDescription() %></td>
      <td><img src="<%= p.getImgUrl() %>" alt="Imagen" width="100"/></td>
      <td><%= p.getStartingBid() %> €</td>
      <td><%= p.getCurrentBid() %> €</td>
      <td><%= p.getClosingBid() %> €</td>
      <td><%= p.getCategory() != null ? p.getCategory().getTitle() : "Sin categoría" %></td>
      <td><%= p.getAuction() != null ? p.getAuction().getTitle() : "Sin subasta" %></td>
      <td><%= p.getAuction() != null ? p.getAuction().getUserId() : "Desconocido" %></td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="9" class="text-center">No hay productos disponibles</td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>
