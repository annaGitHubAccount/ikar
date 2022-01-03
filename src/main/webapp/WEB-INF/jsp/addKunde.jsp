<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
    .error {
        color: red
    }
</style>

<form:form method="post" modelAttribute="kundeForm" action="/ikar/web/kundeweiterleiten">

    <table id="outerGlobal">

        <tr>
            <td>

                <table id="innerGlobal1">
                    <tr>
                        <td>

                            <div id="tabs">
                                <ul>
                                    <li><a href="#kunde">Fuege neuen Kunden hinzu</a></li>
                                    <li><a href="#meldeanschrift">Meldeanschrift</a></li>
                                    <li><a href="#postanschrift">Postanschrift</a></li>
                                </ul>

                                <div id="kunde">
                                    <table>
                                        <tr>
                                            <td>Steuer ID :</td>
                                            <td>
                                                <div class="ui input"><form:input path="steuerId"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="steuerId" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Name :</td>
                                            <td>
                                                <div class="ui input"><form:input path="name"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="name" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Nachname :</td>
                                            <td>
                                                <div class="ui input"><form:input path="nachname"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="nachname" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Rolle :</td>
                                            <td>
                                                <div class="ui input"><form:input path="rolle"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="rolle" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Geburtsdatum :</td>
                                            <td>
                                                <div class="ui input"><form:input path="birthDate"
                                                                                  id="datepickeraddkunde"
                                                                                  autocomplete="false"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="birthDate" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>KundeArt :</td>
                                            <td>
                                                <form:select path="kundeArt" cssClass="ui dropdown"
                                                             items="${kundeForm.kundeArtMap}"/>
                                            </td>
                                            <td>
                                                <form:errors path="kundeArt" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                    </table>
                                </div>

                                <div id="meldeanschrift">
                                    <table>
                                        <tr>
                                            <td>Land :</td>
                                            <td>
                                                <form:select path="landVonMeldeanschrift" id="landVonMeldeanschriftID">
                                                    <form:option value="" label="Waehle ein Land"/>
                                                    <form:options items="${kundeForm.landDTOList}" itemValue="symbol"
                                                                  itemLabel="name"/>
                                                </form:select>
                                            </td>
                                            <td>
                                                <form:errors path="landVonMeldeanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Bundesland :</td>
                                            <c:choose>
                                                <c:when test="${empty kundeForm.bundeslandDTOList}">
                                                    <td>
                                                        <select disabled="true">
                                                           <option>Waehle ein Bundesland</option>
                                                        </select>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>
                                                        <form:select path="bundeslandVonMeldeanschrift"
                                                                     id="bundeslandVonMeldeanschriftID">
                                                            <form:option value="" label="Waehle ein Bundesland"/>
                                                            <form:options items="${kundeForm.bundeslandDTOList}"
                                                                          itemValue="name" itemLabel="name"/>
                                                        </form:select>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <form:errors path="bundeslandVonMeldeanschrift"
                                                             cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ort :</td>
                                            <c:choose>
                                                <c:when test="${empty kundeForm.ortDTOList}">
                                                    <td>
                                                        <select disabled="true">
                                                            <option>Waehle ein Ort</option>
                                                        </select>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>
                                                        <form:select path="ortVonMeldeanschrift">
                                                            <form:option value="" label="Waehle ein Ort"/>
                                                            <form:options items="${kundeForm.ortDTOList}"
                                                                          itemValue="name" itemLabel="name"/>
                                                        </form:select>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <form:errors path="ortVonMeldeanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Postleitzahl :</td>
                                            <td>
                                                <div class="ui input"><form:input
                                                        path="postleitzahlVonMeldeanschrift"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="postleitzahlVonMeldeanschrift"
                                                             cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Strasse :</td>
                                            <td>
                                                <div class="ui input"><form:input
                                                        path="strasseVonMeldeanschrift"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="strasseVonMeldeanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Haus Nr. :</td>
                                            <td>
                                                <div class="ui input"><form:input path="hausNrVonMeldeanschrift"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="hausNrVonMeldeanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                    </table>
                                </div>

                                <div id="postanschrift">
                                    <table>
                                        <tr>
                                            <td>
                                                <h1>Postanschrift</h1>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><label for="checkboxPostanschriftID">Aktiviere Postanschrift:</label>
                                            </td>
                                            <td>
                                                <form:checkbox path="postanschriftAktiv" id="checkboxPostanschriftID"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Land :</td>
                                            <td>
                                                <form:select path="landVonPostanschrift" id="landVonPostanschriftID"
                                                             disabled="true">
                                                    <form:option value="0" label="Waehle ein Land"/>
                                                    <form:options items="${kundeForm.landDTOListPostanschrift}"
                                                                  itemLabel="name" itemValue="symbol"/>
                                                </form:select>
                                            </td>
                                            <td>
                                                <form:errors path="landVonPostanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Bundesland :</td>
                                            <c:choose>
                                                <c:when test="${empty kundeForm.bundeslandDTOListPostanschrift}">
                                                    <td>
                                                        <select disabled="true">
                                                            <option>Waehle ein Bundesland</option>
                                                        </select>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>
                                                        <form:select path="bundeslandVonPostanschrift"
                                                                     id="bundeslandVonPostanschriftID" disabled="true">
                                                            <form:option value="" label="Waehle ein Bundesland"/>
                                                            <form:options
                                                                    items="${kundeForm.bundeslandDTOListPostanschrift}"
                                                                    itemValue="name" itemLabel="name"/>
                                                        </form:select>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <form:errors path="bundeslandVonPostanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ort :</td>
                                            <c:choose>
                                                <c:when test="${empty kundeForm.ortDTOListPostanschrift}">
                                                    <td>
                                                        <select disabled="true">
                                                            <option>Waehle ein Ort</option>
                                                        </select>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>
                                                        <form:select path="ortVonPostanschrift"
                                                                     id="ortVonPostanschriftID" disabled="true">
                                                            <form:option value="" label="Waehle ein Ort"/>
                                                            <form:options items="${kundeForm.ortDTOListPostanschrift}"
                                                                          itemValue="name" itemLabel="name"/>
                                                        </form:select>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <form:errors path="ortVonPostanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Postleitzahl :</td>
                                            <td>
                                                <div class="ui input"><form:input path="postleitzahlVonPostanschrift"
                                                                                  id="postleitzahlVonPostanschriftID"
                                                                                  disabled="true"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="postleitzahlVonPostanschrift"
                                                             cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Strasse :</td>
                                            <td>
                                                <div class="ui input"><form:input path="strasseVonPostanschrift"
                                                                                  id="strasseVonPostanschriftID"
                                                                                  disabled="true"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="strasseVonPostanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Haus Nr. :</td>
                                            <td>
                                                <div class="ui input"><form:input path="hausNrVonPostanschrift"
                                                                                  id="hausNrVonPostanschriftID"
                                                                                  disabled="true"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="hausNrVonPostanschrift" cssClass="ui red label"/>
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
                <fieldset>
                    <legend>Produkte</legend>

                    <table id="innerGlobal2">

                        <tr>

                            <td>Alle Produktstammdaten:</td>
                            <td></td>
                            <td>Produkte von Kunden:</td>

                        </tr>

                        <tr>
                            <td><form:select path="produktStammdatenList" multiple="true"
                                             items="${kundeForm.produktStammdatenList}"
                                             size="6" id="produktStammdaten"/></td>
                            <td>
                                <input type="button" value=">>" id="buttonNachRechts" class="ui button"/>

                                <br/>
                                <br/>
                                <br/>

                                <input type="button" value="<<" id="buttonNachLinks" class="ui button"/>
                            </td>
                            <td><form:select path="produktList" multiple="true"
                                             items="${kundeForm.produktList}"
                                             size="6" id="produkten"/></td>
                        </tr>

                        <tr>
                            <td>
                                <input type="submit" value="Weiter" id="weiterButtonID" class="ui button"/>
                            </td>
                        </tr>

                    </table>
                </fieldset>
            </td>
        </tr>
        <tr>
            <td>
                <br/>
                <input type="button" value="Abbrechen" id="buttonAbbrechen" class="ui button"/>
            </td>
        </tr>


    </table>

