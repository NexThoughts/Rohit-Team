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
  <div class="page-header" style="background-color: #66afe9;margin: 0px !important;">
    <div class="row">
      <div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>Spring MVC + Gradle
        Demo</b></h1></div>
    </div>
  </div>
  <c:if test="${projectList.isEmpty()}">
    <div class="row">
      <div class="col-lg-6 col-lg-offset-3">
        <div class="alert alert-danger"><s:message code="no.projects"/></div>
      </div>
    </div>
  </c:if>
  <c:if test="${!projectList.isEmpty()}">
    <div class="row">
      <div class="col-lg-6 col-lg-offset-3">
        <table class="table table-responsive">
          <tr>
            <th><s:message code="issue.id"/></th>
            <th><s:message code="issue.title"/></th>
            <th><s:message code="issue.action"/></th>
          </tr>
          <c:forEach var="project" items="${projectList}" varStatus="i">
            <tr>
              <td>${i.index +1 }</td>
              <td>${project.getName()}</td>
              <td><a class="btn btn-success" href="<s:url value="edit?id=${project.getId()}"/>">Edit</a>
              </td>
              <td><a class="btn btn-danger" href="<s:url value="delete?id=${project.getId()}"/>">Delete</a>
              </td>
            </tr>
          </c:forEach>
        </table>

      </div>
    </div>
  </c:if>

</div>
</body>
</html>
