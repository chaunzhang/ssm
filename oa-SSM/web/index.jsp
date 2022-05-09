<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>首页</title>
  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script type="text/javasript">
    document.location.href="${pageContext.request.contextPath}/user/userLogin";
  </script>

</head>
<body>

<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          <small>用户登录</small>
          <small style="float: right">
            <a class="nav-link" style="text-decoration: none" href="${pageContext.request.contextPath}/index.jsp">Sign in</a>
            <a class="nav-link" style="text-decoration: none" href="${pageContext.request.contextPath}/user/toUserRegisterPage">Sign up</a>
          </small>
        </h1>
      </div>
    </div>
  </div>
  <form class="form-horizontal" action="${pageContext.request.contextPath}/user/userLogin" method="post">
    <div class="form-group">
      <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
      <div class="col-sm-4">
        <input type="text" class="form-control"  name="username" id="inputEmail3" placeholder="Username" onblur="a1()">
        <span id="userInfo"></span>
      </div>
    </div>
    <div class="form-group">
      <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
      <div class="col-sm-4">
        <input type="password" class="form-control" name="password" id="inputPassword3" placeholder="Password" onblur="a2()">
        <span id="pwdInfo"></span>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-4">
        <div class="checkbox">
          <label>
            <input type="checkbox" name="rem" value="1"> Remember me
          </label>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-4">
        <input type="submit" name="wp-submit" id="wp-submit" style="background-color: #7952B3;color: white;margin-bottom: 22.5px" class="btn btn-brand btn-block mb-4" value="Sign In">
        <%--<button type="submit" class="btn btn-default col-sm-12" style="background-color: #7952B3;color: white">Sign in</button>--%>
        <p class="small text-center text-gray-soft" style="color: #838e95">Don't have an account yet? <a style="text-decoration: none" href="${pageContext.request.contextPath}/user/toUserRegisterPage">Sign up</a></p>
      </div>
    </div>
  </form>


</div>

</body>
</html>

