create table if not exists tbl_regions
(
    id   INTEGER not null,
    name VARCHAR not null
);
INSERT INTO tbl_regions (id, name) VALUES (1, 'Sudamérica');
INSERT INTO tbl_regions (id, name) VALUES (2, 'Centroamérica');
INSERT INTO tbl_regions (id, name) VALUES (3, 'Norteamérica');
INSERT INTO tbl_regions (id, name) VALUES (4, 'Europa');
INSERT INTO tbl_regions (id, name) VALUES (5, 'Asia');
INSERT INTO tbl_regions (id, name) VALUES (6, 'Africa');
INSERT INTO tbl_regions (id, name) VALUES (7, 'Oceanía');
INSERT INTO tbl_regions (id, name) VALUES (8, 'Antártida');

create table tbl_customers
(
    id          INTEGER not null,
    number_id        VARCHAR not null,
    first_name VARCHAR not null,
    last_name       VARCHAR not null,
    email       VARCHAR not null,
    photo_url      VARCHAR not null,
    region_id   INTEGER not null,
    state VARCHAR not null
);
INSERT INTO tbl_customers (id,number_id,first_name,last_name , email, photo_url, region_id, state) VALUES(1,'32404580', 'Andrés', 'Guzmán', 'profesor@bolsadeideas.com','',1,'CREATED');
