<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>

<label>${label}</label>
<input type="text" name="${id}" id="${id}" autocomplete="none">

<script type="text/javascript">
	$("#${id}").datepicker();
</script>