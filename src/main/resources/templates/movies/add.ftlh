<#import "../parts/common.ftlh" as c>

<@c.page>
    <div class="card m-3 shadow-sm rounded">
        <h5 class="card-header text-success">Добавить фильм</h5>
        <div class="card-body">
            <form class="needs-validation" method="post" novalidate>
                <div class="form-group">
                    <label for="inputName">Название фильма</label>
                    <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите название" required>
                    <div class="invalid-feedback">
                        Необходимо ввести название фильма.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputImageUrl">Ссылка на постер</label>
                    <input type="text" name="imageUrl" class="form-control" id="inputImageUrl" placeholder="Укажите ссылку на постер" pattern="(http(s?):)([/|.|\w|\s|-])*\.(?:jpg|gif|png)" required>
                    <div class="invalid-feedback">
                        Необходимо указать ссылку на постер фильма.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDuration">Продолжительность фильма</label>
                    <input type="text" name="duration" class="form-control" id="inputDuration" placeholder="Введите продолжительность" pattern="^0*\d{1,3}" required>
                    <small id="durationHelp" class="form-text text-muted">Продолжительность фильма необходимо указать в минутах</small>
                    <div class="invalid-feedback">
                        Необходимо ввести продолжительность фильма (разрешены только цифры).
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputYear">Год выпуска фильма</label>
                    <input type="text" name="year" class="form-control" id="inputYear" placeholder="Введите год выпуска" pattern="^0*\d{4}" required>
                    <div class="invalid-feedback">
                        Необходимо ввести год выпуска фильма (разрешены только цифры).
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputCountry">Страна выпуска фильма</label>
                    <input type="text" name="country" class="form-control" id="inputCountry" placeholder="Введите страну" required>
                    <div class="invalid-feedback">
                        Необходимо ввести страну фильма.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputGenre">Жанр фильма</label>
                    <input type="text" name="genre" class="form-control" id="inputGenre" placeholder="Введите жанр" required>
                    <small id="durationHelp" class="form-text text-muted">Можно указать несколько жанров через запятую</small>
                    <div class="invalid-feedback">
                        Необходимо ввести жанр фильма.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputStageDirector">Режиссёр фильма</label>
                    <input type="text" name="stageDirector" class="form-control" id="inputStageDirector" placeholder="Введите имя режиссёра" required>
                    <div class="invalid-feedback">
                        Необходимо ввести режиссёра фильма.
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputActor">Актёры фильма</label>
                    <input type="text" name="actor" class="form-control" id="inputActor" placeholder="Укажите актёров" required>
                    <small id="actorHelp" class="form-text text-muted">Актёров необходимо указывать через запятую</small>
                    <div class="invalid-feedback">
                        Необходимо указать актёров фильма.
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Добавить</button>
            </form>
        </div>
    </div>
    <#include "../parts/form-validation.ftlh">
</@c.page>