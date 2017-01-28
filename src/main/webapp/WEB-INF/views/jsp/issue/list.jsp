<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>All Issues</title>
  <link rel="stylesheet"
        type="text/css"
        href="<s:url value="/resources/bootstrap.min.css" />">
</head>
<body>
<div class="container-fluid">
  <%--<div class="page-header" style="background-color: #66afe9;margin: 0px !important;">--%>
    <div class="row">
     <%-- <div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>Spring MVC + Gradle
        Demo</b></h1></div>--%>
       <jsp:include page="../../../../resources/header.jsp"/>
    </div>
  <%--</div>--%>
    <a class="btn btn-success" href="<s:url  value="create"/>">Create</a>

    <c:if test="${issueList.isEmpty()}">
    <div class="row">
      <div class="col-lg-6 col-lg-offset-3">
        <div class="alert alert-danger"><s:message code="no.issue"/></div>
      </div>
    </div>
  </c:if>
  <c:if test="${!issueList.isEmpty()}">
    <div class="row">
      <div class="col-lg-6 col-lg-offset-3">
        <table class="table table-responsive">
          <tr>
            <th><s:message code="issue.id"/></th>
            <th><s:message code="issue.title"/></th>
            <th><s:message code="issue.description"/></th>
            <th><s:message code="issue.action"/></th>
          </tr>
          <c:forEach var="issue" items="${issueList}" varStatus="i">
            <tr>
              <td>${i.index +1 }</td>
              <td>${issue.getTitle()}</td>
              <td>${issue.getDescription()}</td>
              <td><a class="btn btn-success" href="<s:url value="edit?id=${issue.getId()}"/>">Edit</a>
              </td>
              <td><a class="btn btn-danger" href="<s:url value="delete?id=${issue.getId()}"/>">Delete</a>
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
