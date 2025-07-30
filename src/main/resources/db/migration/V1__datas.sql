-- Insertion des catégories
INSERT INTO recipe_category(label, img) VALUES
    ('Salé', 'https://img.cuisineaz.com/660x660/2016/07/29/i84653-spaghettis-bolognaise-rapides.jpg'),
    ('Sucré', 'https://img-3.journaldesfemmes.fr/H0qYPxS9uCGiAxcOYPriAyleulw=/750x500/3e880207483541898952bc7c3491b00b/ccmcms-jdf/39903996.jpg');

-- Insertion des sous-catégories
INSERT INTO recipe_subcategory (label, img, id_recipe_category) VALUES
    ('Apéritif', 'apero.jpg', (SELECT id FROM recipe_category WHERE label = 'Salé')),
    ('Végétarien', 'vegetarien.jpg', (SELECT id FROM recipe_category WHERE label = 'Salé'));

-- Insertion des ingrédients
INSERT INTO ingredient (label)
VALUES
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
INSERT INTO recipe (title, persons, img, id_recipe_subcategory)
VALUES
    ('Cake salé lardons & olives', 6, 'cake_sale.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif')),
    ('Cookies salés', 4, 'cookies_sales.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif')),
    ('Ktipiti', 4, 'ktipiti.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif')),
    ('Tarte fine', 2, 'tarte_fine.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Risotto', 2, 'risotto.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Gaufres de patate douce', 4, 'gaufres_patate_douce.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Gaufres de l''espace', 4, 'gaufres_espace.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Pancakes de pomme de terre', 2, 'pancakes_pomme_de_terre.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Dahl', 2, 'dahl.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Carottes pesto', 2, 'carottes_pesto.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Omelette St Moret', 2, 'omelette_st_moret.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Stick de Polenta', 4, 'stick_polenta.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Croques à l''ancienne', 2, 'croques_ancienne.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Falafels', 4, 'falafels.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Galette maïs', 2, 'galette_mais.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Poutine', 2, 'poutine.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Tortilla', 4, 'tortilla.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Galette Quinoa', 2, 'galette_quinoa.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Camembert pané', 2, 'camembert_pane.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Arancini', 4, 'arancini.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Soupe de butternut', 4, 'soupe_butternut.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Maïs Roti', 2, 'mais_roti.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Quiche sans pâte', 4, 'quiche_sans_pate.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Tarte tatin du soleil', 4, 'tarte_tatin_soleil.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien')),
    ('Crumble légumes', 4, 'crumble_legumes.jpg', (SELECT id FROM recipe_subcategory WHERE label = 'Végétarien'));