<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students Listing</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .action-buttons {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .action-buttons button {
            padding: 6px 12px;
            margin-left: 5px;
            cursor: pointer;
        }

        .submit-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            }

            .submit-button:hover {
            background-color: #45a049;
            }

            .submit-button:active {
            background-color: #3e8e41;
            }

    </style>
</head>
<body>
    <div class="container">
        <h1>Students Listing</h1>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Mobile Number</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.email}</td>
                    <td>${student.mobileNumber}</td>
                  
                    <td class="action-buttons">
                        <form action="load" method="post">
                            <input type="hidden" name="id" value="${student.id}">
                            <button type="submit" cssClass="submit-button">Update</button>
                        </form>
                        <form action="delete" method="post">
                            <input type="hidden" name="id" value="${student.id}">
                            <button type="submit" cssClass="submit-button">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <th colspan="5" align="right"><form action="register" method="post"><button type="submit" cssClass="submit-button">Register</button></form></th>
            </tr>
        </table>
    </div>
</body>
</html>
