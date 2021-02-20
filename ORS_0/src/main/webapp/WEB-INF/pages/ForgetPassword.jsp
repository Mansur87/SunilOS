<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>


<div class="container-fluid" style="/* background-color:pink ; */">
<div class="row">
 <div class="col-md-1"></div> 
<div class="col-md-8 text-dark">

        <div class="modal-content" style="margin-top:60px;">
		  <div class="modal-header justify-content-center bg-dark">
            <h5 class="modal-title " id="ModalTitle">
              <s:message code="label.pass"></s:message>
            </h5>
          </div>
        <sf:form commandName="form" method="post">
         <div class="modal-body">
			    <div class="form-group">
                <h3 class="error justify-content-center  text-center" ><font color="red">${error}</font></h3>
                <h3 class="success justify-content-center  text-center"><font color="green"> ${success}</font></h3>
                </div> 
			   
			   	<fieldset><legend class="text-secondary">
			   	<s:message code="label.formsg" />
			   	<!-- Submit your email address and we'll send you password --></legend></fieldset>
			    <div class="row"> 
				<div class="col-md-12">
			    <div class="form-group">
                
                <sf:label path="login"><s:message code="label.email"/><s:message code="label.id"/>&nbsp;&nbsp;&nbsp;</sf:label>
                <sf:input path="login" class="form-control" placeholder="${enteremail}"/>
                <font color="red"> <sf:errors path="login" cssClass="error" /></font><!-- //it's use for form validation -->
                </div>
				
				<label for="name"></label>
				</div>
				
				
				</div>
			  <div class="row justify-content-center">
			  <div class="col-md-3">
			  <div class="form-group">
			  <button type="submit" class="btn btn-success btn-block" name="operation" value="Go">
			  <s:message code="label.go"/>
			  </button>
			  <!-- <input type="submit" class="btn btn-primary btn-block" name="operation" value="Go"/> -->
		      
		      </div></div>
			  
			  <div class="col-md-3">
			  <button type="submit" class="btn btn-danger btn-block" name="operation" value="Cancel">
			  <s:message code="label.cancel"/>
			  </button>
			 
			  <!-- <input type="submit" class="btn btn-primary btn-block" name="operation" value="Cancel"/> -->			  
			
              </div></div>
			  
		
			  </div>
        
        
        </sf:form>
		  </div>
		  </div>
		 
                      

</div></div>