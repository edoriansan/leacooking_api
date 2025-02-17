INSERT INTO recipe_category (label) VALUES ('Salée'), ('Sucrée');

INSERT INTO recipe_subcategory (label, id_recipe_category)
VALUES ('Pizza', 1), ('Viande', 1), ('Poisson', 1), ('Entremet', 2), ('Tarte', 2), ('Confiserie', 2);

INSERT INTO quantity_type (label) VALUES ('Grammes'), ('Litres'), ('Pièces');

INSERT INTO ingredient (label, id_quantity_type) VALUES
                                                     ('Farine', 1),
                                                     ('Eau', 2),
                                                     ('Tomates', 3),
                                                     ('Mozzarella', 3),
                                                     ('Levure', 1);

-- Insertion d'une recette
INSERT INTO recipe (title, persons, image_url, id_recipe_subcategory)
VALUES
    ('Pizza Margherita', 4, 'http://example.com/pizza.jpg', 1);

-- Insertion des parties de la recette "Pizza Margherita"
INSERT INTO recipe_part (recipe_part_title, process, id_recipe) VALUES
                                                                    ('Pâte', 'Préparer la pâte', 1),
                                                                    ('Garniture', 'Garnir la pâte', 1),
                                                                    ('Cuisson', 'Cuire la pizza', 1);

-- Insertion des ingrédients pour les parties de la recette
INSERT INTO recipe_part_ingredient (id_recipe_part, id_ingredient, quantity)
VALUES
    (1, 1, 500),
    (1, 2, 300),
    (1, 5, 1),
    (2, 3, 2),
    (2, 4, 100);
