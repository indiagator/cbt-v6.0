<%--
  Created by IntelliJ IDEA.
  User: Prateek
  Date: 27-05-2022
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
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
    <title>CBT Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/styles.css">
    <script type="text/javascript" src="scripts/productList.js"></script>
</head>

<body onload="init()">

<header>

    <div class="container" >

        <div class="row mb-3" >
            <div class="col-2 themed-grid-col" ><img src="images/cbt.jpg" style="width: 30%"></div>
            <div class="col-8 themed-grid-col" align="center">
                <h1 ><b><h1><%= "Cross Border Trade Simplified" %></h1></b></h1>
            </div>
            <div class="col-2 themed-grid-col" >
            </div>
        </div>

    </div>

</header>

<main>
    <div class="container">
        <div class="row mb-3">
            <div class="col-2 themed-grid-col" ></div>
            <div class="col-8 themed-grid-col" align="center">
                <h3>List of Products @CBT.com</h3>
                <div id="product_list">


                </div>
            </div>
            <div class="col-2 themed-grid-col" ></div>
        </div>
    </div>
</main>

</body>
</html>
