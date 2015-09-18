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

  <div class="row" id="content">
    <div class="alert alert-warning" role="alert" style="display: none;"></div>
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
<script style="text/javascript">
  var checkName = function(response) {
    var result = JSON.parse(response);
    switch (result.code) {
      case "E0000":
        return true;
        break;
    }
    return false;
  };

  $("#signupForm").validate({
    debug: true,
    onkeyup: false,

    showErrors: function(errorMap, errorList) {
      var errorStrings="";
      console.log(errorList.length);
      if (errorList.length > 0) {
        errorList.forEach(function(element, index, array) {
          errorStrings += "<li>" + element.message + "</li>";
        });
        $(".alert-warning").html(errorStrings).show();
      } else {
        $(".alert-warning").hide();
      }
    },
    submitHandler: function(form) {
      form.submit();
    },

    rules: {
      name: {
        required: true,
        remote: {
          url: "/register/checkName",
          type: "POST",
          dataType: "json",
          cache: false,
          data: {
            "name" : function() {return $("#name").val();}
          },
          dataFilter: function(response) {
            return checkName(response);
          }
        }
      },
      password: {
        required: true,
        minlength: 8
      }
    },
    messages: {
      name: {
        required: "用户名不能为空",
        remote: "用户名未注册,请前往注册界面"
      },
      password: {
        required: "密码不能为空",
        minlength: "密码最低为{0}位"
      }
    }
  });
</script>