<%--
  Created by IntelliJ IDEA.
  User: Mang
  Date: 9/11/15
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
      </button>
      <a class="navbar-brand" href="#">刷题</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">活动</a></li>
        <li><a href="#">题库</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <core:choose>
          <core:when test="${user == null}">
            <li><a href="#">登录</a></li>
            <li><a href="#">注册</a></li>
          </core:when>
          <core:otherwise>
            <li><a href="#">${user.name}</a></li>
          </core:otherwise>
        </core:choose>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>