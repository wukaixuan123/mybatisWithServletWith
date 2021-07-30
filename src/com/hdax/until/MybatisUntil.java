package com.hdax.until;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUntil {
    //SqlSessionFactory
    private static SqlSessionFactory factory = null;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
    static {
        String configPath = "config.xml";
        try {
            Reader reader =   Resources.getResourceAsReader(configPath);
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //打开Seesion连接
    public static void newSession(){
        threadLocal.set(factory.openSession());
    }
    //判断线程
    public static SqlSession getSession(){
        SqlSession session = null;
      if(threadLocal.get()!=null){
          //赋值当前线程的sqlseesion
          session = threadLocal.get();
      }else{
          newSession();
          return threadLocal.get();
      };
      return session;
    }
    //事务提交
    public static void commit(){
        //获取当前线程的变量Sqlsession
        SqlSession session = threadLocal.get();
        if(session!=null){
            session.commit();
            session.close();
            threadLocal.remove();
        }
    }
    //数据回滚
    public static void rollbackAndClose() {
        //将来进行写操作，之后需要提交，我们定义的方法
        SqlSession session = threadLocal.get();
        if (session != null) {
            session.rollback();//回滚
            session.close();//释放
            //已经关闭的session不能留在local
            //所以要删除
            threadLocal.remove();
        }
    }
}
