<%--
  Created by IntelliJ IDEA.
  User: Mang
  Date: 15/9/7
  Time: 下午1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  <div class="row" id="content">
    <div class="alert alert-warning" role="alert" style="display: none"></div>
    <div class="col-md-4 col-md-offset-4 outdiv">
      <h4 class="div-header">欢迎注册</h4>
      <hr>
      <form id="registerForm" method="post" action="/register">
        <div class="form-group">
          <input type="text" name="name" id="name" class="form-control" placeholder="用户名">
        </div>
        <div class="form-group">
          <input type="email" name="email" id="email" class="form-control" placeholder="邮箱">
        </div>
        <div class="form-group">
          <input type="password" name="password" id="password" minlength="2" class="form-control" placeholder="密码">
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-danger btn-sm btn-block">提交</button>
        </div>
      </form>
    </div>
  </div>

<script type="text/javascript">
  var checkUnique = function(response) {
    var result = JSON.parse(response);
    switch (result.code) {
      case "E0001":
        return true;
        break;
      default:
        return false;
    }
  };

  $("#registerForm").validate({
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
      var data = {
        "name": $("#name").val(),
        "password": $("#password").val(),
        "email": $("#email").val()
      };

      $.post('/register', data, function(response) {
        if (response.code == "E0000") {
          console.log("register success");
          location.href = response.message;
        } else {
          $(".alert-warning").html(response.message).show();
          console.log("login error");
        }
      })
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
            return checkUnique(response);
          }
        }
      },
      email: {
        required: true,
        email: true,
        remote: {
          url: "/register/checkEmail",
          type: "POST",
          dataType: "json",
          cache: false,
          data: {
            "email": function() { return $("#email").val(); }
          },
          dataFilter: function(response) {
            return checkUnique(response);
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
        remote: "该用户已经存在,请使用其他用户名"
      },
      email: {
        required: "邮箱不能为空",
        email: "请输入正确的邮箱格式",
        remote: "该邮箱已经注册，请使用其他邮箱"
      },
      password: {
        required: "密码不能为空",
        minlength: "密码最低为{0}位"
      }
    }
  });
</script>
