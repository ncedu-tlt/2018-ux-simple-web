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
<section class="add_form">
    <h1>Countries - Edit</h1>
    <c:if test="${requestScope.error != null}">
        <span class="error">Error from server</span>
    </c:if>
    <span class="js_error_message error_message"></span>
    <form class="js_add_form" method="post">
        <div class="country_name input_block">
            <label for="country_name_input">Country name</label>
            <input id="country_name_input" class="js_country_name_input" type="text" name="countryName" value="${requestScope.country.name}">
        </div>
        <div class="phone_extension input_block">
            <label for="phone_extension_input">Phone extension</label>
            <input id="phone_extension_input" class="js_phone_extension_input" type="text" name="phoneExtension" value="${requestScope.country.phoneExtension}">
        </div>
        <div class="flag_image_link input_block">
            <label for="flag_image_link_input">Flag image link</label>
            <textarea id="flag_image_link_input" class="js_flag_image_link_input" name="flag" >${requestScope.country.flag}</textarea>
        </div>
        <section class="add_form_buttons">
            <button type="submit" id="submit_button">Edit</button>
        </section>
    </form>
</section>
<script type="text/javascript" src="js/countries/validation.js"></script>
</body>
</html>
