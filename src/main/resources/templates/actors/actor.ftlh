<#import "../parts/common.ftlh" as c>

<@c.page>
    <#if actor.isEmpty()>
        <div style="text-align: center;">Ошибка. Актёр с указанным id не найден.</div>
    <#else>
        <#if actor.get().deleted>
            <div style="text-align: center">Ошибка. Страница актёра удалена.</div>
        <#else>
            <h3 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">
                Страница актёра</h3>
            <div class="row">
                <div class="col-3 border-success border-right" style="text-align: center">
                    <img src="${actor.get().imageUrl}" alt="${actor.get().name}" style="max-width: 200px">
                </div>
                <div class="col-5">
                    <p><b>Имя актёра:</b> ${actor.get().name}</p>
                    <p><b>Возраст:</b> ${actor.get().age}</p>
                </div>
            </div>
        </#if>
    </#if>
</@c.page>