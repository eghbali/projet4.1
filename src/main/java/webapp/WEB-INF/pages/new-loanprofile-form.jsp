<%@ page import="dataaccess.entity.LoanType" %>
<%@ page import="java.util.List" %>
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
    List<LoanType> loantype = (List<LoanType>) request.getAttribute("LoanList");
    if (loantype != null) {
%>
<p>
<form action="LoanProfileManager" method="post" class="myAlertForm">
    <input type="hidden" name="customer id" value="<%=request.getParameter("customer id")%>">
    <br> first name: <input type="text" name="first name" value="<%=request.getAttribute("firstname")%>" readonly><br>";
    <br>last name: <input type="text" name="last name" value=" <%=request.getAttribute("lastname")%> " readonly><br>";
    <br>LoanType:
    <br>
    <select name="options">
        <%
            for (int i = 0; i < loantype.size(); i++) {
        %>
        <option value="<%=loantype.get(i).getId()%>"><%=loantype.get(i).getName()%>
        </option>
        <%
            }
        %>
    </select>
    <br><br>Amount:<input type="text" name="Amount">
    <br><br>Duration:<input type="text" name="Duration" required>
    <br><br><input type="submit" value="Submit" class="myAlertForm" required>
</form>
<%
    }
%>
</body>
</html>