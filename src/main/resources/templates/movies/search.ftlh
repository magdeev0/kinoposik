<#import "../parts/common.ftlh" as c>

<@c.page>
    <div class="card m-3 shadow-sm rounded">
        <h5 class="card-header text-success">Поиск фильмов</h5>
        <div class="card-body">
            <form class="needs-validation" method="post" novalidate>
                <div class="form-group">
                    <label for="inputName">Название фильма</label>
                    <input type="text" name="name" class="form-control" id="inputName" placeholder="Введите название">
                </div>
                <div class="form-group">
                    <label for="inputYear">Год выпуска фильма</label>
                    <div class="form-row">
                        <div class="col">
                            <input type="text" name="yearStart" class="form-control" id="inputYearStart" placeholder="Начиная с" pattern="^0*\d{4}">
                            <div class="invalid-feedback">
                                Допустимо вводить только цифры.
                            </div>
                        </div>
                        <div class="col">
                            <input type="text" name="yearEnd" class="form-control" id="inputYearEnd" placeholder="Заканчивая в" pattern="^0*\d{4}">
                            <div class="invalid-feedback">
                                Допустимо вводить только цифры.
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputCountry">Страна выпуска фильма</label>
                    <input type="text" name="country" class="form-control" id="inputCountry"
                           placeholder="Введите страну">
                </div>
                <button type="submit" class="btn btn-success">Найти</button>
            </form>
        </div>
    </div>
    <#include "../parts/form-validation.ftlh">
</@c.page>