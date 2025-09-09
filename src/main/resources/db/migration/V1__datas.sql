-- Insertion des catégories
INSERT INTO recipe_category(id, label, img) VALUES
    (1, 'Salé', 'https://img.cuisineaz.com/660x660/2016/07/29/i84653-spaghettis-bolognaise-rapides.jpg'),
    (2, 'Sucré', 'https://img-3.journaldesfemmes.fr/H0qYPxS9uCGiAxcOYPriAyleulw=/750x500/3e880207483541898952bc7c3491b00b/ccmcms-jdf/39903996.jpg');

-- Insertion des sous-catégories
INSERT INTO recipe_subcategory (label, img, id_recipe_category) VALUES
    ('Apéritif', 'apero.jpg', 1),
    ('Végétarien', 'vegetariennes.jpg', 1),
    ('Pâtes', 'pates.jpg', 1),
    ('Viande', 'viande.jpg', 1),
    ('Poisson', 'poisson.jpg', 1),
    ('Pizza', 'pizza.jpg', 1),
    ('Sandwich', 'sandwich.jpg', 1),
    ('Asiatique', 'asiatiques.jpg', 1),
    ('Bases', 'base_sale.jpg', 1),
    ('Sauces', 'sauces.jpg', 1),
    ('Goûters', 'gouters.jpg', 2),
    ('Anniversaire', 'anniversaire.jpg', 2),
    ('Cheesecakes', 'cheesecakes.jpg', 2),
    ('Individuels', 'individuels.jpg', 2),
    ('Petit déjeuner', 'petit_dejeuner.jpg', 2),
    ('Confiseries', 'confiseries.jpg', 2),
    ('Bases', 'bases_sucre.jpg', 2),
    ('PRO', 'recettes_pro.jpg', 2),
    ('CAP', 'cap.jpg', 2);

-- Insertion des ingrédients
INSERT INTO ingredient (label) VALUES
    ('Échalote'),
    ('Beurre'),
    ('Beurre ramolli'),
    ('Butternut'),
    ('Crème liquide'),
    ('Sel'),
    ('Poivre'),
    ('Huile d''olive'),
    ('Paprika'),
    ('Miel'),
    ('Lait'),
    ('Œufs'),
    ('Œuf'),
    ('Farine'),
    ('Gruyère râpé'),
    ('Courgette'),
    ('Tomates cerises'),
    ('Mozzarella'),
    ('Pâte feuilletée'),
    ('Aubergine'),
    ('Oignon'),
    ('Poivron'),
    ('Feta'),
    ('Herbes de Provence'),
    ('Lardons'),
    ('Parmesan'),
    ('Origan'),
    ('Thym'),
    ('Feuilles de menthe'),
    ('Poivron rouge'),
    ('Yaourt grec'),
    ('Citron vert'),
    ('Ail'),
    ('Olives vertes'),
    ('Fromage râpé'),
    ('Pâte à tarte'),
    ('Pesto'),
    ('Riz Arborio'),
    ('Bouillon'),
    ('Vin blanc'),
    ('Parmesan râpé'),
    ('Champignons'),
    ('Purée de patate douce'),
    ('Levure chimique'),
    ('Tranches de saumon fumé'),
    ('Ciboulette'),
    ('Citron'),
    ('épinards frais'),
    ('Pommes de terre'),
    ('Comté'),
    ('Lentilles vertes'),
    ('Carottes'),
    ('Lait de coco'),
    ('Cumin'),
    ('Garam masala'),
    ('Gingembre en poudre'),
    ('Curry'),
    ('Concentré de tomates');

-- Insertion des recettes apéro
INSERT INTO recipe (title, parts, img, id_recipe_subcategory, description) VALUES
    ('Cake salé lardons & olives',6,'cake_sale.jpg',(SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),'Préchauffer le four à 180°. Découper les olives en 2 et faire cuire les lardons au micro-onde. Dans un saladier, fouetter les œufs, la farine, la levure, le sel et le poivre. Incorporer petit à petit l’huile et le lait préalablement chauffé. Ajouter le gruyère râpé et mélanger. Enfin, incorporer les olives et les lardons. Bien mélanger. Verser le tout dans un moule et faire cuire pendant 40 minutes.'),
    ('Cookies salés',4,'cookies_sales.jpg',(SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),'Mélanger le beurre et le parmesan. Ajouter la farine, l’huile d’olive, l’œuf et les épices. Pétrir jusqu’à obtenir un mélange homogène. Incorporer les lardons. Former des boules et les faire cuire 15 minutes à 180 degrés.'),
    ('Ktipiti',4,'ktipiti.jpg',(SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),'Faire cuire les poivrons coupés en deux et la gousse d’ail 25 minutes à 200 degrés. Les laisser 20 minutes supplémentaires dans le four éteint pour que la peau se retire facilement. Une fois épluchés et refroidis, les placer dans le blender avec tous les autres ingrédients et mixer. Mettre la préparation au frais au moins 1 heure avant de servir.');

