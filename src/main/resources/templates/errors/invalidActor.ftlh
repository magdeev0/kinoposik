<#import "../parts/common.ftlh" as c>

<@c.page>
    <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
    <#if incorrectActors??><a href="/movie/${movie_id}" class="text-success">Фильм <#if add??>добавлен<#elseif edit??>отредактирован</#if></a>, однако некоторые указанные актёры не были найдены и были созданы автоматически: <#list incorrectActors as item><b><a href="/actor/${item.id}" class="text-success">${item.name}</a></b><#if item_has_next>, </#if></#list>.</#if>
</@c.page>