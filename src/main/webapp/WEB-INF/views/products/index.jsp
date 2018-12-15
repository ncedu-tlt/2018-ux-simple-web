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
            for (Product product : products) {
                long categoryId = product.getCategoryId();
                Category category = CategoriesRepository.getInstance().get(categoryId);
        %>
        <tr>
            <td><%= product.getId() %></td>
            <td><%= product.getName() %></td>
            <td><%= category.getName()%></td>
            <td><%= product.getDescription() %></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
