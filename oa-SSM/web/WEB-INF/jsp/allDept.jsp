<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门展示页面</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>部门展示————所有部门</small>
                    <small><a style="text-decoration: none" href="${pageContext.request.contextPath}/user/userLogout"><input style="float: right" type="button" value="退出" class="btn btn-primary"></a></small>
                </h1>

            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/dept/toAddPage">新增部门</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/dept/allDept">显示所有部门</a>
            </div>
            <div class="col-md-4 column" style="float: right">
                <form action="${pageContext.request.contextPath}/dept/queryByName" method="post" class="form-inline">
                    <input type="text" name="queryDeptName" class="form-control" placeholder="请输入要查询的部门的名称">
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <td>部门编号</td>
                    <td>部门名称</td>
                    <td>部门位置</td>
                    <td>操作</td>
                </tr>
                </thead>
                <%--书籍从数据库中查出来，从list中查--%>
                <tbody>
                <c:forEach var="dept" items="${list}">
                    <tr>
                        <td>${dept.deptno}</td>
                        <td>${dept.dname}</td>
                        <td>${dept.loc}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/dept/toUpdatePage?deptno=${dept.deptno}">修改</a>
                            &nbsp;|&nbsp;
                            <a href="${pageContext.request.contextPath}/dept/delDept?deptno=${dept.deptno}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>

</body>
</html>

