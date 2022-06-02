<%--
  Created by IntelliJ IDEA.
  User: Prateek
  Date: 24-05-2022
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="pojo.TestClass" %>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit User Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/styles.css">
    <script type="text/javascript" src="scripts/userprofile.js"></script>
</head>

<body onload="init()">

<header>

    <div class="container" >

        <div class="row mb-3" >
            <div class="col-2 themed-grid-col" ><img src="images/cbt.jpg" style="width: 80%"></div>
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

<main>

    <div class="container" >
        <div class="row mb-3" >
            <div class="col-2 themed-grid-col" ></div>
            <div class="col-8 themed-grid-col" >
                <form name="userprofile_edit_form" id="userprofile_edit_form" action="userprofile-update" method="post">

                    <div>
                        <fieldset>
                            <legend>Update your Profile</legend>

                            <p>
                                <label for="username">
                                    <span>Username</span>
                                </label>
                                <input type="text" id="username" name="edit_username">
                            </p>

                            <p>
                                <label for="password">
                                    <span>Password</span>
                                </label>
                                <input type="password" id="password" name="edit_password">
                            </p>


                            <p>
                                <label for="name">
                                    <span>Full Name</span>
                                </label>
                                <input type="text" id="name" name="edit_name">
                            </p>

                            <p>
                                <label for="emailid">
                                    <span>Email Id</span>
                                </label>
                                <input type="email" id="emailid" name="edit_emailid">
                            </p>

                            <p>
                                <label for="phonenumber">
                                    <span>Phone Number</span>
                                </label>
                                <input type="text" id="phonenumber" name="edit_phonenumber">
                            </p>

                            <p>
                                <label for="company">
                                    <span>Company</span>
                                </label>
                                <input type="text" id="company" name="edit_company">
                            </p>

                            <p>
                                <label for="country">
                                    <span>Country</span>
                                </label>
                                <input type="text" id="country" name="edit_country">
                            </p>

                            <p>
                                <label for="city">
                                    <span>City</span>
                                </label>
                                <input type="text" id="city" name="edit_city">
                            </p>




                        </fieldset>

                        <fieldset>
                            <legend>Choose UserType</legend>
                            <select id="usertype" name="usertype">
                                <option value="seller">Producer</option>
                                <option value="buyer" selected>Consumer</option>
                                <option value="both">Prosumer</option>
                            </select>

                        </fieldset>

                        <p>
                            <button type="submit">Update</button>
                        </p>

                    </div>
                </form>

            </div>
            <div class="col-2 themed-grid-col" ></div>
        </div>
    </div>

</main>


</body>

</html>
