<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 14.09.2016
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Star Express</title>
</head>
<body>
    <c:if test="${profileList.size() > 0}">
      <c:forEach var="i" begin="0" end="${profileList.size()-1}">
        <div>
          <table>
            <tr>
              <td rowspan="2">picture</td>
              <td>
                <c:out value="${profileList.get(i).lastName} ${profileList.get(i).firstName}"/>
              </td>
            </tr>
            <tr>
              <td><h5><i><c:out value="${profileList.get(i).currentUser.email}"/></i></h5></td>
            </tr>
          </table>
        </div>
        <br/>
      </c:forEach>
    </c:if>
</body>
</html>
