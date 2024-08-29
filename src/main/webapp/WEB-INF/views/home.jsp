<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="<c:url value="resources/style.css"/>" rel="stylesheet"/>   
    
    </head>
    <body>
    <header>
        <h1>CRUD Application</h1>
        <nav>
            <ul>
                <li><a href="addEmp">Add New Employee</a></li>
                <li><a href="viewEmp">View All Employees</a></li>
            </ul>
        </nav>
    </header>
    </body>
</html>
