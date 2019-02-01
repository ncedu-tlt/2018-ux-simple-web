<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Countries</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/countries/add.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<a href="${pageContext.request.contextPath}">
    <div class="header">
        <h1>Our Simple Web App</h1>
    </div>
</a>
<section class="AddForm" id="CountryAddForm">
    <h1>Add Form</h1>
    <c:if test="${requestScope.error != null}">
        <span class="error">Error from server</span>
    </c:if>
    <form class="postForm" method="post">
        <div class="CountryName inputBlock">
            <label for="CountryNameInput">Country name</label>
            <input id="CountryNameInput" class="CountryNameInput input" type="text" name="countryName" placeholder="Russia">
        </div>
        <div class="PhoneExtension inputBlock">
            <label for="PhoneExtensionInput">Phone extension</label>
            <input id="PhoneExtensionInput" class="PhoneExtensionInput input" type="text" name="phoneExtension" placeholder="+7">
        </div>
        <div class="FlagImageLink inputBlock">
            <label for="FlagImageLinkInput">Flag image link</label>
            <textarea id="FlagImageLinkInput" class="FlagImageLinkInput" name="flag" placeholder="http://"></textarea>
        </div>
        <section class="AddFormButtons">
            <button type="submit" id="submitButton">Add</button>
            <button type="reset">Clear</button>
        </section>
    </form>
</section>
<script type="text/javascript" src="js/countries.js"></script>
</body>
</html>
