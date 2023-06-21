<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <script src="js/script_general.js"></script>
    <link rel="stylesheet" type="text/css" href="styles/css_general.css">
</head> 
<body>
    <div class="container">
        <h1>Student Registration - Add</h1>
        <s:form action="save"  method="post">
            <s:textfield label="First Name" name="firstName" required="true" />
            <s:textfield label="Last Name" name="lastName" required="true" />
            <s:textfield label="Email" name="email" required="true" />
            <s:textfield label="Mobile Number" name="mobileNumber" required="true" />    
            <s:submit value="Register" cssClass="submit-button" />
        </s:form>
    </div>
</body>
</html>
