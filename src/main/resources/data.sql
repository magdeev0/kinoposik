INSERT INTO movies VALUES (1, 'США', 136, '/images/movies/matrix.jpg', false, 'Матрица', 'Лана Вачовски, Лилли Вачовски', 1999);
INSERT INTO movies VALUES (2, 'США', 142, '/images/movies/shawshank.jpg', false, 'Побег из Шоушенка', 'Фрэнк Дарабонт', 1994);
INSERT INTO movies VALUES (3, 'США', 165, '/images/movies/django.jpg', false, 'Джанго освобожденный', 'Квентин Тарантино', 2012);
INSERT INTO movies VALUES (4, 'Великобритания', 148, '/images/movies/inception.jpg', false, 'Начало', 'Кристофер Нолан', 2010);
INSERT INTO movies VALUES (5, 'США', 138, '/images/movies/shutter-island.jpg', false, 'Остров проклятых', 'Мартин Скорсезе', 2009);
INSERT INTO movies VALUES (6, 'Россия', 100, '/images/movies/brat.jpg', false, 'Брат', 'Алексей Балабанов', 1997);
INSERT INTO movies VALUES (7, 'Россия', 127, '/images/movies/brat-2.jpg', false, 'Брат 2', 'Алексей Балабанов', 2000);


INSERT INTO actors VALUES (1, 56, '/images/actors/reeves.jpg', false, 'Киану Ривз');
INSERT INTO actors VALUES (2, 59, '/images/actors/fishburne.jpg', false, 'Лоренс Фишбёрн');
INSERT INTO actors VALUES (3, 53, '/images/actors/moss.jpg', false, 'Кэрри-Энн Мосс');
INSERT INTO actors VALUES (4, 60, '/images/actors/weaving.jpg', false, 'Хьюго Уивинг');

INSERT INTO actors VALUES (5, 62, '/images/actors/robbins.jpg', false, 'Тим Роббинс');
INSERT INTO actors VALUES (6, 83, '/images/actors/freeman.jpg', false, 'Морган Фриман');
INSERT INTO actors VALUES (7, 75, '/images/actors/gunton.jpg', false, 'Боб Гантон');
INSERT INTO actors VALUES (8, 70, '/images/actors/sadler.jpg', false, 'Уильям Сэдлер');
INSERT INTO actors VALUES (9, 61, '/images/actors/brown.jpg', false, 'Клэнси Браун');

INSERT INTO actors VALUES (10, 53, '/images/actors/fox.jpg', false, 'Джейми Фокс');
INSERT INTO actors VALUES (11, 64, '/images/actors/waltz.jpg', false, 'Кристоф Вальц');
INSERT INTO actors VALUES (12, 46, '/images/actors/dicaprio.jpg', false, 'Леонардо ДиКаприо');
INSERT INTO actors VALUES (13, 46, '/images/actors/washington.jpg', false, 'Керри Вашингтон');
INSERT INTO actors VALUES (14, 71, '/images/actors/ljackson.jpg', false, 'Сэмюэл Л. Джексон');
INSERT INTO actors VALUES (15, 49, '/images/actors/goggins.jpg', false, 'Уолтон Гоггинс');
INSERT INTO actors VALUES (16, 65, '/images/actors/christopher.jpg', false, 'Деннис Кристофер');

INSERT INTO actors VALUES (17, 39, '/images/actors/levitt.jpg', false, 'Джозеф Гордон-Левитт');
INSERT INTO actors VALUES (18, 33, '/images/actors/page.jpg', false, 'Эллиот Пейдж');
INSERT INTO actors VALUES (19, 43, '/images/actors/hardy.jpg', false, 'Том Харди');
INSERT INTO actors VALUES (20, 61, '/images/actors/watanabe.jpg', false, 'Кэн Ватанабэ');

INSERT INTO actors VALUES (21, 53, '/images/actors/ruffalo.jpg', false, 'Марк Руффало');
INSERT INTO actors VALUES (22, 76, '/images/actors/kingsley.jpg', false, 'Бен Кингсли');
INSERT INTO actors VALUES (23, 90, '/images/actors/sydow.jpg', false, 'Макс фон Сюдов');
INSERT INTO actors VALUES (24, 40, '/images/actors/williams.jpg', false, 'Мишель Уильямс');

