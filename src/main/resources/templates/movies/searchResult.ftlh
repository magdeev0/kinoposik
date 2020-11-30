<#import "../parts/common.ftlh" as c>

<@c.page>
    <h3 style="text-align: center">Фильтр фильмов по стране ${country}</h3>
    <#list movies as movie>
        <div>
            <a href="${movie.id}">${movie.name}</a>
            <b>${movie.id}</b>
            <span>Название: ${movie.name}</span>
            <span>Страна: ${movie.country}</span>
            <span>Год: ${movie.year}</span>
            <span>Режиссёр: ${movie.stageDirector}</span>
            <span>Продолжительность: ${movie.duration}</span>
            <#list movie.genre as item>
                Жанр: <b>${item}</b>
            </#list>
            <#list movie.actor as item>
                Актер: <b>${item.name}</b>
            </#list>
        </div>
    <#else>
        Не нашлось фильмов с подходящей страной
    </#list>
</@c.page>