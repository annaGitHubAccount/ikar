<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Wollen Sie wirklich die Produkt Stammdaten speichern?</h1>

<form:form method="post" modelAttribute="produktStammdatenForm" action="/ikar/web/saveproduktstammdaten">
    <table>
        <tr>
            <td>Name :</td>
            <td>${produktStammdatenForm.name}</td>
        </tr>
        <tr>
            <td>Preis :</td>
            <td>${produktStammdatenForm.preis}</td>
        </tr>
        <tr>
            <td>Symbol :</td>
            <td>${produktStammdatenForm.symbol}</td>
        </tr>
        <tr>
            <td>Is Aktiv :</td>
            <td>
                <c:if test="${produktStammdatenForm.aktiv}">
                    <i class="check square outline icon"></i>
                </c:if>
                <c:if test="${not produktStammdatenForm.aktiv}">
                    <i class="square outline icon"></i>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Produkt Art :</td>
            <td>${produktStammdatenForm.produktArt}</td>
        </tr>


        <tr>
            <td></td>
            <td><input type="submit" value="Save" class="ui button"/></td>
        </tr>
    </table>

    <form:hidden path="id"/>
    <form:hidden path="name"/>
    <form:hidden path="preis"/>
    <form:hidden path="aktiv"/>
    <form:hidden path="produktArt"/>
    <form:hidden path="symbol"/>
</form:form>
