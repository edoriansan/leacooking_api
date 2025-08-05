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
INSERT INTO recipe (title, parts, img, id_recipe_subcategory, description)
VALUES
    (
        'Cake salé lardons & olives',
        6,
        'cake_sale.jpg',
        (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),
        'Un délicieux cake salé moelleux, garni de lardons, d''olives vertes et de gruyère râpé. Parfait pour un apéritif ou un pique-nique.'
    ),
    (
        'Cookies salés',
        4,
        'cookies_sales.jpg',
        (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),
        'Des petits biscuits salés au fromage râpé et aux épices, croustillants à l’extérieur et fondants à l’intérieur. À servir tièdes pour l''apéritif.'
    ),
    (
        'Ktipiti',
        4,
        'ktipiti.jpg',
        (SELECT id FROM recipe_subcategory WHERE label = 'Apéritif'),
        'Tartinade grecque onctueuse à base de feta, poivron rôti, yaourt grec, ail et huile d''olive. À déguster avec du pain pita grillé.'
    );

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