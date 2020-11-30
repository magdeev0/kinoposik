<#import "../parts/common.ftlh" as c>

<@c.page>
    <form class="needs-validation" method="post" novalidate>
        <div class="form-group">
            <label for="inputName">Имя актёра</label>
            <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите имя" required>
            <div class="invalid-feedback">
                Необходимо ввести имя актёра.
            </div>
        </div>
        <div class="form-group">
            <label for="inputAge">Возраст актёра</label>
            <input type="text" name="age" class="form-control" id="inputAge" placeholder="Введите возраст" required>
            <div class="invalid-feedback">
                Необходимо указать возраст актёра.
            </div>
        </div>
        <div class="form-group">
            <label for="inputImageUrl">Фотография актёра</label>
            <input type="text" name="imageUrl" class="form-control" id="inputImageUrl" placeholder="Укажите ссылку на фото" required>
            <div class="invalid-feedback">
                Необходимо указать ссылку на фото актёра.
            </div>
        </div>
        <button type="submit" class="btn btn-success">Добавить</button>
    </form>
    <#include "../parts/form-validation.ftlh">
</@c.page>