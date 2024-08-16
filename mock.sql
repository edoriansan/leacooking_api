-- Insertion des types de recettes
INSERT INTO recipe_type (label) VALUES ('Salée'), ('Sucrée');

-- Insertion des types de quantités
INSERT INTO quantity_type (label) VALUES ('Grammes'), ('Litres'), ('Pièces');

-- Insertion des parties de recettes
INSERT INTO recipe_part (label) VALUES ('Pâte'), ('Garniture');

-- Insertion des ingrédients
INSERT INTO ingredient (label) VALUES ('Farine'), ('Eau'), ('Tomates'), ('Mozzarella'), ('Levure');

-- Insertion d'une recette
INSERT INTO recipe (title, process, persons, image_url, id_recipe_type)
VALUES ('Pizza Margherita', 'Préparer la pâte, ajouter la garniture, et cuire.', 4, 'http://example.com/pizza.jpg', 1);

-- Insertion des ingrédients pour la recette (Pizza Margherita)
INSERT INTO recipe_ingredient (id_recipe, id_ingredient, ingredient_quantity,id_quantity_type, id_recipe_part)
VALUES
    (1, 1, 500, 1, 1),  -- 500g de farine pour la pâte
    (1, 2, 300, 2, 1),  -- 300ml d'eau pour la pâte
    (1, 5, 1, 3, 1),    -- 1 sachet de levure pour la pâte
    (1, 3, 200, 1, 2),  -- 200g de tomates pour la garniture
    (1, 4, 100, 1, 2);  -- 100g de mozzarella pour la garniture
