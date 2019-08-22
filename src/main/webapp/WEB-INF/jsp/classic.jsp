<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
            $( "#tabs" ).tabs();
        } );
    </script>

</head>

<body>
<table width="100%">
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td width="20%" nowrap="nowrap">
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