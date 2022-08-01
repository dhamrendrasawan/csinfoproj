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
<form:form method="post" modelAttribute="afterLoginForm" action="${pageContext.request.contextPath}/login.sawan" id="form1">
<div class="row">
 
  
   <div class="col-md-12">
   <br/><br/><br/>
     <div class="panel panel-primary">
    
         <div class="panel-heading text-center"><font size="5">User Details</font></div>
         <div class="panel-body">
          <c:if test="${afterLoginForm.flag1=='Y'}"> 
           <h3><font color="red" style="text-align:center;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Record has been created successfully</font></h3>
          </c:if>
         <br/><br/>
         
        <div class="form-group">
            <div class="row text-center">         
                 <div class="col-md-1">&nbsp;</div> 
                  <div class="col-md-2"><button type="submit" class="btn btn-primary btn-sm" style="width:170px;margin-left:20px;" onclick="addCenter()"><font size="3">Add Center</font></button></div>  
                  <div class="col-md-3">&nbsp;</div>            
                 <div class="col-md-2"><button type="submit" class="btn btn-primary btn-sm" style="width:170px;margin-left:20px;" onclick="viewCenter()"><font size="3">View Center</font></button> </div>
                 <div class="col-md-1">&nbsp;</div> 
                 <div class="col-md-2"> <input class="form-control" id="myInput" type="text" placeholder="Search.....any record"></div>                     
          </div>
        </div>
       
          <div class="form-group">
            <div class="row text-center"> 
             <c:if test="${afterLoginForm.flag1=='Y'}">                                                                          
                  <div class="col-md-5">
                  <div class="table-responsive">          
                       <table class="table table-bordered">
                             <thead>
                                <tr>
                                      <th>Area_Code</th>
                                      <th>Center_Name</th>
        
                                    </tr>
                                </thead>
                               <tbody>
                                  <tr>
                                        <td>${afterLoginForm.centerCode}</td>
                                        <td>${afterLoginForm.centerName}</td>
                                  </tr>
                               </tbody>
                       </table>
                   </div>
               </div> 
            </c:if>  
            <c:if test="${afterLoginForm.flag2=='Y'}">   
                <div class="col-md-5">&nbsp;</div>          
               <div class="col-md-7">             
                              
                 <div class="table-responsive">          
                       <table class="table table-bordered  table-hover">
                             <thead class="thead-dark" style="background-color:black;">
                                <tr>
                                      <th class="text-center"><font color="white">AreaCode</font></th>
                                      <th class="text-center"><font color="white">CenterName</font></th>
                                      <th class="text-center"><font color="white">ViewCenter</font></th>
                                      <th class="text-center"><font color="white">EditCenter</font></th>
                                      <th class="text-center"><font color="white">DeleteCenter</font></th>
        
                                    </tr>
                                </thead>
                               <tbody id="myTable">                               
                                                          
                              <c:set var = "count" scope = "session" value = "${0}"/>     
                               <c:forEach var="listValue" items="${afterLoginForm.datalist}">                               
                               <c:set var = "count" scope = "session" value = "${count+1}"/>
                                  <tr>
                                       <%--  <c:out value = "${count}"/> --%>
                                        <td class="text-center">${listValue.centerCode}</td>
                                        <td class="text-center">${listValue.centerName}</td>
                                        <td class="text-center"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="viewCenter_User('${listValue.centerCode}')"><font size="2" > ${listValue.viewCenter}</font></button>
                                        </td>
                                        <td class="text-center"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="editCenter('${listValue.centerCode}')"><font size="2" >${listValue.edit}</font></button>
                                        </td>
                                         <td class="text-center"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="deleteCenter('${listValue.centerCode}')"><font size="2" style="text-align:center;">${listValue.delete}</font></button>
                                      </td>
                                     
                                  </tr>
                                  </c:forEach>
                                  
                               </tbody>
                       </table>
                   </div>
               </div>                                                 
           </c:if>                    
          </div>
        </div>
      
        </div>    
     </div>
   </div>
  
 </div>
 <br/>
<c:if test="${afterLoginForm.flag=='Y'}">
 <div class="form-group">
   <div class="row">
     <div class="col-md-2">&nbsp;</div>
     <div class="col-md-2">Enter Center Code</div>
     <div class="col-md-2"><form:input type="text" class="form-control" path="centerCode" name="centerCode"/></div>
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
     <div class="col-md-1"><button type="submit" class="btn btn-primary btn-sm" style="width:150px;margin-left:20px;" onclick="createCenter();"><font size="3" >Create</font></button></div>
     <div class="col-md-2">&nbsp;</div>
   </div>
</div>
</c:if>
 <%-- <c:if test="${afterLoginForm.flag4=='Y'}">
 
<div class="form-group">
   <div class="row">
     <div class="col-md-2">&nbsp;</div>
     <div class="col-md-2">Enter Center Code</div>
     <div class="col-md-2"><form:input type="text" class="form-control" path="centerCode" name="centerCode" readonly=true/></div>
   </div>
</div>
 <div class="form-group">
   <div class="row">
     <div class="col-md-2">&nbsp;</div>
     <div class="col-md-2">Enter Center Name</div>
     <div class="col-md-2"><form:input type="text" class="form-control"  path="centerName" name="centerName"/></div>
   </div>
</div>

<br/>
<div class="form-group">
   <div class="row">
     <div class="col-md-3">&nbsp;</div>
     <div class="col-md-1"><button type="submit" class="btn btn-primary btn-sm" style="width:150px;margin-left:20px;" onclick="updateCenter();"><font size="3" >Update</font></button></div>
     <div class="col-md-2">&nbsp;</div>
   </div>
</div>
</c:if> --%>
 
 </form:form>
 </div>
 <br/><br/>
 <script type="text/javascript">
    function addCenter()
    {
    	var action_src="addCenter.sawan";
    	var actionForm=document.getElementById("form1");
    	actionForm.action=action_src;
    	actionForm.submit();
    }
   function createCenter()
   {
	   var action_src="createCenter.sawan";
	   var actionForm=document.getElementById("form1");
	   actionForm.action=action_src;
   	   actionForm.submit();
   }
   function viewCenter(areaCode)
   {
	   var action_src="viewCenter.sawan";
	   var actionForm=document.getElementById("form1");
	   actionForm.action=action_src;
	   actionForm.submit();
   }
   function editCenter(areaCode)
   {
	   var action_src="editCenter.sawan?areaCode="+areaCode;
	   var actionForm=document.getElementById("form1");
	   actionForm.action=action_src;
	   actionForm.submit();	   
   }
   function deleteCenter(num)
   {
	   var action_src="deleteCenter.sawan?areaCode="+num;
	   var action_Form=document.getElementById("form1");
	   action_Form.action=action_src;
	   action_Form.submit();
   }
   function viewCenter_User(areaCode)
   {
	 var action_src="viewCenter_User.sawan?areaCode="+areaCode;  
	 var action_Form=document.getElementById("form1");
	 action_Form.action=action_src;
	 action_Form.submit();
   }
 </script>
 <script>
  $(document).ready(function(){
   $("#myInput").on("keyup", function() {
     var value = $(this).val().toLowerCase();
     $("#myTable tr").filter(function() {
       $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
     });
  });
</script>
 

<div class="footer">
  <p><font size="3">Dhamrendra Kumar Sawan</font></p>
</div>


</body>
</html>