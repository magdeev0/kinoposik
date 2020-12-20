<#import "../parts/common.ftlh" as c>
<#assign host = 'http://localhost:8080/'>

<@c.page>
    <#if movie.isEmpty()>
        <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
        Фильм с указанным id не найден.
    <#else>
        <#if movie.get().deleted>
            <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
            Фильм с указанным id удалён.
        <#else>
            <h3 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Страница фильма</h3>
            <div class="card m-3 shadow-sm rounded">
                <h5 class="card-header"><a href="/movie/${movie.get().id}" class="text-success">${movie.get().name}</a><a href="/movie/delete/${movie.get().id}" class="text-hide icon-attr" style="background-image: url('https://kinoposik.herokuapp.com/icons/delete.svg');">delete</a><a href="/movie/edit/${movie.get().id}" class="text-hide icon-attr" style="background-image: url('https://kinoposik.herokuapp.com/icons/edit.svg');">edit</a></h5>
                <div class="card-body">
                    <div class="row">
                        <div class="col-3 border-success border-right" style="text-align: center">
                            <img src="${movie.get().imageUrl}" alt="${movie.get().name}" style="max-width: 200px">
                        </div>
                        <div class="col-9">
                            <p><b>Название:</b> ${movie.get().name}</p>
                            <p><b>Год выпуска:</b> ${movie.get().year?string.computer}</p>
                            <p><b>Продолжительность:</b> ${movie.get().duration} <i>мин.</i> / 0${(movie.get().duration - movie.get().duration%60)/60}:<#if movie.get().duration%60 < 10>0</#if>${movie.get().duration%60}</p>
                            <p><b>Страна:</b> <a href="/movie/filter/country/${movie.get().country}" class="text-success">${movie.get().country}</a></p>
                            <p><b>Режиссёр:</b> ${movie.get().stageDirector}</p>
                            <p><b>Жанр:</b>
                                <#list movie.get().genre as item>
                                    <a href="/movie/filter/genre/${item}"
                                       class="text-success">${item}</a><#if item_has_next>,</#if>
                                </#list>
                            </p>
                            <p><b>Актёры:</b>
                                <#list movie.get().actor as item>
                                    <a href="/actor/${item.id}"
                                       class="text-success">${item.name}</a><#if item_has_next>,</#if>
                                </#list>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </#if>
    </#if>
</@c.page>