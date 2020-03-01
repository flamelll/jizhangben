<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 信1805-2 刘子煜 20183542 2020年1月2日 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<!-- Bootstrapvalidate导入 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/plug-ins/css/bootstrapValidator.css" />
<link href="${pageContext.request.contextPath}/plug-ins/css/demo.css" rel="stylesheet" type="text/css">
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/plug-ins/css/bootstrap.css" rel="stylesheet">

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/plug-ins/js/jquery-1.10.2.min.js"></script>

<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/plug-ins/js/bootstrap.js"></script>
</head>
<body>
<div class="col-lg-8 col-lg-offset-2">
   <div class="page-header">
   <div style="background-color:rgb(255,255,0)">
   <h1 >用户登录</h1>
   </div>
  <h2>登录</h2>
  <form action="${pageContext.request.contextPath }/loginservlet?method=search" class="form-horizontal" role="form">
  <div class="form-group">
  <label class="col-lg-3 control-label">账号：</label>
  <div class="col-lg-8">
  <input type="text" class="form-control" name="name" placeholding="账号"/>
  </div>
  <label class="col-lg-3 control-label">密码：</label>
  <div class="col-lg-8">
  <input type="password" class="form-control" name="password" placeholding="密码"/>
  </div>
  <div>
  <button type="submit" class="btn bvtn-primary">登录</button>
  </div>
  </div>
  
  </form>
  <a href="register.jsp">注册</a>
   </div>
</div>

</body>
</html>