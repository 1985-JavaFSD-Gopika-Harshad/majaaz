<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            background-color: #f4f4f4;
        }
        .recipe-image {
            width: 100%;
            height: 200px;
            object-fit: contain;
            padding: 10px;
            background-color: #f8f9fa;
        }
        .recipe-item {
            margin-bottom: 20px;
        }
        .order-container {
            display: none; /* Hidden by default */
            margin-top: 20px;
        }
    </style>
</head>
<body>
  

    <!-- Main content -->
    <div class="container mt-4">
        <!-- Recipe Grid -->
        <div class="row" id="recipeGrid">
            <c:set var="searchQuery" value="${param.search}"/> <!-- Capture search query -->
            <c:forEach var="recipe" items="${recipes}">
                <c:if test="${empty searchQuery || fn:containsIgnoreCase(recipe.name, searchQuery) || fn:containsIgnoreCase(recipe.ingredients, searchQuery)}">
                    <div class="col-md-4 mb-4 recipe-item">
                        <div class="card">
                            <img class="card-img-top recipe-image" src="${recipe.imageUrl}" alt="Recipe Image">
                            <div class="card-body">
                                <h5 class="card-title">${recipe.name}</h5>
                                <p class="card-text">${recipe.description}</p>
                                <p class="card-text"><strong>Preparation Time:</strong> ${recipe.preparationTime} mins</p>

                                <!-- Buttons side by side -->
                                <div class="d-flex justify-content-start">
                                    <button class="btn btn-info mr-2" 
                                            onclick="viewRecipe('${recipe.id}')">
                                        View Recipe
                                    </button>
                                    <button class="btn btn-warning mr-2" 
                                            onclick="addToFavorites('${recipe.id}', '${recipe.name}')">
                                        Add to Favorites
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <!-- Recipe Modal -->
        <div class="modal fade" id="recipeModal" tabindex="-1" aria-labelledby="recipeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="recipeModalLabel">Recipe Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span>&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="recipeDetails">
                        <!-- Recipe details will be populated here -->
                    </div>
                </div>
            </div>
        </div>

        <!-- Include Bootstrap JS and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <script>
            function viewRecipe(recipeId) {
                // Fetch recipe details based on recipeId
                fetch(`http://localhost:9000/api/recipe/${recipeId}`)
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok ' + response.statusText);
                        }
                        return response.json();
                    })
                    .then(recipe => {
                        document.getElementById('recipeDetails').innerHTML = `
                            <h5>${recipe.name}</h5>
                            <img src="${recipe.imageUrl}" alt="Recipe Image" class="img-fluid">
                            <p>${recipe.description}</p>
                            <p><strong>Ingredients:</strong> ${recipe.ingredients}</p>
                            <p><strong>Instructions:</strong> ${recipe.instructions}</p>
                        `;
                        $('#recipeModal').modal('show'); // Show the modal
                    })
                    .catch(error => {
                        console.error('Error fetching recipe details:', error);
                    });
            }

            function addToFavorites(recipeId, recipeName) {
                // Logic to add the recipe to favorites
                console.log(`Adding recipe to favorites: ${recipeId} - ${recipeName}`);
                // Implement the API call to add the recipe to favorites here
            }
        </script>

      
    </div>
</body>
</html>
