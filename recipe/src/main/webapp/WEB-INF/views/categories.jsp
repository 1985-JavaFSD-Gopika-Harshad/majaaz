<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
    <h2>Categories</h2>
    <a href="${pageContext.request.contextPath}/categories/create">Add New Category</a>
    <table border="1">
        <tr>
            <th>Category ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/categories/edit/${category.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/categories/delete/${category.id}" 
                       onclick="return confirm('Are you sure you want to delete this category?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
