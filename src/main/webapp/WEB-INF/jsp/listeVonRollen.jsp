<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>
    Liste von Rollen
</h1>

<table class="ui celled table striped">

    <tbody>
    <c:forEach var="rolle" items="${rolleList}">
        <td data-label="Rollen">${rolle.name}</td>
    </c:forEach>
    </tbody>

</table>