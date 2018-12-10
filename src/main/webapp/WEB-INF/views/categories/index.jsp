<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.ncedu.simpleweb.models.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Categories</title>

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
        <h2>Categories</h2>
    </div>
    <div class="line _bordered">
        <a href="categories/add">Add</a>
    </div>

    <div class="line _subtitle">
        <h2>Java:</h2>
    </div>

    <div class="line _table">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
            <%
                List<Category> categories = (List<Category>) request.getAttribute("categories");
                for (Category category : categories) {
                %>
                  <tr>
                      <td><%= category.getId() %></td>
                      <td><%= category.getName() %></td>
                      <td><%= category.getDescription() %></td>
                  </tr>
                <%
                }
            %>
        </table>
    </div>

    <div class="line _subtitle">
        <h2>JSTL:</h2>
    </div>

    <div class="line _table">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
            <c:forEach items="${requestScope.categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
