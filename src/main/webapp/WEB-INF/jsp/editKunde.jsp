<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Edit Kunde</h1>

<form:form modelAttribute="kundeForm" action="/ikar/web/kundeweiterleitenedit">

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
                                            <td>Kunde Nummer :</td>
                                            <td>
                                                <div class="ui input"><form:input path="kundeNummer"/></div>
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
                                            <td>Land :</td>
                                            <td>
                                                <form:select path="landVonMeldeanschrift" id="landVonMeldeanschriftID">
                                                    <form:option value="" label="Waehle ein Land"/>
                                                    <form:options items="${kundeForm.landDTOList}" itemValue="symbol" itemLabel="name"/>
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
                                                        <form:select path="bundeslandVonMeldeanschrift" id="bundeslandVonMeldeanschriftID">
                                                            <form:option value="" label="Waehle ein Bundesland"/>
                                                            <form:options items="${kundeForm.bundeslandDTOList}"
                                                                          itemValue="name" itemLabel="name"/>
                                                        </form:select>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>
                                                <form:errors path="bundeslandVonMeldeanschrift" cssClass="ui red label"/>
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
                                                <div class="ui input"><form:input path="postleitzahlVonMeldeanschrift"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="postleitzahlVonMeldeanschrift" cssClass="ui red label"/>
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
                                            <td>Land :</td>
                                            <td>
                                                <form:select path="landVonPostanschrift" id="landVonPostanschriftID" disabled="true">
                                                    <form:option value="" label="Waehle ein Land"/>
                                                    <form:options items="${kundeForm.landDTOList}" itemValue="symbol" itemLabel="name"/>
                                                </form:select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Bundesland :</td>
                                                    <td>
                                                        <form:select path="bundeslandVonPostanschrift" id="bundeslandVonPostanschriftID" disabled="true">
                                                            <form:option value="" label="Waehle ein Bundesland"/>
                                                            <form:options items="${kundeForm.bundeslandDTOListPostanschrift}" itemValue="name" itemLabel="name"/>
                                                        </form:select>
                                                    </td>
                                            <td>
                                                <form:errors path="bundeslandVonPostanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Ort :</td>
                                                    <td>
                                                        <form:select path="ortVonPostanschrift" id="ortVonPostanschriftID" disabled="true">
                                                            <form:option value="" label="Waehle ein Ort"/>
                                                            <form:options items="${kundeForm.ortDTOListPostanschrift}"
                                                                          itemValue="name" itemLabel="name"/>
                                                        </form:select>
                                                    </td>
                                            <td>
                                                <form:errors path="ortVonPostanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Postleitzahl :</td>
                                            <td>
                                                <div class="ui input"><form:input path="postleitzahlVonPostanschrift"
                                                                                  id="postleitzahlVonPostanschriftID" disabled="true"/></div>
                                            </td>
                                            <td>
                                                <form:errors path="postleitzahlVonPostanschrift" cssClass="ui red label"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Strasse :</td>
                                            <td>
                                                <div class="ui input"><form:input path="strasseVonPostanschrift" id= "strasseVonPostanschriftID" disabled="true"/></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Haus Nr. :</td>
                                            <td>
                                                <div class="ui input"><form:input path="hausNrVonPostanschrift" id= "hausNrVonPostanschriftID" disabled="true"/></div>
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
                        <td><form:select path="produktStammdatenList" multiple="true" size="6"
                                         items="${kundeForm.produktStammdatenList}" id="produktStammdaten"/></td>
                        <td>
                            <input type="button" value=">>" id="buttonNachRechts" class="ui button"/>

                            <br/>
                            <br/>
                            <br/>

                            <input type="button" value="<<" id="buttonNachLinks" class="ui button"/>
                        </td>
                        <td><form:select path="produktList" multiple="true" size="6"
                                         items="${kundeForm.produktList}" id="produkten"/></td>
                    </tr>

                    <tr>
                        <td>
                            <input type="submit" value="Weiter" id="weiterButtonID" class="ui button"/>
                        </td>
                    </tr>

                </table>
            </td>
        </tr>

    </table>

</form:form>


