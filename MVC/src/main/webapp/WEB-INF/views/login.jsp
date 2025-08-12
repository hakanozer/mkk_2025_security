<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
    <meta http-equiv="Content-Security-Policy" content="default-src 'self' cdn.jsdelivr.net ">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h2>Welcome Login</h2>
    <c:out value="${data}"></c:out>
    <form action="/login" method="post">
        <input type="text" name="data" placeholder="Username">
        <input type="hidden" name="csrf" value="${csrf}">
        <button type="submit">Login</button>
    </form>
    <div class="ratio ratio-16x9">
        <iframe src="https://www.youtube.com/embed/zpOULjyy-n8?rel=0" width="100"  height="100" title="YouTube video" allowfullscreen></iframe>
    </div>
</div>
</body>
</html>