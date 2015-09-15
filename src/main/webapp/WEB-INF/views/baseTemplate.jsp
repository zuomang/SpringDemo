<%--
  Created by IntelliJ IDEA.
  User: Mang
  Date: 9/11/15
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html lang="zh-CN">
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>刷题</title>
  <link href="/static/css/bootstrap.min.css" rel="stylesheet">
  <link href="/static/css/starter-template.css" rel="stylesheet">
  <link href="/static/css/global.css" rel="stylesheet">
  <script type="text/javascript" src="/static/js/jquery-1.11.3.js"></script>
  <script type="text/javascript" src="/static/js/jquery.validate.min.js"></script>
  <script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
</head>
<body>
<div id="top">
  <tiles:insertAttribute name="top"></tiles:insertAttribute>
</div>
<div id="content">
  <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
</body>
</html>