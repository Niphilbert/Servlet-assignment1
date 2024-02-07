<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admission Details</title>
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

<div class="admission-details">
    <h2>Admission Details</h2>
    <p><strong>Student Name:</strong> <%= request.getAttribute("studentName") %></p>
    <p><strong>Student Email:</strong> <%= request.getAttribute("studentEmail") %></p>
    <p><strong>Student Phone Number:</strong> <%= request.getAttribute("studentPhoneNumber") %></p>
    <p><strong>Student Nationality:</strong> <%= request.getAttribute("studentNationality") %></p>
    <p><strong>Student Age:</strong> <%= request.getAttribute("studentAge") %></p>
</div>

</body>
</html>
