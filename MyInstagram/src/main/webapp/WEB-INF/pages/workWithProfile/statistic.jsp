<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="leftMenu" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Star Express</title>
    <link href="/resources/styles/my_styles.css" rel="stylesheet" type="text/css">
    <%--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>--%>
    <script type="text/javascript" src="/resources/js/ajax_libs.js"></script>
    <script type="text/javascript" src="/resources/jqplot/jquery.jqplot.js"></script>
    <script type="text/javascript" src="/resources/jqplot/plugins/jqplot.highlighter.js"></script>
    <script type="text/javascript" src="/resources/jqplot/plugins/jqplot.cursor.js"></script>
    <script type="text/javascript" src="/resources/jqplot/plugins/jqplot.dateAxisRenderer.js"></script>
    <script type="text/javascript" src="/resources/jqplot/plugins/jqplot.pieRenderer.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/jqplot/jquery.jqplot.css" />
    <script type="text/javascript" src="/resources/js/charts.js"></script>
</head>
<body style="background: url('/resources/images/bg/yoda-statistic.jpg'); background-position-y: 100px;
    background-size: cover; background-attachment: fixed; background-repeat: no-repeat;">
  <div class="inline" id="menu">
    <c:if test="${!profile.firstName.equals('') || !profile.lastName.equals('')}">
      <leftMenu:leftMenu/>
    </c:if>
  </div>
  <div class="inline" id="mainColumn">
    <div id="chart1" style="width: 400px; height: 300px"></div>
  </div>
</body>
</html>
