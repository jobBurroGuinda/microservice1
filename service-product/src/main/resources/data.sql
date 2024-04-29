/*create table tbl_categories
(
    id   INTEGER not null,
    name VARCHAR not null
);
INSERT INTO tbl_categories (id, name) VALUES (1, 'shoes');
INSERT INTO tbl_categories (id, name) VALUES (2, 'books');
INSERT INTO tbl_categories (id, name) VALUES (3, 'electronics');

create table tbl_products
(
    id          INTEGER not null,
    name        VARCHAR not null,
    description VARCHAR not null,
    stock       INTEGER not null,
    price       DECIMAL not null,
    status      VARCHAR not null,
    create_at   VARCHAR not null,
    category_id INTEGER not null
);
INSERT INTO tbl_products (id, name, description, stock,price,status, create_at,category_id)
VALUES (5, 'adidas Cloudfoam Ultimate','Walk in the air in the black / black CLOUDFOAM ULTIMATE running shoe from ADIDAS',5,178.89,'CREATED','2018-09-05',4);

INSERT INTO tbl_products (id, name, description, stock,price,status, create_at,category_id)
VALUES (6, 'under armour Men ''s Micro G Assert – 7','under armour Men ''Lightweight mesh upper delivers complete breathability . Durable leather overlays for stability ',4,12.5,'CREATED','2018-09-05',4);


INSERT INTO tbl_products (id, name, description, stock,price,status, create_at,category_id)
VALUES (7, 'Spring Boot in Action','under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action',12,40.06,'CREATED','2018-09-05',2);
*/