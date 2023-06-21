<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration - Edit</title>
    <script src="js/script_general.js"></script>
    <link rel="stylesheet" type="text/css" href="styles/css_general.css">
</head>
<body>
    <div class="container">
        <h1>Student Registration - Update</h1>
        <s:form action="update"  method="post">
            <s:hidden name="id" value="%{student.id}" />
            <s:textfield name="firstName" label="First Name" value="%{student.firstName}" required="true" /><br>
            <s:textfield name="lastName" label="Last Name" value="%{student.lastName}"  required="true" /><br>
            <s:textfield name="email" label="Email" value="%{student.email}"  required="true" /><br>
            <s:textfield name="mobileNumber" label="Mobile Number" value="%{student.mobileNumber}"  required="true" /><br>
            <s:submit value="Update" cssClass="submit-button" />
        </s:form>
    </div>
</body>
</html>
