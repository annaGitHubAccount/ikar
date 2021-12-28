<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Wollen Sie wirklich die Daten speichern?</h1>

<form:form method="post" modelAttribute="kundeForm" action="/ikar/web/saverolle">


    <table>

        <tr>
            <td>Rollen : </td>

            <td>
                <c:forEach items="${kundeForm.rolleList}" var="rolle">
                       ${rolle.name}
                </c:forEach>
            </td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Save" class="ui button"/></td>
        </tr>

    </table>

    <form:hidden path="kundeId"/>
    <form:hidden path="name" />


</form:form>