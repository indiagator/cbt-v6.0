<%--
  Created by IntelliJ IDEA.
  User: Prateek
  Date: 27-05-2022
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Hsv Codes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/styles.css">

</head>
<body>

<div>
    <h3>Update HSV Codes file - Only for Admin Access</h3>

    <form method="post" action="add-product">
        <fieldset>

            <p>
                <label for="chapter">
                    <span>Chapter</span>
                </label>
                <input type="text" id="chapter" name="chapter">
            </p>

            <p>
                <label for="hscode">
                    <span>ITC-HS Code</span>
                </label>
                <input type="text" id="hscode" name="hscode">
            </p>

            <p>
                <label for="description">
                    <span>Product Description</span>
                </label>
                <input type="text" id="description" name="description">
            </p>

        </fieldset>

        <fieldset>
            <select id="unit" name="unit">
                <option value="nos">Nos</option>
                <option value="kgs" selected>Kgs</option>
                <option value="lts">Lts</option>
                <option value="ton">Ton</option>
                <option value="sqm">Sqm</option>
            </select>

        </fieldset>

        <button type="submit">Add Product</button>

    </form>


</div>

</body>
</html>
