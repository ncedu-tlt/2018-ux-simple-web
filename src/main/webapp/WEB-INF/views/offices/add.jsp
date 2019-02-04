<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add office</title>

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
    <h2>Add office</h2>
</div>
<div class="line _form">
    <form class="form" method="post">

        <c:if test="${requestScope.error != null}">
            <div class="form_row_error">
                <div class="form_error">Please, fill up all fields before submitting the form</div>
            </div>
        </c:if>

        <div class="js_error_massage error_message_no_active error_message">Not all fields were filled in correctly</div>

        <div class="form_row">
            <label class="form_label" for="name">Name</label>
            <input class="form_input js_input_name" type="text" id="name" name="name"/>
            <div class="error_message_row js_error_massage_name"></div>
        </div>

        <div class="form_row">
            <label class="form_label" for="phone_number">Phone number</label>
            <input class="form_input js_input_phone_number" type="tel" id="phone_number" name="phone_number" PLACEHOLDER="+79ххххххххх"/>
            <div class="error_message_row js_error_massage_phone_number"></div>
        </div>

        <div class="form_row">
            <label class="form_label" for="city">City</label>
            <select class="js_select_city" id="city" name="city">
                <option value="">none selected</option>
                <c:forEach items="${requestScope.cites}" var="city">
                    <option value="${city.id}"> ${city.name} </option>
                </c:forEach>
            </select>
            <div class="error_message_row js_error_massage_city"></div>
        </div>

        <div class="form_row">
            <button class="form_button js_add_button" type="submit">Add</button>
            <button class="form_button" type="reset">Clear</button>
        </div>

    </form>

</div>
<script type="text/javascript" src="js/offices.js" ></script>
</body>
</html>
