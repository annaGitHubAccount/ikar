<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Kunde Statistik</h1>

<table class="ui celled table striped">

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