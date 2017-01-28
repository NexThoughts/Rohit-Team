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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create </title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/bootstrap.min.css" />">
    <%--<style>
        #footer {
            position:absolute;
            bottom:0;
            width:100%;
            height:60px;   /* Height of the footer */
            background:#5cb85c;
        }

        /*span.error {
            background-color: #ffcccc;
            border: 2px solid red;
        }*/
    </style>--%>
    <title>Create</title>
</head>
<body>
<div class="container-fluid">

    <header>
        <jsp:include page="layout/header.jsp"/>
    </header>

    <div class="row">
    <%--<%@ include file="layout/main.jsp"%>--%>
    <div class="col-lg-6 col-lg-offset-3">
        <form method="post">
            <div class="col-lg-6 col-lg-offset-3">
                <div class="form-group">
                    <label for="exampleInputEmail1">Name</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Name">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">Mail</label>
                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Mail">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword3">Address</label>
                    <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Mail">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword4">Mail</label>
                    <input type="password" class="form-control" id="exampleInputPassword4" placeholder="Mail">
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="pull-left">
                            <input type="submit" value="Create" class="btn btn-success ">
                        </div>
                    </div>
                </div>
            </div>

        </form>
    </div>
</div>

    <footer>
    <jsp:include page="layout/footer.jsp"/>
    </footer>
    </div>
</body>
</html>
