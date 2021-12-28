<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<table class="ui celled table striped">

    <h2>Kundenzahl pro Land</h2>

    <thead>
    <tr>
        <th>Land</th>
        <th>Anzahl Von Kunden</th>
    </tr>
    </thead>

    <tbody>
        <c:forEach var="iter" items="${anzahlVonKundenImLand}">

        <tr>
            <td data-label="Land">${iter.land}</td>
            <td data-label="Anzahl Von Kunden">${iter.anzahlVonKunden}</td>
        </tr>

        </c:forEach>
    </tbody>

</table>

<table class="ui celled table striped">

    <h2>Kundezahl pro Produkt</h2>

    <thead>
    <tr>
        <th>Produkt</th>
        <th>Anzahl Von Kunden</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="iter" items="${anzahlVonKundenProProdukt}">

        <tr>
            <td data-label="Produkt">${iter.produktName}</td>
            <td data-label="Anzahl Von Kunden">${iter.anzahlVonKunden}</td>
        </tr>

    </c:forEach>
    </tbody>

</table>