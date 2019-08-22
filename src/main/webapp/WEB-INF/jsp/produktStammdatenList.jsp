<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


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
            <th>Is Aktiv ?</th>
            <th colspan="2">Operation</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="produkt" items="${produktStammdatenList}">

            <tr>
                <td data-label="Name">${produkt.name}</td>
                <td data-label="Preis">${produkt.preis}</td>
                <td data-label="Is Aktiv">
                     <c:if test="${produkt.aktiv}">
                         <i class="green check icon"></i>
                     </c:if>
                    <c:if test="${not produkt.aktiv}">
                        <i class="red x icon"></i>
                    </c:if>
                </td>

                <td data-label="Operation"><a href="/web/editproduktstammdaten/${produkt.id}">Aendern</a></td>
                <td data-label="Operation"><a href="/web/deleteproduktstammdaten/${produkt.id}">Loeschen</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</c:if>