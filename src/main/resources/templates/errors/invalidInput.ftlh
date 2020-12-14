<#import "../parts/common.ftlh" as c>

<@c.page>
    <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
    Вы попытались ввести некорректные данные<#if error??> «<b>${error}</b>»</#if>. Вернитесь назад и повторите попытку.
</@c.page>