function init()
{
    // alert("buyerdash javascript runs");

    var testHttpRequest;

    function ajaxTestHandler()
    {
        if (testHttpRequest.readyState === XMLHttpRequest.DONE) {
            if (testHttpRequest.status === 200) {
                // alert(testHttpRequest.responseText);

                let user_details_obj = JSON.parse(testHttpRequest.responseText);

                // alert("username : "+user_details_obj.username +
                //     "phonenumber : "+user_details_obj.phonenumber +
                //     "emailid : "+user_details_obj.emailid +
                //     "name : "+user_details_obj.name +
                //     "company : "+user_details_obj.company +
                //      "country : "+user_details_obj.country +
                //    "city : "+user_details_obj.city
                // );

                document.getElementById("username_key").innerText = "Username :";
                document.getElementById("username_value").innerText = user_details_obj.username;

                document.getElementById("name_key").innerText = "Name :";
                document.getElementById("name_value").innerText = user_details_obj.name;

                document.getElementById("phonenumber_key").innerText = "Phone Number :";
                document.getElementById("phonenumber_value").innerText = user_details_obj.phonenumber;

                document.getElementById("emailid_key").innerText = "Email Id :";
                document.getElementById("emailid_value").innerText = user_details_obj.emailid;

                document.getElementById("company_key").innerText = "Company :";
                document.getElementById("company_value").innerText = user_details_obj.company;

                document.getElementById("country_key").innerText = "Country :";
                document.getElementById("country_value").innerText = user_details_obj.country;

                document.getElementById("city_key").innerText = "City :";
                document.getElementById("city_value").innerText = user_details_obj.city;




            } else {
                alert('There was a problem with the request.');
            }
        }
    }

    function makeTestRequest()
    {

        testHttpRequest = new XMLHttpRequest();
        if (!testHttpRequest) {
            alert('Giving up :( Cannot create an XMLHTTP instance');
            return false;
        }

        // alert("Ajax request Created");

        let username = document.getElementById("username").innerText;
        dataString = "username="+username;

        testHttpRequest.onreadystatechange = ajaxTestHandler;
        testHttpRequest.open('POST','http://localhost:80/cbt-1.0-SNAPSHOT/BuyerDashboardResponse_1',true);
        testHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        testHttpRequest.send(dataString);


    }


    document.getElementById("show_profile_button").addEventListener("click",makeTestRequest);




}