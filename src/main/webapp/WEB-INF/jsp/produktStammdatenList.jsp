<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
    .error {
        color: red
    }
</style>

<form:form method="post" modelAttribute="produktStammdatenSucheForm" action="/ikar/produktstammdatensucheform/findeproduktstammdaten">

    <fieldset>
        <legend>Suchmachine</legend>

        <table>

            <tr>
                <td></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><div class="ui input"><form:input path="name"/></div></td>

                <td>Symbol :</td>
                <td><div class="ui input"><form:input path="symbol"/></div></td>
            </tr>

            <tr>
                <td><form:errors path="preisAB" cssClass="error"/></td>
                <td><form:errors path="preisBIS" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Preis ab :</td>
                <td><div class="ui input"><form:input path="preisAB"/></div></td>

                <td>Preis bis :</td>
                <td><div class="ui input"><form:input path="preisBIS"/></div></td>
            </tr>

            <tr>
                <td>Is Aktiv? :</td>
                <td>
                    <form:select path="aktiv">
                        <form:options cssClass="ui dropdown" items="${produktStammdatenSucheForm.isAktivMap}"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td><input type="submit" value="Suche" class="ui button"/></td>
                <td><input type="button" value="Reset" id="resetId" class="ui button"/></td>
                <td colspan="2"></td>
            </tr>

        </table>

    </fieldset>

</form:form>

<h1>
    <c:if test="${empty produktStammdatenList}">
        Es gibt keine Produkt Stammdaten zum zeigen
    </c:if>
    <c:if test="${not empty produktStammdatenList}">
        Liste von Produkt Stammdaten
    </c:if>
</h1>

<c:if test="${not empty produktStammdatenList}">

    <table class="ui celled table striped">

        <thead>
        <tr>
            <th>Name</th>
            <th>Preis</th>
            <th>Symbol</th>
            <th>Is Aktiv ?</th>
            <th colspan="2">Operation</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="produkt" items="${produktStammdatenList}">

            <tr>
                <td data-label="Name">${produkt.name}</td>
                <td data-label="Preis">${produkt.preis}</td>
                <td data-label="Symbol">${produkt.symbol}</td>
                <td data-label="Is Aktiv">
                     <c:if test="${produkt.aktiv}">
                         <i class="green check icon"></i>
                     </c:if>
                    <c:if test="${not produkt.aktiv}">
                        <i class="red x icon"></i>
                    </c:if>
                </td>

                <td data-label="Operation"><a href="/ikar/web/editproduktstammdaten/${produkt.id}">Aendern</a></td>
                <td data-label="Operation"><a href="/ikar/web/deleteproduktstammdaten/${produkt.id}">Loeschen</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</c:if>

<script>

    function bedieneResetButton() {

        var buttonReset = document.getElementById("resetId");

        buttonReset.addEventListener("click", function () {
            document.forms[0].action = "/ikar/produktstammdatensucheform/resetbutton";
            document.forms[0].submit();
        });
    }

    bedieneResetButton();
</script>