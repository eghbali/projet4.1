<%@ page import="static logic.LoanProfileManager.selectLoanType" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="cssfile/style.css" media="screen"/>
    <script language="JavaScript"></script>
</head>
<body>
<form name="newLoanType" class="myForm" action="LoanProfileManager" method="get">
    <fieldset>
        <legend> ***new loanType Profile***</legend>
        <br>
        Customer id: <input type="text" name="customer id" required/>
        <br><br>
        <input type="submit" name="Submit" value="Submit" class="myButton">
        <br>
    </fieldset>
</form>
<%
    ArrayList<String> loantype = (ArrayList<String>) request.getAttribute("LoanList");
    if (loantype != null) {
        out.print("<p><form  action=\"LoanProfileManager\" method=\"post\" class=\"myAlertForm\">");
        out.print("<input type=\"hidden\" name=\"customer id\" value=\""+request.getParameter("customer id")+"\">");
        out.print(request.getAttribute("message"));
        out.print("<br>LoanType:<br><select name=\"options\">");
        for (int i = 0; i < loantype.size(); i++) {
            out.print("<option value=\"" + loantype.get(i).split("\\+")[1] + "\">" + loantype.get(i).split("\\+")[0] + "</option>");
        }
        out.print("</select><br><br>Amount:<input type=\"text\" name=\"Amount\" >");
        out.print("<br><br>Duration:<input type=\"text\" name=\"Duration\">");
        out.print("<br><br><input type=\"submit\" value=\"Submit\" class=\"myAlertForm\">");
        out.print("</p></form>");
    }
%>
</body>
</html>