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
  <%--<div class="page-header" style="background-color: #66afe9;margin: 0px !important;">--%>
    <div class="row">
     <%-- <div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>Spring MVC + Gradle
        Demo</b></h1></div>--%>
      <jsp:include page="../../../../resources/header.jsp"/>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-6 col-lg-offset-3">
      <h3 class="text-center">Create Issue</h3>
      <form method="post" class="form-horizontal">
        <div class="col-lg-6 col-lg-offset-3">
          <fieldset>
            <label class="text-left control-label" for="title">Title</label>
            <input class="pull-right form-control input-md" name="title" id="title"
                   placeholder="Enter Title"/>
            <errors name="title" class="error"/>
            <br>
          </fieldset>

          <fieldset>
            <label class="text-left control-label" for="description">Description</label>
            <input class="pull-right form-control input-md" name="description" id="description"
                   placeholder="Enter Description"/>
            <errors name="description" class="error"/>
            <br>
          </fieldset>

          <fieldset>
            <br>
            <div class="row">
              <div class="col-lg-6">
                  <input type="submit" value="Create" class="btn btn-success">
                </div>
                <div class="col-lg-6">
                  &nbsp;<a class="btn btn-info" href="<s:url value="/issue/list"/>">Back</a>
              </div>
            </div>
          </fieldset>
        </div>
      </form>
    </div>
  <%--</div>--%>
  <jsp:include page="../../../../resources/footer.jsp"/>

</div>
</body>
</html>