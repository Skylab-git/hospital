<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室列表</title>
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
            <a href="/department/list.do?categoryId=1">内科</a>
        </nav>
        <nav>
            <a href="/department/list.do?categoryId=2">外科</a>
        </nav>
        <nav>
            <a href="/department/list.do?categoryId=1">分类</a>
        </nav>

    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>科室</h1>
            <p>科室列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>分类</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="dept">
                <tr>
                    <td>${dept.name}</td>
                    <td>${dept.categoryId}</td>
                    <td>${dept.createTime}</td>
                    <td>${dept.updateTime}</td>
                    <td>

                        <a href="/department/update.do?id=${dept.id}">修改</a>&nbsp;&nbsp;
                        <a href="/department/delete.do?id=${dept.id}">删除</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="/department/toAdd.do">
                <button>新建</button>
            </a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>