<%@page import="in.co.sunrays.proj0.dto.RoleDTO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>

<c:set value="${findList}" var="findtotal"></c:set>
<c:set value="${list}" var="total"></c:set>
                
<style>
.table-responsive {
	height:340px;
	}

</style>
<script type="text/javascript">
function checkedAll()
{
	
	var totalElement=document.forms[0].elements.length;
	//alert(totalElement);
	for(var i=0;i<totalElement;i++){
		var en=document.forms[0].elements[i].name;
		
		//alert(en);
		if(en!=undefined & en.indexOf("chk_")!=-1)
		{	
			document.forms[0].elements[i].checked=document.frm.chk_all.checked;
		 
		}		
	}
}
function check(){
	var en=document.forms[0].elements[8].name;
	if(en!=undefined & en.indexOf("chk_")!=-1)
	{	
		document.forms[0].elements[8].checked=document.frm.chk_all.unchecked;
	}	
}
</script>


<sf:form method="post" modelAttribute="form" name="frm">
    
     <c:set value="${((form.pageNo-1)*form.pageSize)+1}" var="index"></c:set>
    
    <sf:hidden path="pageNo" />
    <sf:hidden path="pageSize" />
    
    
    
<div class="container-fluid">
    <div class="row">
     <div class="modal-content" style="">
	<div class="modal-body">	  
		  <div class="modal-header justify-content-center bg-dark">
            <h5 class="modal-title " id="ModalTitle">
           <s:message code="label.marksheetmeritlist"></s:message>
            </h5>
          </div>
          </div>
     
     <div class="row" style="margin-top:0px;">
     <div class="col-md-4 "></div>
     <div class="col-md-4 ">
	<div class="form-group">
	<!-- <input type="submit" class="form-control bg-success text-white" value="(click here)Print MeritList" name="operation" /> -->
    <center>
    <a href="<c:url value="/ctl/Jasper" />" target="blank" 
    class="form-control bg-success text-white"><font>(<s:message code="label.chere"/>)<s:message code="label.meritList"/></font></a>
    </center>
    </div>
		
         </div>
         </div>
   
    </div>
     <div class="modal-content" style="">
	<div class="modal-body">	  
      <div class="table-responsive">
        <table class="table table-hover table-dark ">
          <thead>
            <tr class="thread-light">
              <th>
              <s:message code="label.SNo"/>
              <div class="form-check">
            <%--   <label class="form-check-label">
              <input type="checkbox" class="form-check-input" name="chk_all" onchange="checkedAll()"><s:message code="label.selectall" />
              </label>   --%>  
            
              </div>
              
              </th>
              
              <th><s:message code="label.rollNo"/></th>
              <th><s:message code="label.studentName"/></th>
              <th><s:message code="label.physics"/></th>
              <th><s:message code="label.chemistry"/></th>
              <th><s:message code="label.maths"/></th>
              <th><s:message code="label.total"/></th>
              <th><s:message code="label.percentage"/></th>
             <%--  <th><s:message code="label.edit"/></th>
          --%>
            </tr>
            
          </thead>
         <h3 class="error justify-content-center  text-center "><font color="red">${error1}</font></h3>
         <h3 class="success justify-content-center  text-center "><font color="green"> ${success}</font></h3>
         
          <tbody id="myTable" style="background-color:black; ">
          <c:if test="${!empty list}">
             <c:forEach items="${list}" var="marksheet" varStatus="ct">
              
           <tr>
              <td>
				<c:out value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
				<c:set var="index" value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
              </td>
                  
                    <td><c:out value="${marksheet.rollNo}" /></td>
                    <td><c:out value="${marksheet.studentName}" /></td>
                    <td><c:out value=" ${marksheet.physics}" /></td>
                    <td><c:out value="${marksheet.chemistry}"/></td>
                    <td><c:out value="${marksheet.maths}"/></td>
                    <c:set value=" ${marksheet.physics + marksheet.chemistry+marksheet.maths}" var="total"/>
                    <td><c:out value="${total}"/></td>
                      
                       <c:set var="percentage">
								<fmt:formatNumber type="number" minFractionDigits="2"
									maxFractionDigits="2"
									value="${(marksheet.maths + marksheet.physics + marksheet.chemistry)/3}" />
							</c:set>

							<td><c:out value="${percentage}%" /></td>
                    
                    </td>             
            </tr>
            </c:forEach>
          </c:if>  
          <c:if test="${empty list}">
           <tr><td colspan="6" align="center"><h3><font color="red">${error}</font></h3></td></tr>   
          </c:if>
             
          </tbody>
     
        </table>   
      </div>
      </div>
      </div>
      
      <div class="col-md-4"></div>
	            <div class="col-md-2">
			    <div class="form-group" style="margin-top:5px; margin-bottom:-7px;">
               
             
                
                </div>
			    </div>
			    <div class="col-md-2">
			    <div class="form-group" style="margin-top:5px; margin-bottom:-7px;">
               <%--  <s:message code="label.delete" var="delete"/>
                 <abbr title="${delete}"> --%>
             
			   <!--   </abbr> -->
                </div>
			    </div> 
	
		</div>	

	
</div>
</sf:form>

