<html>
<body>
    <h2>Edit Recipe</h2>
    <form action="/recipes/update/${recipe.id}" method="post">
        Name: <input type="text" name="name" value="${recipe.name}"><br>
        Description: <textarea name="description">${recipe.description}</textarea><br>
        Cuisine: <input type="text" name="cuisine" value="${recipe.cuisine}"><br>
        Meal Type: <input type="text" name="mealType" value="${recipe.mealType}"><br>
        <input type="submit" value="Update Recipe">
    </form>
</body>
</html>
