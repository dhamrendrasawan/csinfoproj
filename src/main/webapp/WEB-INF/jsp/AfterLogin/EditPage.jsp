<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="genweb.model.ViewCenterForm" %>
 <%-- <% ViewCenterForm viewCenterForm=(ViewCenterForm) session.getAttribute("viewCenterForm")%> --%>
<html>
<head>    
<link type="text/css" rel="stylesheet" href="webapp/resources/css/MyStyle.css" />
<link type="text/css" rel="stylesheet" href="webapp/resources/css/bootstrap.min.css" />
<script type="text/javascript" src="webapp/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/webapp/resources/js/jquery.min.js"></script> 
 <script type="text/javascript" src="webapp/resources/js/main.js"></script> 
 <style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: black;
   color: white;
   text-align: center;
   height:auto;
}
</style>
</head>
<body style="height:100%;">
<div class="container">    	
  <nav class="navbar navbar-inverse navbar-fixed-top " style="background-color:blue;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <ul class="nav">         
      <li><h2 style="text-align:center;color:white;margin-right:185px;">Mahamaya Homes</h2></li>
    </ul>
  </div>
  <div style="background-color:black;height:auto;">
    <div class="navbar-header">
     <a class="navbar-brand" href="#">WELCOME ADMIN</a>
    </div>
    <ul class="nav">      
     
      <li><h4 style="text-align:right;color:white;margin-right:40px;">LogOut</h4></li>
    </ul>
  </div>
</nav>  
<br/>
<form:form method="post" modelAttribute="afterLoginForm" action="${pageContext.request.contextPath}/viewCenter.sawan" id="form1">
<div class="row">  
   <div class="col-md-12">
   <br/><br/><br/>
     <div class="panel panel-primary">
    
         <div class="panel-heading text-center"><font size="5">Edit CenterName</font></div>
         <div class="panel-body">
         <c:if test="${afterLoginForm.flag4=='Y'}">
           <h3><font color="red" style="text-align:center;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Record has been updated successfully</font></h3>
         </c:if>
         <br/>     
         
         
           
 
              <div class="form-group">
                <div class="row">
                  <div class="col-md-2">&nbsp;</div>
                   <div class="col-md-2">Enter Center Code</div>
                   <div class="col-md-2 text-center"><form:input type="text" class="form-control" path="centerCode" name="centerCode" readonly="true" style="text-align:center;"/></div>
               </div>
               </div>
              <div class="form-group">
                  <div class="row">
                       <div class="col-md-2">&nbsp;</div>
                       <div class="col-md-2">Enter Center Name</div>
                       <div class="col-md-2"><form:input type="text" class="form-control" path="centerName" name="centerName"/></div>
                    </div>
               </div>

               <br/>
               <div class="form-group">
               <div class="row">
                     <div class="col-md-3">&nbsp;</div>
                      <div class="col-md-1"><button type="submit" class="btn btn-primary btn-sm" style="width:150px;margin-left:20px;" onclick="updateCenter('${afterLoginForm.centerCode}');"><font size="3">Update</font></button></div>
                       <div class="col-md-1">&nbsp;</div>
                       <div class="col-md-1"><button type="submit" class="btn btn-primary btn-sm"style="width:150px;margin-left:20px;" onclick="back('${afterLoginForm.centerCode}')"><font size="3">Back</font></button></div>
              </div>
            </div>
         
         </div> 
         </div>
         </div>
         </div>
 </form:form>
 </div>
 <br/><br/>
 <script type="text/javascript">
    function back(num)
    {
    	var action_src="viewCenter.sawan?areaCode="+num;
    	var actionForm=document.getElementById("form1");
    	actionForm.action=action_src;
    	actionForm.submit();
    }
    function updateCenter(num)
    {
    	var action_src="updateCenter.sawan?areaCode="+num;
    	var actionForm=document.getElementById("form1");
    	actionForm.action=action_src;
    	actionForm.submit();
    }
   
 </script>
 
 

<div class="footer">
  <p><font size="3">Dhamrendra Kumar Sawan</font></p>
</div>


</body>
</html>