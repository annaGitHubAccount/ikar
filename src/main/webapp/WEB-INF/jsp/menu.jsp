<div style="padding: 5px;">

    Sie sind als <b>${loggedUser}</b> angemeldet.
    <br>
    <br>
    <br>
    <li><a href="${pageContext.request.contextPath}/web/homepage">Homepage</a></li>
    <br>
    <li><a href="${pageContext.request.contextPath}/web/addkunde">Fuege neuen Kunden hinzu</a></li>
    <li><a href="${pageContext.request.contextPath}/kundesucheform/listevonkunden">Liste von Kunden</a></li>
    <br>
    <li><a href="${pageContext.request.contextPath}/web/addproduktstammdaten">Fuege neuen Produktstammdaten hinzu</a></li>
    <li><a href="${pageContext.request.contextPath}/produktstammdatensucheform/produktstammdatenlist">Liste von Produktstammdaten</a></li>
    <br>

    <li style="color: #4183C4">Statistiken
        <ul>
            <li><a href="${pageContext.request.contextPath}/web/findanzahlvonkundenimland">Kunden Statistiken</a></li>
        </ul>
    </li>

    <br>
    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>

</div>