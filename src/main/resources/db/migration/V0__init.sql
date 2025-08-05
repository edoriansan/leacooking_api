create sequence recipe_category_seq;
create sequence recipe_subcategory_seq;
create sequence ingredient_seq;
create sequence recipe_seq;
create sequence recipe_ingredient_seq;

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

create table "ingredient" (
                              id bigint default nextval('ingredient_seq') primary key,
                              label VARCHAR(255) NOT NULL
);

create table "recipe" (
                          id bigint default nextval('recipe_seq') primary key,
                          title VARCHAR(255) NOT NULL,
                          parts INT,
                          description VARCHAR(255),
                          img VARCHAR(255) NOT NULL,
                          id_recipe_subcategory BIGINT REFERENCES recipe_subcategory
);

create table "recipe_ingredient" (
                          id bigint default nextval('recipe_ingredient_seq') primary key,
                          id_recipe BIGINT REFERENCES recipe ON DELETE CASCADE,
                          id_ingredient BIGINT REFERENCES ingredient,
                          quantity VARCHAR(255)
);

create index index_recipe_category__recipe_subcategory on recipe_subcategory (id_recipe_category);
create index index_recipe__recipe_subcategory on recipe (id_recipe_subcategory);
create index index_recipe_ingredient__recipe on recipe_ingredient (id_recipe);
create index index_recipe_ingredient__ingredient on recipe_ingredient (id_ingredient);
