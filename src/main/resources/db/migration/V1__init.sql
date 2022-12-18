create table products (
  id    bigserial primary key,
  title varchar(255),
  price decimal
);

insert into products (title, price)
VALUES
('milk', 72),
('bread', 35),
('cheese', 272);