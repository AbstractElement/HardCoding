<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 06.09.2016
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>StarExpress</title>
</head>
<body>
  <h1><spring:message code="message.label.post"/></h1>
  <c:if test="${posts.size() > 0}">
    <c:forEach var="i" begin="0" end="${posts.size()-1}">
      <div>
        <table>
          <tr>
            <td rowspan="2">picture</td>
            <td><spring:message code="message.label.author"/>: <c:out value="${posts.get(i).ownerPost}"/></td>
          </tr>
          <tr>
            <td><h5 class="time"><i><c:out value="${posts.get(i).timeOfPublication}"/></i></h5></td>
          </tr>
          <tr><td colspan="2">
                <textarea cols="40" rows="5" disabled><c:out value="${posts.get(i).message}"/>
                </textarea>
          </td></tr>
        </table>
      </div>
      <br/>
    </c:forEach>
  </c:if>
  <form action="/posts/newPost" method="get">
    <button type="submit" >
      <spring:message code="message.label.newPost"/>
    </button>
  </form>
  <button type="button" onclick="history.back()">
    <spring:message code="message.label.back"/>
  </button>
</body>
</html>
