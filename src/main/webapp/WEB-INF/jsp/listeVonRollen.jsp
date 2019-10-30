<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<h1>
    Liste von Rollen
</h1>


<table class="ui celled table striped">

    <thead>
    <tr>
        <th>Rolle</th>
        <th colspan="2">Operation</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="rolle" items="${rolleList}">
        <tr>
            <td data-label="Rolle">${rolle.name}</td>
            <td data-label="Operation"><a href="/web/editrolle/${rolle.id}">Aendern</a></td>
            <td data-label="Operation"><a href="/web/deleterolle/${rolle.id}">Loeschen</a></td>
        </tr>
    </c:forEach>

    </tbody>

</table>


<form:form method="post" modelAttribute="rolle" action="/web/addrole">

    <form:hidden path="kundeId"/>

    <table>
        <tr>
            <td><input type="submit" value="Fuege Rolle hinzu" id="rolleHinzufuegenId" class="ui button"/></td>
        </tr>
    </table>
</form:form>