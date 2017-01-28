<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User SignUp</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/bootstrap.min.css" />">
    <style>
        span.error {
            background-color: #ffcccc;
            border: 2px solid red;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <%--<div class="page-header" style="background-color: #66afe9;margin: 0px !important;">--%>
    <%--<div class="row">--%>
    <%--<div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>Spring MVC + Gradle--%>
    <%--Demo</b></h1></div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <h3 class="text-center"><s:message code="create.userCommand"/></h3>
            <form method="post" class="form-horizontal">
                <div class="col-lg-6 col-lg-offset-3">
                    <fieldset>
                        <label class="text-left control-label" for="username">Username</label>
                        <input class="pull-right form-control input-md" name="username" id="username"
                               placeholder="User name"/>
                        <errors name="username" class="error"/>
                        <br>
                    </fieldset>


                    <fieldset>
                        <label class="text-left control-label" for="email">Email</label>
                        <input class="pull-right form-control input-md" name="email" id="email"
                               placeholder="Email"/>
                        <errors name="email" class="error"/>
                        <br>
                    </fieldset>

                    <fieldset>
                        <label class="text-left control-label" for="password">Password</label>
                        <input type="password" class="pull-right form-control input-md" name="password" id="password"
                               placeholder="password"/>
                        <errors name="password" class="error"/>
                        <br>
                    </fieldset>

                    <fieldset>
                        <br>
                        <div class="row">
                            <div class="col-lg-6">
                                    <input type="submit" value="Create" class="btn btn-success ">
                                </div>
                                <div class="col-lg-6">
                                    &nbsp;<a class="btn btn-info" href="<s:url value="/login"/>">Back</a>
                                </div>
                            </div>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>