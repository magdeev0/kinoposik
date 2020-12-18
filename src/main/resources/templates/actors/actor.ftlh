<#import "../parts/common.ftlh" as c>
<#assign host = 'http://localhost:8080/'>
<@c.page>
    <#if actor.isEmpty()>
        <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
        Актёр с указанным id не найден.
    <#else>
        <#if actor.get().deleted>
            <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
            Актёр с указанным id удален.
        <#else>
            <h3 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Страница актёра</h3>
            <div class="card m-3 shadow-sm rounded">
                <h5 class="card-header"><a href="/actor/${actor.get().id}" class="text-success">${actor.get().name}</a><a href="/actor/delete/${actor.get().id}" class="text-hide icon-attr" style="background-image: url('${host}icons/delete.svg');">delete</a><a href="/actor/edit/${actor.get().id}" class="text-hide icon-attr" style="background-image: url('${host}icons/edit.svg');">edit</a></h5>
                <div class="card-body">
                    <div class="row">
                        <div class="col-3 border-success border-right" style="text-align: center">
                            <img src="${actor.get().imageUrl}" alt="${actor.get().name}" style="max-width: 200px">
                        </div>
                        <div class="col-9">
                            <p><b>Имя:</b> ${actor.get().name}</p>
                            <p><b>Возраст:</b> <#if actor.get().age = 0>[нет информации]<#else>${actor.get().age}</#if></p>
                            <p><b>Фильмы с актёром:</b> <#if movies??><#list movies as item><a href="/movie/${item.id}" class="text-success">${item.name}</a><#if item_has_next>, </#if></#list> [<a href="/movie/filter/actor/${actor.get().name}" class="text-success">ещё</a>]<#else>[не найдено]</#if></p>
                        </div>
                    </div>
                </div>
            </div>
        </#if>
    </#if>
</@c.page>