<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 05.09.2016
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
    <form:form action="/profile/saveEdit" method="post" commandName="editProfile">
        <%--<form:hidden path="idProfile"/>--%>
        <%--<form:hidden path="currentUser"/>--%>

        <table>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" size="30" placeholder = "First Name"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" size="30" placeholder = "Last Name"/></td>
            </tr>
            <tr>
                <td>Current City:</td>
                <td><form:input path="currentCity" size="30" placeholder = "Current City"/></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><form:input path="phoneNumber" size="30" placeholder = "+375XXXXXXXXXX"/></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><form:input type="number" min="1" max="101" path="age" size="2"/></td>
            </tr>
            <tr>
                <td>Sex:</td>
                <td>
                    <form:radiobutton path="sex" value="Male"/>Male
                    <form:radiobutton path="sex" value="Female" name="Female"/>Female
                    <form:radiobutton path="sex" value="Other" name="Other"/>Other
                </td>
            </tr>
        </table>
        <button type="submit">Submit</button>
        <button type="button" onclick="history.back()">Back</button>
    </form:form>
</body>
</html>
