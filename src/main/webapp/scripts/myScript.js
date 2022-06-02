function init(){




    let s1 = document.getElementById("session_test").innerHTML;
    let s2 = document.getElementById("session_test").innerText;
    if((s2 !== "null"))
    {
       // alert(s2);
        location.replace("http://localhost/cbt-1.0-SNAPSHOT/hello-servlet");
    }

    let user_status = document.getElementById("user_test").innerText;
    if(user_status === "uc")
    {
        //alert("You just signed up");
        document.getElementById("signup_form_message").innerText = "You just SignedUp! Please Login with your Username/Password";
    }
    else if(user_status === "ue")
    {
        //alert("Please login with your username/password");
        document.getElementById("signup_form_message").innerText = "Your Username Exists!! Please Login with your Username/Password";

    }
    else if(user_status === "null")
    {
        //alert("the signup js is working");
    }

    let usr_login_status = document.getElementById("user_login_test").innerText;

    if(usr_login_status === "incorrect_password")
    {
        //alert("incorrect password");
        document.getElementById("login_form_message").innerText = "You entered an Incorrect Pasword!";
    }
    else if(usr_login_status === "username_dn_exist")
    {
        //alert("username does not exist");
        document.getElementById("login_form_message").innerText = "Please Signup using a New Username/Password!";

    }

    //alert("JS is ON!");

    fetch("http://localhost:80/cbt-1.0-SNAPSHOT/api/hello-world")
        .then(response => response.json())
        .then(data => console.log(data));


}