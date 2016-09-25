<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="leftMenu" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 01.09.2016
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%--i18--%>
<spring:message code="message.label.currentCity" var="currentCity"/>
<spring:message code="message.label.phone" var="phone"/>
<spring:message code="message.label.age" var="age"/>
<spring:message code="message.label.sex" var="sex"/>
<spring:message code="message.label.email" var="email"/>
<spring:message code="message.label.edit" var="edit"/>
<spring:message code="message.label.myPosts" var="myPosts"/>
<spring:message code="message.label.author" var="author"/>
<spring:message code="message.label.delete" var="del"/>
<spring:message code="message.label.notPublication" var="noPubl"/>
<spring:message code="message.label.saveEdit" var="save"/>
<%--   --%>

<html>
<head>
    <title>StarExpress</title>
    <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
</head>
<c:if test="${sessionScope.idUser != null}">
    <body style="background: url('/resources/images/bg/right.jpg'); background-size: 100%; background-attachment: fixed">
        <%--<div id="profilePage">--%>
            <div class="inline" id="menu">
                <leftMenu:leftMenu/>
            </div>
            <div class="inline" id="mainColumn">
                <span>${profile.lastName} ${profile.firstName}</span>
                <form:form action="/profile/edit" method="post" commandName="editProfile">
                    <hr>
                    <table>
                        <tr>
                            <td rowspan="6">
                                <img style="width: 100px" src="/resources/images/avatar/${profile.avatar}"/>
                            </td>
                            <td>${age}: ${profile.age}</td>
                        </tr>
                        <tr>
                            <td>${currentCity}: ${profile.currentCity}</td>
                        </tr>
                        <tr>
                            <td>${sex}: <img style="width: 15px" src="/resources/images/sex/${profile.sex}"/></td>
                        </tr>
                        <tr>
                            <td>${phone}: ${profile.phoneNumber}</td>
                        </tr>
                        <tr>
                            <td>${email}: ${profile.currentUser.email}</td>
                        </tr>
                    </table>
                    <c:if test="${sessionScope.idUser == profile.currentUser.id}">
                        <button id="edit" type="submit">${edit}</button>
                    </c:if>
                    <hr>
                </form:form>
            <h1>${myPosts}</h1>
                <c:if test="${posts.size() > 0}">
                    <c:forEach var="i" begin="0" end="${posts.size()-1}">
                            <table>
                                <tr>
                                    <td rowspan="2" class="avatar">
                                        <img style="width: 70px" src="/resources/images/avatar/${profile.avatar}">
                                    </td>
                                    <td>${author}: ${posts.get(i).ownerPost}</td>
                                </tr>
                                <tr>
                                    <td><h5 class="time"><i>${posts.get(i).timeOfPublication}</i></h5></td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <form:form method="post" action="/posts/edit" commandName="editPost">
                                            <c:choose>
                                                <c:when test="${editPost.idPosts == posts.get(i).idPosts}">
                                                    <form:hidden path="idPosts"/>
                                                    <form:textarea path="message" cols="40" rows="5"/><br/>
                                                    <button class="" type="submit">${save}</button>
                                                </c:when>
                                                <c:otherwise>
                                                    <textarea cols="40" rows="5" disabled>${posts.get(i).message}
                                                    </textarea>
                                                </c:otherwise>
                                            </c:choose>
                                        </form:form>
                                    </td>
                                </tr>
                                <c:if test="${sessionScope.idUser == profile.currentUser.id}">
                                    <tr class="button">
                                        <td colspan="2">
                                            <a href="/posts/edit/${posts.get(i).idPosts}">${edit}</a>
                                            <a href="/posts/delete/${posts.get(i).idPosts}">${del}</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </table>
                        <br/><br/>
                    </c:forEach>
                </c:if>
                <c:if test="${posts.size() == 0}">
                    ${noPubl}
                </c:if>
            </div>
        <%--</div>--%>
    </body>
</c:if>
<c:if test="${sessionScope.idUser == null}">
    <body background="/resources/images/error/error-page.jpg">
        <div id="mes">Power to see this page, you not have</div>
    </body>
</c:if>
</html>
