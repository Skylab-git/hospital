<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>日志列表</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>

<body>
<header>
    <div class="container">
        <nav>
            <a href="/log/operrationLog.do">日志</a>
        </nav>
        <nav>
            <a href="/log/operrationLog.do">操作日志</a>
        </nav>
        <nav>
            <a href="/log/systemLog.do">系统日志</a>
        </nav>
        <nav>
            <a href="/department/list.do?categoryId=1">分类</a>
        </nav>

    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>日志</h1>
            <p>日志列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>操作人员</th>
                <th>操作模块</th>
                <th>操作行为</th>
                <th>结果</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${LIST}" var="log">
                <tr>
                    <td>${log.operator}</td>
                    <td>${log.moudle}</td>
                    <td>${log.operation}</td>
                    <td>${log.result}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<footer>
    copy@
</footer>
</body>
</html>