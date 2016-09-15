<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 02.09.2016
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Profile</title>
</head>
<body>
    <div><h1>My profile</h1></div>
    <div>
        <form:form action="/profile/edit" method="post" commandName="editProfile">
            <div>
                First name: ${profile.firstName} <br/>
            </div>
            <div>
                Last name: ${profile.lastName} <br/>
            </div>
            <div>
                Age: ${profile.age} <br/>
            </div>
            <div>
                Current City: ${profile.currentCity} <br/>
            </div>
            <div>
                Sex: ${profile.sex} <br/>
            </div>
            <div>
                Phone number: ${profile.phoneNumber} <br/>
            </div>
            <div>
                E-mail: ${profile.currentUser.email} <br/>
            </div>
            <button type="submit">Edit</button>
        </form:form>
        <button type="button" onclick="history.back()">Back</button>
    </div>
</body>
</html>
