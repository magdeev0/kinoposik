INSERT INTO actors(id, age, image_url, name, is_deleted) VALUE (1, 56, 'https://st.kp.yandex.net/im/kadr/3/3/7/kinopoisk.ru-Keanu-Reeves-3379590.jpg', 'Киану Ривз', false);
INSERT INTO actors(id, age, image_url, name, is_deleted) VALUE (2, 80, 'https://st.kp.yandex.net/im/kadr/2/5/8/kinopoisk.ru-Al-Pacino-2580555.jpg', 'Аль Пачино', false);
INSERT INTO actors(id, age, image_url, name, is_deleted) VALUE (3, 57, 'https://st.kp.yandex.net/im/kadr/1/1/7/kinopoisk.ru-Patrick-Swayze-1178121.jpg', 'Патрик Суэйзи', false);

INSERT INTO movies(id, name, image_url, duration, country, stage_director, year, is_deleted) VALUE (1, 'The Matrix', 'https://st.kp.yandex.net/im/poster/3/4/1/kinopoisk.ru-The-Matrix-3418823.jpg', 136, 'США', 'Вачовски', '1999', false);
INSERT INTO movies(id, name, image_url, duration, country, stage_director, year, is_deleted) VALUE (2, 'The Green Mile', 'https://st.kp.yandex.net/im/poster/7/8/9/kinopoisk.ru-The-Green-Mile-789138.jpg', 189, 'США', 'Фрэнк Дарабонт', 1999, false);
INSERT INTO movies(id, name, image_url, duration, country, stage_director, year, is_deleted) VALUE (3, 'The Matrix', 'https://st.kp.yandex.net/im/poster/3/4/1/kinopoisk.ru-The-Matrix-3418823.jpg', 136, 'США', 'Вачовски', '1999', false);
INSERT INTO movies(id, name, image_url, duration, country, stage_director, year, is_deleted) VALUE (4, 'The Green Mile', 'https://st.kp.yandex.net/im/poster/7/8/9/kinopoisk.ru-The-Green-Mile-789138.jpg', 189, 'США', 'Фрэнк Дарабонт', 1999, false);

INSERT INTO movie_genre(Movie_id, genre) VALUE (1, 'Фантастика');
INSERT INTO movie_genre(Movie_id, genre) VALUE (1, 'Драма');
INSERT INTO movie_genre(Movie_id, genre) VALUE (1, 'Криминал');
INSERT INTO movie_genre(Movie_id, genre) VALUE (1, 'Детектив');
INSERT INTO movie_genre(Movie_id, genre) VALUE (2, 'Фантастика');
INSERT INTO movie_genre(Movie_id, genre) VALUE (2, 'Драма');
INSERT INTO movie_genre(Movie_id, genre) VALUE (2, 'Криминал');
INSERT INTO movie_genre(Movie_id, genre) VALUE (2, 'Детектив');

INSERT INTO movies_actors(Movie_id, actor_id) VALUE (1, 1);
INSERT INTO movies_actors(Movie_id, actor_id) VALUE (1, 2);
INSERT INTO movies_actors(Movie_id, actor_id) VALUE (1, 3);
INSERT INTO movies_actors(Movie_id, actor_id) VALUE (2, 1);
INSERT INTO movies_actors(Movie_id, actor_id) VALUE (2, 3);
INSERT INTO movies_actors(Movie_id, actor_id) VALUE (3, 1);