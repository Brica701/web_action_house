<%--
  Created by IntelliJ IDEA.
  User: isaac
  Date: 27/05/2025
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web_action_house.dao.ProductDAOImpl" %>
<%@ page import="com.example.web_action_house.model.Category" %>
<%@ page import="com.example.web_action_house.model.Product" %>
<%@ page import="com.example.web_action_house.dao.CategoryDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: photo
  Date: 25/05/2025
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body, html {
      height: 100%;
    }
    .center-container {
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .form-half {
      width: 100%;
      max-width: 500px;
    }
  </style>
</head>
<body>
<div class="center-container">
  <form action="crearProducto" method="post" class="form-half bg-white p-4 rounded shadow">
    <h2 class="mb-4 text-center">Crear Producto</h2>
    <div class="mb-3">
      <label for="nombre" class="form-label">Nombre:</label>
      <input type="text" id="nombre" name="nombre" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="descripcion" class="form-label">Descripción:</label>
      <textarea id="descripcion" name="descripcion" class="form-control" required></textarea>
    </div>
    <div class="mb-3">
      <label for="urlImagen" class="form-label">URL Imagen:</label>
      <input type="text" id="urlImagen" name="urlImagen" class="form-control" >
    </div>
    <div class="mb-3">
      <label for="pujaInicial" class="form-label">Puja Inicial:</label>
      <input type="number" id="pujaInicial" name="pujaInicial" class="form-control" min="1" required>
    </div>
    <div class="mb-3">
      <label for="categoria" class="form-label">Categoría:</label>
      <select id="categoria" name="categoria" class="form-select" required>
        <%
          ProductDAOImpl productoDaoImplements = new ProductDAOImpl();
          List<Product> products = productoDaoImplements.getAll();
          CategoryDAOImpl categoryDAOImplements = new CategoryDAOImpl();
          List<Category> categories = categoryDAOImplements.getAll();

          for (Category c : categories){

        %>

        <option value="<%= c.getCategory_id()%>"><%=c.getTitle()%></option>
        <%
          }
        %>
      </select>
    </div>
    <button action="crearProducto<" type="submit" class="btn btn-primary w-100">Crear Producto</button>
  </form>
</div>
<!-- Bootstrap JS (opcional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>