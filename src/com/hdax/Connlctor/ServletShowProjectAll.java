package com.hdax.Connlctor;

import com.alibaba.fastjson.JSON;
import com.hdax.mapper.ProjectMapper;
import com.hdax.until.MybatisUntil;
import com.hdax.pojo.Project;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletShowProjectAll", value = "/ServletShowProjectAll")
public class ServletShowProjectAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ProjectMapper projectMapper = MybatisUntil.getSession().getMapper(ProjectMapper.class);
        List<Project> list =  projectMapper.queryAllProject();
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(list));
        out.flush();
        out.close();
    }
}
