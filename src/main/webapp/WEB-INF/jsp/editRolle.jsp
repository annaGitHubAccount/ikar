<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Edit Rolle</h1>

<form:form modelAttribute="rolle" action="/web/rolleweiterleitenedit">

    <table>
        <tr>
            <td>
                <div class="ui input"><form:hidden path="id"/></div>
            </td>
        </tr>
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

</form:form>