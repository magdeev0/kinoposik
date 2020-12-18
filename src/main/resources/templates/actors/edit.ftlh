<#import "../parts/common.ftlh" as c>

<@c.page>
    <#if actor.isEmpty()>
        <h5 class="border-success border-bottom" style="padding-bottom: 10px; margin-bottom: 10px; text-align: center">Ошибка</h5>
        Актёр с указанным id не найден.
    <#else>
        <div class="card m-3 shadow-sm rounded">
            <h5 class="card-header text-success">Редактирование актёра ${actor.get().name}</h5>
            <div class="card-body">
                <form class="needs-validation" method="post" novalidate>
                    <div class="form-group">
                        <label for="inputName">Имя актёра</label>
                        <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите имя" value="${actor.get().name}" required>
                        <div class="invalid-feedback">
                            Необходимо ввести имя актёра.
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAge">Возраст актёра</label>
                        <input type="text" name="age" class="form-control" id="inputAge" placeholder="Введите возраст" value="${actor.get().age}" pattern="^0*\d{1,2}" required>
                        <div class="invalid-feedback">
                            Необходимо указать возраст актёра (разрешены только цифры).
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputImageUrl">Фотография актёра</label>
                        <input type="text" name="imageUrl" class="form-control" id="inputImageUrl" placeholder="Укажите ссылку на фото" value="${actor.get().imageUrl}" required>
                        <div class="invalid-feedback">
                            Необходимо указать ссылку на фото актёра.
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success">Изменить</button>
                </form>
            </div>
        </div>
        <#include "../parts/form-validation.ftlh">
    </#if>
</@c.page>