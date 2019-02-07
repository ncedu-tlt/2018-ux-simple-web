<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Offerings</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" type="text/css" href="css/offerings.css">
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<a href="${pageContext.request.contextPath}">
    <div class="header">
        <h1>Our Simple Web App</h1>
    </div>
</a>
<div>
    <h1>Add offering</h1>
</div>
<c:if test="${requestScope.error != null}">
    <div class="form_row_error">
        <div class="form_error">Please fill up all the fields in the form with valid data.</div>
    </div>
</c:if>
<c:if test="${requestScope.saveError != null}">
    <div class="form_row_error">
        <div class="form_error">This combination of office and product already exists.</div>
    </div>
</c:if>
<div class="form_row_error">
<div class="form_error js_required none">All fields must be filled!</div>
</div>
<div class="form_row_error">
<div class="form_error js_valid none">The field price should contain only numbers!</div>
</div>
<div class="table_offerings">
    <form method="post" class="addForm js_form_add">
        <table>
            <tbody>
            <tr>
                <td>
                    <label class="form_label" for="offices">Office</label>
                </td>
                <td>
                    <select id="offices" name="office_id" class="js_office">
                        <option value="">none selected</option>
                        <c:forEach items="${requestScope.offices}" var="office">
                            <option value="${office.id}"> ${office.name} </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="form_label" for="product">Product</label>
                </td>
                <td>
                    <select id="product" name="product_id" class="js_product">
                        <option value="">none selected</option>
                        <c:forEach items="${requestScope.products}" var="product">
                            <option value="${product.id}"> ${product.name} </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="form_label" for="offering_price">Offering price</label>
                </td>
                <td>
                    <input  id="offering_price" name="offering_price" class="js_offering_price"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Add</button>
                    <button type="reset">Clear</button>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
    <script type="text/javascript" src="js/offering.js"></script>
</div>
</body>
</html>
