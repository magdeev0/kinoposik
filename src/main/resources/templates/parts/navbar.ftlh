<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Kinoposik</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/movie/all">Все фильмы</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/actor/all">Все актёры</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Поиск
                </a>
                <div class="dropdown-menu" aria-labelledby="searchDropdown">
                    <a class="dropdown-item" href="/movie/search">Поиск по фильмам</a>
                    <a class="dropdown-item" href="/actor/search">Поиск по актёрам</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="addDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Добавить
                </a>
                <div class="dropdown-menu" aria-labelledby="addDropdown">
                    <a class="dropdown-item" href="/movie/add">Добавить фильм</a>
                    <a class="dropdown-item" href="/actor/add">Добавить актёра</a>
                </div>
            </li>
        </ul>
    </div>
</nav>