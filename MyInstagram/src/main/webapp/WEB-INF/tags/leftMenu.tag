<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<spring:message code="message.label.menu" var="menu"/>
<spring:message code="message.label.post" var="post"/>
<spring:message code="message.label.people" var="people"/>
<spring:message code="message.label.newPost" var="newPost"/>
<spring:message code="message.label.exit" var="exit"/>
<spring:message code="message.label.myProfile" var="myProfile"/>

<table class="lMenu">
    <%--<tr>--%>
        <%--<td>${menu}</td>--%>
    <%--</tr>--%>
    <tr>
        <td><a href="/profile/myPage">${myProfile}</a></td>
    </tr>
    <tr>
        <td><a href="/profile/posts">${post}</a></td>
    </tr>
    <tr>
        <td><a href="/profile/people">${people}</a></td>
    </tr>
    <tr>
        <td><a href="/posts/newPost">${newPost}</a></td>
    </tr>
    <tr>
        <td><a href="/">${exit}</a><br/></td>
    </tr>
</table>