-- Insertion des ingrédients par recette
INSERT INTO recipe_ingredient (id_recipe, id_ingredient, quantity) VALUES
    (1, (SELECT id FROM ingredient WHERE label = 'Farine'), '200g'),
    (1, (SELECT id FROM ingredient WHERE label = 'Œufs'), '3'),
    (1, (SELECT id FROM ingredient WHERE label = 'Lait'), '10cl'),
    (1, (SELECT id FROM ingredient WHERE label = 'Huile d''olive'), '8cl'),
    (1, (SELECT id FROM ingredient WHERE label = 'Lardons'), '100g'),
    (1, (SELECT id FROM ingredient WHERE label = 'Olives vertes'), '60g'),
    (1, (SELECT id FROM ingredient WHERE label = 'Gruyère râpé'), '100g');

INSERT INTO recipe_ingredient (id_recipe, id_ingredient, quantity) VALUES
    (2, (SELECT id FROM ingredient WHERE label = 'Farine'), '150g'),
    (2, (SELECT id FROM ingredient WHERE label = 'Beurre ramolli'), '100g'),
    (2, (SELECT id FROM ingredient WHERE label = 'Fromage râpé'), '100g'),
    (2, (SELECT id FROM ingredient WHERE label = 'Œuf'), '1'),
    (2, (SELECT id FROM ingredient WHERE label = 'Paprika'), '1 c. à café'),
    (2, (SELECT id FROM ingredient WHERE label = 'Sel'), '1 pincée');

INSERT INTO recipe_ingredient (id_recipe, id_ingredient, quantity) VALUES
    (3, (SELECT id FROM ingredient WHERE label = 'Feta'), '200g'),
    (3, (SELECT id FROM ingredient WHERE label = 'Yaourt grec'), '100g'),
    (3, (SELECT id FROM ingredient WHERE label = 'Poivron rouge'), '1'),
    (3, (SELECT id FROM ingredient WHERE label = 'Ail'), '1 gousse'),
    (3, (SELECT id FROM ingredient WHERE label = 'Huile d''olive'), '2 c. à soupe'),
    (3, (SELECT id FROM ingredient WHERE label = 'Citron vert'), 'Jus d''un demi citron'),
    (3, (SELECT id FROM ingredient WHERE label = 'Paprika'), '1 pincée');

-- Recettes pour la sous-catégorie Végétarien
INSERT INTO recipe(title, parts, description, img, id_recipe_subcategory) VALUES
    ('Tarte fine', NULL, 'Couper les tomates cerises en deux et les courgettes en rondelles. Etaler le pesto sur la pâte puis placer les légumes. Parsemer d’herbes de Provence. Enfourner à 180°C pendant 25 minutes.', NULL, 2),
    ('Risotto', 2, 'Faire revenir le riz dans un peu d’huile d’olive jusqu’à ce qu’il soit translucide. Ajouter progressivement le bouillon. Faire revenir les oignons et champignons séparément. Ajouter parmesan, champignons et olives à la fin.', NULL, 2),
    ('Gaufres de patate douce', NULL, 'Mélanger la purée et les œufs battus. Ajouter farine et levure. Cuire dans le gaufrier. Garnir avec yaourt, citron, ciboulette, saumon fumé et œuf mollet.', NULL, 2),
    ('Gaufres de l’espace', 4, 'Mélanger épinards, farine, levure, lait et œuf. Cuire dans le gaufrier.', NULL, 2),
    ('Pancakes de pomme de terre', NULL, 'Faire bouillir les pommes de terre, réduire en purée. Ajouter farine, former des boules avec un cube de fromage au centre. Cuire comme pancakes.', NULL, 2),
    ('Dahl', 2, 'Faire revenir oignon, ail, carotte et épices. Ajouter lentilles et lait de coco. Mijoter 30 min en rajoutant de l’eau si nécessaire.', NULL, 2),
    ('Carottes pesto', 2, 'Cuire les carottes à l’eau puis ajouter le pesto. Servir avec du riz.', NULL, 2);

-- Tarte fine
INSERT INTO recipe_ingredient(id_recipe, id_ingredient, quantity) VALUES
    ((SELECT id FROM recipe WHERE title='Tarte fine'), (SELECT id FROM ingredient WHERE label='Pâte à tarte'), '1 pâte'),
    ((SELECT id FROM recipe WHERE title='Tarte fine'), (SELECT id FROM ingredient WHERE label='Pesto'), '3 cuillères à soupe'),
    ((SELECT id FROM recipe WHERE title='Tarte fine'), (SELECT id FROM ingredient WHERE label='Tomates cerises'), '1 barquette'),
    ((SELECT id FROM recipe WHERE title='Tarte fine'), (SELECT id FROM ingredient WHERE label='Courgette'), '1 grosse'),
    ((SELECT id FROM recipe WHERE title='Tarte fine'), (SELECT id FROM ingredient WHERE label='Herbes de Provence'), 'QS');

