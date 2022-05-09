<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增部门</small>
                    <small><a style="text-decoration: none" href="${pageContext.request.contextPath}/user/userLogout"><input style="float: right" type="button" value="退出" class="btn btn-primary"></a></small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/dept/addDept" method="post">
        <div class="form-group">
            <label>部门编号</label>
            <input type="text" name="deptno" class="form-control" >
        </div>
        <div class="form-group">
            <label >部门名称</label>
            <input type="text" name="dname" class="form-control" >
        </div>
        <div class="form-group">
            <label >部门位置</label>
            <input type="text" name="loc" class="form-control" >
        </div>
        <div class="form-group">
            <input type="submit" value="添加"/>
        </div>
    </form>
</div>

</body>
</html>
