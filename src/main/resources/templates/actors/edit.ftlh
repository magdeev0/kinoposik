<#import "../parts/common.ftlh" as c>

<@c.page>
    <div class="card m-3 shadow-sm rounded">
        <h5 class="card-header text-success">Редактирование актёра ${actor.get().name}</h5>
        <div class="card-body">
            <form class="needs-validation" method="post" novalidate>
                <div class="form-group">
                    <label for="inputName">Имя актёра</label>
                    <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите имя" value="${actor.get().name}"
                           required>
                    <div class="invalid-feedback">
                        Необходимо ввести имя актёра.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputAge">Возраст актёра</label>
                    <input type="text" name="age" class="form-control" id="inputAge" placeholder="Введите возраст" value="${actor.get().age}" required>
                    <div class="invalid-feedback">
                        Необходимо указать возраст актёра.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputImageUrl">Фотография актёра</label>
                    <input type="text" name="imageUrl" class="form-control" id="inputImageUrl"
                           placeholder="Укажите ссылку на фото" value="${actor.get().imageUrl}" required>
                    <div class="invalid-feedback">
                        Необходимо указать ссылку на фото актёра.
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Изменить</button>
            </form>
        </div>
    </div>
    <#include "../parts/form-validation.ftlh">
</@c.page>