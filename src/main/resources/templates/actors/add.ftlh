<#import "../parts/common.ftlh" as c>

<@c.page>
    <div class="card m-3 shadow-sm rounded">
        <h5 class="card-header text-success">Добавить актёра</h5>
        <div class="card-body">
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
                    <input type="text" name="age" class="form-control" id="inputAge" placeholder="Введите возраст" pattern="^0*\d{1,2}" required>
                    <div class="invalid-feedback">
                        Необходимо указать возраст актёра (разрешены только цифры).
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputImageUrl">Фотография актёра</label>
                    <input type="text" name="imageUrl" class="form-control" id="inputImageUrl" placeholder="Укажите ссылку на фото" pattern="(http(s?):)([/|.|\w|\s|-])*\.(?:jpg|gif|png)" required>
                    <div class="invalid-feedback">
                        Необходимо указать ссылку на фото актёра.
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Добавить</button>
            </form>
        </div>
    </div>
    <#include "../parts/form-validation.ftlh">
</@c.page>