<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:tiles="http://tiles.apache.org/tags-tiles"
	xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">

	<jsp:directive.page contentType="text/html;charset=UTF-8" />

	<div>
		<c:url var="css_customer" value="/resources/css/customer.css" />
		<link href="${css_customer}" rel="stylesheet" type="text/css" />

		<form:form id="customer_form" method="post" modelAttribute="customerDTO" action="save">
			<div id="page_content">
				<h1>Create Customer</h1>
				<div class="customer_field">
					<form:label path="name">Name:</form:label>
					<form:input id="customerdto_name" path="name" maxLength="100" />
					<form:errors path="name" />
				</div>
				<div class="customer_field">
					<form:label path="phone">Phone:</form:label>
					<form:input id="customerdto_phone" path="phone" maxLength="10" />
					<form:errors path="phone" />
				</div>
				<div class="customer_field">
					<form:label path="email">E-mail:</form:label>
					<form:input id="customerdto_email" path="email" maxLength="100" />
					<form:errors path="email" />
				</div>
				<div class="customer_field">
					<form:label path="address">Address:</form:label>
					<form:textarea id="customerdto_address" path="address" rows="2"
						cols="30" />
					<form:errors path="address" />
				</div>

				<input id="customer_button" type="submit" value="Save" />
			</div>

		</form:form>
	</div>
</jsp:root>
