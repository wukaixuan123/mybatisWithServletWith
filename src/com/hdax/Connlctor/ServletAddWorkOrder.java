package com.hdax.Connlctor;

import com.hdax.mapper.ProjectMapper;
import com.hdax.pojo.Workorder;
import com.hdax.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;

@WebServlet(name = "ServletAddWorkOrder", value = "/ServletAddWorkOrder")
public class ServletAddWorkOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取数据
        Integer id = Integer.valueOf(request.getParameter("ProjectId"));
       String description =   request.getParameter("description");
       String executor = request.getParameter("executor");
       Integer orderLevel = Integer.valueOf(request.getParameter("orderLevel"));
       Workorder workorder = new Workorder();
       workorder.setProjectId(id);
       workorder.setExecutor(executor);
       workorder.setDescription(description);
        workorder.setOrderLevel(orderLevel);
        SqlSession session = MybatisUntil.getSession();
        ProjectMapper mapper = session.getMapper(ProjectMapper.class);
       int row =  mapper.insertWorkOrder(workorder);
       MybatisUntil.commit();
        System.out.println(row);
    }
}
