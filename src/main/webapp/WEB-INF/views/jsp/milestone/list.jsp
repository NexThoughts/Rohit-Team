<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All MileStones</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/bootstrap.min.css" />">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="../../../../resources/header.jsp"/>
    </div>
    <a class="btn btn-success" href="<s:url  value="create"/>">Create</a>

    <c:if test="${milestoneList.isEmpty()}">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <div class="alert alert-danger"><s:message code="no.milestones"/></div>
            </div>
        </div>
    </c:if>
    <c:if test="${!milestoneList.isEmpty()}">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3">
                <table class="table table-responsive">
                    <tr>
                        <th><s:message code="issue.id"/></th>
                        <th><s:message code="label.name"/></th>
                        <th><s:message code="milestone.startDate"/></th>
                        <th><s:message code="milestone.endDate"/></th>
                        <th><s:message code="issue.action"/></th>
                    </tr>
                    <c:forEach var="milestone" items="${milestoneList}" varStatus="i">
                        <tr>
                            <td>${i.index +1 }</td>
                            <td>${milestone.getName()}</td>
                            <td>${milestone.getStartDate()}</td>
                            <td>${milestone.getEndDate()}</td>
                            <td><a class="btn btn-success" href="<s:url value="edit?id=${milestone.getId()}"/>">Edit</a>
                            </td>
                            <td><a class="btn btn-danger"
                                   href="<s:url value="delete?id=${milestone.getId()}"/>">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </c:if>
    <jsp:include page="../../../../resources/footer.jsp"/>

</div>
</body>
</html>
