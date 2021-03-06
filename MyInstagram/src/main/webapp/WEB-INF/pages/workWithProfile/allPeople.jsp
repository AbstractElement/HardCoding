<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<%--i18--%>
<spring:message code="message.label.back" var="back"/>
<%--   --%>

<html>
<head>
    <title>StarExpress</title>
    <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<c:if test="${sessionScope.idUser != null}">
  <body style="background: url('/resources/images/bg/darth-right.jpg');
  background-size: cover; background-attachment: fixed; background-repeat: no-repeat">
    <div class="inline" id="menu">
      <myTags:leftMenu/>
    </div>
    <div class="inline" id="mainColumn">
      <c:if test="${profileList.size() > 0}">
        <c:forEach var="i" begin="0" end="${profileList.size()-1}">
          <div>
            <table>
              <tr>
                <td rowspan="2">
                  <img style="width: 70px" src="/resources/images/avatar/${profileList.get(i).avatar}"/>
                </td>
                <td>
                  <a href="/profile/viewProfile/${profileList.get(i).idProfile}">
                      ${profileList.get(i).lastName} ${profileList.get(i).firstName}
                  </a>
                </td>
              </tr>
              <tr>
                <td>
                  <h5><i>${profileList.get(i).currentUser.email}</i></h5>
                </td>
              </tr>
            </table>
          </div>
          <br/>
        </c:forEach>
      </c:if>
      <%--<button type="button" onclick="history.back()">${back}</button>--%>
    </div>
  </body>
</c:if>
<c:if test="${sessionScope.idUser == null}">
  <body background="/resources/images/error/error-page.jpg">
    <div id="mes">Power to see this page, you not have</div>
  </body>
</c:if>
</html>
