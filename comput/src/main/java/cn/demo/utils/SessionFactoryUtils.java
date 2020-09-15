package cn.demo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SessionFactoryUtils {
    public SqlSession initFactory(){
        InputStream in;
        try {
            //1.读取配置文件，生成字节输入流
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.获取SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            in.close();
            //3.获取SqlSession对象
            return factory.openSession();
        } catch (Exception e){
            System.out.println("session获取失败");
        }
        return null;
    }
    public void destroyFactory(SqlSession sqlSession){
        System.out.println("关闭");
        //4.提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
    }
}
