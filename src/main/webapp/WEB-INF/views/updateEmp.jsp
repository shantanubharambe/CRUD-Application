<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href='<c:url value="resources/addEmp.css"/>' rel="stylesheet" />
</head>
<body class="bodyadd">
<jsp:include page="home.jsp"></jsp:include>
   <div class="form-container">
        <h2 class="form-title">Update Employee</h2>
        <form action="frmupdsbt" method="post" id="employee-form">
          <input type="hidden" id="id" name="id" value="${id}" required>
            <div class="input-wrapper">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${name}" required>
            </div>
            <div class="input-wrapper">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${email}" required>
            </div>
            <div class="input-wrapper">
                <label for="contact">Contact:</label>
                <input type="tel" id="contact" name="contact" value="${contact}" required>
            </div>
            <button type="submit" class="submit-btn">Update Employee</button>
        </form>
         <c:if test="${msg == 'Update failed'}">
            ${del}
        </c:if>
    </div>
</body>
</html>