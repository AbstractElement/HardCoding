
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<%--i18--%>
<spring:message code="message.label.post" var="post"/>
<spring:message code="message.label.author" var="author"/>
<spring:message code="message.label.newPost" var="newPost"/>
<spring:message code="message.label.back" var="back"/>
<%--   --%>

<html>
<head>
    <title>StarExpress</title>
  <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<c:if test="${sessionScope.idUser != null}">
  <body style="background: url('/resources/images/bg/left.jpg');
  background-size: cover; background-attachment: fixed; background-repeat: no-repeat">
    <%--<h1 style="margin-left: 50%">${post}</h1>--%>
    <div class="inline" id="menu">
      <myTags:leftMenu/>
    </div>
    <div class="inline" id="mainColumn">
      <c:if test="${posts.size() > 0}">
        <c:forEach var="i" begin="0" end="${posts.size()-1}">
          <div>
            <table>
              <tr>
                <td rowspan="2">
                  <img style="width: 70px" src="/resources/images/avatar/${posts.get(i).profile.avatar}">
                </td>
                <td>${author}: ${posts.get(i).ownerPost}</td>
              </tr>
              <tr>
                <td><h5 class="time"><i>${posts.get(i).timeOfPublication}</i></h5></td>
              </tr>
              <tr><td colspan="2">
                    <textarea cols="40" rows="5" disabled>${posts.get(i).message}</textarea>
              </td></tr>
            </table>
          </div>
          <br/>
        </c:forEach>
      </c:if>
      <%--<form action="/posts/newPost" method="get">--%>
        <%--<button type="submit" >${newPost}</button>--%>
        <%--&lt;%&ndash;<button type="button" onclick="history.back()">${back}</button>&ndash;%&gt;--%>
      <%--</form>--%>
    </div>
  </body>
</c:if>
<c:if test="${sessionScope.idUser == null}">
  <body background="/resources/images/error/error-page.jpg">
    <div id="mes">Power to see this page, you not have</div>
  </body>
</c:if>
</html>
