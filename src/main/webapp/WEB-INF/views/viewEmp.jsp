<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee List</title>
    <link href='<c:url value="resources/viewEmp.css" />' rel="stylesheet" />
    <script src="<c:url value="resources/validate.js" />" type="text/javascript"></script>
   
</head>
<body>
    <jsp:include page="home.jsp"></jsp:include>
     
    <div class="table-container">
     <div class="search-container">
        <input type="text" id="search-bar" placeholder="Search..." onkeyup="search(this.value)">
    </div>
       <div id="d">
        <table>
            <thead>
                <tr>
                    <th class="name-header">Name</th>
                    <th class="email-header">Email</th>
                    <th class="contact-header">Contact</th>
                    <th class="actions-header">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="e" items="${empList}">
                    <tr>
                        <td class="name-cell">${e.getName()}</td>
                        <td class="email-cell">${e.getEmail()}</td>
                        <td class="contact-cell">${e.getContact()}</td>
                        <td class="actions-cell">
                            <a href="updateEmp?id=${e.getId()}&name=${e.getName()}&email=${e.getEmail()}&contact=${e.getContact()}" class="update-link">Update</a>
                            <a href="deleteEmp?id=${e.getId()}" class="delete-link">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
        <c:if test="${del == 'deleted Successfully'}">
            ${del}
        </c:if>

    </div>
</body>
</html>
