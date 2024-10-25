<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Reviews</title>
</head>
<body>
    <h2>Reviews</h2>
    <a href="${pageContext.request.contextPath}/reviews/create">Add New Review</a>
    <table border="1">
        <tr>
            <th>Review ID</th>
            <th>Recipe</th>
            <th>Comment</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="review" items="${reviews}">
            <tr>
                <td>${review.id}</td>
                <td>${review.recipe.name}</td>
                <td>${review.comment}</td>
                <td>${review.rating}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/reviews/edit/${review.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/reviews/delete/${review.id}" 
                       onclick="return confirm('Are you sure you want to delete this review?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
