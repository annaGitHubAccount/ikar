<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<h1>
    Rollen
</h1>


<form:form method="post" modelAttribute="kundeForm" action="/ikar/web/rolleweiterleiten">

    <table>

        <tr>
            <td>Alle Rollestammdaten:</td>
            <td></td>
            <td>Rollen von Kunden:</td>
        </tr>

        <tr>
            <td><form:select path="rolleStammdatenGewaehlteList" multiple="true"
                             items="${kundeForm.rolleStammdatenList}"
                             itemValue = "name"
                             itemLabel="name" size="6"/></td>
            <td>
                <input type="button" value=">>" id="buttonNachRechts" class="ui button"/>

                <br/>
                <br/>
                <br/>

                <input type="button" value="<<" id="buttonNachLinks" class="ui button"/>
            </td>
            <td><form:select path="rolleGewaehlteList" multiple="true"
                             items="${kundeForm.rolleList}"
                             itemValue = "name"
                             itemLabel="name" size="6"/></td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="Weiter" id="weiterId" class="ui button"/>
            </td>
        </tr>

    </table>

<%--    <input type="hidden" name="rolle" value="${rolleDTO}"/>--%>
    <form:hidden path="kundeId" />

</form:form>


<script>

    function bedienebuttonNachRechts() {
        var buttonNachRechts = document.getElementById("buttonNachRechts");

        buttonNachRechts.addEventListener("click", function () {
            document.forms[0].action = "/ikar/web/rollebuttonnachrechts";
            document.forms[0].submit();
        })
    }

    function bedieneButtonNachLinks() {
        var buttonNachLinks = document.getElementById("buttonNachLinks");

        buttonNachLinks.addEventListener("click", function () {
            document.forms[0].action = "/ikar/web/rollebuttonnachlinks";
            document.forms[0].submit();
        });
    }

    bedienebuttonNachRechts();
    bedieneButtonNachLinks();

</script>