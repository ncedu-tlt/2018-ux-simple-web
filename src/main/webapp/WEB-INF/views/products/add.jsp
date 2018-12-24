<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Products-Add</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <base href="${pageContext.request.contextPath}/" />
    <link rel="stylesheet" type="text/css" href="css/categories.css">

</head>
<body>

<div class="header">
    <h1>Add Product</h1>
</div>

<div class="line _form">
    <form id="form" class="form" method="post">
        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="productName">Name</label>
            </div>
            <div class="form__cell">
                <input class="form__input" type="text" id="productName" name="name" />
            </div>
        </div>

        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="category">Category</label>
            </div>

            <select id="category" name="category" size="1"  >
                <option value="" style="display:none;"></option>
                <c:forEach items="${requestScope.categories}" var="category">
                <option value= "${category.id}"> ${category.name}  </option>
                </c:forEach>
            </select>
        </div>

        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="productDescription">Description</label>
            </div>
            <div class="form__cell">
                <textarea class="form__area" id="productDescription" name="description"></textarea>
            </div>
        </div>

        <div class="form__row" >
            <div class="form__error" style='display:none;' id="error">Please, fill up all fields before submitting the form</div>
        </div>

        <div class="form__row">
            <button class="form__button" type="submit">Add</button>
            <button class="form__button" type="reset">Clear</button>
        </div>
    </form>

</div>
<script type="text/javascript" src="js/products.js" ></script>
</body>
</html>
