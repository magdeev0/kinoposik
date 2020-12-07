<#import "../parts/common.ftlh" as c>

<@c.page>
    <h3 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Все фильмы</h3>
    <div class="sort-by">
        <div class="btn-group">
            <button type="button" class="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Сортировка
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item active" href="/movie/filter/order-by/id-desc">по id &darr;</a>
                <a class="dropdown-item" href="/movie/filter/order-by/name">по названию &duarr;</a>
                <a class="dropdown-item" href="/movie/filter/order-by/year">по году &duarr;</a>
            </div>
        </div>
    </div>
    <#list movies as movie>
        <div class="card m-3 shadow-sm rounded">
            <h5 class="card-header"><a href="/movie/${movie.id}" class="text-success">${movie.name}</a></h5>
            <div class="card-body">
                <div class="row">
                    <div class="col-3 border-success border-right" style="text-align: center">
                        <a href="/movie/${movie.id}"><img src="${movie.imageUrl}" alt="${movie.name}" title="${movie.name}" style="max-width: 150px"></a>
                    </div>
                    <div class="col-5">
                        <p class="card-text"><b>Название:</b> ${movie.name}</p>
                        <p class="card-text"><b>Год:</b> ${movie.year?string.computer}</p>
                        <p class="card-text"><b>Страна:</b> ${movie.country}</p>
                        <p class="card-text"><a href="/movie/${movie.id}" class="text-success">Полная информация о фильме</a></p>
                    </div>
                </div>
            </div>
        </div>
    <#else>
        Нет добавленных фильмов
    </#list>
</@c.page>