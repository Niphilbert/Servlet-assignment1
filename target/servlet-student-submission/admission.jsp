<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Admission</title>
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
    <form action="request" method="post">
        <h2>Student Admission</h2>
        <input type="text" name="name" placeholder="Student Name" required><br>
        <input type="text" name="email" placeholder="Student Email" required><br>
        <input type="text" name="phonenumber" placeholder="Student Phone Number" required><br>
        <input type="text" name="nationality" placeholder="Student Nationality" required><br>
        <input type="number" name="age" placeholder="Student Age" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
