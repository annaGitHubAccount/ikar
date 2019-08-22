<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


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