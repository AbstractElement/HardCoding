<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 09.09.2016
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Post</title>
</head>
<body>
    <form:form action="/posts/newPost" method="post" commandName="post">
      <form:textarea path="message" cols="40" rows="5"/><br/>
        <form:errors path="message"/>
      <button type="submit">Submit</button>
    </form:form>
</body>
</html>
