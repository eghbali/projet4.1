<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="cssfile/style.css" media="screen"/>
    <script language="JavaScript"></script>
</head>
<body>
<form name="newLoanType" class="myForm" action="" method="">
    <fieldset>
        <legend> ***new loanType Profile***</legend>
        <br>
        Customer id: <input type="text" name="customer id" required/>

        <br><br>
        <input type="submit" name="Submit" value="Submit" class="myButton">
        <%
            System.out.println(session.getAttribute("submit"));

        %>
    </fieldset>

</form>
</body>
</html>