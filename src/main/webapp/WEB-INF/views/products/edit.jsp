<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products-Edit</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <base href="${pageContext.request.contextPath}/" />
    <link rel="stylesheet" type="text/css" href="css/categories.css">
</head>
<body>

<div class="header">
    <h1>Edit Product</h1>
</div>
<div class="line _form">
    <form class="form"  method="post">
        <div id="productId" name="productId" value="${requestScope.product.id}"></div>
        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="name">Name</label>
            </div>
            <div class="form__cell">
                <input class="form__input js_productName" type="text" id="name" name="name" value="${requestScope.product.name}"/>
            </div>
        </div>

        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="category">Category</label>
            </div>

            <select  class="js_category" id="category" name="category" size="1" >
                <c:forEach items="${requestScope.categories}" var="category">
                    <c:if test="${requestScope.categoryId != category.id}">
                        <option value= "${category.id}"> ${category.name}  </option>
                    </c:if>
                    <c:if test="${requestScope.categoryId == category.id}">
                        <option value= "${category.id}" selected> ${category.name}  </option>
                    </c:if>
                </c:forEach>
            </select>
        </div>

        <div class="form__row">
            <div class="form__cell _label">
                <label class="form__label" for="description">Description</label>
            </div>
            <div class="form__cell">
                <textarea class="form__area js_productDescription" id="description" name="description">${requestScope.product.description}</textarea>
            </div>
        </div>

        <div class="form__row" >
            <div class="js_error form__error _hidden">Please, fill up all fields before submitting the form</div>
            <c:if test="${requestScope.error != null}">
                <div class="form__error">Error in the input data.</div>
            </c:if>
        </div>

        <div class="form__row">
            <button class="form__button" type="submit">Edit</button>
            <button class="form__button" type="reset">Reset</button>
        </div>
    </form>
</div>
<script type="text/javascript" src="js/products.js" ></script>
</body>
</html>
