<#import "../parts/common.ftlh" as c>

<@c.page>
    <h3 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Все актёры</h3>
    <#list actors as actor>
        <div class="border border-dark rounded m-2 p-2">
            <div class="row">
                <div class="col-3 border-success border-right" style="text-align: center">
                    <a href="/actor/${actor.id}"><img src="${actor.imageUrl}" alt="${actor.name}" title="${actor.name}" style="max-height: 100px"></a>
                </div>
                <div class="col-5">
                    <p><b>Имя актёра:</b> <a class="actor" href="/actor/${actor.id}">${actor.name}</a></p>
                    <p><b>Возраст:</b> ${actor.age}</p>
                </div>
            </div>
        </div>
    <#else>
        Нет добавленных актёров
    </#list>
</@c.page>