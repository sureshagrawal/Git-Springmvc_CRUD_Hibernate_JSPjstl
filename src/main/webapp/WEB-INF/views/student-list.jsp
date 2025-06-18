<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>NSG Academy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
</head>
<body>
<div class="container my-5">
    <h1 class="text-center">CRUD MVC APPLICATION</h1>
    <h3 class="text-center">Using Spring, Hibernate(JPA) AND JSP(JSTL+EL)</h3>

    <a href="students/new" class="btn btn-primary mb-5">
        <i class="fa-solid fa-user-plus m-1"></i>Add Student
    </a>

    <c:if test="${not empty param.success}">
        <div class="alert alert-success text-center">${param.success}</div>
    </c:if>

    <table class="table table-hover table-striped">
        <thead class="bg-dark text-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Contact</th>
            <th scope="col">Operations</th>
        </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty students}">
                <c:forEach var="student" items="${students}" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index + 1}</th>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>${student.mobile}</td>
                        <td>
                            <a href="students/edit?id=${student.id}" class="btn btn-info">
                                <i class="fa-solid fa-pen-to-square mx-1"></i>Update
                            </a>
                            <a href="students/delete?id=${student.id}" class="btn btn-danger" onclick="return confirm('Are you sure to delete?');">
                                <i class="fa-solid fa-trash-can mx-1"></i>Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5" class="text-center">No students found.</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>