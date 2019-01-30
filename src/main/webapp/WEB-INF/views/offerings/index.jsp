<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Offerings</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="css/offerings.css">
        <link rel="stylesheet" type="text/css" href="css/common.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <base href="${pageContext.request.contextPath}/"/>
    </head>
    <body>
        <a href="/simple-web/">
            <div class="header">
                <h1>Our Simple Web App</h1>
            </div>
        </a>
        <div>
            <a href="/simple-web/"><h3>Add offering(In developing)</h3></a>
        </div>
        <div>
            <h1>Offering list:</h1>
        </div>
        <c:if test="${requestScope.error != null}">
            <div class="error">Error from server</div>
        </c:if>
        <div class="table_offerings">
            <table>
                <thead class="first">
                    <tr>
                        <th><p>Product name</p></th>
                        <th><p>Office name</p></th>
                        <th><p>Offering price</p></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.offerings}" var="offering">
                        <tr>
                            <th><p>${offering.productName}</p></th>
                            <th><p>${offering.officeName}</p></th>
                            <th><p>${offering.offeringPrice}</p></th>
                            <th><p>Edit</p></th>
                            <th><p>Delete</p></th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
