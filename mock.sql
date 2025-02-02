-- Insertion des types de recettes
INSERT INTO recipe_type (label) VALUES ('Salée'), ('Sucrée');

-- Insertion des types de quantités
INSERT INTO quantity_type (label) VALUES ('Grammes'), ('Litres'), ('Pièces');

-- Insertion des ingrédients
INSERT INTO ingredient (label, id_quantity_type) VALUES
                                                     ('Farine', 1),
                                                     ('Eau', 2),
                                                     ('Tomates', 3),
                                                     ('Mozzarella', 3),
                                                     ('Levure', 1);

-- Insertion d'une recette
INSERT INTO recipe (title, process, persons, image_url, id_recipe_type)
VALUES
    ('Pizza Margherita', 'Préparer la pâte, ajouter la garniture, et cuire.', 4, 'http://example.com/pizza.jpg', 1);

-- Insertion des parties de la recette "Pizza Margherita"
INSERT INTO recipe_part (label, id_recipe) VALUES
                                               ('Pâte', 1),
                                               ('Garniture', 1);

-- Insertion des ingrédients pour les parties de la recette
INSERT INTO recipe_part_ingredient (id_recipe_part, id_ingredient, quantity)
VALUES
    (1, 1, 500),
    (1, 2, 300),
    (1, 5, 1),
    (2, 3, 2),
    (2, 4, 100);
