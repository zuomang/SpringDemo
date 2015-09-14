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

<div class="container">
  <div class="row">
    <div class="alert alert-warning" role="alert" style="display: none"></div>
    <div class="col-md-4 col-md-offset-4 outdiv">
      <h4 class="div-header">欢迎注册</h4>
      <hr>
      <form method="post" action="/register">
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
</div>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
  var checkFlag;

  $(function() {
    $('.btn-danger').attr({"disabled":"disabled"});
  });

  $('input').blur(function() {
    var value = $.trim($(this).val());
    var name = $('#name').val().trim();
    var email = $('#email').val().trim();
    var password = $('#password').val().trim();

    $('.alert-warning').hide();
    if (value.length == 0) {
      $('.alert-warning').html($(this).attr("placeholder") + "不能为空").show();
    } else if ($(this).attr("id") == "name") {
      var data = {
        "name" : value
      };

      //TODO:暂时无法解决表单验证时异步数据返回问题
      $.ajax({
        type : 'post',
        url : '/register/checkName',
        dataType : 'json',
        async: false,
        data : JSON.stringify(data),
        contentType : 'application/json; charset=UTF-8',
        success : function(result) {
          $('.alert-warning').html(result.message).show();
          checkFlag = (result.code == 'E0000' ? false : true);
        }
      })
    }

    if (name.length > 0 && email.length > 0 && password.length > 0 && checkFlag) {
      $('.btn-danger').removeAttr("disabled");
    } else {
      $('.btn-danger').attr("disabled", "disabled");
    }
  });
</script>
