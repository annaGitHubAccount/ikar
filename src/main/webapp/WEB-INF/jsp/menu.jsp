<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <ul id="menu">
        <li class="ui-widget-header">
            <div>Menu</div>
        </li>
        <li>
            <div id="homepage">Homepage</div>
        </li>
        <li>
            <div id="addKunde">Fuege neuen Kunden hinzu</div>
        </li>
        <li>
            <div id="listeVonKunden">Liste von Kunden</div>
        </li>

        <c:if test="${zeigeProduktStammdaten == 'show'}">
            <li>
                <div id="addproduktstammdaten">Fuege neuen Produktstammdaten hinzu</div>
            </li>
            <li>
                <div id="produktstammdatenlist">Liste von Produktstammdaten</div>
            </li>
        </c:if>

        <li class="ui-widget-header">
            <div>Statistiken</div>
        </li>
        <li>
            <div id="findanzahlvonkundenimland">Kunden Statistiken</div>
        </li>
        <li class="ui-widget-header">
            <div></div>
        </li>
        <li>
            <div id="logout">Logout</div>
        </li>
    </ul>
    <br/>
    <span style="font-style: italic">Sie sind als <b>${loggedUser}</b> angemeldet.</span>
</div>




<script>

    function bedieneHomepageLink() {

        let homepage = document.getElementById("homepage");

        homepage.onclick = function () {
            window.location = "${pageContext.request.contextPath}/ikar/web/homepage";
        }
    }

    function bedieneAddKundeLink() {

        let addKunde = document.getElementById("addKunde");

        addKunde.onclick = function () {
            window.location = "${pageContext.request.contextPath}/ikar/web/addkunde";
        }
    }

    function bedieneListeVonKunden() {

        let listeVonKunden = document.getElementById("listeVonKunden");

        listeVonKunden.onclick = function () {
            window.location = "${pageContext.request.contextPath}/ikar/kundesucheform/listevonkunden";
        }
    }

    function bedieneAddproduktstammdatenLink() {

        let addproduktstammdaten = document.getElementById("addproduktstammdaten");

        if (addproduktstammdaten !== null) {
            addproduktstammdaten.onclick = function () {
                window.location = "${pageContext.request.contextPath}/ikar/web/addproduktstammdaten";
            }
        }
    }

    function bedieneProduktstammdatenlistLink() {

        let produktstammdatenlist = document.getElementById("produktstammdatenlist");

        if (produktstammdatenlist !== null) {
            produktstammdatenlist.onclick = function () {
                window.location = "${pageContext.request.contextPath}/ikar/produktstammdatensucheform/produktstammdatenlist";
            }
        }
    }

    function bedieneFindanzahlvonkundenimlandLink() {

        let findanzahlvonkundenimland = document.getElementById("findanzahlvonkundenimland");

        findanzahlvonkundenimland.onclick = function () {
            window.location = "${pageContext.request.contextPath}/web/findanzahlvonkundenimland";
        }
    }

    function bedieneLogoutLink() {

        let logout = document.getElementById("logout");

        logout.onclick = function () {
            window.location = "${pageContext.request.contextPath}/logout";
        }
    }


    bedieneHomepageLink();
    bedieneAddKundeLink();
    bedieneListeVonKunden();
    bedieneAddproduktstammdatenLink();
    bedieneProduktstammdatenlistLink();
    bedieneFindanzahlvonkundenimlandLink();
    bedieneLogoutLink();

</script>