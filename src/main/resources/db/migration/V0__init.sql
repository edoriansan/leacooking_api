create sequence recipe_type_seq;
create sequence ingredient_seq;
create sequence quantity_type_seq;
create sequence recipe_part_seq;
create sequence recipe_seq;

-- Création de la table recipe_type
create table "recipe_type" (
                          id bigint default nextval('recipe_type_seq') primary key,
                          label VARCHAR(255) NOT NULL
);

-- Création de la table quantity_type
create table "quantity_type" (
                           id bigint default nextval('quantity_type_seq') primary key,
                           label VARCHAR(255)
);

-- Création de la table ingredient
create table "ingredient" (
                              id bigint default nextval('ingredient_seq') primary key,
                              label VARCHAR(255) NOT NULL,
                              id_quantity_type BIGINT REFERENCES quantity_type
);

-- Création de la table recipe_part
create table "recipe_part" (
                          id bigint default nextval('recipe_part_seq') primary key,
                          label VARCHAR(255) NOT NULL
);

-- Création de la table recipe
create table "recipe" (
                         id bigint default nextval('recipe_seq') primary key,
                         title VARCHAR(255) NOT NULL,
                         process VARCHAR(255) NOT NULL,
                         persons INT,
                         image_url VARCHAR(255),
                         id_recipe_type BIGINT REFERENCES recipe_type
);

-- Création de la table recipe_ingredient (table de jointure)
create table "recipe_ingredient" (
                                    id_recipe BIGINT REFERENCES recipe,
                                    id_ingredient BIGINT REFERENCES ingredient,
                                    ingredient_quantity INT NOT NULL,
                                    id_recipe_part BIGINT REFERENCES recipe_part,
                                    PRIMARY KEY (id_recipe, id_ingredient, id_recipe_part)
);

create index index_recipe__recipe_type on recipe (id_recipe_type);
create index index_ingredient__quantity_type on ingredient (id_quantity_type);

create index index_recipe_ingredient__recipe on recipe_ingredient (id_recipe);
create index index_recipe_ingredient__ingredient on recipe_ingredient (id_ingredient);
create index index_recipe_ingredient__recipe_part on recipe_ingredient (id_recipe_part);


