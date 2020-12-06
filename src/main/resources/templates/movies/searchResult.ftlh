<#import "../parts/common.ftlh" as c>
<@c.page>
    <h3 class="border-success border-bottom"
        style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Фильтр фильмов <#if country??>по стране ${country}</#if><#if genre??>по жанру ${genre}</#if><#if actor??>по актёру ${actor}</#if></h3>
    <#list movies as movie>
        <div class="card m-3 shadow-sm rounded">
            <h5 class="card-header"><a href="/movie/${movie.id}" class="text-success">${movie.name}</a></h5>
            <div class="card-body">
                <div class="row">
                    <div class="col-3 border-success border-right" style="text-align: center">
                        <a href="/movie/${movie.id}"><img src="${movie.imageUrl}" alt="${movie.name}" title="${movie.name}" style="max-height: 150px"></a>
                    </div>
                    <div class="col-9">
                        <p class="card-text"><b>Название:</b> ${movie.name}</p>
                        <p class="card-text"><b>Год:</b> ${movie.year?string.computer}</p>
                        <p class="card-text"><b>Страна:</b> ${movie.country}</p>
                        <p class="card-text"><a href="/movie/${movie.id}" class="text-success">Полная информация о фильме</a></p>
                    </div>
                </div>
            </div>
        </div>
    <#else>
        Не нашлось фильмов с подходящими критериями
    </#list>
</@c.page>