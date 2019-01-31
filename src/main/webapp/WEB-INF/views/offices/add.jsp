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
<a href="/simple-web" class="header">
    <h1>Our Simple Web App</h1>
</a>
<div class="line _title">
    <h2>Add office</h2>
</div>
<div class="line _form">
    <form class="form" method="post">

        <div class="form_row">
            <div class="form_cell _label">
                <label class="form_label" for="name">Name</label>
            </div>
            <div class="form_cell">
                <input class="form_input" type="text" id="name" name="name"/>
            </div>
        </div>

        <div class="form_row">
            <div class="form_cell _label">
                <label class="form_label" for="phone_number">Phone number</label>
            </div>
            <div class="form_cell">
                <input class="form_input" type="tel" id="phone_number" name="phone_number"/>
            </div>
        </div>

        <div class="form_row">
            <button class="form_button" type="submit">Add</button>
            <button class="form_button" type="reset">Clear</button>
        </div>

    </form>
</div>
</body>
</html>
