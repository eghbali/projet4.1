<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="cssfile/style.css" media="screen"/>
    <script language="JavaScript"></script>
</head>
<body>
<form name="conditions" class="myForm" action="LoanTypeManagerServlet" method="post">
    <%= "  Loan Name: " + request.getParameter("Loan Name") +
            "                  Interest Rate:" +
            request.getParameter("Interest Rate")%>
    <br><br>
    <fieldset>
        <legend> *** Grant Conditions ***</legend>
        <%= "<input type=\"hidden\" name=\"Loan Name\" value=\" " + request.getParameter("Loan Name") + "\" required/>" %>
        <%= "<input type=\"hidden\" name=\"Interest Rate\" value=\" " + request.getParameter("Interest Rate") + "\" required/>" %>
        <br>
        Name: <br><input type="text" name="Condition Name" required/>
        <br><br>
        min Duration : <br> <input type="text" name="min Duration" required/>
        <br><br>
        max Duration : <br><input type="text" name="max Duration" required/>
        <br><br>
        min Amount: <br><input type="text" name="min Amount" required/>
        <br><br>
        max Amount : <br><input type="text" name="max Amount" required/>
        <br><br>
        <input type="button" value="add " class="myButton" onclick="showConditions()">
    </fieldset>
    <p id="output"></p>
</form>
<p id="table"></p>
</body>
</html>
<script>
    var condition="";
    var conditions = "<tr> <th>Condition Name </th><th> min Duration</th><th> max Duration</th><th>min Amount </th><th> max Amount</th></tr>";
    grantConditions = [];
    function showConditions() {

        if (document.forms["conditions"]["Condition Name"].value == "" || document.forms["conditions"]["min Duration"].value == ""
                || document.forms["conditions"]["max Duration"].value == "" || document.forms["conditions"]["min Amount"].value == ""
                || document.forms["conditions"]["max Amount"].value == "") {
            alert("Error: empty fields");
        }

        else {
             condition+= document.forms["conditions"]["Condition Name"].value +"*"+ document.forms["conditions"]["min Duration"].value +"*"+
                     document.forms["conditions"]["max Duration"].value +"*"+ document.forms["conditions"]["min Amount"].value +"*"+
                     document.forms["conditions"]["max Amount"].value+"+" ;
            var newCondition = "";
            newCondition += "<tr>" + "<td>" + document.forms["conditions"]["Condition Name"].value + "</td>";
            newCondition += "<td>" + document.forms["conditions"]["min Duration"].value + "</td>";
            newCondition += "<td>" + document.forms["conditions"]["max Duration"].value + "</td>";
            newCondition += "<td>" + document.forms["conditions"]["min Amount"].value + "</td>";
            newCondition += "<td>" + document.forms["conditions"]["max Amount"].value + "<tr>" + "</td>";
            conditions += newCondition;
            document.forms["conditions"]["Condition Name"].value = "";
            document.forms["conditions"]["min Duration"].value = "";
            document.forms["conditions"]["max Duration"].value = "";
            document.forms["conditions"]["min Amount"].value = "";
            document.forms["conditions"]["max Amount"].value = "";

            document.getElementById('table').innerHTML = "<table>" + conditions +
                    "</table>" + "<br> <input type=\"button\" value=\"Final Submit\" class=\"myButton\"  onclick='submitFunction()'>";
        }

    }
    function submitFunction() {
        document.getElementById('output').innerHTML ="<input type=\"hidden\" name=\"output\" value=\""+condition+"\"/>";
        document.conditions.submit();
    }
</script>
