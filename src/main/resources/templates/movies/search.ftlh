<#import "../parts/common.ftlh" as c>

<@c.page>
    <div class="card m-3 shadow-sm rounded">
        <h5 class="card-header text-success">Поиск фильмов по названию</h5>
        <div class="card-body">
            <form class="needs-validation" method="post" novalidate>
                <div class="form-group">
                    <label for="inputName">Название фильма</label>
                    <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите название"
                           required>
                    <div class="invalid-feedback">
                        Необходимо ввести название фильма.
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Найти</button>
            </form>
        </div>
    </div>

    <div class="card m-3 shadow-sm rounded">
        <h5 class="card-header text-success">Поиск фильмов по другим параметрам</h5>
        <div class="card-body">
            <form method="post" novalidate>
                <div class="form-group">
                    <label for="inputName">Название фильма</label>
                    <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите название">
                </div>
                <div class="form-group">
                    <label for="inputYear">Год выпуска фильма</label>
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="yearStart" class="form-control" id="inputYearStart" placeholder="Начиная с">
                        </div>
                        <div class="col">
                            <input type="text" name="yearEnd" class="form-control" id="inputYearEnd" placeholder="Заканчивая в">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputCountry">Страна выпуска фильма</label>
                    <input type="text" name="country" class="form-control" id="inputCountry"
                           placeholder="Введите страну">
                </div>
                <div class="form-group">
                    <label for="inputGenre">Жанр фильма</label>
                    <input type="text" name="genre" class="form-control" id="inputGenre" placeholder="Введите жанр"
                           required>
                    <small id="durationHelp" class="form-text text-muted">Можно указать несколько жанров через
                        запятую</small>
                </div>
                <button type="submit" class="btn btn-success">Найти</button>
            </form>
        </div>
    </div>
    <#include "../parts/form-validation.ftlh">
</@c.page>