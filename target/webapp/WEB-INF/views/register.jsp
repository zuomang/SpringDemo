<%--
  Created by IntelliJ IDEA.
  User: Mang
  Date: 15/9/7
  Time: 下午1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>速刷题</title>
  <link href="/static/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="/static/css/showcontainer.css">
  <style type="text/css">
    body {
      background-color: #F5F5F5;
    }
    .outdiv {
      top: 50px;
      border: 1px solid #ddd;
      background-color: #FFFFFF;
    }
    .div-header {
      text-align: center;
    }
    hr {
      padding: 0px;
      margin: 15px 0px;
    }
  </style>
</head>
<body>
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
        <li><a href="#about">题库</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#about">登录</a></li>
        <li><a href="/register">注册</a></li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>

<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-offset-4 outdiv">
      <h4 class="div-header">欢迎注册</h4>
      <hr>
      <form method="post" action="/register">
        <div class="form-group">
          <input type="text" name="username" class="form-control" placeholder="用户名">
        </div>
        <div class="form-group">
          <input type="email" name="email" class="form-control" placeholder="邮箱">
        </div>
        <div class="form-group">
          <input type="password" name="password" class="form-control" placeholder="密码">
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
</body>
</html>
