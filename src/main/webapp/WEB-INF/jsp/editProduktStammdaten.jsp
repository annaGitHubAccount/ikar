<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Edit Produkt Stammdaten</h1>

<style>
    .error {
        color: red
    }
</style>

<form:form modelAttribute="produktStammdatenForm" action="/ikar/web/produktstammdatenweiterleitenedit">
    <table>
        <tr>
            <td>Name :</td>
            <td>
                <div class="ui input"><form:input path="name"/></div>
            </td>
            <td>
                <form:errors path="name" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Preis :</td>
            <td>
                <div class="ui input"><form:input path="preis"/></div>
            </td>
            <td>
                <form:errors path="preis" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Symbol :</td>
            <td>
                <div class="ui input"><form:input path="symbol"/></div>
            </td>
            <td>
                <form:errors path="symbol" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Is Aktiv :</td>
            <td>
                <form:checkbox path="aktiv" cssClass="ui checkbox"/>
            </td>
        </tr>
        <tr>
            <td>Produkt Art :</td>
            <td>
                <form:radiobuttons path="produktArt" items="${produktArtMap}" cssClass="ui radio checkbox"/>
            </td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>

    <form:hidden path="id"/>
</form:form>