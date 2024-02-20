<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<div class="header-container">
    <div class="logo">
        <h1>ServletApplication</h1>
    </div>
    <nav>
        <ul>
            <li><a href="Signup.jsp">Signup</a></li>
            <li><a href="login">Login</a></li>
            <li><a href="request">Request</a></li>
        </ul>
    </nav>
</div>

<form action="login" method="post">
    <h2>Login</h2>
    <% if(request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
    <% } %>
    <input type="text" name="username" placeholder="Username" required><br>
    <input type="password" name="password" placeholder="Password" required><br>
    <input type="submit" value="Login">
</form>

</body>
</html>
