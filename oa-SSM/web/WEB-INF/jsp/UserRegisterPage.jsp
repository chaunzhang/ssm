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
                    <small>用户注册</small>
                    <small><a style="text-decoration: none" href="${pageContext.request.contextPath}/user/userLogout"><input style="float: right" type="button" value="退出" class="btn btn-primary"></a></small>
                </h1>
            </div>
        </div>
    </div>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/UesrRegister" method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" name="username" id="inputEmail3" placeholder="Username">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-4">
                <button type="submit" class="btn btn-default col-sm-12"  style="background-color: #7952B3;color: white">Sign up</button>
            </div>
        </div>

    </form>
</div>

</body>
</html>
