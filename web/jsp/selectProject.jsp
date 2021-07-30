<%@ page import="com.hdax.until.MybatisUntil" %>
<%@ page import="com.hdax.mapper.ProjectMapper" %>
<%@ page import="com.hdax.pojo.Project" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cf" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2021/7/30
  Time: 下午 6:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择工单</title>
    <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" href="${path}/layui/css/layui.css">
    <script type="text/javascript" src="${path}/layui/layui.js"></script>
</head>
<body>
<%--加载选择数据--%>
    <div style="border: 1px solid red">
        <h1>工单选择系统</h1>
        <form class="layui-form" lay-filter="selectTab">
                <div class="layui-form-item">
                    <label for="" class="layui-form-label">选择项目</label>
                    <div class="layui-input-inline">
                        <select name="select" id="selecctOn" style="width: 200px">
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <button type="submit" lay-submit lay-filter="submit" class="layui-btn">提交</button>
                    </div>
                </div>
        </form>
    </div>
</body>
<script type="text/javascript">
    layui.use(['jquery','form','layer'],function () {
        var table = layui.table;
        var $ = layui.jquery;
        var form = layui.form;
        var layer = layui.layer;
        var allshow ;
        $.ajax({
            url:"/GONGdan/ServletShowProjectAll",
            type:"POST",
            dataType:"JSON",
            success:function (data) {
                allshow = data;
                //动态添加数据
                for (let i = 0; i < data.length; i++) {
                    $("#selecctOn").append("<option value='"+data[i].id+"'>"+data[i].projectName+"</option>")
                }
                //完成后重新渲染表单
                form.render('select','selectTab')
            }
        })
        form.on('submit(submit)',function (data) {
            layer.open({
                type:2,
                area :['800px','700px'],
                content:"/GONGdan/jsp/addProject.jsp",
                success:function (layero,index) {
                    console.log(layero+"11"+index)
                    var iframeWin = window['layui-layer-iframe'+index];
                    iframeWin.val($("select").val())
                    var body = layer.getChildFrame('body', index);
                    for (let i = 0; i < allshow.length; i++) {
                        body.find('select').append("<option value='"+allshow[i].id+"'>"+allshow[i].projectName+"</option>")
                    }
                    var iframeWin = window['layui-layer-iframe'+index];
                    iframeWin.xuanran()
                    //完成后赋值
                },
                btn:['取消'],
                yes:function (index) {

                }
            })
           console.log(data.field)
           return false;
        })
        //关闭所有弹窗
        function CloseWindow() {
            layui.layer.closeAll()
        }
    })
</script>
</html>
