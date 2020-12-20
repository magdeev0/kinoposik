<#import "parts/common.ftlh" as c>

<@c.page>
    <h3 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">
        Kinoposik</h3>
    <div>
        Выпускной проект выполнен на Spring. Доступный функционал:
        <ul>
            <li>CRUD фильмов, актёров</li>
            <li>Поиск фильмов, актёров по заданным параметрам</li>
            <li>Сортировка фильмов</li>
        </ul>
    </div>
    <div>
        Статистика:
        <ul>
            <li>Фильмов всего: <a href="/movie/all" class="text-success">${countMovies}</a>, из них удалено ${countDeletedMovies}</li>
            <li>Актёров всего: <a href="/actor/all" class="text-success">${countActors}</a>, из них удалено ${countDeletedActors}</li>
        </ul>
    </div>
</@c.page>