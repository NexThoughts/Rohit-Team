<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
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
    <div class="row">
        <div class="col-lg-12">
            <h3 class="text-center">Add User</h3>
            <form method="post" class="form-horizontal">
                <div class="col-lg-12  col-lg-offset-4">
                    <fieldset>
                        <div class="col-lg-1">
                            <label class="textleft control-label" for="username">Username</label>
                        </div>
                        <div class="col-lg-2">
                            <input class="pull-right form-control input-md" name="username" id="username"
                                   placeholder="Username"/>
                            <errors name="title" class="error"/>
                            <br>
                        </div>
                    </fieldset>
                </div>
                <br>
                <br>
                <div class="col-lg-12 col-lg-offset-5">
                    <input type="submit" value="Search" class="btn btn-success ">
                    &nbsp;<a class="btn btn-info" href="<s:url value="/project/list"/>">Back</a>
                </div>
            </form>

            <c:if test="${users.isEmpty()}">
                <div class="row">
                    <div class="col-lg-6 col-lg-offset-3">
                        <div class="alert alert-danger"><s:message code="no.userFound"/></div>
                    </div>
                </div>
            </c:if>
            <c:if test="${!users.isEmpty()}">
                <div class="row">
                    <div class="col-lg-6 col-lg-offset-3">
                        <table class="table table-responsive">
                            <tr>
                                <th><s:message code="issue.id"/></th>
                                <th><s:message code="issue.title"/></th>
                                <th><s:message code="issue.action"/></th>
                            </tr>
                            <c:forEach var="user" items="${users}" varStatus="i">
                                <tr>
                                    <td>${i.index +1 }</td>
                                    <td>${user.getUsername()}</td>
                                    <td><a class="btn btn-success"
                                           href="<s:url value="removeUser?id=${id}&userId=${user.getId()}"/>">Remove
                                        User</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                </div>
            </c:if>

        </div>
    </div>
</div>
</body>
</html>