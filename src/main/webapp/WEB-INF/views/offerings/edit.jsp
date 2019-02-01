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
    <h1>Edit offering</h1>
</div>
<c:if test="${requestScope.error != null}">
    <div class="form_row_error">
        <div class="form_error">Please, fill up all fields before submitting the form</div>
    </div>
</c:if>
<div class="table_offerings">
    <form method="post" class="addForm">
        <table>
            <tbody>
            <tr>
                <td>
                    Office:
                </td>
                <td>
                    ${requestScope.offering_view_model.officeName}</td>
            </tr>
            <tr>
                <td>
                    Product:
                </td>
                <td>
                    ${requestScope.offering_view_model.productName}
                </td>
            </tr>
            <tr>
                <td>
                    <label class="form_label" for="offering_price">Offering price</label>
                </td>
                <td>
                    <input value="${requestScope.offering_view_model.offeringPrice}" step="any" type="number" id="offering_price" name="offering_price"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Edit</button>
                    <button type="reset">Clear</button>
                </td>
            </tr>
            </tbody>
        </table>


    </form>

</div>
</body>
</html>
