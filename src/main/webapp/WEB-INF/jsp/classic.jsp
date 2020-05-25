<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <title><tiles:getAsString name="title" /></title>

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script
            src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
            integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
    <script>
        $( function() {
            var dateFormat = { dateFormat: "dd.mm.yy" };
            $( "#datepickeraddkunde" ).datepicker(dateFormat);
            $( "#datepickereditkunde" ).datepicker(dateFormat);
            $( "#datepickergeburtsdatumab" ).datepicker(dateFormat);
            $( "#datepickergeburtsdatumbis" ).datepicker(dateFormat);

            <c:if test="${empty TabNummer}">
                $( "#tabs" ).tabs();
            </c:if>

            <c:if test="${not empty TabNummer}">
                $( "#tabs" ).tabs({
                    active: "${TabNummer}"
                });
            </c:if>
        } );

        $( function() {
            $( "#menu" ).menu({
                items: "> :not(.ui-widget-header)"
            });
        } );
    </script>
    <style>
        body {background-color: #f6f6f6;}
        .ui-menu { width: 320px; }
        .ui-widget-header { padding: 0.2em; }
    </style>
</head>

<body>
<table width="100%" cellpadding="15">
    <tr>
        <td></td>
        <td>
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td width="20%" valign="top">
            <tiles:insertAttribute name="menu" />
        </td>
        <td width="80%">
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>