<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Main Page</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <base href="${pageContext.request.contextPath}/" />
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
    <div class="header">
        <h1>Our Simple Web App</h1>
    </div>
    <div class="line _title">
        <h3>What model do you wanna work on?</h3>
    </div>
    <div class="line _suggestions">
        <ul>
            <li>
                <div class="list-icon"></div>
                <a href="categories">Categories</a>
            </li>
            <li>
                <div class="list-icon"></div>
                <a href="products">Products</a>
            </li>
            <li>
                <div class="list-icon"></div>
                <a href="offerings">Offerings</a>
            </li>
            <li>
                <div class="list-icon"></div>
                <a href="offices">Offices</a>
            </li>
            <li>
                <div class="list-icon"></div>
                <a href="countries">Countries</a>
            </li>
        </ul>
    </div>
</body>
</html>
