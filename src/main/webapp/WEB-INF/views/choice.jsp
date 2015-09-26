<%--
  Created by IntelliJ IDEA.
  User: Mang
  Date: 15/9/18
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row" id="content">
  <div class="col-md-10 col-md-offset-1">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4>选择题</h4>
      </div>
      <div class="panel-body">
        <div class="row">
          <core:choose>
            <core:when test="${librarys == null}">
              <p>题库内暂时没有任何题目</p>
            </core:when>
            <core:otherwise>
              <core:forEach items="${librarys}" var="library">
                <div class="col-md-3">
                  <div class="thumbnail">
                    <h4>${library.title}</h4>
                    <p><small>${library.content}</small></p>
                    <p><small>题数: ${library.countChoice}</small></p>
                    <p>
                      <a href="/question/choice/practice/${library.ID}" class="btn btn-primary" role="button">练习</a>
                      <a href="/question/choice/practice/${library.ID}" class="btn btn-default" role="button">错题</a>
                    </p>
                  </div>
                </div>
              </core:forEach>
            </core:otherwise>
          </core:choose>
        </div>
      </div>
    </div>
  </div>
</div>