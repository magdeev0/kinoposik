<#import "../parts/common.ftlh" as c>

<@c.page>
    <h3 class="border-success border-bottom"
        style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Фильтр фильмов
        <#if country??>по стране ${country}</#if>
        <#if genre??>по жанру ${genre}</#if>
        <#if actor??>по актёру ${actor}</#if>
        <#if value?? && value = "id">по id (по возрастанию)</#if>
        <#if value?? && value = "id-desc">по id (по убыванию)</#if>
        <#if value?? && value = "year">по году (по возрастанию)</#if>
        <#if value?? && value = "year-desc">по году (по убыванию)</#if>
        <#if value?? && value = "name">по id (в алфавитном порядке)</#if>
        <#if value?? && value = "name-desc">по id (в обратном алфавиту порядке)</#if>
    </h3>
    <#if movies??>
        <#if value??>
        <div class="sort-by">
            <div class="btn-group">
                <button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Сортировка
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item <#if value = "id" || value = "id-desc">active</#if>" href="<#if value = "id">/movie/filter/order-by/id-desc<#else>/movie/filter/order-by/id</#if>">по id <#if value = "id">&darr;<#elseif value = "id-desc">&uarr;<#else>&duarr;</#if></a>
                    <a class="dropdown-item <#if value = "name" || value = "name-desc">active</#if>" href="<#if value = "name">/movie/filter/order-by/name-desc<#else>/movie/filter/order-by/name</#if>">по названию <#if value = "name">&darr;<#elseif value = "name-desc">&uarr;<#else>&duarr;</#if></a>
                    <a class="dropdown-item <#if value = "year" || value = "year-desc">active</#if>" href="<#if value = "year">/movie/filter/order-by/year-desc<#else>/movie/filter/order-by/year</#if>">по году <#if value = "year">&darr;<#elseif value = "year-desc">&uarr;<#else>&duarr;</#if></a>
                </div>
            </div>
        </div>
        </#if>
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
        </#list>
    <#else>
        Не нашлось фильмов с подходящими критериями
    </#if>
</@c.page>