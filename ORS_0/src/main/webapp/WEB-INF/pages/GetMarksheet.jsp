<%@page import="in.co.sunrays.proj0.dto.RoleDTO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="in.co.sunrays.proj0.controller.MarksheetCtl"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>

                
<style>
.table-responsive {
	height:340px;
	}

</style>


 
    
<div class="container">
    <div class="row">
     <div class="modal-content" style="">
		  
		  <div class="modal-header justify-content-center bg-dark">
            <h5 class="modal-title " id="ModalTitle">
           <s:message code="label.getmarkheet"></s:message>
            </h5>
          </div>
          </div>
          
          
     <div class="modal-body">
     

<sf:form method="post"  modelAttribute="form" name="frm">
    
     <div class="row" style="margin-top:0px;">
				<div class="col-md-4" align="right">
				<label for="disabledTextInput"
							style="color: black; margin-top: 8px;"><strong><s:message code="label.rollNo"></s:message></strong><font
							color="red">*</font>
						</label>
				</div>
				<div class="col-md-3">
			    <div class="form-group">
		
			   <s:message code="label.searchByRollNo" var="enterrollno"></s:message> 
               <sf:input path="rollNo" class="form-control" placeholder="${enterrollno}"/>
               
			    </div>
				</div>
				
				
			
		        <div class="col-lg-1">
			    <div class="form-group">
                <s:message code="label.search" var="search"/>
                <abbr title="${search}">
                <button type="submit" class="btn btn-success btn-block" name="operation" value="Search" >
			   
			    <i class="fa fa-search" aria-hidden="true" style="height:20px;"></i>		
			    </button>
                </abbr>
                </div>
				</div>
				
				<div class="col-md-1">
			    <div class="form-group">
              <s:message code="label.reset" var="reset"/>
              <abbr title="${reset}">
              <button type="submit" class="btn btn-danger btn-block" name="operation" value="reset">
			  <i class="fa fa-retweet" aria-hidden="true" style="height:20px;"></i>
			  </button>
              </abbr>
              </div>
				</div>
			<div class="col-md-1"></div>
				
			
         </div>
         <div align="center">
		
						<h3 style="color: red;">${error}</h3>
		</div>
         </sf:form>
         </div>
   

   
   <c:if test="${form.id!=null && form.id>0}">
   
   
   <div class="table-responsive">
   <c:set value="${form.physics}" var="physics"></c:set>
   <c:set value="${form.chemistry}" var="chemistry"></c:set>
   <c:set value="${form.maths}" var="maths"></c:set>
   <c:set value="${physics+chemistry+maths}" var="result"></c:set>    
   <fmt:formatNumber value="${result/3}" minFractionDigits="2" maxFractionDigits="2" var="per"></fmt:formatNumber>
							
       <table class="table table-hover" border="2">

			<tr class="">
		       
		        <td colspan="" bgcolor="" class="bg-secondary text-white"><b><s:message code="label.rollNo" ></s:message>:</b><b>${form.rollNo}</b></td>
                <td colspan="2" bgcolor="" class="bg-secondary text-white"><b><s:message code="label.name"></s:message>: </b>${form.studentName}</td>
		
			<td colspan="3" align="center" class="bg-secondary text-white"><s:message code="label.obtained"/></td>
						</tr>

						<tr class="bg-secondary text-white">
							<td><s:message code="label.subject"/></td>
			                <td><s:message code="label.maxmarks"/></td>
			                <td><s:message code="label.minmarks"/></td>
							<td><s:message code="label.theorymarks"/></td>
							<td><s:message code="label.remark"/></td>
							<td><s:message code="label.grade"/></td>
						</tr>
						<tr class="bg-light">
							<td><font color=""><s:message code="label.physics"></s:message></font></td>
							<td align="center"><%=MarksheetCtl.MAX_MARKS%></td>
							<td align="center"><%=MarksheetCtl.MIN_MARKS %></td>
							<td align="center">${physics}</td>		
							<td align="center"><c:choose><c:when test="${physics<=100 && physics>=35}"><s:message code="label.passf"/></c:when><c:otherwise><font color="red"><s:message code="label.fail"/></font></c:otherwise></c:choose></td>
						    <td align="center">
							<c:if test="${physics<=100 && physics>=80}"><s:message code="label.a"/></c:if>
							<c:if test="${physics<=79 && physics>=60}"><s:message code="label.b"/></c:if>
							<c:if test="${physics<=59 && physics>=40}"><s:message code="label.c"/></c:if>
							<c:if test="${physics<=39 && physics>=0}">---</c:if>
							</td>
						</tr>
							<tr class="bg-light">
							<td>
							<font color=""><s:message code="label.chemistry"/></font></td>
							<td align="center"><%=MarksheetCtl.MAX_MARKS%></td>
							<td align="center"><%=MarksheetCtl.MIN_MARKS %></td>
							<td align="center">${chemistry}</td>		
							<td align="center"><c:choose><c:when test="${chemistry<=100 && chemistry>=35}"><s:message code="label.passf"/></c:when><c:otherwise><font color="red"><s:message code="label.fail"/></font></c:otherwise></c:choose></td>
							<td align="center">
							<c:if test="${chemistry<=100 && chemistry>=80}"><s:message code="label.a"/></c:if>
							<c:if test="${chemistry<=79 && chemistry>=60}"><s:message code="label.b"/></c:if>
							<c:if test="${chemistry<=59 && chemistry>=40}"><s:message code="label.c"/></c:if>
							<c:if test="${chemistry<=39 && chemistry>=0}">---</c:if>
							</td>
						</tr>

						<tr class="bg-light">
							<td><font color=""><s:message code="label.maths"></s:message></font></td>
				            <td align="center"><%=MarksheetCtl.MAX_MARKS%></td>
							<td align="center"><%=MarksheetCtl.MIN_MARKS %></td>
							<td align="center">${maths}</td>		
							<td align="center"><c:choose><c:when test="${maths<=100 && maths>=35}"><s:message code="label.passf"/></c:when><c:otherwise><font color="red"><s:message code="label.fail"/></font></c:otherwise></c:choose></td>
							<td align="center">
							<c:if test="${maths<=100 && maths>=80}"><s:message code="label.a"/></c:if>
							<c:if test="${maths<=79 && maths>=60}"><s:message code="label.b"/></c:if>
							<c:if test="${maths<=59 && maths>=40}"><s:message code="label.c"/></c:if>
							<c:if test="${maths<=39 && maths>=0}">---</c:if>
							</td>
						</tr>

						<tr class="bg-light">
							<td><b><s:message code="label.totalmarks"/></b></td>
							<td align="center"><%=MarksheetCtl.TOTAL_MARKS %></b></td>
							<td></td>
							<td align="center"><b>${result}</b></td>
							<td colspan="2"></td>
						</tr>

						<tr bgcolor="" class="bg-secondary text-white" >
							<td colspan="6" align="center">
							<b><s:message code="label.result"/> :</b>
							<c:choose>
							<c:when test="${physics>=35 && chemistry>=35 && maths>=35}">
								 ${per}
							<c:if test="${per>=60.00}">[ <s:message code="label.first"/> ]</c:if>
							<c:if test="${per>=50.00 && per<59.00}">[ <s:message code="label.second"/> ]</c:if> 
							<c:if test="${per>=0.00 && per<49.00}">[ <s:message code="label.thrid"/> ]</c:if> 
							
							
							</c:when>
							<c:otherwise><font color="red" ><s:message code="label.fail"/></font></c:otherwise>
						    </c:choose> </td>
					
						</tr>
					
					</table>
   </div>
</c:if>
   </div>	

	
</div>


