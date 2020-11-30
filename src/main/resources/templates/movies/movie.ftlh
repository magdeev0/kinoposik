<#import "../parts/common.ftlh" as c>

<@c.page>
    <#if movie.isEmpty()>
        <div style="text-align: center;">Ошибка. Фильм с указанным id не найден.</div>
    <#else>
        <div>
            <b>${movie.get().id}</b>
            <span>${movie.get().name}</span>
            <span>${movie.get().duration}</span>
            <span>${movie.get().year}</span>
            <span>${movie.get().stageDirector}</span>
            <span>${movie.get().country}</span>
            <#list movie.get().genre as item>
                ${item}
            </#list>
            <#list movie.get().actor as item>
                ${item.name}
            </#list>
        </div>
    </#if>

</@c.page>