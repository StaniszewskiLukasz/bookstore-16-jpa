insert into categories(name,code) values ('Crime','CRIME');
insert into categories(name,code) values ('Fantasy','FANTASY');
insert into categories(name,code) values ('Horror','HORROR');

insert into addresses(city,zip_code,street,street_no,home_no) values ('Warszawa','56-345','Pomorska','12B','1');
insert into addresses(city,zip_code,street,street_no,home_no) values ('Warszawa','56-345','Pomorska','110C','12');
insert into addresses(city,zip_code,street,street_no,home_no) values ('Warszawa','56-345','Pomorska','23','41');

insert into addresses(city,zip_code,street,street_no,home_no) values ('Lublin','78-412',' Leśna','76','45');
insert into addresses(city,zip_code,street,street_no,home_no) values ('Lublin','78-412','Leśna','21','32');


insert into publishers(name,email,phone_number,address_id) values ('Wydawnictwo 1','wyd1@gmail.com',500500500,1)
insert into publishers(name,email,phone_number,address_id) values ('Wydawnictwo 2','wyd2@poczta.pl',500500501,2)

insert into authors(first_name,last_name,date_of_birth,sex) values ('Andrzej','Sapkowski','1948-06-21','M');
insert into authors(first_name,last_name,date_of_birth,sex) values ('Stephen','King','1947-09-21','M');
insert into authors(first_name,last_name,date_of_birth,sex) values ('Camila','Lackberg','1974-09-30','F');
insert into authors(first_name,last_name,date_of_birth,sex) values ('Jan','Kowalski','1984-09-30','M');


insert into books(title,pages_number,isbn,category_id,publisher_id) values ('Kaznodzieja',440,8788375545067,1,1);
insert into books(title,pages_number,isbn,category_id,publisher_id) values ('Kamieniarz',536,9788375545074,1,1);

insert into books(title,pages_number,isbn,category_id,publisher_id) values ('Miasteczko Salem',311,5823459248522,3,2);
insert into books(title,pages_number,isbn,category_id,publisher_id) values ('To',1104,9788365781628,3,1);

insert into books(title,pages_number,isbn,category_id,publisher_id) values ('Czas pogardy',368,9788375780666,2,2);
insert into books(title,pages_number,isbn,category_id,publisher_id) values ('Chrzest ognia',382,9788375780673,2,2);

insert into books_authors(book_id,author_id) values (1,3);
insert into books_authors(book_id,author_id) values (2,3);

insert into books_authors(book_id,author_id) values (3,2);
insert into books_authors(book_id,author_id) values (4,2);

insert into books_authors(book_id,author_id) values (5,1);
insert into books_authors(book_id,author_id) values (6,1);