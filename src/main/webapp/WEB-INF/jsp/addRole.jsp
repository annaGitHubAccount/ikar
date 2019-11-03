<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Add Rolle</h1>

<form:form method="post" modelAttribute="rolle" action="/web/rolleweiterleiten">

<table>
    <tr>
        <td>Rolle :</td>
        <td>
            <div class="ui input"><form:input path="name"/></div>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Weiter" id="weiterId" class="ui button"/>
        </td>
    </tr>
</table>

    <form:hidden path="kundeId"/>
</form:form>