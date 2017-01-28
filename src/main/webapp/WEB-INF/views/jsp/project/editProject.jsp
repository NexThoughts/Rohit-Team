<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Project</title>
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
        <div class="col-lg-6 col-lg-offset-3">
            <h3 class="text-center"><s:message code="edit.Project"/></h3>
            <sf:form method="post" cssClass="form-horizontal" commandName="project">
                <div class="col-lg-6 col-lg-offset-3">
                    <fieldset>
                        <label class="text-left control-label" for="name">Name</label>
                        <sf:input cssClass="pull-right form-control input-md" path="name"
                                  placeholder="Enter Project Name"/>
                        <sf:errors path="name" cssClass="error"/><br>
                    </fieldset>
                    <fieldset>
                        <br>

                        <div class="row">
                            <div class="col-lg-6">
                                <input type="submit" value="Update" class="btn btn-success ">
                            </div>
                            <div class="col-lg-6">
                                &nbsp;<a class="btn btn-info" href="<s:url value="/project/list"/>">Back</a>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </sf:form>
        </div>
    </div>
    <jsp:include page="../../../../resources/footer.jsp"/>
    <span css="pull-right" style="margin-left: 80%"> <a class="btn btn-success" style="" href="/issue/create">Create
        Issue</a></span>
    <%--<c:if test="${issueCommands.isEmpty()}">--%>
    <%--<div class="row">--%>
    <%--<div class="col-lg-6 col-lg-offset-3">--%>
    <%--<div class="alert alert-danger"><s:message code="no.issue"/></div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${!issueCommands.isEmpty()}">--%>
    <%--<div class="row">--%>
    <%--<div class="col-lg-6 col-lg-offset-3">--%>
    <%--<table class="table table-responsive">--%>
    <%--<tr>--%>
    <%--<th><s:message code="issue.id"/></th>--%>
    <%--<th><s:message code="issue.title"/></th>--%>
    <%--<th><s:message code="issue.action"/></th>--%>
    <%--</tr>--%>
    <%--<c:forEach var="issue" items="${issueCommands}" varStatus="i">--%>
    <%--<tr>--%>
    <%--<td>${i.index +1 }</td>--%>
    <%--<td>${issue.getName()}</td>--%>
    <%--<td><a class="btn btn-success" href="<s:url value="edit?id=${issue.getId()}"/>">Edit</a>--%>
    <%--</td>--%>
    <%--<td><a class="btn btn-danger"--%>
    <%--href="<s:url value="delete?id=${issue.getId()}"/>">Delete</a>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</table>--%>

    <%--</div>--%>
    <%--</div>--%>
    <%--</c:if>--%>
</div>
</body>
</html>