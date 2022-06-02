<%@ page import="pojo.TestClass" %><%--
  Created by IntelliJ IDEA.
  User: Prateek
  Date: 20-05-2022
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CBT-Buyer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/styles.css">
    <script type="text/javascript" src="scripts/buyer_ds.js"></script>
</head>


<body onload="init()">

<%
    //TestClass temp_tc = (TestClass) request.getAttribute("obj");
    String usrname = (String) request.getSession(false).getAttribute("username");
%>

<header>

    <div class="container" >

        <div class="row mb-3" >
            <div class="col-2 themed-grid-col" ><img src="images/cbt.jpg" style="width: 30%"></div>
            <div class="col-8 themed-grid-col" align="center">
                <h1 ><b><h1><%= "Cross Border Trade Simplified" %></h1></b></h1>
            </div>
            <div class="col-2 themed-grid-col" >

                <form id="logout-form" name="logout-form" method="get" action="logout-servlet">
                    <button type="submit">Logout</button>
                </form>

            </div>
        </div>

    </div>

</header>

<hr>

<main>

    <div class="container" id="main_body">

        <div class="row mb-3" >

            <div class="col-3 themed-grid-col" >
                <h3>Buyer Dashboard</h3>
                <section id="user_profile">
                    <p>Welcome <span id="username"><b><%=usrname%></b></span> <span><a href="userprofile.jsp">Add/Update Profile</a></span></p>
                    <button id="show_profile_button" type="button">Show User Profile</button>
                    <div id="user_details">

                        <p><span id="username_key"></span>&nbsp;<span id="username_value"></span></p>
                        <p><span id="name_key"></span>&nbsp;<span id="name_value"></span></p>
                        <p><span id="phonenumber_key"></span>&nbsp;<span id="phonenumber_value"></span></p>
                        <p><span id="emailid_key"></span>&nbsp;<span id="emailid_value"></span></p>
                        <p><span id="company_key"></span>&nbsp;<span id="company_value"></span></p>
                        <p><span id="country_key"></span>&nbsp;<span id="country_value"></span></p>
                        <p><span id="city_key"></span>&nbsp;<span id="city_value"></span></p>

                    </div>
                </section>
            </div>

            <div class="col-8 themed-grid-col" align="center">
                <div class="central_div" style="width: 100%">

                    <section>
                        <a href="CBTProductList.jsp" target="_blank">Product List</a>
                    </section>
                </div>
            </div>

            <div class="col-1 themed-grid-col" ></div>
        </div>

    </div>


</main>


</body>
</html>
