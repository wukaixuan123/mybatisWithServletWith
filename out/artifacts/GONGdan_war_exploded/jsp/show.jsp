<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2021/7/30
  Time: 上午 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有</title>
    <c:set value="${pageContext.request.contextPath}" var="path"></c:set>
    <link rel="stylesheet" href="${path}/layui/css/layui.css">
    <script type="text/javascript" src="${path}/layui/layui.js"></script>
    <script type="text/html" id="workOrder">
        {{d.workorder.orderLevel+'等级'}}
</script>
    <script type="text/html" id="level">
          {{d.workorder.orderLevel+'等级'}}
    </script>
    <script type="text/javascript">
        layui.use(['table','jquery'],function () {
            var table = layui.table;
            var $ = layui.jquery;
            table.render({
                elem:"#table",
                url:"/GONGdan/ServletShowAll",
                cols:[[
                    {field:'id',title:'项目编号'},
                    {field:'projectName',title:'项目名称'},
                    {field:'workorder.executor',title:'负责人',templet: "<div>{{d.workorder.executor}}</div>"},
                    {field:'workorder.description',title:'项目描述',templet: "<div>{{d.workorder.description}}</div>"},
                    {field:'workorder.orderLevel',title:'项目等级',templet :'#level'},
                    {field:'workorder.createDate',title: '时间',templet: "<div>{{d.workorder.createDate}}</div>"}
                ]],
                title:'所有工单信息'
            })
        })
    </script>
</head>
<body>
  <div>
      <h1 style="margin: 0 auto">企业工单列表</h1>
      <table class="layui-table" id="table"></table>
  </div>
</body>
</html>
