<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Login</title>
    <script src="js/script_general.js"></script>
    <link rel="stylesheet" type="text/css" href="styles/css_general.css">
</head>
<body>
    <div class="container">
        <h1>Student Login</h1>
        <s:form action="login"  method="post">
            <s:textfield label="User ID" name="userId" required="true" />
            <s:password label="Password" name="password" required="true" />
            <s:fielderror fieldName="userId" cssClass="error" />
            <s:submit value="Login" cssClass="submit-button" />
        </s:form>
    </div>
</body>
</html>
