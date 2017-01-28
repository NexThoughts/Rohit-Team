<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Issue</title>
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
        <jsp:include page="../../../../resources/header.jsp"/>
    </div>
    <div class="row">
        <span style="margin-left: 10px"><b>Projects</b></span>
        <span css="pull-right" style="margin-left: 80%"><a href="/project/create" class="btn btn-success">Create Projects</a></span>
        <c:if test="${projects.isEmpty()}">
            <div class="col-lg-12">No Project Found</div>
        </c:if>
        <c:if test="${!projects.isEmpty()}">
            <div class="col-lg-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th> Project Name</th>
                        <th> Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${projects}" var="project">
                        <tr>
                            <td>${project.name}</td>
                            <td><a href="/project/edit?id=${project.id}" class="btn btn-info">Edit</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
    <jsp:include page="../../../../resources/footer.jsp"/>

</div>
</body>
</html>