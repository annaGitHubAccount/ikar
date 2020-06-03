<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<style>
    .error {
        color: red
    }
    .textGold{
        color: gold;
    }
    .textSilber{
        color: silver;
    }
    .textBronze{
        color: brown;
    }

</style>

<form:form method="post" modelAttribute="kundeSucheForm" action="/ikar/kundesucheform/findekunden">

    <fieldset>
        <legend>Suchmachine</legend>

        <table>

            <tr>
                <td></td>
                <td><form:errors path="kundeNummer" cssClass="error"/></td>
                <td></td>
                <td><form:errors path="steuerId" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Kunde Nummer :</td>
                <td><div class="ui input"><form:input path="kundeNummer"/></div></td>

                <td>Steuer ID :</td>
                <td><div class="ui input"><form:input path="steuerId"/></div></td>
            <tr>

            <tr>
            <td>Nachname :</td>
            <td><div class="ui input"><form:input path="nachname"/></div></td>

            <td>KundeArt :</td>
            <td>
                <form:select path="kundeArt">
                    <form:option value="">--keine KundeArt--</form:option>
                    <form:options cssClass="ui dropdown" items="${kundeSucheForm.kundeArtMap}"/>
                </form:select>
            </td>
            </tr>

            <tr>
                <td>Geburtsdatum ab:</td>
                <td>
                    <div class="ui input"><form:input path="geburtsdatumAB" id="datepickergeburtsdatumab" autocomplete="false"/></div>
                </td>

                <td>Geburtsdatum bis:</td>
                <td>
                    <div class="ui input"><form:input path="geburtsdatumBIS" id="datepickergeburtsdatumbis" autocomplete="false"/></div>
                </td>
                <td colspan="3"></td>
            </tr>

            <tr>
                <td><input type="button" value="Suche" id="sucheButtonId" class="ui button"/></td>
                <td><input type="button" value="Reset" id="resetId" class="ui button"/></td>
                <td><input type="button" value="Generate XML" id="generateXMLButtonId" class="ui button"/></td>
                <td colspan="4"></td>
            </tr>

        </table>

    </fieldset>

</form:form>

<h1>
    <c:if test="${empty kundeList}">
        Es gibt keine Kunden zum zeigen
    </c:if>
    <c:if test="${not empty kundeList}">
        Liste von Kunden
    </c:if>
</h1>

<c:if test="${not empty kundeList}">

    <table class="ui celled table striped">

        <thead>
        <tr>
            <th>Kunde Nummer</th>
            <th>Steuer ID</th>
            <th>Name</th>
            <th>Nachname</th>
            <th>Rolle</th>
            <th>Geburtsdatum</th>
            <th>KundeArt</th>
            <th colspan="3">Operation</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="kunde" items="${kundeList}">

            <tr>
                <td data-label="Kunde Nummer">${kunde.kundeNummer}</td>
                <td data-label="Steuer ID">${kunde.steuerId}</td>
                <td data-label="Name">${kunde.name}</td>
                <td data-label="Nachname">${kunde.nachname}</td>
                <td data-label="Rolle">${kunde.rolle}</td>

                <fmt:parseDate value="${kunde.birthDate}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
                <fmt:formatDate value="${parsedDate}" var="formattedBirthDate" type="date" pattern="dd.MM.yyyy"/>
                <td data-label="Geburtsdatum">${formattedBirthDate}</td>

                <c:if test = "${kunde.kundeArt.text == 'Gold'}">
                    <td class="textGold" data-label="KundeArt">${kunde.kundeArt.text}</td>
                </c:if>
                <c:if test = "${kunde.kundeArt.text == 'Silber'}">
                    <td class=textSilber data-label="KundeArt">${kunde.kundeArt.text}</td>
                </c:if>
                <c:if test = "${kunde.kundeArt.text == 'Bronze'}">
                    <td class=textBronze data-label="KundeArt">${kunde.kundeArt.text}</td>
                </c:if>

                <td data-label="Operation"><a href="/ikar/web/editkunde/${kunde.id}">Aendern</a></td>
                <td data-label="Operation"><a href="/ikar/web/deletekunde/${kunde.id}">Loeschen</a></td>
                <td data-label="Operation"><a href="/ikar/web/findrollenvonkunde/${kunde.id}">Manage von Rollen</a></td>
            </tr>

        </c:forEach>

        </tbody>

    </table>

</c:if>

<a href="${pageContext.request.contextPath}/ikar/kundesucheform/generatexmllistevonkunden">Generate XML Liste von Kunden</a>
<br>
<%--<a href="${pageContext.request.contextPath}/kundesucheform/generatepdflistevonkunden">Generate PDF Liste von Kunden</a>--%>

<script>

    function bedieneResetButton() {

        var buttonReset = document.getElementById("resetId");

        buttonReset.addEventListener("click", function () {
            document.forms[0].action = "/ikar/kundesucheform/resetbutton";
            document.forms[0].submit();
        });
    }


    function bedieneGenerateXMLButton() {

        var buttonXML = document.getElementById("generateXMLButtonId");

        buttonXML.addEventListener("click", function () {
            document.forms[0].action = "/ikar/kundesucheform/generatexml";
            document.forms[0].submit();
        });
    }


    function bedieneSucheButton() {

        var sucheButton = document.getElementById("sucheButtonId");

        sucheButton.addEventListener("click", function () {
            document.forms[0].action = "/ikar/kundesucheform/findekunden";
            document.forms[0].submit();
        });
    }

    bedieneResetButton();
    bedieneGenerateXMLButton();
    bedieneSucheButton();

</script>