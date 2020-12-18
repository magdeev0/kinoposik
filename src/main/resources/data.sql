INSERT INTO actors VALUES (1, 56, 'https://st.kp.yandex.net/im/kadr/3/3/7/kinopoisk.ru-Keanu-Reeves-3379590.jpg', false, 'Киану Ривз');
INSERT INTO actors VALUES (2, 80, 'https://st.kp.yandex.net/im/kadr/2/5/8/kinopoisk.ru-Al-Pacino-2580555.jpg', false, 'Аль Пачино');
INSERT INTO actors VALUES (3, 57, 'https://st.kp.yandex.net/im/kadr/1/1/7/kinopoisk.ru-Patrick-Swayze-1178121.jpg', false, 'Патрик Суэйзи');

INSERT INTO movies VALUES (1, 'США', 136, 'https://st.kp.yandex.net/im/poster/3/4/1/kinopoisk.ru-The-Matrix-3418823.jpg', false, 'The Matrix', 'Вачовски', 1999);
INSERT INTO movies VALUES (2, 'США', 189, 'https://st.kp.yandex.net/im/poster/7/8/9/kinopoisk.ru-The-Green-Mile-789138.jpg', false, 'The Green Mile', 'Фрэнк Дарабонт', 1999);
INSERT INTO movies VALUES (3, 'США', 136, 'https://st.kp.yandex.net/im/poster/3/4/1/kinopoisk.ru-The-Matrix-3418823.jpg', false, 'The Matrix', 'Вачовски', 1999);
INSERT INTO movies VALUES (4, 'США', 189, 'https://st.kp.yandex.net/im/poster/7/8/9/kinopoisk.ru-The-Green-Mile-789138.jpg', false, 'The Green Mile', 'Фрэнк Дарабонт', 1999);

INSERT INTO movie_genre VALUES (1, 'Фантастика');
INSERT INTO movie_genre VALUES (1, 'Драма');
INSERT INTO movie_genre VALUES (1, 'Криминал');
INSERT INTO movie_genre VALUES (1, 'Детектив');
INSERT INTO movie_genre VALUES (2, 'Фантастика');
INSERT INTO movie_genre VALUES (2, 'Драма');
INSERT INTO movie_genre VALUES (2, 'Криминал');
INSERT INTO movie_genre VALUES (2, 'Детектив');

INSERT INTO movies_actors VALUES (1, 1);
INSERT INTO movies_actors VALUES (1, 2);
INSERT INTO movies_actors VALUES (1, 3);
INSERT INTO movies_actors VALUES (2, 1);
INSERT INTO movies_actors VALUES (2, 3);
INSERT INTO movies_actors VALUES (3, 1);
INSERT INTO movies_actors VALUES (4, 3);