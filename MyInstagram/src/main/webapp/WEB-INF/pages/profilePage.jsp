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
</head>
<body>
    <div class="inline" id="myProfile">
        <h1>Menu</h1>
        <div>
          <a href="/profile/posts">All posts</a><br/>
        </div>
        <div>
            <a href="/profile/people">People</a><br/>
        </div>
        <div>
            <a href="/posts/newPost">New Post</a><br/>
        </div>
        <div>
            <a href="/">Exit</a><br/>
        </div>
    </div>
    <div class="inline">
    <form:form action="/profile/edit" method="post" commandName="editProfile">
        <div>
            <h2>${profile.lastName} ${profile.firstName}</h2>
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
    <h1>My posts</h1>
        <c:if test="${posts.size() > 0}">
            <c:forEach var="i" begin="0" end="${posts.size()-1}">
                <table>
                    <tr>
                        <td rowspan="2" class="avatar">picture</td>
                        <td>Author: <c:out value="${posts.get(i).ownerPost}"/></td>
                    </tr>
                    <tr>
                        <td><h5 class="time"><i><c:out value="${posts.get(i).timeOfPublication}"/></i></h5></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea cols="40" rows="5" readonly><c:out value="${posts.get(i).message}"/></textarea>
                        </td>
                    </tr>
                    <tr class="button">
                        <td colspan="2">
                            <a href="/posts/edit">Edit</a>
                            <a href="/posts/delete?id=${posts.get(i).idPosts}">Delete</a>
                        </td>
                    </tr>
                </table>
                <br/><br/>
            </c:forEach>
        </c:if>
        <c:if test="${posts.size() == 0}">
            You have not publications
        </c:if>
    </div>
</body>
</html>
