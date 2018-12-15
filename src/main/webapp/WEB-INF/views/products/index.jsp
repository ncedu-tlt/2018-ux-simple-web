<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.ncedu.simpleweb.models.Product" %>
<%@ page import="ru.ncedu.simpleweb.models.Category" %>
<%@ page import="ru.ncedu.simpleweb.repositories.CategoriesRepository" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <base href="${pageContext.request.contextPath}/" />
    <link rel="stylesheet" type="text/css" href="css/categories.css">
</head>
<body>
    <div class="header">
        <h1>Our Simple Web App</h1>
    </div>
    <div class="line _title">
        <h2>Products</h2>
    </div>


<div class="line _table">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Description</th>
        </tr>
        <%
            List<Product> products = (List<Product>) request.getAttribute("products");
            List<Category> categories = (List<Category>) request.getAttribute("categories");

            for (int i=0; i<products.size(); i++) {
        %>
        <tr>
            <td><%= products.get(i).getId() %></td>
            <td><%= products.get(i).getName() %></td>
            <td><%= categories.get(i).getName()%></td>
            <td><%= products.get(i).getDescription() %></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
