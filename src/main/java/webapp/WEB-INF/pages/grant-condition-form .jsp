<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="cssfile/style.css" media="screen"/>
    <script language="JavaScript"></script>
</head>
<body >
<form name="conditions" class="myForm" action="" method="post">

    <fieldset>
        <legend> ***  Grant Conditions  ***</legend>
            <%= "<input type=\"hidden\" name=\"Loan Name\" value=\" "+request.getParameter("Loan Name") +"\" required/>" %>
            <%= "<input type=\"hidden\" name=\"Loan Name\" value=\" "+request.getParameter("Interest Rate") +"\" required/>" %>
        <form name="condition" class="myForm" action="" onsubmit="showConditions();">
                <br>
                Name: <br><input type="text" name="Condition Name" required/>
                <br><br>
                min Dration : <br> <input type="text" name="min Dration" required/>
                <br><br>
                max Duration : <br><input type="text" name="max Duration" required/>
                <br><br>
                min Amount: <br><input type="text" name="min Amount" required/>
                <br><br>
                max Amount : <br><input type="text" name="max Amount" required/>
                <br><br>
                <input type="submit" value="add more" class="myButton">
        </form>
        <input type="submit" value="Final Submit" class="myButton">
            </fieldset>
        </form>
<p id="demo"></p>

</body>
</html>
<script>
    grantConditions=[];
function showConditions(){
    alert("hello")
    /*
    conditionName = document.forms["condition"]["Condition Name"].value;
    conditionMinDuration = document.forms["condition"]["min Dration"].value;
    conditionMaxDration = document.forms["condition"]["max Duration"].value;
    conditionMinAmount = document.forms["condition"]["min Amount"].value;
    conditionMaxAmount = document.forms["condition"]["max Amount"].value;
*/
    var condition={name:document.forms["condition"]["Condition Name"].value ,
        minDration:document.forms["condition"]["min Dration"].value,
        maxDration:document.forms["condition"]["max Duration"].value,
        minAmount:document.forms["condition"]["min Amount"].value,
        maxAmount:document.forms["condition"]["max Amount"].value };
    grantConditions.push(condition);
    alert(condition);

}
 //   document.getElementById("demo").innerHTML = " <input type=\"button\" value=\"add more\" class=\"myButton\">";
</script>
