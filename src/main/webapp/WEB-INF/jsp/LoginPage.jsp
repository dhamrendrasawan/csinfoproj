<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
<body >

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
     <a class="navbar-brand" href="#"></a>
    </div>
    <ul class="nav">         
      <li>&nbsp;</li>
    </ul>
  </div>
</nav>  
<br/>
<form:form method="post" modelAttribute="userLoginForm" action="${pageContext.request.contextPath}/login.sawan" id="form1">
<div class="row">
 <div class="col-md-2">&nbsp;</div>
  
   <div class="col-md-7">
   <br/><br/><br/>
     <div class="panel panel-primary">
    
         <div class="panel-heading text-center"><font size="5">Login Page</font></div>
         <div class="panel-body">
         <br/><br/>
         <div class="form-group">
             <div class="row text-center">
                 <div class="col-md-1"></div>
                 <div class="col-md-3">Enter UserId</div>
                 <div class="col-md-4"><form:input type="text" class="form-control" path="userId" name="userId"/><font color="red"><form:errors path="userId"></form:errors></font></div>
                  <div class="col-md-5"></div>
              </div>
             </div>
         
             <div class="form-group">
               <div class="row text-center">
                  <div class="col-md-1"></div>
                   <div class="col-md-3">Enter Password</div>
                  <div class="col-md-4"><form:input type="text" class="form-control" path="password" name="password"/><font color="red"><form:errors path="password"/></font></div>
                   <div class="col-md-5"></div>
               </div>
             </div>
   
         <div class="form-group">
            <div class="row text-center">         
                 <div class="col-md-4">&nbsp;</div> 
                  <div class="col-md-2"><button type="submit" class="btn btn-primary btn-sm" style="width:150px;margin-left:20px;"><font size="3">Login</font></button></div>              
                 <div class="col-md-5">&nbsp; </div>                      
          </div>
        </div>
     </div>    
     </div>
  </div> 
  <div class="col-md-2">&nbsp;</div>
 </div>
 </form:form>
</div>
<div class="footer">
  <p><font size="3">Dhamrendra Kumar Sawan</font></p>
</div>


</body>
</html>