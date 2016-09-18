<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Profile</title>
    <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
    <style>
        div#profilePage{
            width: 70%;
            margin: auto;
        }
    </style>
</head>
<body>
    <c:if test="${sessionScope.idUser != ''}">
        <div id="profilePage">
            <div class="inline" id="myProfile">
                <h1>Menu</h1>
                <a href="/profile/posts">All posts</a><br/>
                <a href="/profile/people">People</a><br/>
                <a href="/posts/newPost">New Post</a><br/>
                <a href="/">Exit</a><br/>
            </div>
            <div class="inline">
                <form:form action="/profile/edit" method="post" commandName="editProfile">
                    <h2>${profile.lastName} ${profile.firstName}</h2>
                    Age: ${profile.age}<br/>
                    Current City: ${profile.currentCity}<br/>
                    Sex: ${profile.sex}<br/>
                    Phone number: ${profile.phoneNumber}<br/>
                    E-mail: ${profile.currentUser.email}<br/>
                    <c:if test="${sessionScope.idUser == profile.currentUser.id}">
                        <button type="submit">Edit</button>
                    </c:if>
                </form:form>
            <h1>My posts</h1>
                <c:if test="${posts.size() > 0}">
                    <c:forEach var="i" begin="0" end="${posts.size()-1}">
                        <table>
                            <tr>
                                <td rowspan="2" class="avatar">picture</td>
                                <td>Author: ${posts.get(i).ownerPost}</td>
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
                                        <a href="/posts/edit/${posts.get(i).idPosts}">Edit</a>
                                        <a href="/posts/delete/${posts.get(i).idPosts}">Delete</a>
                                    </td>
                                </tr>
                            </c:if>
                        </table>
                        <br/><br/>
                    </c:forEach>
                </c:if>
                <c:if test="${posts.size() == 0}">
                    You have not publications
                </c:if>
            </div>
        </div>
    </c:if>
</body>
</html>
