<%-- 
    Document   : withdrawaldisplay
    Created on : Apr 15, 2019, 4:59:59 AM
    Author     : HP
--%>

<%@page import="java.util.List"%>
<%@page import="Model.AccOps.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Add Expenses</title>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Abel|Satisfy' rel='stylesheet' type='text/css' />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css">
		body {
    		background-image: url(125.jpg);
    		font-family: Arial, Helvetica, sans-serif;
  		}

  		form {
    		border: 3px ;
    		width: 600px;
    		height: 600px;
    		background-color: 
  		}

  		input[type=text], input[type=password] {
    		width: 50%;
    		padding: 12px 20px;
    		margin: 8px 0;
    		display: inline-block;
    		border: 1px solid #ccc;
    		box-sizing: border-box;
  		}

  		select {
    		width: 100%;
    		padding: 12px 20px;
    		margin: 8px 0;
    		display: inline-block;
    		border: 1px solid #ccc;
    		box-sizing: border-box;
  		}

  		button {
    		background-color: #4CAF50;
    		color: white;
    		padding: 10px 18px;
    		margin: 8px 0;
    		border: none;
    		cursor: pointer;
    		width: 100%;
  		}

  		button:hover {
    		opacity: 0.8;
  		}

  		.container {
    		padding: 16px;
   		 	width: 500px
   		 	float: center;
  		}

  		span.psw {
    		float: right;
    		padding-top: 16px;
  		}

  		label {
    		float: left;
  		}
  		.lnk{
  			float: right;
  		}
  		.title{
  			margin-bottom: 100px;
  		}
                .schedule {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 80%;
            }
            .schedule td,.schedule th {
                border: 1px solid #ddd;
                padding: 8px;
            }
            .schedule tr:nth-child(even){background-color: lightblue;}
            .schedule th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align:center;
                background-color: grey;
                color: white;
            } 
	</style>
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body>
<div id="wrapper">
	<div id="header-wrapper">
		<div id="header">
			<div id="logo">
				<h1><a href="#">ABC Bank</a></h1>
				<p>Personal Accounting</p>
			</div>
			<div id="menu">
				<ul>
					<li><a href="home.html" accesskey="1" title="">Homepage</a></li>
					<li class="current_page_item"><a href="withdrawal.html" accesskey="2" title="">Add Expenses</a></li>
					<li><a href="deposit.html" accesskey="3" title="">Deposit</a></li>
					<li><a href="#" accesskey="4" title="">Enquiry</a></li>
					<li><a href="#" accesskey="5" title="">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="banner"><img src="images/header-img.jpg" width="1120" height="500" alt="" /></div>
	<div id="page-wrapper">
					<div class="loginform">
		<form action="ExpensesServlet" name="expenses" method="get" onsubmit="return Validation()">
			<div class="container">
				<label><b>Account Number:</b></label><br>
				<input type="text" name="accno" placeholder="Enter Account No."><br>
				<label><b>Electricity Bill:</b></label><br>
				<input type="text" name="ebill" placeholder="Enter Electricity Bill"><br>
				<label><b>Living Expenses:</b></label><br>
				<input type="text" name="lbill" placeholder="Enter Living Expenses"><br>
				<label><b>Vehicle Maintenance & Fuel:</b></label><br>
				<input type="text" name="carbill" placeholder="Enter Vehicle Maintenance & Fuel bill"><br>
				<label><b>Other Expenses:</b></label><br>
				<input type="text" name="obill" placeholder="Enter Other Expenses"><br>
				<label><b>Taxes:</b></label><br>
				<input type="text" name="tax" placeholder="Enter Taxes"><br>
				<label>
					<button type="submit" value="submit">Submit</button>
				</label>
			</div>
		</form>	</div>
		
	</div>
	<div id="footer-wrapper">
		<div id="footer-content">
                    <table class="schedule" align="center" >
            <tr><th colspan="3" style="font-size: 30px;">BUDGET TABLE</th></tr>
            <tr>
                <th>ACCOUNT NO.</th>
                <th>SAVINGS AMT</th>
                <th>CURRENT AMT</th>
            </tr>
            <%
                List <Account> list = (List<Account>)request.getSession().getAttribute("list");
                
                for(Account disp : list)
                {
            %>
                    <tr>
                        <td><%=disp.getAccno()%></td>                         
                        <td><%=disp.getSavingsamt()%></td>
                        <td><%=disp.getCurrentamt()%></td>
                    </tr>
            <% 
                }
            %>    
        </table>
		</div>
	</div>
</div>
<div id="footer">
	<p>&copy; Untitled. All rights reserved.</p>
</div>
<script type="text/javascript">  
        function Validation(){
			var accno=document.forms["expenses"]["accno"].value
			var ebill=document.forms["expenses"]["ebill"].value
			var lbill=document.forms["expenses"]["lbill"].value
			var carbill=document.forms["expenses"]["carbill"].value
			var obill=document.forms["expenses"]["obill"].value
			var tax=document.forms["expenses"]["tax"].value
      		var flag=true;
      		if(accno===""||ebill===""||lbill===""||carbill===""||obill===""||tax===""){
      			alert("Please fill in the empty fields");
      			flag=false;
      		}
      		return flag;
		}

</script> 
</body>
</html>
