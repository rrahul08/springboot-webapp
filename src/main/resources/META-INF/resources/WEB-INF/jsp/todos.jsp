<%@include file="common/header.jspf"%>
<%@include  file="common/navigation.jspf" %>
<div class="container">
<div>Your todos are</div>
    <table class="table">
        <thead>
          <tr>
              <th>description</th>
              <th>targetdate</th>
              <th>Is Done ?</th>
              <th></th>
              <th></th>
          </tr>
        </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
    <tr>
        <td>${todo.description}</td>
        <td >${todo.targetdate}</td>
        <td>${todo.done}</td>
        <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete </a> </td>
        <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update </a></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
<a href="add-todos" class="btn btn-success">Add Todo</a>

</div>
<%@include file="common/footer.jspf"%>