<#import "../parts/common.ftlh" as c>

<@c.page>
    <h3 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Все актёры</h3>
    <#list actors as actor>
        <div class="card m-3 shadow-sm rounded">
            <h5 class="card-header"><a href="/actor/${actor.id}" class="text-success">${actor.name}</a></h5>
            <div class="card-body">
                <div class="row">
                    <div class="col-3 border-success border-right" style="text-align: center">
                        <a href="/actor/${actor.id}"><img src="${actor.imageUrl}" alt="${actor.name}" title="${actor.name}" style="max-height: 150px"></a>
                    </div>
                    <div class="col-5">
                        <p class="card-text"><b>Имя актёра:</b> ${actor.name}</p>
                        <p class="card-text"><b>Возраст:</b> <#if actor.age = 0>[нет информации]<#else>${actor.age}</#if></p>
                    </div>
                </div>
            </div>
        </div>
    <#else>
        Нет добавленных актёров
    </#list>
</@c.page>