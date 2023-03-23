<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>

<table border="1" width="20%" align="center">
    <caption><h2>List of users</h2></caption>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Action</th>

        <c:forEach var="user" items="${usersMap.entrySet()}">

    <tr>
        <td>${user.key}</td>
        <td>${user.value}</td>
        <td>
            <a href="/deleteUser?userNameToDelete=${user.key}">delete</a>
            <a href="/updateUser?userNameToUpdate=${user.key}">update</a>
        </td>

        </c:forEach>

    </tr>
</table>

<a href="/addUserForm"><p style="text-align: center">Add user</p></a>
</body>

</html>