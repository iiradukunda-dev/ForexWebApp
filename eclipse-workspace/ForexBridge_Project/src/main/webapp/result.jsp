<html>
<body>
    <h2>Conversion Result</h2>

    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>Result</th>
        </tr>
        <tr>
            <td>${result}</td>
        </tr>
    </table>

    <br>

    <h3>History</h3>
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>Previous Conversions</th>
        </tr>
        <c:forEach var="item" items="${history}">
            <tr>
                <td>${item}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="home">Convert Again</a>
</body>
</html>