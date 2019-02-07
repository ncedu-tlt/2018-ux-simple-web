<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Countries - Add</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/countries/countries.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<a href="${pageContext.request.contextPath}">
    <div class="header">
        <h1>Our Simple Web App</h1>
    </div>
</a>
<section class="country_list">
    <h1>Countries</h1>
    <c:if test="${requestScope.error != null}">
        <span class="error">Error from server</span>
    </c:if>
    <section class="delete_window js_delete_window">
        <p class="js_delete_message"></p>
        <div class="buttons_block">
            <button type="button" class="yes_button">Yes</button>
            <button type="button" class="no_button">No</button>
        </div>
    </section>
    <table border="1" cellPadding="5">
        <tbody>
        <tr>
            <th>Country name</th>
            <th>Phone extension</th>
            <th>Flag</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.countries}" var="country">
            <tr>
                <td class="name js_name_cell">${country.name}</td>
                <td class="js_phone_cell">${country.phoneExtension}</td>
                <td class="flag js_flag_cell"><img src="${country.flag}" alt="flag" width="50px"></td>
                <td>
                    <a href="countries/edit?country_id=${country.id}" class="edit js_edit_link"><button class="edit">edit</button></a>
                </td>
                <td>
                    <button type="button" class="delete js_delete_button">delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="countries/add" class="add_link">
        <div class="plus">
            <div class="line1"></div>
            <div class="line2"></div>
        </div>
        <span>Add</span>
    </a>
</section>
<script type="text/javascript" src="js/countries/delete.js"></script>
</body>
</html>
