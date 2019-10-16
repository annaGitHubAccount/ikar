<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>
    Liste von Rollen
</h1>

<table class="ui celled table striped">

    <tbody>
    <c:forEach var="rolle" items="${rolleList}">
        <tr data-label="Rollen">
            <td> ${rolle.name} </td>
        </tr>
    </c:forEach>
    </tbody>

</table>