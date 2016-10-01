<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message text="/resources/images/avatar/1.jpg" var="img1"/>
<spring:message text="/resources/images/avatar/2.jpg" var="img2"/>
<spring:message text="/resources/images/avatar/3.jpg" var="img3"/>
<spring:message text="/resources/images/avatar/4.jpg" var="img4"/>
<spring:message text="/resources/images/avatar/5.jpg" var="img5"/>
<spring:message text="/resources/images/avatar/6.jpg" var="img6"/>
<spring:message text="/resources/images/avatar/7.jpg" var="img7"/>
<spring:message text="/resources/images/avatar/8.jpg" var="img8"/>
<spring:message text="/resources/images/avatar/9.jpg" var="img9"/>

<form:radiobutton path="avatar" value="1.jpg"/><img style="width: 100px" src="${img1}"/>
<form:radiobutton path="avatar" value="2.jpg"/><img style="width: 100px" src="${img2}"/>
<form:radiobutton path="avatar" value="3.jpg"/><img style="width: 100px" src="${img3}"/><br/>
<form:radiobutton path="avatar" value="4.jpg"/><img style="width: 100px" src="${img4}"/>
<form:radiobutton path="avatar" value="5.jpg"/><img style="width: 100px" src="${img5}"/>
<form:radiobutton path="avatar" value="6.jpg"/><img style="width: 100px" src="${img6}"/><br/>
<form:radiobutton path="avatar" value="7.jpg"/><img style="width: 100px" src="${img7}"/>
<form:radiobutton path="avatar" value="8.jpg"/><img style="width: 100px" src="${img8}"/>
<form:radiobutton path="avatar" value="9.jpg"/><img style="width: 100px" src="${img9}"/><br/>