<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/1/8
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bright.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <style type="text/css">
        #all{
            height:400px;
            width:800px;
            margin-top: 100px;
            margin-left: 100px;
        }
    </style>
</head>
<body>
<div id="all">
    <table class="table table-bordered table-striped">
        <tr>
            <th>类型ID</th>
            <th>类型名称</th>
            <th>操作</th>
        </tr>
        <tr>
            <th></th>
            <th></th>
            <th><button type="button" class="btn btn-warning" id="mydel"
                        onclick="getAll()">查询
            </button></th>
        </tr>
        <c:forEach items="${list}" var="type">
            <tr>
                <td>${type.typeId}</td>
                <td>${type.typeName}</td>
                <td><button type="button" class="btn btn-info myupdate"
                            onclick="typeEdit(${p.pId})">编辑
                </button>
                    <button type="button" class="btn btn-warning" id="mydel"
                            onclick="del(${p.pId})">删除
                    </button>
                </td>
            </tr>
        </c:forEach>
<%--        <tr>--%>
<%--            <td>1</td>--%>
<%--            <td>手机</td>--%>
<%--            <td><button type="button" class="btn btn-info myupdate"--%>
<%--                        onclick="typeEdit(${p.pId})">编辑--%>
<%--            </button>--%>
<%--                <button type="button" class="btn btn-warning" id="mydel"--%>
<%--                        onclick="del(${p.pId})">删除--%>
<%--                </button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>2</td>--%>
<%--            <td>电脑</td>--%>
<%--            <td><button type="button" class="btn btn-info myupdate"--%>
<%--                        onclick="typeEdit(${p.pId})">编辑--%>
<%--            </button>--%>
<%--                <button type="button" class="btn btn-warning" id="mydel"--%>
<%--                        onclick="del(${p.pId})">删除--%>
<%--                </button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>3</td>--%>
<%--            <td>电视</td>--%>
<%--            <td><button type="button" class="btn btn-info myupdate"--%>
<%--                        onclick="typeEdit(${p.pId})">编辑--%>
<%--            </button>--%>
<%--                <button type="button" class="btn btn-warning" id="mydel"--%>
<%--                        onclick="del(${p.pId})">删除--%>
<%--                </button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>4</td>--%>
<%--            <td>手表</td>--%>
<%--            <td><button type="button" class="btn btn-info myupdate"--%>
<%--                        onclick="typeEdit(${p.pId})">编辑--%>
<%--            </button>--%>
<%--                <button type="button" class="btn btn-warning" id="mydel"--%>
<%--                        onclick="del(${p.pId})">删除--%>
<%--                </button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>5</td>--%>
<%--            <td>平衡车</td>--%>
<%--            <td><button type="button" class="btn btn-info myupdate"--%>
<%--                        onclick="typeEdit(${p.pId})">编辑--%>
<%--            </button>--%>
<%--                <button type="button" class="btn btn-warning" id="mydel"--%>
<%--                        onclick="del(${p.pId})">删除--%>
<%--                </button>--%>
<%--            </td>--%>
<%--        </tr>--%>
    </table>
</div>
<script type="text/javascript">
    function getAll() {
        location.href = "${pageContext.request.contextPath}/prodty/getAll.action";
    }
</script>
</body>
</html>
