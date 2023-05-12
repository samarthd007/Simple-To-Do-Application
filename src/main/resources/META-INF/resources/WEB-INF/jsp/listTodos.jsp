<%@ include file="common/header.jspf"%>
<body>
<%@ include file="common/navigation/navigation.jspf" %>
<div class="container">
    <h1>Welcome ${name}</h1>
    <h2>All your To-Do List </h2>
    <hr>
    <div> <h3> Your To-do are </h3></div>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target </th>
            <th>is Done?</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${toDos}" var="todo">
                 <tr>
                    <td>${todo.description}</td>
                    <td>${todo.target}</td>
                    <td>${todo.done}</td>
                     <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE </a> </td>
                     <td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE </a> </td>
                </tr>

            </c:forEach>
        </tbody>
    </table>
    <script src="webjars//jquery//3.6.0//jquery.min.js"></script>
    <script src="webjars//bootstrap//5.1.3//js//bootstrap.min.js"></script>
    <a href="addtodo" class="btn btn-success">Add-ToDo</a>
</div>
</body>

</html>