<script>

    function checkLandVonPostanschriftChange() {

        let land = document.getElementById("landVonPostanschriftID");

        if(land) {
            land.addEventListener("change", function () {

                sammleAlleProduktstammdatenUndProdukten();

                document.forms[0].action = "/ikar/web/bundeslaenderVonPostanschrift";
                document.forms[0].submit();
            });
        }
    }

    function checkBundeslandVonPostanschriftChange() {

        let bundesland = document.getElementById("bundeslandVonPostanschriftID");

        if(bundesland) {
            bundesland.addEventListener("change", function () {

                sammleAlleProduktstammdatenUndProdukten();

                document.forms[0].action = "/ikar/web/orteVonPostanschrift";
                document.forms[0].submit();
            });
        }
    }

    function checkLandVonMeldeanschriftChange() {

        let land = document.getElementById("landVonMeldeanschriftID");

        if(land) {
            land.addEventListener("change", function () {

                sammleAlleProduktstammdatenUndProdukten();

                document.forms[0].action = "/ikar/web/bundeslaenderVonMeldeanschrift";
                document.forms[0].submit();
            });
        }
    }

    function checkBundeslandVonMeldeanschriftChange() {

        let bundesland = document.getElementById("bundeslandVonMeldeanschriftID");

        if(bundesland) {
            bundesland.addEventListener("change", function () {

                sammleAlleProduktstammdatenUndProdukten();

                document.forms[0].action = "/ikar/web/orteVonMeldeanschrift";
                document.forms[0].submit();
            });
        }
    }

    function checkboxChange() {
        var checkbox = document.getElementById("checkboxPostanschriftID");

        checkbox.addEventListener("change", function () {

            if (checkbox.checked) {
                document.getElementById("landVonPostanschriftID").disabled = false;
                document.getElementById("bundeslandVonPostanschriftID").disabled = false;
                document.getElementById("ortVonPostanschriftID").disabled = false;
                document.getElementById("postleitzahlVonPostanschriftID").disabled = false;
                document.getElementById("strasseVonPostanschriftID").disabled = false;
                document.getElementById("hausNrVonPostanschriftID").disabled = false;
            } else {
                document.getElementById("landVonPostanschriftID").disabled = true;
                document.getElementById("bundeslandVonPostanschriftID").disabled = true;
                document.getElementById("ortVonPostanschriftID").disabled = true;
                document.getElementById("postleitzahlVonPostanschriftID").disabled = true;
                document.getElementById("strasseVonPostanschriftID").disabled = true;
                document.getElementById("hausNrVonPostanschriftID").disabled = true;
            }
        });
    }

    function bedienebuttonNachRechts() {

        var buttonNachRechts = document.getElementById("buttonNachRechts");

        let produktStammdatenSelect = document.getElementById("produktStammdaten");
        let produktStammdatenOptions = produktStammdatenSelect.options;

        let produktenSelect = document.getElementById("produkten");

        if (buttonNachRechts) {
            buttonNachRechts.addEventListener("click", function () {

                let selectedProduktStammdaten = [];

                for (let i = 0; i < produktStammdatenOptions.length; i++) {
                    let produktStammdatenOption = produktStammdatenOptions[i];
                    if (produktStammdatenOption.selected) {
                        selectedProduktStammdaten.push(produktStammdatenOption);
                    }
                }

                for (let i = 0; i < selectedProduktStammdaten.length; i++) {
                    let selectedProduktStammdatenElement = selectedProduktStammdaten[i];
                    produktStammdatenSelect.removeChild(selectedProduktStammdatenElement);
                    produktenSelect.appendChild(selectedProduktStammdatenElement);
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

                let selectedProdukten = [];

                for (let i = 0; i < produktenOptions.length; i++) {
                    let produktenOption = produktenOptions[i];
                    if (produktenOption.selected) {
                        selectedProdukten.push(produktenOption);
                    }
                }

                for (let i = 0; i < selectedProdukten.length; i++) {
                    let selectedProduktenElement = selectedProdukten[i];
                    produktenSelect.removeChild(selectedProduktenElement);
                    produktStammdatenSelect.appendChild(selectedProduktenElement);
                }
            });
        }
    }

    function sammelnGewahlteProdukten() {

        let buttonWeiter = document.getElementById("weiterButtonID");
        let produktenSelect = document.getElementById("produkten");
        let produktenOptions = produktenSelect.options;

        buttonWeiter.onclick = function(){

            for (let i = 0; i < produktenOptions.length; i++) {
                let produktOption = produktenOptions[i];
                produktOption.selected = true;
            }
        }
    }

    function sammleAlleProduktstammdatenUndProdukten(){

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

    checkboxChange();
    bedienebuttonNachRechts();
    bedieneButtonNachLinks();
    checkLandVonMeldeanschriftChange();
    checkBundeslandVonMeldeanschriftChange();
    checkLandVonPostanschriftChange();
    checkBundeslandVonPostanschriftChange();
    sammleAlleProduktstammdatenUndProdukten();
    sammelnGewahlteProdukten();

</script>
