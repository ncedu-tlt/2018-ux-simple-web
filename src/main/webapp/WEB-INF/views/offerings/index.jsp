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
            <a href="offerings/add"><h3>Add offering</h3></a>
        </div>
        <div>
            <h1>Offering list:</h1>
        </div>
        <c:if test="${requestScope.error != null}">
            <div class="error">Error from server</div>
        </c:if>
        <div class="js_error none error">Error with delete.</div>
            <table class="main_table">
                <thead class="first">
                    <tr>
                        <th><p>Product id</p></th>
                        <th><p>Product name</p></th>
                        <th><p>Office id</p></th>
                        <th><p>Office name</p></th>
                        <th><p>Offering price</p></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.offerings}" var="offering">
                        <tr class="js_row">
                            <th><p class="js_product_id">${offering.productId}</p></th>
                            <th><p>${offering.productName}</p></th>
                            <th><p class="js_office_id">${offering.officeId}</p></th>
                            <th><p>${offering.officeName}</p></th>
                            <th><p>${offering.offeringPrice}</p></th>
                            <th><a href="offerings/edit?office_id=${offering.officeId}&product_id=${offering.productId}"><p>Edit</p></a></th>
                            <th><p class="js_delete delete">Delete</p></th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        <script type="text/javascript" src="js/offering.js" ></script>
    </body>
</html>
