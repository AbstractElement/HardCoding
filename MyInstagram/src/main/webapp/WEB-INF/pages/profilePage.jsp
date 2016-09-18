<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 01.09.2016
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StarExpress</title>
    <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="profilePage">
        <div class="inline" id="myProfile">
            <h1><spring:message code="message.label.menu"/></h1>
            <a href="/profile/posts"><spring:message code="message.label.post"/></a><br/>
            <a href="/profile/people"><spring:message code="message.label.people"/></a><br/>
            <a href="/posts/newPost"><spring:message code="message.label.newPost"/></a><br/>
            <a href="/"><spring:message code="message.label.exit"/></a><br/>
        </div>
        <div class="inline">
            <form:form action="/profile/edit" method="post" commandName="editProfile">
                <h2>${profile.lastName} ${profile.firstName}</h2>
                <spring:message code="message.label.age"/>: ${profile.age}<br/>
                <spring:message code="message.label.currentCity"/>: ${profile.currentCity}<br/>
                <spring:message code="message.label.sex"/>: ${profile.sex}<br/>
                <spring:message code="message.label.phone"/>: ${profile.phoneNumber}<br/>
                <spring:message code="message.label.email"/>: ${profile.currentUser.email}<br/>
                <c:if test="${sessionScope.idUser == profile.currentUser.id}">
                    <button type="submit"><spring:message code="message.label.edit"/></button>
                </c:if>
            </form:form>
        <h1><spring:message code="message.label.myPosts"/></h1>
            <c:if test="${posts.size() > 0}">
                <c:forEach var="i" begin="0" end="${posts.size()-1}">
                    <table>
                        <tr>
                            <td rowspan="2" class="avatar">picture</td>
                            <td><spring:message code="message.label.author"/>: ${posts.get(i).ownerPost}</td>
                        </tr>
                        <tr>
                            <td><h5 class="time"><i>${posts.get(i).timeOfPublication}</i></h5></td>
                        </tr>
                            <tr>
                                <td colspan="2">
                                    <c:choose>
                                        <c:when test="${editPost.idPosts == posts.get(i).idPosts}">
                                            <form:form action="/posts/edit" method="post" commandName="editPost">
                                                <form:form path="idPosts"/>
                                                <textarea cols="40" rows="5" name="newMes">${editPost.message}</textarea><br/>
                                                <button type="submit">Save edit</button>
                                            </form:form>
                                        </c:when>
                                        <c:otherwise>
                                            <textarea cols="40" rows="5" disabled>${posts.get(i).message}</textarea>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        <c:if test="${sessionScope.idUser == profile.currentUser.id}">
                            <tr class="button">
                                <td colspan="2">
                                    <a href="/posts/edit/${posts.get(i).idPosts}">
                                        <spring:message code="message.label.edit"/>
                                    </a>
                                    <a href="/posts/delete/${posts.get(i).idPosts}">
                                        <spring:message code="message.label.delete"/>
                                    </a>
                                </td>
                            </tr>
                        </c:if>
                    </table>
                    <br/><br/>
                </c:forEach>
            </c:if>
            <c:if test="${posts.size() == 0}">
                <spring:message code="message.label.notPublication"/>
            </c:if>
        </div>
    </div>
</body>
</html>
