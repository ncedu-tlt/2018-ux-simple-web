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
    <form class="form" method="post">
        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="name">Name</label>
            </div>
            <div class="form__cell">
                <input class="form__input" type="text" id="name" name="name" />
            </div>
        </div>

        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="categoryList">Category</label>
            </div>


            <select id="categoryList" name="categoryList" size="1"  >
                <c:forEach items="${requestScope.categories}" var="category">
                <option value= "${category.id}"> ${category.name}  </option>
                </c:forEach>
            </select>

        </div>

        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="description">Description</label>
            </div>
            <div class="form__cell">
                <textarea class="form__area" id="description" name="description"></textarea>
            </div>
        </div>

        <div class="form__row">
            <c:if test="${requestScope.error != null}">
                <div class="form__error">Please, fill up all fields before submitting the form</div>
            </c:if>
        </div>

        <div class="form__row">
            <button class="form__button" type="submit">Add</button>
            <button class="form__button" type="reset">Clear</button>
        </div>
    </form>
</div>

</body>
</html>
