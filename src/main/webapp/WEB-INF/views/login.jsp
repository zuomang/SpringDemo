<%--
  Created by IntelliJ IDEA.
  User: Mang
  Date: 15/9/7
  Time: 下午12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
  <div class="row">
    <div class="alert alert-warning" role="alert" style="display: none"></div>
    <div class="col-md-4 col-md-offset-4 outdiv">
      <h4 class="div-header">登录</h4>
      <hr>
      <form id="signupForm" method="post" action="/login">
        <div class="input-group">
          <span class="input-group-addon" id="basic-addon1">
            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
          </span>
          <input type="text" class="form-control" id="name" name="name" placeholder="用户名" aria-describedby="basic-addon1">
        </div>
        <div class="input-group">
          <span class="input-group-addon" id="basic-addon2">
            <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
          </span>
          <input type="password" class="form-control" id="password" name="password" placeholder="密码" aria-describedby="basic-addon2">
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-danger form-center">登录</button>
          <a href="/register" class="btn btn-primary form-center" role="button">注册</a>
        </div>
      </form>
    </div>
  </div>
</div>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script style="text/javascript">
  var checkFlag = "";

  $(function() {
    $('.btn-danger').attr({"disabled":"disabled"});
  });

  $('input').blur(function() {
    var name = $('#name').val().trim();
    var password = $('#password').val().trim();
    $('.alert-warning').hide();

    if($(this).attr("name") == "name") {
      if(name.length == 0) {
        $('.btn-danger').html("用户名不能为空").show();
      } else {
        var data = {
          "name": name
        };
        $.ajax({
          type: 'post',
          url: '/register/checkName',
          async: false,
          data : JSON.stringify(data),
          contentType : 'application/json; charset=UTF-8',
          dataType : 'json',
          success : function(result) {
            if(result.code == "E0001")
              $('.alert-warning').html("用户名不存在,请重试").show();
            checkFlag = (result.code == 'E0000' ? true : false);
          }
        });
      }
    }

    if(name.length > 0 && password.length > 0 && checkFlag) {
      $('.btn-danger').removeAttr("disabled");
    } else {
      $('.btn-danger').attr("disabled", "disabled");
    }
  })
</script>