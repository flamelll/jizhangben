<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>记账</title>
<!-- Bootstrapvalidate导入 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/plug-ins/css/bootstrapValidator.css" />
<link href="${pageContext.request.contextPath}/plug-ins/css/demo.css" rel="stylesheet" type="text/css">
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/plug-ins/css/bootstrap.css" rel="stylesheet">

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="${pageContext.request.contextPath}/plug-ins/js/jquery-1.10.2.min.js"></script>

<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="${pageContext.request.contextPath}/plug-ins/js/bootstrap.js"></script>

<!-- validate表单验证导入 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/plug-ins/js/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/plug-ins/js/bootstrapValidator_zh_CN.js"></script>

<!-- Font Awesome -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/plug-ins/css/font-awesome.min.css">

<script type="text/javascript">
	$(function() {
		//#''单引号里面是下面form标签的id
		$('#tally').bootstrapValidator(
				{
					message : 'This value is not valid',
					feedbackIcons : {
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					},
					fields : {
						date : {
							validators : {
								notEmpty : {
									message : '日期不能为空'
								},
								stringLength : {
									min : 1,
									max : 12,
									message : '日期由1-12个字符组成'
								},
							}
						},
						money:{
							validators:{
								notEmpty : {
									message : '金额不能为空'
								},
								stringLength : {
									min : 1,
									max : 12,
								},
								regexp : {
									regexp : /^[a-zA-Z0-9]+$/,
									message : '密码只能由字母数字组成'
								}
							}
						},
						style:{
							validators:{
								notEmpty : {
									message : '说明不能为空'
								}
							}
						},
					},
				});
	});
</script>

</head>
<body>
         <div class="col-lg-8 col-lg-offset-2">
             <div class="page-header">
                 <h2>用户记账</h2>
             </div>

             <form id="tally" method="post" class="form-horizontal" action="${pageContext.request.contextPath }/tallyservlet">
                 <div class="form-group">
                     <label class="col-lg-3 control-label">日期:</label>
                     <div class="col-lg-4">
                         <input type="text" class="form-control" name="date" placeholder="请设置日期 " />
                     </div>
                 </div>

                 <div class="form-group">
                     <label class="col-lg-3 control-label">金额:</label>
                     <div class="col-lg-5">
                         <input type="text" class="form-control" name="money" placeholder="请设置金额" />
                     </div>
                 </div>
                 
                 <div class="form-group">
                     <label class="col-lg-3 control-label">类型:</label>
                     <div class="col-lg-5">
                         <input type="radio" name="type"  value="收入"/>收入
                         <input type="radio" name="type"  value="支出"/>支出
                     </div>
                 </div>
                 
                 <div class="form-group">
                     <label class="col-lg-3 control-label">说明:</label>
                     <div class="col-lg-5">
                         <input type="text" class="form-control" name="style" placeholder="请说明" />
                     </div>
                 </div>

                 <div class="form-group">
                     <div class="col-lg-3 col-lg-offset-3">
                         <button type="submit" class="btn btn-primary">记账</button>
                 
             </form>
             <a href="index.jsp">返回</a>
         </div>
</body>
</html>