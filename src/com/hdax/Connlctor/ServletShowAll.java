package com.hdax.Connlctor;

import com.alibaba.fastjson.JSON;
import com.hdax.mapper.ProjectMapper;
import com.hdax.pojo.Project;
import com.hdax.until.MybatisUntil;
import com.hdax.until.pageConfig;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletShowAll", value = "/ServletShowAll")
public class ServletShowAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
      SqlSession session =  MybatisUntil.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
        List<Project> list = mapper.getProject();
        System.out.println(list);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","");
        map.put("code","0");
        map.put("data",list);
        map.put("count",200);
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(map));
        out.flush();
        out.close();
    }
}
