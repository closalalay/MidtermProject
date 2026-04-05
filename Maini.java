<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company Profile Card</title>

    <!-- External CSS -->
    <link rel="stylesheet" href="styles.css">

    <!-- Internal CSS -->
    <style>
        article {
            background-color: white;
            border-radius: 8px;
            padding: 15px;
            margin: 20px auto;
            width: 300px;
            box-shadow: 2px 2px 5px gray;
        }
    </style>
</head>
<body>

    <header>
        <h1>My Company</h1>
        <p>Simple and Reliable Services</p>
    </header>

    <main>
        <article>
            <h2>About Us</h2>
            <p>
                Our company provides simple and reliable services to help customers
                solve their daily problems. We focus on quality and customer satisfaction.
            </p>
        </article>
    </main>

    <footer>
        <p>&copy; 2026 My Company</p>

        <!-- Inline CSS -->
        <button style="background-color: blue; color: white; padding: 8px 15px; border: none; border-radius: 5px;">
            Contact Us
        </button>
    </footer>

</body>
</html>

body {
    background-color: #dcdcdc; /* clearly sets page background */
    font-family: Arial, sans-serif;
    text-align: center;
}

header {
    background-color: black;
    color: white;
    padding: 20px;
}

footer {
    background-color: black;
    color: white;
    padding: 15px;
    margin-top: 20px;
}