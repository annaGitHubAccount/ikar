<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Edit Kunde</h1>

<form:form modelAttribute="kundeForm" action="/web/kundeweiterleitenedit">

    <table id="outerGlobal">

        <tr>
            <td>

                <table id="innerGlobal1">
                    <tr>
                        <td>

                            <div id="tabs">
                                <ul>
                                    <li><a href="#editkunde">Edit Kunde</a></li>
                                    <li><a href="#meldeanschrift">Meldeanschrift</a></li>
                                    <li><a href="#postanschrift">Postanschrift</a></li>
                                </ul>

                                <div id="editkunde">
                                    <table>
                                        <tr>
                                            <td>
                                                <div class="ui input"><form:hidden path="id"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Steuer ID :</td>
                                            <td>
                                                <div class="ui input"><form:input path="steuerId"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Name :</td>
                                            <td>
                                                <div class="ui input"><form:input path="name"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Nachname :</td>
                                            <td>
                                                <div class="ui input"><form:input path="nachname"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Rolle :</td>
                                            <td>
                                                <div class="ui input"><form:input path="rolle"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Date of Birth :</td>
                                            <td>
                                                <div class="ui input"><form:input path="birthDate"
                                                                                  id="datepickereditkunde"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>KundeArt :</td>
                                            <td><form:select path="kundeArt" cssClass="ui dropdown"
                                                             items="${kundeForm.kundeArtMap}"/></td>
                                        </tr>
                                    </table>

                                </div>

                                <div id="meldeanschrift">
                                    <table>
                                        <tr>
                                            <td>
                                                <h1>Meldeanschrift</h1>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>Land :</td>
                                            <td>
                                                <div class="ui input"><form:input path="landVonMeldeanschrift"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ort :</td>
                                            <td>
                                                <div class="ui input"><form:input path="ortVonMeldeanschrift"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Strasse :</td>
                                            <td>
                                                <div class="ui input"><form:input
                                                        path="strasseVonMeldeanschrift"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Haus Nr. :</td>
                                            <td>
                                                <div class="ui input"><form:input path="hausNrVonMeldeanschrift"/></div>
                                            </td>
                                        </tr>
                                    </table>
                                </div>

                                <div id="postanschrift">
                                    <table>
                                        <tr>
                                            <td><label for="checkboxPostanschriftID">Aktiviere Postanschrift:</label>
                                            </td>
                                            <td><input type="checkbox" id="checkboxPostanschriftID"></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <h1>Postanschrift</h1>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>Land :</td>
                                            <td>
                                                <div class="ui input"><form:input path="landVonPostanschrift"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ort :</td>
                                            <td>
                                                <div class="ui input"><form:input path="ortVonPostanschrift"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Strasse :</td>
                                            <td>
                                                <div class="ui input"><form:input path="strasseVonPostanschrift"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Haus Nr. :</td>
                                            <td>
                                                <div class="ui input"><form:input path="hausNrVonPostanschrift"/></div>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>

                        </td>
                    </tr>

                </table>

            </td>
        </tr>


        <tr>
            <td>
                <table id="innerGlobal2">

                    <tr>
                        <td>Alle Produktstammdaten:</td>
                        <td></td>
                        <td>Produkte von Kunden:</td>
                    </tr>

                    <tr>
                        <td><form:select path="produktStammdatenGewaehlteList" multiple="true" size="10"
                                         items="${kundeForm.produktStammdatenList}" itemValue="symbol"
                                         itemLabel="name"/></td>
                        <td>
                            <input type="button" value=">>" id="buttonNachRechts" class="ui button"/>

                            <br/>
                            <br/>
                            <br/>

                            <input type="button" value="<<" id="buttonNachLinks" class="ui button"/>
                        </td>
                        <td><form:select path="produktGewaehlteList" multiple="true" items="${kundeForm.produktList}"
                                         size="10"
                                         itemValue="symbol" itemLabel="name"/></td>
                    </tr>

                    <tr>
                        <td>
                            <input type="submit" value="Weiter" id="saveId" class="ui button"/>
                        </td>
                    </tr>

                </table>
            </td>
        </tr>

    </table>

</form:form>


<script>

    function checkboxChange() {
        var checkbox = document.getElementById("checkboxPostanschriftID");

        checkbox.addEventListener("change", function () {

            if (checkbox.checked) {
                document.getElementById("landVonPostanschriftID").disabled = false;
                document.getElementById("ortVonPostanschriftID").disabled = false;
                document.getElementById("strasseVonPostanschriftID").disabled = false;
                document.getElementById("hausNrVonPostanschriftID").disabled = false;
            } else {
                document.getElementById("landVonPostanschriftID").disabled = true;
                document.getElementById("ortVonPostanschriftID").disabled = true;
                document.getElementById("strasseVonPostanschriftID").disabled = true;
                document.getElementById("hausNrVonPostanschriftID").disabled = true;
            }
        });
    }

    function bedienebuttonNachRechts() {
        var buttonNachRechts = document.getElementById("buttonNachRechts");

        buttonNachRechts.addEventListener("click", function () {
            document.forms[0].action = "/web/buttonnachrechts";
            document.forms[0].submit();
        })
    }

    function bedieneButtonNachLinks() {
        var buttonNachLinks = document.getElementById("buttonNachLinks");

        buttonNachLinks.addEventListener("click", function () {
            document.forms[0].action = "/web/buttonnachlinks";
            document.forms[0].submit();
        });
    }

    checkboxChange();
    bedienebuttonNachRechts();
    bedieneButtonNachLinks();

</script>
