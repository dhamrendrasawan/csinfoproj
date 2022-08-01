<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="genweb.model.ViewCenterUserForm" %>
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
<form:form method="post" modelAttribute="viewCenterUserForm" action="${pageContext.request.contextPath}/viewCenter.sawan" id="form1">
<div class="row">  
   <div class="col-md-12">
   <br/>
     <div class="panel panel-primary">
    
         <div class="panel-heading text-center"><font size="5">Center & User Details</font></div>
         <div class="panel-body">  
         <div class="row">
          <div class="col-md-12">
            <div class="table-responsive">          
                       <table class="table table-bordered  table-hover">
                             <thead class="thead-dark" style="background-color:black;">
                                <tr>
                                      <th class="text-center"><font color="white">AreaCode</font></th>
                                      <th class="text-center"><font color="white">CenterName</font></th>
                                       <th class="text-center"><font color="white">CreateNewUser</font></th>
                                      <th class="text-center"><font color="white">ViewUserDetails</font></th>
                                      <th class="text-center"><font color="white">TotalUserCreated</font></th>
                                     
        
                                    </tr>
                                </thead>
                               <tbody id="myTable">                               
                                                          
                              <%-- <c:set var = "count" scope = "session" value = "${0}"/>     
                               <c:forEach var="listValue" items="${afterLoginForm.datalist}">                               
                               <c:set var = "count" scope = "session" value = "${count+1}"/> --%>
                                  <tr>
                                       <%--  <c:out value = "${count}"/> --%>
                                        <td class="text-center">${viewCenterUserForm.centerCode}</td>
                                        <td class="text-center">${viewCenterUserForm.centerName}</td>
                                        <td class="text-center"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="createUser('${viewCenterUserForm.centerCode}')"><font size="2" >Create</font></button>
                                        </td>
                                        <td class="text-center"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="viewUserDetails('${viewCenterUserForm.centerCode}')"><font size="2" >View</font></button>
                                        </td>
                                         <td class="text-center">${viewCenterUserForm.userCount}</td>
                                                                                                                    
                                  </tr>
                                 <%--  </c:forEach> --%>
                                  
                               </tbody>
                       </table>
                   </div>
                  </div>
                 </div> 
                <c:if test="${viewCenterUserForm.flag1=='Y'}">
                  <div class="row">
                     <div class="col-md-1">&nbsp;</div>
                     <div class="col-md-2">Enter Name</div>
                     <div class="col-md-2"><form:input type="text" path="name" name="name" class="form-control"/></div>
                     <div class="col-md-1">&nbsp;</div>
                    <div class="col-md-2">Enter Product Name</div>
                    <div class="col-md-2"><form:input type="text" path="productName" name="productName" class="form-control"/></div>
                  </div>  
                  <br>                
                   <div class="row">
                     <div class="col-md-1">&nbsp;</div>
                     <div class="col-md-2">Enter Price</div>
                     <div class="col-md-2"><form:input type="text" path="price" name="price" class="form-control"/></div>
                     <div class="col-md-1">&nbsp;</div>
                     <div class="col-md-2">Enter Rate Of Interest</div>
                     <div class="col-md-2"><form:input type="text" path="rateOfInterest" name="rateOfInterest" class="form-control"/></div>
                     <div class="col-md-1">&nbsp;</div>
                  </div>
                  <br>                 
                  <div class="row">
                     <div class="col-md-1">&nbsp;</div>
                     <div class="col-md-2">Enter Tenure</div>
                     <div class="col-md-2"><form:input type="text" path="tenure" name="tenure" class="form-control"/></div>
                     <div class="col-md-1">&nbsp;</div>
                     <div class="col-md-2">Enter Address</div>
                     <div class="col-md-2"><form:input type="text" path="address" name="address" class="form-control"/></div>
                     <div class="col-md-1">&nbsp;</div>
                  </div> 
                  <br>
                  <div class="row"  style="backgroung-color:blue;">
                     <div class="col-md-1">&nbsp;</div>
                     <div class="col-md-3">&nbsp;</div>                     
                     <div class="col-md-6"><font color="red">${viewCenterUserForm.sucessMsg}</font></div>
                     <div class="col-md-1">&nbsp;</div>
                  </div> 
                 
               </c:if> 
               <c:if test="${viewCenterUserForm.flag2=='Y'}"> 
                  <div class="row">
          <div class="col-md-12">
            <div class="table-responsive">          
                       <table class="table table-bordered  table-hover">
                             <thead class="thead-dark" style="background-color:gray;">
                                <tr>
                                      <th class="text-center"><font color="white">UserName</font></th>
                                      <th class="text-center"><font color="white">ProductName</font></th>
                                       <th class="text-center"><font color="white">Price</font></th>
                                      <th class="text-center"><font color="white">InterestRate</font></th>
                                      <th class="text-center"><font color="white">TotalTenure</font></th>
                                      <th class="text-center"><font color="white">TotalAmount</font></th>
                                      <th class="text-center"><font color="white">RemaingTenure</font></th>
                                      <th class="text-center"><font color="white">RemaingAmount</font></th>                                      
                                      <th class="text-center"><font color="white">Delete</font></th>
                                      <th class="text-center"><font color="white">Update</font></th>
                                      <th class="text-center"><font color="white">Payment</font></th>
        
                                    </tr>
                                </thead>
                               <tbody id="myTable">                               
                                                          
                              <c:set var = "count" scope = "session" value = "${0}"/>     
                             <c:forEach var="listValue" items="${viewCenterUserForm.dataList}">                               
                               <c:set var = "count" scope = "session" value = "${count+1}"/> 
                                  <tr>
                                       <%--  <c:out value = "${count}"/> --%>
                                        <td class="text-center">${listValue.name}</td>
                                        <td class="text-center">${listValue.productName}</td>
                                        <td class="text-center">${listValue.price} </td>
                                        <td class="text-center">${listValue.rateOfInterest}</td>
                                        <td class="text-center">${listValue.tenure}</td>
                                        <td class="text-center">${listValue.tenureAmount}</td>
                                        <td class="text-center">${listValue.tenureRemaining}</td>
                                        <td class="text-center">${listValue.outstandingAmount}</td>
                                        <td class="text-center"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="createUser('${listValue.userId}')"><font size="2" >${listValue.delete}</font></button></td>
                                        <td class="text-center"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="createUser('${listValue.userId}')"><font size="2" >${listValue.edit}</font></button></td>
                                        <td class="text-center"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="createUser('${listValue.userId}')"><font size="2" >${listValue.payment}</font></button></td>
                                                                                                                                                                                                   
                                  </tr>
                                 
                                   </c:forEach> 
                                  
                               </tbody>
                       </table>
                   </div>
                  </div>
                 </div> 
               </c:if>                        
          <br/> 
                                         
         </div> 
              <div class="row">
                  <div class="col-md-4">&nbsp;</div>
                  <div class="col-md-2"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="back('${viewCenterUserForm.centerCode}')"><font size="2" >Back</font></button>
                  </div>
                    <c:if test="${viewCenterUserForm.flag1=='Y'}">
                        <div class="col-md-2"><button type="submit" class="btn btn-primary btn-sm text-center" style="width:80px;margin-left:20px;" onclick="save('${viewCenterUserForm.centerCode}')"><font size="2" >Save</font></button>
                        </div>
                    </c:if>
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
    function createUser(num)
    {
    	var action_src="createUser.sawan?areaCode="+num;
    	var actionForm=document.getElementById("form1");
    	actionForm.action=action_src;
    	actionForm.submit();
    }
   function save(num)
   {
	    var action_src="saveUser.sawan?areaCode="+num;
     	var actionForm=document.getElementById("form1");
     	actionForm.action=action_src;
   	    actionForm.submit();
   } 
   function viewUserDetails(num)
   {
	   var action_src="viewUserDetails.sawan?areaCode="+num;
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