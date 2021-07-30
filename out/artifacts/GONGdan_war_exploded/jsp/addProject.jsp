<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2021/7/30
  Time: 下午 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增Porject</title>
    <script type="text/javascript" src="/GONGdan/layui/layui.js"></script>
    <link rel="stylesheet" href="/GONGdan/layui/css/layui.css">
</head>
<body>
<form action="" class="layui-form" lay-filter="formadd">
  <h1>添加工单</h1>
      <input type="hidden" value="" name="ProjectId"/>
    <div class="layui-form-item">
        <label for="" class="layui-form-label">负责人</label>
        <div class="layui-input-block">
            <input type="text" name="executor" required lay-verify="Excutor" placeholder="请输入负责人姓名" autocomplete="off" class="layui-input">        </div>
    </div>
    <div class="layui-form-item">
        <label for="" class="layui-form-label">任务描述</label>
        <div class="layui-input-inline">
            <textarea placeholder="请输入内容" lay-verify="text" class="layui-textarea" name="description"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label for="" class="layui-form-label">任务级别</label>
        <div class="layui-input-inline">
            <select name="orderLevel" id="selectc" class="layui-form-select">
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label for="" class="layui-form-label"></label>
        <div class="layui-input-inline">
            <button type="submit" lay-submit lay-filter="subAdd"  class="layui-btn">提交</button>
        </div>
    </div>
</form>
<script type="text/javascript">
    layui.use(['form','jquery'],function () {
        var form = layui.form;
        var $ = layui.jquery
        //监听提交事件
        form.on('submit(subAdd)',function (data) {
            console.log(data.field);
            $.ajax({
                url:"/GONGdan/ServletAddWorkOrder",
                type:"post",
                data:data.field,
                success:function (data) {
                    let index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    parent.window.open("http://localhost:8080/GONGdan/jsp/show.jsp","_self")
                }
            })
            //
            return false;
        })
        form.verify({
            Excutor:function (value,dom) {
                if(value!=null&&value.length>0){

                }else{
                    return "项目负责人不能为空";
                }
            },
            text:function (value,DOM) {
                if(value!=null&&value.length>0){

                }else{
                    return "项目描述不能为空";
                }
            }
        })
    })
    function val(priejctId) {
        alert(priejctId)
        layui.form.val('formadd',{
            'ProjectId':priejctId
        })
    }
    //表单取值
    function getVal() {
        return layui.form.val('formadd');
    }
    function xuanran() {
        layui.form.render();
    }
    //监听提交事件
</script>
</body>
</html>
