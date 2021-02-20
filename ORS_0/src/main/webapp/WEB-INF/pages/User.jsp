<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<form:form method="post" modelAttribute="form">
	<div class="container-fluid" style="margin-bottom: 20px;">
		<div class="row">
			<div class="col-md-10 text-dark">

				<div class="model-content">

					<div class="modal-header justify-content-center bg-dark">
						<h5 class="modal-title " id="ModalTitle">
							<c:choose>
								<c:when test="${form.id==0 }">
									<s:message code="label.addUser" />
								</c:when>
								<c:otherwise>
									<s:message code="label.updateUser" />
								</c:otherwise>
							</c:choose>

						</h5>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<h3 class="error justify-content-center">
								<font color="red">${error}</font>
							</h3>
							<h3 class="success  justify-content-center">
								<font color="green">${success}</font>
							</h3>

						</div>
						<fieldset>
							<legend>
								<s:message code="label.peri" />
							</legend>
						</fieldset>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">

									<form:label path="firstName">
										<s:message code="label.firstName">
											<font color="red">*</font>
										</s:message>
									</form:label>
									<form:input path="firstName" class="form-control"
										placeholder="${enterfirstName }" />
									<font color="red"><form:errors path="firstName"
											cssClass="error" /></font>

								</div>
							</div>

							<div class="col-md-6">
								<div class="form-control">
									<form:label path="lastName">
										<s:message code="label.lastName">
											<font color="red">*</font>
										</s:message>
									</form:label>
									<form:input path="lastName" class="form-control"
										placeholder="${enterLastName}" />
									<font color="red"><form:errors path="lastName"
											cssClass="error" /></font>


								</div>
							</div>

							<div class="col-md-6">
								<div class="col-md-6">
									<form:label path="gender">
										<s:message code="label.gender">
											<font color="red">*</font>
										</s:message>
									</form:label>
									<form:select path="gender" class="form-control">
										<form:option value="" label="${selecttime}" />
										<form:option value="Male" label="Male" />
										<form:option value="Female" label="Female" />
									</form:select>
									<font><form:errors path="gender" cssClass="error" /></font>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group">

									<form:label path="dob">
										<s:message code="label.dob" />
										<font color="red">*</font>
									</form:label>
									<form:input path="dob" class="form-control" name="dob"
										id="datepicker" readonly="readonly" placeholder="${enterdob}" />
									<font color="red"><form:errors path="dob"
											cssClass="error"></form:errors></font>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group">
									<form:label path="mobileNo">
										<s:message code="label.mobileNo" />
										<font color="red">*</font>
									</form:label>
									<form:input path="mobileNo" class="form-control"
										placeholder="${enterMobile}" />
									<font color="red"><form:errors path="mobileNo"
											cssClass="error"></form:errors></font>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<form:label path="roleId">
										<s:message code="label.role" />
										<font color="red">*</font>
									</form:label>
									<form:select path="roleId" Class="form-control">

										<form:option value="0" label="${enterRoleName}" />
										<form:options items="${roleList}" itemValue="id"
											itemLabel="roleName" />
									</form:select>
									<font color="red">${errorRole}<form:errors path="roleId"
											cssClass="error" /></font>

								</div>

							</div>


							<fieldset>
								<legend>
									<s:message code="label.acci" />
								</legend>
								<hr></hr>
							</fieldset>
							<div class="form-group">

								<form:label path="login">
									<s:message code="label.email" />
									<s:message code="label.id" />
									<font color="red">*</font>
								</form:label>

								<c:choose>
									<c:when test="${form.id==0}">
										<form:input path="login" class="form-control"
											placeholder="${enteremail}" />
									</c:when>
									<c:otherwise>
										<form:input path="login" class="form-control"
											placeholder="${enteremail}" readonly="true" />
									</c:otherwise>
								</c:choose>
								<font color="red"><form:errors path="login"
										cssClass="error"></form:errors></font>

							</div>


							<div class="form-group">

								<form:label path="password">
									<s:message code="label.password" />
									<font color="red">*</font>
								</form:label>

								<form:input path="password" type="password" class="form-control"
									placeholder="${enterpassword}" />

								<font color="red"><form:errors path="password"
										cssClass="error"></form:errors></font>
							</div>

							<div class="form-group">
								<form:label path="rePassword">
									<s:message code="label.confirmPassword" />
									<font color="red">*</font>
								</form:label>
								<form:input path="rePassword" type="password"
									class="form-control" placeholder="${enterconPassword}" />
								<font color="red">${error1}<form:errors path="rePassword"
										cssClass="error"></form:errors></font>
							</div>



							<div class="row justify-content-center">
								<div class="col-md-0"></div>
								<div class="col-md-3">
									<div class="form-group">
										<button type="submit" class="btn btn-success btn-block"
											name="operation" value="save">
											<s:message code="label.save" />
										</button>
									</div>
								</div>

								<c:choose>
									<c:when test="${form.id==0}">
										<div class="col-md-3">
											<div class="form-group">
												<button type="submit" class="btn btn-danger btn-block"
													name="operation" value="reset">
													<s:message code="label.reset" />
												</button>
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<div class="col-md-3">
											<div class="form-group">
												<button type="submit" class="btn btn-warning btn-block"
													name="operation" value="cancel">
													<s:message code="label.cancel" />
												</button>
											</div>
										</div>

									</c:otherwise>
								</c:choose>

							</div>

							<%-- </form:form>       --%>
						</div>

					</div>


				</div>

			</div>
		</div>

	</div>
</form:form>
<%-- <script src="<c:url value="/resources/css/bootstrap-iso.css"/>"></script>
<script src="<c:url value="/resources/css/jquery-ui.css"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>	

 --%>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'mm/dd/yy',
			defaultDate : "01/01/1985",
			changeMonth : true,
			changeYear : true,
			yearRange : '-35:-18'
		});

	});

	
</script>