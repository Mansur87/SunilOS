<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
           <s:message code="label.collegelist" ></s:message>
            </h5>
          </div>
          </div>
     
     <div class="row" style="margin-left:3px;">
				
				<div class="col-md-3">
			    <div class="form-group">
			       <s:message code="label.searchname" var="rolename"/>
			    <sf:select path="Id" Class="form-control">
                <sf:option value="0" label="${rolename}" />
                <sf:options items="${collegeList}" itemValue="id" itemLabel="name"/>
                </sf:select>  
                </div>
				</div>
				
				<div class="col-md-3">
			    <div class="form-group">
			    <s:message code="label.searchcity" var="city"/>
			    <sf:input path="city" cssClass="form-control" placeholder="${city}"  />
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
				
				<div class="col-md-3">
              
                
                <ul class="pagination float-right"style="margin-left:10px;">
                
				 <li class="page-item"><a class="page-link" >
			     PageNo:<c:out value="${form.pageNo}"></c:out> 
			     </a></li>
                 <li class="page-item"><!-- <a class="page-link">Previous</a> -->
               
               <s:message code="label.previous" var="previous"/>
               <abbr title="${previous}"> 
              <button type="submit" name="operation" value="Previous"
              <c:choose>
              <c:when test="${form.pageNo == 1}">
              class="page-link btn bg-white btn-block no-drop" disabled="disabled"
              </c:when>
              <c:otherwise>
              class="page-link btn bg-white btn-block" 
              </c:otherwise>
              </c:choose> >
			   <i class="fa fa-chevron-left" aria-hidden="true"></i><i class="fa fa-chevron-left" aria-hidden="true"></i>
			   </button>
               </abbr>  
                
                 </li>
               
			    <li class="page-item"><!-- <a class="page-link">Next</a> -->
		          <s:message code="label.next" var="next"/>
				  <abbr title="${next}">
				  <button type="submit"  name="operation" value="next"
				  <c:choose>
              <c:when test="${form.pageSize>total.size()|| findtotal.size()==form.pageSize*form.pageNo }">
              class="page-link btn bg-white btn-block no-drop" disabled="disabled"
              </c:when>
              <c:otherwise>
              class="page-link btn bg-white btn-block" 
              </c:otherwise>
              </c:choose> 
             <%--  <c:choose>
              
              <c:when test="${findtotal.size()==form.pageSize*form.pageNo}">
              class="page-link btn bg-white btn-block no-drop" disabled="disabled"
              </c:when>
              <c:otherwise>
              class="page-link btn bg-white btn-block" 
              </c:otherwise>
              </c:choose> --%> >
				
			      <i class="fa fa-chevron-right" aria-hidden="true"></i><i class="fa fa-chevron-right" aria-hidden="true"></i>
			      </button>
			      </abbr>
			   </li> 
				 
				</ul>
				</div>
			
         </div>
         </div>
   <div class="modal-content" style="">
	<div class="modal-body">	
    
      <div class="table-responsive">
        <table class="table table-hover table-dark table-striped">
          <thead>
            <tr class="thread-light">
              <th>
              <div class="form-check">
              <label class="form-check-label">
              <input type="checkbox" class="form-check-input" name="chk_all" onchange="checkedAll()"><s:message code="label.selectall" />
              </label>    
              </div>
              
              </th>
              <th><s:message code="label.collegeName"/></th>
              <th><s:message code="label.phoneNo"/></th>
              <th><s:message code="label.address"/></th>
              <th><s:message code="label.city"/></th>
              <th><s:message code="label.state"/></th>
              
              <th><s:message code="label.edit"/></th>
         
            </tr>
            
          </thead>
         <h3 class="error justify-content-center  text-center "><font color="red">${error1}</font></h3>
         <h3 class="success justify-content-center  text-center "><font color="green"> ${success}</font></h3>
         
          <tbody id="myTable" style="background-color:black; ">
          <c:if test="${!empty list}">
             <c:forEach items="${list}" var="college" varStatus="ct">
              
           <tr>
              <td>
               <div class="form-check">
              
              <label class="form-check-label">
             
              <input type="checkbox" class="form-check-input" name="chk_1" id="sid" onchange="check()" value="${college.id}">
             
            
            <c:out value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
						<c:set var="index"
							value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" />
            
            
              <%-- <c:out value="${role.id}" /> --%>
              
              </label>    
              </div>
             
              </td>
                    <td><c:out value="${college.name}" /></td>
                    <td><c:out value="${college.phoneNo}" /></td>
                    <td><c:out value="${college.address}"/></td>
                    <td><c:out value="${college.city}" /></td>
                    <td><c:out value="${college.state}" /></td>
              <td>
              <c:url var="editUrl" value="/ctl/College/College?id=" />
              <a href="${editUrl}${college.id}"><s:message code="label.edit"/> <i class="fas fa-edit"></i></a>
             
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
               
                 <button type="submit" class="form-control btn btn-success btn-block" name="operation" value="new">
			     <i class="fa fa-plus" aria-hidden="true"></i>
			     <s:message code="label.new"/>     
			     </button>
                
                </div>
			    </div>
			    <div class="col-md-2">
			    <div class="form-group" style="margin-top:5px; margin-bottom:-7px;">
               <%--  <s:message code="label.delete" var="delete"/>
                 <abbr title="${delete}"> --%>
                 <button type="submit"  name="operation" value="Delete"
              <c:choose>
              <c:when test="${total.size()==0}">
              class="form-control btn btn-danger btn-block no-drop" disabled="disabled"
              </c:when>
              <c:otherwise>
              class="form-control btn btn-danger btn-block" 
              </c:otherwise>
              </c:choose>>
			     <i class="fa fa-trash" aria-hidden="true"></i>
			     <s:message code="label.delete"/>
			     </button>
			   <!--   </abbr> -->
                </div>
			    </div> 
	<!-- <div class="col-md-5"></div>		 -->
		</div>	

	
</div>
</sf:form>
