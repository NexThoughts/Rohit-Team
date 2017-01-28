<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:message code="milestone.create.label"/></title>
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
            <h3 class="text-center"><s:message code="milestone.create.label"/></h3>
            <sf:form method="post" cssClass="form-horizontal" commandName="milestone">
                <div class="col-lg-6 col-lg-offset-3">
                    <fieldset>
                        <label class="text-left control-label" for="name"><s:message code="milestone.name"/></label>
                        <sf:input cssClass="pull-right form-control input-md" path="name"
                                  placeholder="Enter Name"/>
                        <sf:errors path="name" cssClass="error"/><br>
                    </fieldset>

                    <fieldset>
                        <label class="text-left control-label" for="startDate"><s:message
                                code="milestone.startDate"/></label>
                        <sf:input cssClass="pull-right form-control input-md" path="startDate"
                                  placeholder="Enter last Name"/>
                        <sf:errors path="startDate" cssClass="error"/><br>
                    </fieldset>
                    <fieldset>
                        <label class="text-left control-label" for="endDate"><s:message
                                code="milestone.endDate"/></label>
                        <sf:input cssClass="pull-right form-control input-md" path="endDate"
                                  placeholder="Enter last Name"/>
                        <sf:errors path="endDate" cssClass="error"/><br>
                    </fieldset>


                    <fieldset>
                        <br>
                        <div class="row">
                            <div class="col-lg-6">
                                    <input type="submit" value="Update" class="btn btn-success ">
                                </div>
                                <div class="col-lg-6">
                                    &nbsp;<a class="btn btn-info" href="<s:url value="/label/list"/>">Back</a>
                                </div>
                            </div>
                    </fieldset>
                </div>
            </sf:form>
        </div>
    </div>
    <jsp:include page="../../../../resources/footer.jsp"/>
</div>
</body>
</html>