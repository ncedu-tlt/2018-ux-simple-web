<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Offices</title>

    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" type="text/css" href="css/offices.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/" class="header">
    <h1>Our Simple Web App</h1>
</a>
<div class="line _title">
    <h2>Offices</h2>
</div>
<div class="line _bordered">
    <a href="offices/add">Add</a>
</div>
<div class="line _title">
    <h2>List:</h2>
</div>
<c:if test="${empty requestScope.offices}">
    <div>no offices</div>
</c:if>
<c:if test="${not empty requestScope.offices}">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone number</th>
            <th>City name</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${requestScope.offices}" var="office">
            <tr>
                <th class="js_id_th">${office.id}</th>
                <th>${office.name}</th>
                <th>${office.phoneNumber}</th>
                <th>${office.cityName}</th>
                <th>edit</th>
                <th class="js_button_delete">delete</th>
            </tr>
        </c:forEach>
    </table>
</c:if>

<script type="text/javascript" src="js/offices.js" ></script>
</body>
</html>
