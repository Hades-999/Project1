<%-- 
    Document   : enquiry
    Created on : Apr 15, 2019, 3:51:11 AM
    Author     : HP
--%>

<%@page import="java.util.List"%>
<%@page import="Model.AccOps.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ENQUIRY</title>
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
    		height: 400px;
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
					<li><a href="withdrawal.html" accesskey="2" title="">Add Expenses</a></li>
					<li ><a href="deposit.html" accesskey="3" title="">Deposit</a></li>
					<li class="current_page_item"><a href="DisplayServlet" accesskey="4" title="">Enquiry</a></li>
					<li><a href="#" accesskey="5" title="">Contact Us</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="banner"><img src="images/header-img.jpg" width="1120" height="500" alt="" /></div>
	<div id="page-wrapper">
		<div class="loginform">
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
	<div id="footer-wrapper">
		<div id="footer-content">
                    
		</div>
	</div>
</div>
<div id="footer">
	<p>&copy; Untitled. All rights reserved.</p>
</div>
    </body>
</html>
