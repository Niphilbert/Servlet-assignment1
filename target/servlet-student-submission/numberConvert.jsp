<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Converter</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<div class="header-container">
    <div class="logo">
        <h1>ServletApplication</h1>
    </div>
    <nav>
        <ul>
            <li><a href="convert">Convert</a></li>
            <li><a href="login">Login</a></li>
            <li><a href="request">Request</a></li>
        </ul>
    </nav>
</div>

<h2>Converter</h2>

<form action="convert" method="post">
    Enter base 10 number <input type="text" name="number" placeholder="Enter a number"><br>
    <button type="submit" name="type" value="binary">Binary</button>
    <button type="submit" name="type" value="hexa">Hexa</button>
    <button type="submit" name="type" value="octal">Octal</button>
    <button type="reset">Clean</button>
</form>

<%
if(request.getAttribute("newNumber") != null){ %>
<div class="result">
    <h2>Result</h2>
    <p>Number <%= request.getAttribute("number") %></p>
    <p>Result <%= request.getAttribute("newNumber") %></p>
    <ul>
        <li>Decimal number converted to <%= request.getAttribute("action") %></li>
    </ul>
</div>
<% }
%>

</body>
</html>
