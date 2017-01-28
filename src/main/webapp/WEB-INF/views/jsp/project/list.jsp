<%--
  Created by IntelliJ IDEA.
  User: bhaskar
  Date: 28/1/17
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/bootstrap.min.css" />">

</head>
<body>
<header>
    <jsp:include page="layout/header.jsp"/>
</header>
<div class="container-fluid">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Username</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="#" items="${#}" varStatus="i">
                        <tr>
                            <td>firstName</td>
                            <td>lastName</td>
                            <td>Username</td>
                            <td>update</td>
                            <td><a class="btn btn-success" href="<s:url value="edit?id=#"/>">Edit</a>
                            </td>
                            <td><a class="btn btn-danger" href="<s:url value="delete?id=#"/>">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
<footer>
    <jsp:include page="layout/footer.jsp"/>
</footer>
</div>

</body>
</html>
