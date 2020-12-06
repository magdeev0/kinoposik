INSERT INTO actors(id, age, image_url, name, is_deleted)
VALUES (1, 56, 'https://st.kp.yandex.net/im/kadr/3/3/7/kinopoisk.ru-Keanu-Reeves-3379590.jpg', 'Киану Ривз', false),
       (2, 80, 'https://st.kp.yandex.net/im/kadr/2/5/8/kinopoisk.ru-Al-Pacino-2580555.jpg', 'Аль Пачино', false),
       (3, 57, 'https://st.kp.yandex.net/im/kadr/1/1/7/kinopoisk.ru-Patrick-Swayze-1178121.jpg', 'Патрик Суэйзи', false);

INSERT INTO movies(id, name, image_url, duration, country, stage_director, year, is_deleted)
VALUES (1, 'The Matrix', 'https://st.kp.yandex.net/im/poster/3/4/1/kinopoisk.ru-The-Matrix-3418823.jpg', 136, 'США', 'Вачовски', '1999', false),
       (2, 'The Green Mile', 'https://st.kp.yandex.net/im/poster/7/8/9/kinopoisk.ru-The-Green-Mile-789138.jpg', 189, 'США', 'Фрэнк Дарабонт', 1999, false),
       (3, 'The Matrix', 'https://st.kp.yandex.net/im/poster/3/4/1/kinopoisk.ru-The-Matrix-3418823.jpg', 136, 'США', 'Вачовски', '1999', false),
       (4, 'The Green Mile', 'https://st.kp.yandex.net/im/poster/7/8/9/kinopoisk.ru-The-Green-Mile-789138.jpg', 189, 'США', 'Фрэнк Дарабонт', 1999, false);

INSERT INTO movie_genre(movie_id, genre) VALUES (1, 'Фантастика'),
                                                (1, 'Драма'),
                                                (1, 'Криминал'),
                                                (1, 'Детектив'),
                                                (2, 'Фантастика'),
                                                (2, 'Драма'),
                                                (2, 'Криминал'),
                                                (2, 'Детектив');

INSERT INTO movies_actor(movie_id, actor_id) VALUES (1, 1),
                                                    (1, 2),
                                                    (1, 3),
                                                    (2, 1),
                                                    (2, 3),
                                                    (3, 1);

select movie_id from movie_genre m where m.genre = 'Фантастика';

create table movie_genre;