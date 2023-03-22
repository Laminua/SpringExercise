<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>

<table border="1" width="90%">
    <caption><h2>List of users</h2></caption>
    <tr><th>Name</th><th>Email</th>
<c:forEach var="user" items="${usersMap.entrySet()}">

    <tr><td>${user.key}</td><td>${user.value}</td>

</c:forEach>
    </tr>
</table>

<a href="addUserForm">Add user</a>
</body>

</html>