<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CBT Platform</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/styles.css">
    <script type="text/javascript" src="scripts/myScript.js"></script>



</head>

<body onload="init()">

<%

    String usr = (String) request.getSession().getAttribute("username");
    String usr_status =  (String) request.getAttribute("userStatus");
    String usr_login_status = (String) request.getAttribute("userLoginStatus");

%>

<span id="session_test" style="display: none"><%=usr%></span>
<span id="user_test" style="display: none"><%=usr_status%></span>
<span id="user_login_test" style="display: none"><%=usr_login_status%></span>


<header>

    <div class="container" >

        <div class="row mb-3" >
            <div class="col-2 themed-grid-col" ><img src="images/cbt.jpg" style="width: 80%"></div>
            <div class="col-8 themed-grid-col" align="center">
                <h1 ><b><h1><%= "Cross Border Trade Simplified" %></h1></b></h1>
            </div>
            <div class="col-2 themed-grid-col" ><h1>CBT.com</h1></div>
        </div>

    </div>

</header>


<main>

    <div class="container" >

        <div class="row mb-3" >
            <div class="col-2 themed-grid-col" ><h4></h4></div>
            <div class="col-4 themed-grid-col" align="center"></div>
            <div class="col-6 themed-grid-col" >

                <form name="login" id="login_form" method="post" action="hello-servlet" >
                    <div>
                        <fieldset>
                            <legend>Please enter username/password to Login</legend>

                            <p>
                                <label for="username">
                                    <span>Username</span>
                                </label>
                                <input type="text" id="username" name="username">
                            </p>
                            <p>
                                <label for="password">
                                    <span>Password</span>
                                </label>
                                <input type="password" id="password" name="password">
                            </p>

                            <p>
                                <button type="submit">Login</button>
                            </p>

                            <p><span id="login_form_message"></span></p>


                        </fieldset>


                    </div>

                </form>

            </div>
        </div>

        <div class="row mb-3" >
            <div class="col-2 themed-grid-col" ><h4></h4></div>
            <div class="col-4 themed-grid-col" align="center"></div>
            <div class="col-6 themed-grid-col" >

                <form name="signup" id="signup_form" method="post" action="signup-servlet" >
                    <div>
                        <fieldset>
                            <legend>Please Enter New Username/Password to Signup</legend>

                            <p>
                                <label for="username_signup">
                                    <span>Username</span>
                                </label>
                                <input type="text" id="username_signup" name="username_signup" placeholder="Enter new Username">
                            </p>
                            <p>
                                <label for="password_signup">
                                    <span>Password</span>
                                </label>
                                <input type="password" id="password_signup" name="password_signup" placeholder="Enter New Password">
                            </p>

                            <p>
                                <button type="submit">Signup</button>
                            </p>

                            <p><span id="signup_form_message"></span></p>


                        </fieldset>


                    </div>

                </form>

            </div>
        </div>



    </div>


</main>

<script>



</script>

</body>
</html>