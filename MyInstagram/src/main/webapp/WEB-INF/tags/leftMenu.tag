<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code="message.label.menu" var="menu"/>
<spring:message code="message.label.post" var="post"/>
<spring:message code="message.label.people" var="people"/>
<spring:message code="message.label.newPost" var="newPost"/>
<spring:message code="message.label.exit" var="exit"/>
<spring:message code="message.label.myProfile" var="myProfile"/>

<table class="lMenu" style="width:150px;">
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
        <td>
            <a href="/posts/newPost">${newPost}</a>
        </td>
    </tr>
    <tr>
        <td><a href="/">${exit}</a><br/></td>
    </tr>
    <%--<tr>--%>
        <%--<td>--%>
           <%--<span style="float: right; margin-right: 10px;">--%>
                <%--<a href="?lang=en"><img src="/resources/images/flags/us.png"></a>--%>
                <%--<a href="?lang=ru"><img src="/resources/images/flags/ru.png"></a>--%>
		    <%--</span>--%>
        <%--</td>--%>
    <%--</tr>--%>
</table>