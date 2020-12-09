<#import "../parts/common.ftlh" as c>

<@c.page>
    <div class="card m-3 shadow-sm rounded">
        <h5 class="card-header text-success">Поиск актёра</h5>
        <div class="card-body">
            <form class="needs-validation" method="post" novalidate>
                <div class="form-group">
                    <label for="inputName">Имя актёра</label>
                    <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите имя"
                           required>
                    <div class="invalid-feedback">
                        Необходимо ввести имя актёра.
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Найти</button>
            </form>
        </div>
    </div>
    <#include "../parts/form-validation.ftlh">
</@c.page>