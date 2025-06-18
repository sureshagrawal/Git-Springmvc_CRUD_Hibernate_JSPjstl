<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5 text-center">
        <h1 class="text-danger">Something Went Wrong</h1>
        <p class="lead">
            <c:choose>
                <c:when test="${not empty pageContext.exception}">
                    ${pageContext.exception.message}
                </c:when>
                <c:when test="${not empty errorMessage}">
                    ${errorMessage}
                </c:when>
                <c:otherwise>
                    An internal error occurred. Please try again later or contact support.
                </c:otherwise>
            </c:choose>
        </p>
        <a href="home" class="btn btn-primary">Go Back</a>
    </div>
</body>
</html>
