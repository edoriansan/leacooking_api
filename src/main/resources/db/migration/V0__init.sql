create sequence recipe_category_seq;
create sequence recipe_subcategory_seq;
create sequence ingredient_seq;
create sequence quantity_type_seq;
create sequence recipe_part_seq;
create sequence recipe_seq;
create sequence recipe_part_ingredient_seq;

create table "recipe_category" (
                                      id bigint default nextval('recipe_category_seq') primary key,
                                      label VARCHAR(255) NOT NULL,
                                      img VARCHAR(255) NOT NULL
);

create table "recipe_subcategory" (
                               id bigint default nextval('recipe_subcategory_seq') primary key,
                               label VARCHAR(255) NOT NULL,
                               img VARCHAR(255) NOT NULL,
                               id_recipe_category BIGINT REFERENCES recipe_category
);

create table "quantity_type" (
                                 id bigint default nextval('quantity_type_seq') primary key,
                                 label VARCHAR(255)
);

create table "ingredient" (
                              id bigint default nextval('ingredient_seq') primary key,
                              label VARCHAR(255) NOT NULL,
                              id_quantity_type BIGINT REFERENCES quantity_type
);

create table "recipe" (
                          id bigint default nextval('recipe_seq') primary key,
                          title VARCHAR(255) NOT NULL,
                          persons INT,
                          img VARCHAR(255) NOT NULL,
                          id_recipe_subcategory BIGINT REFERENCES recipe_subcategory
);

create table "recipe_part" (
                               id bigint default nextval('recipe_part_seq') primary key,
                               recipe_part_title VARCHAR(255),
                               recipe_part_process VARCHAR(255) NOT NULL,
                               id_recipe BIGINT REFERENCES recipe ON DELETE CASCADE
);

create table "recipe_part_ingredient" (
                                          id bigint default nextval('recipe_part_ingredient_seq') primary key,
                                          id_recipe_part BIGINT REFERENCES recipe_part ON DELETE CASCADE,
                                          id_ingredient BIGINT REFERENCES ingredient,
                                          quantity INT NOT NULL
);

create index index_recipe_category__recipe_subcategory on recipe_subcategory (id_recipe_category);
create index index_recipe__recipe_subcategory on recipe (id_recipe_subcategory);
create index index_ingredient__quantity_type on ingredient (id_quantity_type);
create index index_recipe_part__recipe on recipe_part (id_recipe);
create index index_recipe_part_ingredient__recipe_part on recipe_part_ingredient (id_recipe_part);
create index index_recipe_part_ingredient__ingredient on recipe_part_ingredient (id_ingredient);
