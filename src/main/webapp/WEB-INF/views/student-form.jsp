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
</head>
<body>
<div class="container my-5">
        <h1 class="text-center">CRUD MVC APPLICATION</h1>
        <h3 class="text-center">Using Spring, Hibernate(JPA) AND JSP(JSTL+EL)</h3>

        <c:set var="isEdit" value="${not empty student}" />

        <h2>
            <c:choose>
                <c:when test="${isEdit}">Edit Student</c:when>
                <c:otherwise>Add New Student</c:otherwise>
            </c:choose>
        </h2>

        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>


        <form action="${isEdit ? 'update' : 'insert'}" method="POST">

            <c:if test="${isEdit}">
                <input type="hidden" name="id" value="${student.id}" />
            </c:if>

            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" class="form-control" placeholder="Enter your name" name="name"
                       value="${student.name}" id="stnameid" required
                       pattern="[A-Za-z\s]+" title="Name should contain only letters and spaces.">
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" placeholder="Enter your Email" name="email"
                       value="${student.email}" id="stemailid" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Mobile</label>
                <input type="text" class="form-control" placeholder="Enter your Mobile" name="mobile"
                       value="${student.mobile}" id="stmobileid" required
                       pattern="\d{10}" title="Mobile number should be 10 digits.">
            </div>

            <button type="submit" class="btn btn-primary" name="submit">Submit</button>
            <button type="reset" class="btn btn-dark">Reset</button>
        </form>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
