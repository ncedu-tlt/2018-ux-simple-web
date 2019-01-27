<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <title>Cities</title>

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
            <h2>Cities</h2>
        </div>
        <div class="line _bordered">
            <a href="">Add</a>
            <a href="">Edit</a>
            <!--<a href="">Delete</a>-->
        </div>

        <div class="line _table">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone extension</th>
                    <th>Description</th>
                </tr>
                <%
                    List<City> cities = (List<City>) request.getAttribute("cities");
                    for (City cities : cities) {
                    %>
                      <tr>
                          <td><%= city.getId() %></td>
                          <td><%= city.getName() %></td>
                          <td><%= city.getPhoneExtension() %></td>
                          <td><%= city.getDescription() %></td>
                      </tr>
                    <%
                    }
                %>
            </table>
        </div>

    </body>
</html>