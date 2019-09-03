<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<form:form method="post" modelAttribute="kundeSucheForm" action="/web/findekunden">

    <fieldset>
        <legend>Suchmachine</legend>

        <table>

            <tr>
                <td>Steuer ID :</td>
                <td>
                    <div class="ui input"><form:input path="steuerId"/></div>
                </td>

                <td>Nachname :</td>
                <td>
                    <div class="ui input"><form:input path="nachname"/></div>
                </td>
                <td></td>

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
                    <div class="ui input"><form:input path="geburtsdatumAB" id="datepickergeburtsdatumab"/></div>
                </td>

                <td>Geburtsdatum bis:</td>
                <td>
                    <div class="ui input"><form:input path="geburtsdatumBIS" id="datepickergeburtsdatumbis"/></div>
                </td>
            </tr>

            <tr>
                <td><input type="submit" value="Suche" class="ui button"/></td>
                <td><input type="button" value="Reset" id="resetId" class="ui button"/></td>
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
            <th>Steuer ID</th>
            <th>Name</th>
            <th>Nachname</th>
            <th>Geburtsdatum</th>
            <th>KundeArt</th>
            <th colspan="2">Operation</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="kunde" items="${kundeList}">

            <tr>
                <td data-label="Steuer ID">${kunde.steuerId}</td>
                <td data-label="Name">${kunde.name}</td>
                <td data-label="Nachname">${kunde.nachname}</td>

                <fmt:parseDate value="${kunde.birthDate}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
                <fmt:formatDate value="${parsedDate}" var="formattedBirthDate" type="date" pattern="dd.MM.yyyy"/>
                <td data-label="Geburtsdatum">${formattedBirthDate}</td>

                <td data-label="KundeArt">${kunde.kundeArt.text}</td>

                <td data-label="Operation"><a href="/web/editkunde/${kunde.id}">Aendern</a></td>
                <td data-label="Operation"><a href="/web/deletekunde/${kunde.id}">Loeschen</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</c:if>

<script>

    function bedieneResetButton() {

        var buttonReset = document.getElementById("resetId");

        buttonReset.addEventListener("click", function () {
            document.forms[0].action = "/web/resetbutton";
            document.forms[0].submit();
        });
    }

    bedieneResetButton();

</script>