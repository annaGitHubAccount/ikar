<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Wollen Sie wirklich die Daten speichern?</h1>

<form:form method="post" modelAttribute="rolle" action="/ikar/web/saverolle">


    <table>

        <tr>
            <td>Rolle : </td>
            <td>${rolle.name}</td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save" class="ui button"/></td>
        </tr>

    </table>

    <form:hidden path="kundeId"/>
    <form:hidden path="id" />
    <form:hidden path="name" />


</form:form>