package com.hdax.mapper;
import com.hdax.pojo.Project;
import com.hdax.pojo.Workorder;
import com.hdax.until.pageConfig;

import java.util.List;

public interface ProjectMapper {
    List<Project> getProject();//项目所有信息
   int  queryAllCount(pageConfig p);
    List<Project> queryAllProject();//项目 id和名称信息
   int  insertWorkOrder(Workorder workorder);
}