-- Risotto
INSERT INTO recipe_ingredient(id_recipe, id_ingredient, quantity) VALUES
    ((SELECT id FROM recipe WHERE title='Risotto'), (SELECT id FROM ingredient WHERE label='Riz Arborio'), '200g'),
    ((SELECT id FROM recipe WHERE title='Risotto'), (SELECT id FROM ingredient WHERE label='Oignon'), '1'),
    ((SELECT id FROM recipe WHERE title='Risotto'), (SELECT id FROM ingredient WHERE label='Bouillon'), '1L'),
    ((SELECT id FROM recipe WHERE title='Risotto'), (SELECT id FROM ingredient WHERE label='vin blanc'), '10cL'),
    ((SELECT id FROM recipe WHERE title='Risotto'), (SELECT id FROM ingredient WHERE label='parmesan râpé'), '50g'),
    ((SELECT id FROM recipe WHERE title='Risotto'), (SELECT id FROM ingredient WHERE label='olives vertes'), 'QS'),
    ((SELECT id FROM recipe WHERE title='Risotto'), (SELECT id FROM ingredient WHERE label='champignons'), 'QS');

-- Gaufres de patate douce
INSERT INTO recipe_ingredient(id_recipe, id_ingredient, quantity) VALUES
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='purée de patate douce'), '420g'),
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='farine'), '100g'),
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='levure chimique'), '6g'),
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='œufs'), '2'),
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='yaourt grec'), '150g'),
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='tranches de saumon fumé'), 'QS'),
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='œufs'), '1 par personne'),
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='ciboulette'), 'QS'),
    ((SELECT id FROM recipe WHERE title='Gaufres de patate douce'), (SELECT id FROM ingredient WHERE label='citron'), '1');

-- Gaufres de l’espace
INSERT INTO recipe_ingredient(id_recipe, id_ingredient, quantity) VALUES
    ((SELECT id FROM recipe WHERE title='Gaufres de l’espace'), (SELECT id FROM ingredient WHERE label='épinards frais'), '200g'),
    ((SELECT id FROM recipe WHERE title='Gaufres de l’espace'), (SELECT id FROM ingredient WHERE label='farine'), '200g'),
    ((SELECT id FROM recipe WHERE title='Gaufres de l’espace'), (SELECT id FROM ingredient WHERE label='levure chimique'), '1 sachet'),
    ((SELECT id FROM recipe WHERE title='Gaufres de l’espace'), (SELECT id FROM ingredient WHERE label='lait'), '200ml'),
    ((SELECT id FROM recipe WHERE title='Gaufres de l’espace'), (SELECT id FROM ingredient WHERE label='œufs'), '1');

-- Pancakes de pomme de terre
INSERT INTO recipe_ingredient(id_recipe, id_ingredient, quantity) VALUES
    ((SELECT id FROM recipe WHERE title='Pancakes de pomme de terre'), (SELECT id FROM ingredient WHERE label='pommes de terre'), '4 moyennes'),
    ((SELECT id FROM recipe WHERE title='Pancakes de pomme de terre'), (SELECT id FROM ingredient WHERE label='farine'), '3 cuillères à soupe'),
    ((SELECT id FROM recipe WHERE title='Pancakes de pomme de terre'), (SELECT id FROM ingredient WHERE label='comté'), '1 morceau');

-- Dahl
INSERT INTO recipe_ingredient(id_recipe, id_ingredient, quantity) VALUES
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='lentilles vertes'), '100g'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Carottes'), '1 ou 2'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Oignon'), '1'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Ail'), '1 gousse'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Lait de coco'), '1 brique'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Cumin'), '1 cuillère à café'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Garam masala'), '1 cuillère à café'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Gingembre en poudre'), '½ cuillère à café'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Curry'), '1 cuillère à café'),
    ((SELECT id FROM recipe WHERE title='Dahl'), (SELECT id FROM ingredient WHERE label='Concentré de tomates'), '1 cuillère à soupe');

-- Carottes pesto
INSERT INTO recipe_ingredient(id_recipe, id_ingredient, quantity) VALUES
    ((SELECT id FROM recipe WHERE title='Carottes pesto'), (SELECT id FROM ingredient WHERE label='Carottes'), '5 ou 6'),
    ((SELECT id FROM recipe WHERE title='Carottes pesto'), (SELECT id FROM ingredient WHERE label='Pesto'), '½ pot');
