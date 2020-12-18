<#import "../parts/common.ftlh" as c>

<@c.page>
    <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
    <#if searchError??>Актёр с именем <b>${searchedName}</b> не найден. Можно <a href="/actor/add" class="text-success">создать</a>.</#if>
</@c.page>