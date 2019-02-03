<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Countries - Add</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/countries/countries.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<a href="${pageContext.request.contextPath}">
    <div class="header">
        <h1>Our Simple Web App</h1>
    </div>
</a>
<section class="country_list">
    <h1>Countries</h1>
    <c:if test="${requestScope.error != null}">
        <span class="error">Error from server</span>
    </c:if>
    <section class="edit_window js_edit_window">
        <h2>Country edit</h2>
        <span class="js_edit_error"></span>
        <form>
            <div class="country_name input_block">
                <label for="country_name_edit_input">Country name</label>
                <input id="country_name_edit_input" class="js_country_name_edit_input" type="text" name="countryName" placeholder="Russia">
            </div>
            <div class="phone_extension input_block">
                <label for="phone_extension_edit_input">Phone extension</label>
                <input id="phone_extension_edit_input" class="js_phone_extension_edit_input" type="text" name="phoneExtension" placeholder="+7">
            </div>
            <div class="flag_image_link input_block">
                <label for="flag_image_link_edit_input">Flag image link</label>
                <textarea id="flag_image_link_edit_input" class="js_flag_image_link_edit_input" name="flag" placeholder="http://"></textarea>
            </div>
            <section class="edit_form_buttons">
                <button type="button" id="edit_button">Edit</button>
                <button type="button" id="js_cancel_button">Cancel</button>
            </section>
        </form>
    </section>
    <table border="1" cellPadding="5">
        <tbody>
        <tr>
            <th>Country name</th>
            <th>Phone extension</th>
            <th>Flag</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.countries}" var="country">
            <tr>
                <td class="name">${country.name}</td>
                <td>${country.phoneExtension}</td>
                <td class="flag"><img src="${country.flag}" alt="flag" width="50px"></td>
                <td>
                    <button class="edit js_edit_button">edit</button>
                </td>
                <td>
                    <button class="delete js_delete_button">delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="countries/add" class="add_link">
        <div class="plus">
            <div class="line1"></div>
            <div class="line2"></div>
        </div>
        <span>Add</span>
    </a>
</section>
<script type="text/javascript" src="js/countries.js"></script>
</body>
</html>