</form:form>


<script>

    function checkLandVonPostanschriftChange() {

        let land = document.getElementById("landVonPostanschriftID");

        if (land) {
            land.addEventListener("change", function () {

                sammleAlleProduktstammdatenUndProdukten();

                document.forms[0].action = "/ikar/web/bundeslaenderVonPostanschrift";
                document.forms[0].submit();
            });
        }
    }

    function checkBundeslandVonPostanschriftChange() {

        let bundesland = document.getElementById("bundeslandVonPostanschriftID");

        if (bundesland) {
            bundesland.addEventListener("change", function () {

                sammleAlleProduktstammdatenUndProdukten();

                document.forms[0].action = "/ikar/web/orteVonPostanschrift";
                document.forms[0].submit();
            });
        }
    }

    function checkLandVonMeldeanschriftChange() {

        let land = document.getElementById("landVonMeldeanschriftID");

        if (land) {
            land.addEventListener("change", function () {

                sammleAlleProduktstammdatenUndProdukten();

                document.forms[0].action = "/ikar/web/bundeslaenderVonMeldeanschrift";
                document.forms[0].submit();
            });
        }
    }

    function checkBundeslandVonMeldeanschriftChange() {

        let bundesland = document.getElementById("bundeslandVonMeldeanschriftID");

        if (bundesland) {
            bundesland.addEventListener("change", function () {

                sammleAlleProduktstammdatenUndProdukten();

                document.forms[0].action = "/ikar/web/orteVonMeldeanschrift";
                document.forms[0].submit();
            });
        }
    }

    function checkboxChange() {

        isCheckboxChecked();

        let checkbox = document.getElementById("checkboxPostanschriftID");
        checkbox.addEventListener("change", function () {
            isCheckboxChecked();
        });
    }

    function isCheckboxChecked() {

        let checkbox = document.getElementById("checkboxPostanschriftID");

        if (checkbox.checked) {

            document.getElementById("landVonPostanschriftID").disabled = false;

            let bundeslandVonPostanschriftID = document.getElementById("bundeslandVonPostanschriftID");
            if (bundeslandVonPostanschriftID) {
                bundeslandVonPostanschriftID.disabled = false;
            }

            let ortVonPostanschriftID = document.getElementById("ortVonPostanschriftID");
            if (ortVonPostanschriftID) {
                ortVonPostanschriftID.disabled = false;
            }

            document.getElementById("postleitzahlVonPostanschriftID").disabled = false;
            document.getElementById("strasseVonPostanschriftID").disabled = false;
            document.getElementById("hausNrVonPostanschriftID").disabled = false;

        } else {
            document.getElementById("landVonPostanschriftID").disabled = true;

            let bundeslandVonPostanschriftID = document.getElementById("bundeslandVonPostanschriftID");
            if (bundeslandVonPostanschriftID) {
                bundeslandVonPostanschriftID.disabled = true;
            }

            let ortVonPostanschriftID = document.getElementById("ortVonPostanschriftID");
            if (ortVonPostanschriftID) {
                ortVonPostanschriftID.disabled = true;
            }

            document.getElementById("postleitzahlVonPostanschriftID").disabled = true;
            document.getElementById("strasseVonPostanschriftID").disabled = true;
            document.getElementById("hausNrVonPostanschriftID").disabled = true;
        }
    }


    function bedienebuttonNachRechts() {

        let buttonNachRechts = document.getElementById("buttonNachRechts");

        let produktStammdatenSelect = document.getElementById("produktStammdaten");
        let produktStammdatenOptions = produktStammdatenSelect.options;

        let produktenSelect = document.getElementById("produkten");

        if (buttonNachRechts) {
            buttonNachRechts.addEventListener("click", function () {

                let selectedProduktStammdatenMap = new Map();

                let selectedProduktStammdaten = [];

                for (let i = 0; i < produktStammdatenOptions.length; i++) {
                    let produktStammdatenOption = produktStammdatenOptions[i];
                    if (produktStammdatenOption.selected) {
                        selectedProduktStammdatenMap.set(produktStammdatenOption.value, produktStammdatenOption.text);
                        selectedProduktStammdaten.push(produktStammdatenOption);
                    }
                }

                for (let i = 0; i < selectedProduktStammdaten.length; i++) {
                    produktStammdatenSelect.removeChild(selectedProduktStammdaten[i]);
                }

                // Map iteration
                for (let [key, value] of selectedProduktStammdatenMap) {
                    let htmlOptionElement = document.createElement("option");
                    htmlOptionElement.value = key;
                    htmlOptionElement.innerHTML = value;
                    produktenSelect.appendChild(htmlOptionElement);
                }

            });
        }
    }

    function bedieneButtonNachLinks() {

        var buttonNachLinks = document.getElementById("buttonNachLinks");

        let produktenSelect = document.getElementById("produkten");
        let produktenOptions = produktenSelect.options;

        let produktStammdatenSelect = document.getElementById("produktStammdaten");

        if (buttonNachLinks) {
            buttonNachLinks.addEventListener("click", function () {

                let selectedProduktMap = new Map();

                let selectedProdukten = [];

                for (let i = 0; i < produktenOptions.length; i++) {
                    let produktenOption = produktenOptions[i];
                    if (produktenOption.selected) {
                        selectedProduktMap.set(produktenOption.value, produktenOption.text);
                        selectedProdukten.push(produktenOption);
                    }
                }

                for (let i = 0; i < selectedProdukten.length; i++) {
                    produktenSelect.removeChild(selectedProdukten[i]);
                }

                // Map iteration
                for (let [key, value] of selectedProduktMap) {
                    let htmlOptionElement = document.createElement("option");
                    htmlOptionElement.value = key;
                    htmlOptionElement.innerHTML = value;
                    produktStammdatenSelect.appendChild(htmlOptionElement);
                }

            });
        }
    }

    function bedieneButtonAbbrechen() {
        var buttonAbbrechen = document.getElementById("buttonAbbrechen");

        if (buttonAbbrechen) {
            buttonAbbrechen.onclick = function () {
                document.forms[0].action = "/ikar/kundesucheform/listevonkunden";
                document.forms[0].submit();
            };
        }
    }

    function sammelnGewahlteProdukten() {

        let buttonWeiter = document.getElementById("weiterButtonID");
        let produktenSelect = document.getElementById("produkten");
        let produktenOptions = produktenSelect.options;

        buttonWeiter.onclick = function () {

            for (let i = 0; i < produktenOptions.length; i++) {
                let produktOption = produktenOptions[i];
                produktOption.selected = true;
            }
        }
    }

    function sammleAlleProduktstammdatenUndProdukten() {

        let produktStammdatenSelect = document.getElementById("produktStammdaten");
        let produktStammdatenOptions = produktStammdatenSelect.options;

        for (let i = 0; i < produktStammdatenOptions.length; i++) {
            let produktStammdatenOption = produktStammdatenOptions[i];
            produktStammdatenOption.selected = true;
        }


        let produktenSelect = document.getElementById("produkten");
        let produktenOptions = produktenSelect.options;

        for (let i = 0; i < produktenOptions.length; i++) {
            let produktOption = produktenOptions[i];
            produktOption.selected = true;
        }
    }


    window.onload = function () {
        checkboxChange();
        bedienebuttonNachRechts();
        bedieneButtonNachLinks();
        bedieneButtonAbbrechen();
        checkLandVonMeldeanschriftChange();
        checkBundeslandVonMeldeanschriftChange();
        checkLandVonPostanschriftChange();
        checkBundeslandVonPostanschriftChange();
        sammelnGewahlteProdukten();
        sammleAlleProduktstammdatenUndProdukten();
    }
</script>
