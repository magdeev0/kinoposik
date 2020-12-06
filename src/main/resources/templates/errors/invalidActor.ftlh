<#import "../parts/common.ftlh" as c>

<@c.page>
    <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
    <#if actor??>Произошла ошибка: актёр с именем <b>${actor}</b> не найден. Можно <#if movie_id??><a href="/movie/edit/${movie_id}" class="text-success">вернуться назад</a> или </#if><a href="/actor/add" class="text-success">создать</a> нового актёра.</#if>
    <#if incorrectNames??>Фильм добавлен, но некоторые указанные актёры не были найдены: <#list incorrectNames as item><b>${item}</b><#if item_has_next>, </#if></#list>. Их необходимо <a href="/actor/add" class="text-success">добавить на сайт</a> и <a href="/movie/edit/${movie_id}" class="text-success">отредактировать</a> фильм.</#if>
</@c.page>