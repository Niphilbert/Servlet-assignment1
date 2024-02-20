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
                <li><a href="Signup.jsp">Signup</a></li>
            </ul>
        </nav>
    </div>
    <form action="request" method="post" enctype="multipart/form-data">
        <h2>Student Admission</h2>
        
        <input type="text" name="name" placeholder="Student Name" required><br>
        <input type="text" name="email" placeholder="Student Email" required><br>
        <label for="file">Upload image:</label>
        <input type="file" id="file1" name="file1"><br><br>

        <label for="file2">Upload PDF:</label>
        <input type="file" id="files2" name="file2"><br><br>

        <input type="text" name="phonenumber" placeholder="Student Phone Number" required><br>
        <input type="text" name="nationality" placeholder="Student Nationality" required><br>
        <input type="number" name="age" placeholder="Student Age" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
