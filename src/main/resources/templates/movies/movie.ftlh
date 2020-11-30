<#import "../parts/common.ftlh" as c>

<@c.page>
    <#if movie.isEmpty()>
        <div style="text-align: center;">Ошибка. Фильм с указанным id не найден.</div>
    <#else>
        <#if movie.get().deleted>
            <div style="text-align: center">Ошибка. Страница фильма удалена.</div>
        <#else>
            <h3 class="border-success border-bottom"
                style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">
                Страница фильма</h3>
            <div class="card m-2">
                <h5 class="card-header"><a href="/movie/${movie.get().id}" class="text-success">${movie.get().name}</a></h5>
                <div class="card-body">
                    <div class="row">
                        <div class="col-3 border-success border-right" style="text-align: center">
                            <img src="${movie.get().imageUrl}" alt="${movie.get().name}" style="max-width: 200px">
                        </div>
                        <div class="col-5">
                            <p><b>Название:</b> ${movie.get().name}</p>
                            <p><b>Год выпуска:</b> ${movie.get().year}</p>
                            <p><b>Продолжительность:</b> 0${(movie.get().duration - movie.get().duration%60)/60}:<#if movie.get().duration%60 < 10>0</#if>${movie.get().duration%60}</p>
                            <p><b>Страна:</b> <a href="/movie/search/country/${movie.get().country}" class="text-success">${movie.get().country}</a></p>
                            <p><b>Режиссёр</b> ${movie.get().stageDirector}</p>
                            <p><b>Жанр:</b>
                                <#list movie.get().genre as item>
                                <a href="/movie/search/genre/${item}" class="text-success">${item}</a><#if item_has_next>,</#if>
                                </#list>
                            </p>
                            <p><b>Актёры:</b>
                                <#list movie.get().actor as item>
                                    <a href="/actor/${item.id}" class="text-success">${item.name}</a><#if item_has_next>,</#if>
                                </#list>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </#if>
    </#if>
</@c.page>