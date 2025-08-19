-- Insertion des catégories
INSERT INTO recipe_category(label, img) VALUES
    ('Salé', 'https://img.cuisineaz.com/660x660/2016/07/29/i84653-spaghettis-bolognaise-rapides.jpg'),
    ('Sucré', 'https://img-3.journaldesfemmes.fr/H0qYPxS9uCGiAxcOYPriAyleulw=/750x500/3e880207483541898952bc7c3491b00b/ccmcms-jdf/39903996.jpg');

-- Insertion des sous-catégories
INSERT INTO recipe_subcategory (label, img, id_recipe_category) VALUES
    ('Apéro', 'apero.jpg', 1),
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
    ('Crème fraiche épaisse'),
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
    ('Fromage râpé');

-- Insertion des recettes
INSERT INTO recipe (title, parts, img, id_recipe_subcategory, description) VALUES
    (
        'Cake salé lardons & olives',
        6,
        'cake_sale.jpg',
        (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),
        'Préchauffer le four à 180°. Découper les olives en 2 et faire cuire les lardons au micro-onde. Dans un saladier, fouetter les œufs, la farine, la levure, le sel et le poivre. Incorporer petit à petit l’huile et le lait préalablement chauffé. Ajouter le gruyère râpé et mélanger. Enfin, incorporer les olives et les lardons. Bien mélanger. Verser le tout dans un moule et faire cuire pendant 40 minutes.'
    ),
    (
        'Cookies salés',
        4,
        'cookies_sales.jpg',
        (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),
        'Mélanger le beurre et le parmesan. Ajouter la farine, l’huile d’olive, l’œuf et les épices. Pétrir jusqu’à obtenir un mélange homogène. Incorporer les lardons. Former des boules et les faire cuire 15 minutes à 180 degrés.'
    ),
    (
        'Ktipiti',
        4,
        'ktipiti.jpg',
        (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),
        'Faire cuire les poivrons coupés en deux et la gousse d’ail 25 minutes à 200 degrés. Les laisser 20 minutes supplémentaires dans le four éteint pour que la peau se retire facilement. Une fois épluchés et refroidis, les placer dans le blender avec tous les autres ingrédients et mixer. Mettre la préparation au frais au moins 1 heure avant de servir.'
    ),
    ('Tarte fine', NULL, NULL, 'tarte_fine.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Risotto', NULL, NULL, 'risotto.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Gaufres de patate douce', NULL, NULL, 'gaufres_de_patate_douce.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Gaufres de l’espace', NULL, NULL, 'gaufres_de_lespace.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Pancakes de pomme de terre', NULL, NULL, 'pancakes_de_pomme_de_terre.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Dahl', NULL, NULL, 'dahl.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Carottes pesto', NULL, NULL, 'carottes_pesto.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Omelette St Moret', NULL, NULL, 'omelette_st_moret.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Stick de Polenta', NULL, NULL, 'stick_de_polenta.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Croques à l’ancienne', NULL, NULL, 'croques_a_lancienne.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Falafels', NULL, NULL, 'falafels.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Galette maïs', NULL, NULL, 'galette_mais.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Poutine', NULL, NULL, 'poutine.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Tortilla', NULL, NULL, 'tortilla.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Galette Quinoa', NULL, NULL, 'galette_quinoa.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Camembert pané', NULL, NULL, 'camembert_pane.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Arancini', NULL, NULL, 'arancini.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Soupe de butternut', NULL, NULL, 'soupe_de_butternut.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Maïs Roti', NULL, NULL, 'mais_roti.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Quiche sans pâte', NULL, NULL, 'quiche_sans_pate.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Tarte tatin du soleil', NULL, NULL, 'tarte_tatin_du_soleil.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Crumble légumes', NULL, NULL, 'crumble_legumes.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Boulettes végétales', NULL, NULL, 'boulettes_vegetales.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien'));

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