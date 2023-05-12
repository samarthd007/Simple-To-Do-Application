<%@ include file="common/header.jspf"%>
<body>
<%@ include file="common/navigation/navigation.jspf" %>
<div class="container">
    <h1>Enter To-Do Details</h1>
    <%--@elvariable id="todo" type="com"--%>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input  type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="target">TargetDate</form:label>
            <form:input  type="text" path="target" required="required"/>
            <form:errors path="target" cssClass="text-warning"/>
        </fieldset>
        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done"/>
        <input type="submit" class="btn btn-success">
    </form:form>
    <script src="webjars//jquery//3.6.0//jquery.min.js"></script>
    <script src="webjars//bootstrap//5.1.3//js//bootstrap.min.js"></script>
    <script src="webjars//bootstrap-datepicker//1.9.0//js//bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
        $('#target').datepicker({
            format: 'mm/dd/yyyy',
            startDate: '-3d'
        });
    </script>
</div>
</body>

</html>