<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<sf:form method="post" modelAttribute="form">

	<div class="container-fluid" style="margin-bottom: 20px;">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-8 text-dark">

				<div class="modal-content" style="">

					<div class="modal-header justify-content-center bg-dark">
						<h5 class="modal-title " id="ModalTitle">
							<c:choose>
								<c:when test="${form.id==0}">
									<s:message code="label.addtimetable" />
								</c:when>
								<c:otherwise>
									<s:message code="label.updatetimetable"></s:message>
								</c:otherwise>
							</c:choose>


						</h5>
					</div>


					<div class="modal-body">

						<div class="form-group">
							<h3 class="error justify-content-center  text-center ">
								<font color="red">${error}</font>
							</h3>
							<h3 class="success justify-content-center  text-center ">
								<font color="green"> ${success}</font>
							</h3>
						</div>

						<div class="row">


							<div class="col-md-12">
								<div class="form-group">
									<sf:hidden path="id" />
									<sf:hidden path="createdBy" />
									<sf:hidden path="modifiedBy" />
									<sf:hidden path="createdDatetime" />
									<sf:hidden path="modifiedDatetime" />

								</div>
							</div>

							<div class="col-md-12">
								<div class="form-group">
									<s:message code="label.select" var="coursename"></s:message>
									<sf:label path="courseId">
										<s:message code="label.course"></s:message>
										<font color="red">*</font>
									</sf:label>
									<sf:select path="courseId" class="form-control">
										<sf:option value="0" label="${coursename}"></sf:option>
										<sf:options items="${courseList}" itemValue="id"
											itemLabel="courseName" />
									</sf:select>
									<font color="red"><sf:errors path="courseId"
											cssClass="error"></sf:errors></font>
								</div>
							</div>
							<!-- couseName is use in courseDTO -->

							<div class="col-md-12">
								<div class="form-group">
									<s:message code="label.select" var="subjectname"></s:message>
									<sf:label path="subjectId">
										<s:message code="label.subject"></s:message>
										<font color="red">*</font>
									</sf:label>
									<sf:select path="subjectId" class="form-control">
										<sf:option value="0" label="${subjectname}"></sf:option>
										<sf:options items="${subjectList}" itemValue="id"
											itemLabel="subjectName" />
									</sf:select>
									<font color="red"><sf:errors path="subjectId"
											cssClass="error"></sf:errors></font>
								</div>
							</div>


							<div class="col-md-12">
								<div class="form-group">
									<s:message code="label.enterexamdate" var="enterdob"></s:message>
									<sf:label path="examDate">
										<s:message code="label.examdate" />
										<font color="red">*</font>
									</sf:label>
									<sf:input path="examDate" class="form-control" name="dob"
										id="datepicker" readonly="readonly" placeholder="${enterdob}" />
									<font color="red"><sf:errors path="examDate"
											cssClass="error"></sf:errors></font>
								</div>
							</div>


							<div class="col-md-12">
								<div class="form-group">
									<s:message code="label.selecttime" var="selecttime"></s:message>
									<sf:label path="examTime">
										<s:message code="label.examtime" />
										<font color="red">*</font>
									</sf:label>
									<sf:select path="examTime" class="form-control">
										<sf:option value="" label="${selecttime}"></sf:option>
										<sf:option value="7am to 9am" label="7am to 9am"></sf:option>
										<sf:option value="10am to 1am" label="10am to 1am"></sf:option>
										<sf:option value="2am to 5am" label="2am to 5am"></sf:option>
									</sf:select>

									<%-- <sf:input path="examTime" class="form-control" placeholder="${entertime}"/>     --%>

									<font color="red"><sf:errors path="examTime"
											cssClass="error"></sf:errors></font>

								</div>
							</div>



						</div>

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


				</div>

			</div>


		</div>

	</div>

</sf:form>

<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'mm/dd/yy',
			defaultDate : "01/01/1982",
			changeMonth : true,
			changeYear : true,
			minDate : "+1d",
		/* 	yearRange : '-35:-18' */
		});

	});
</script>



