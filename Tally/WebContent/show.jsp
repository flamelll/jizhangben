<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath%>">
    <title>账单页面</title>
  </head>
  
  <body>
  <h1>${xiaoxi}</h1>
  <table  width="600" border="1" cellpadding="0" >
  <form id="search" method="post" class="form-horizontal" action="${pageContext.request.contextPath }/searchservlet">  
    <tr>
           <td><input type="text" class="form-control" name="date" placeholder="请输入日期"></td>
           <button type="submit" class="btn btn-primary">查询</button>
    </tr>
    </form>
  		<tr>
	  		<th>日期</th>
	  		<th>金额</th>
	  		<th>类型</th>
	  		<th>说明</th>
  		</tr>
     <c:forEach var="U" items="${list}"  > 
      <form action="#" method="post"> 
       <tr>
	       <td><input type="text" value="${U.date}" name="date"></td>
	       <td><input type="text" value="${U.money}" name="money"></td>
	       <td><input type="text" value="${U.type}" name="type"></td>
	       <td><input type="text" value="${U.style}" name="style"></td>
	       <td><a onclick="return check()" href="deleteservlet?date=${U.date}&money=${U.money}&type=${U.type}&style=${U.style}">删除</a></td>
	   </tr>
    </form> 
    </c:forEach>
    <div><a  href="index.jsp"><font SIZE="4" >返回</font></a></div>
    </table>
    <script type="text/javascript">
        function check() {
            if (confirm("是否确认删除该员工信息？")){
                return true;
            }else{
                return false;
            }
        }
    </script>
  </body>
</html>