INSERT INTO actors(id, age, image_url, name)
VALUES (1, 56, 'https://st.kp.yandex.net/im/kadr/3/3/7/kinopoisk.ru-Keanu-Reeves-3379590.jpg', 'Киану Ривз'),
       (2, 80, 'https://st.kp.yandex.net/im/kadr/2/5/8/kinopoisk.ru-Al-Pacino-2580555.jpg', 'Аль Пачино'),
       (3, 57, 'https://st.kp.yandex.net/im/kadr/1/1/7/kinopoisk.ru-Patrick-Swayze-1178121.jpg', 'Патрик Суэйзи');

select movie_id from movie_genre m where m.genre = 'aa'