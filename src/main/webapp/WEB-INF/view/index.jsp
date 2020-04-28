<%--
  Created by IntelliJ IDEA.
  User: Vinod
  Date: 4/28/2020
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sms page</title>
<link type="text/css" rel="stylesheet" href="webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>
</head>
<body>
    <h1 class="text-center">Send SMS</h1>
<div class="container mt-5">
    <form method="get" action="${pageContext.request.contextPath}/sendMessage">
        <input type="text" name="mobileNumber" placeholder="+91 phone number" class="form-control">
        <textarea cols="4" name="message" placeholder="message..." class="form-control"></textarea>
        <button type="submit" class="btn btn-primary">Send</button>
    </form>
    <div class="alert-info">
        ${msg}
    </div>
</div>
</body>
</html>
