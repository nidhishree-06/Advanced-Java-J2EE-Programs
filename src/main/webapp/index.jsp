<!DOCTYPE html>
<html>
<head>
    <title>Student Result Form</title>
    <script>
        function validateForm() {
            let roll = document.forms["myForm"]["rollno"].value;
            let name = document.forms["myForm"]["name"].value;

            if (roll === "" || name === "") {
                alert("Roll No and Name must be filled!");
                return false;
            }

            for (let i = 1; i <= 5; i++) {
                let mark = document.forms["myForm"]["sub" + i].value;

                if (mark === "" || mark < 0 || mark > 100) {
                    alert("Enter valid marks (0-100) for Subject " + i);
                    return false;
                }
            }

            return true;
        }
    </script>
</head>
<body>

<h2>Enter Student Details</h2>

<form name="myForm" action="ResultServlet" method="post" onsubmit="return validateForm()">
    Roll No: <input type="text" name="rollno"><br><br>
    Name: <input type="text" name="name"><br><br>

    Sub1: <input type="number" name="sub1"><br>
    Sub2: <input type="number" name="sub2"><br>
    Sub3: <input type="number" name="sub3"><br>
    Sub4: <input type="number" name="sub4"><br>
    Sub5: <input type="number" name="sub5"><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>