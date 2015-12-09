<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="cssfile/style.css" media="screen"/>
    <script language="JavaScript"></script>
</head>
<body>
<form name="newcustomer" class="myForm" action="ManageNewCustomer" METHOD="post" onsubmit="return CheckNationalCode();">
    <fieldset>
        <legend> ***new customer***</legend>
        First name:<br> <input type="text" name="first_name" required/>
        <br><br>
        Last name: <br><input type="text" name="last_name" required/>
        <br><br>
        Father name:<br> <input type="text" name="father_name" required/>
        <br><br>
        National code:<br> <input type="text" name="national_code" required/>
        <br><br>
        Birth date: <br><input type="date" name="birth_date" min="2000-01-02" required/><br>
        <br>
        <br>
        <input type="submit" value="Submit" class="myButton">


    </fieldset>

</form>
<script>
    function CheckNationalCode() {

        var nationalcode = document.forms["newcustomer"]["national_code"].value;
        if (nationalcode.length != 10) {
            alert("National code must have 10 digit");
            return false;
        }
        var sum = 0;
        for (i = 0; i < 9; i++) {
            sum = sum + parseInt(nationalcode.charAt(i)) * (i + 1);
        }
        var remainder = sum % 11;
        if (remainder != nationalcode.charAt(9) && remainder != 11 - nationalcode.charAt(9)) {
            alert("Invalid National Code");
            return false;
        }

    }
</script>
</body>
</html>