INSERT INTO actors VALUES (25, 30, '/images/actors/bodrov-jr.jpg', false, 'Сергей Бодров мл.');
INSERT INTO actors VALUES (26, 69, '/images/actors/sukhorukov.jpg', false, 'Виктор Сухоруков');
INSERT INTO actors VALUES (27, 57, '/images/actors/pismichenko.jpg', false, 'Светлана Письмиченко');
INSERT INTO actors VALUES (28, 47, '/images/actors/zhukova.jpg', false, 'Мария Милютина');
INSERT INTO actors VALUES (29, 74, '/images/actors/kuznetcov.jpg', false, 'Юрий Кузнецов');

INSERT INTO actors VALUES (30, 62, '/images/actors/makovetsky.jpg', false, 'Сергей Маковецкий');
INSERT INTO actors VALUES (31, 54, '/images/actors/saltykova.jpg', false, 'Ирина Салтыкова');
INSERT INTO actors VALUES (32, 47, '/images/actors/pirogov.jpg', false, 'Кирилл Пирогов');
INSERT INTO actors VALUES (33, 55, '/images/actors/diachenko.jpg', false, 'Александр Дьяченко');


INSERT INTO movie_genre VALUES (1, 'Фантастика');
INSERT INTO movie_genre VALUES (1, 'Драма');
INSERT INTO movie_genre VALUES (1, 'Криминал');
INSERT INTO movie_genre VALUES (1, 'Детектив');

INSERT INTO movie_genre VALUES (2, 'Драма');

INSERT INTO movie_genre VALUES (3, 'Вестерн');
INSERT INTO movie_genre VALUES (3, 'Боевик');
INSERT INTO movie_genre VALUES (3, 'Драма');
INSERT INTO movie_genre VALUES (3, 'Комедия');

INSERT INTO movie_genre VALUES (4, 'Фантастика');
INSERT INTO movie_genre VALUES (4, 'Боевик');
INSERT INTO movie_genre VALUES (4, 'Триллер');
INSERT INTO movie_genre VALUES (4, 'Драма');
INSERT INTO movie_genre VALUES (4, 'Детектив');

INSERT INTO movie_genre VALUES (5, 'Триллер');
INSERT INTO movie_genre VALUES (5, 'Детектив');
INSERT INTO movie_genre VALUES (5, 'Драма');

INSERT INTO movie_genre VALUES (6, 'Боевик');
INSERT INTO movie_genre VALUES (6, 'Драма');
INSERT INTO movie_genre VALUES (6, 'Криминал');
INSERT INTO movie_genre VALUES (6, 'Музыка');

INSERT INTO movie_genre VALUES (7, 'Боевик');
INSERT INTO movie_genre VALUES (7, 'Криминал');


INSERT INTO movies_actors VALUES (1, 1);
INSERT INTO movies_actors VALUES (1, 2);
INSERT INTO movies_actors VALUES (1, 3);
INSERT INTO movies_actors VALUES (1, 4);

INSERT INTO movies_actors VALUES (2, 5);
INSERT INTO movies_actors VALUES (2, 6);
INSERT INTO movies_actors VALUES (2, 7);
INSERT INTO movies_actors VALUES (2, 8);
INSERT INTO movies_actors VALUES (2, 9);

INSERT INTO movies_actors VALUES (3, 10);
INSERT INTO movies_actors VALUES (3, 11);
INSERT INTO movies_actors VALUES (3, 12);
INSERT INTO movies_actors VALUES (3, 13);
INSERT INTO movies_actors VALUES (3, 14);
INSERT INTO movies_actors VALUES (3, 15);
INSERT INTO movies_actors VALUES (3, 16);

INSERT INTO movies_actors VALUES (4, 12);
INSERT INTO movies_actors VALUES (4, 17);
INSERT INTO movies_actors VALUES (4, 18);
INSERT INTO movies_actors VALUES (4, 19);
INSERT INTO movies_actors VALUES (4, 20);

INSERT INTO movies_actors VALUES (5, 12);
INSERT INTO movies_actors VALUES (5, 21);
INSERT INTO movies_actors VALUES (5, 22);
INSERT INTO movies_actors VALUES (5, 23);
INSERT INTO movies_actors VALUES (5, 24);

INSERT INTO movies_actors VALUES (6, 25);
INSERT INTO movies_actors VALUES (6, 26);
INSERT INTO movies_actors VALUES (6, 27);
INSERT INTO movies_actors VALUES (6, 28);
INSERT INTO movies_actors VALUES (6, 29);

INSERT INTO movies_actors VALUES (7, 25);
INSERT INTO movies_actors VALUES (7, 26);
INSERT INTO movies_actors VALUES (7, 30);
INSERT INTO movies_actors VALUES (7, 31);
INSERT INTO movies_actors VALUES (7, 32);
INSERT INTO movies_actors VALUES (7, 33);