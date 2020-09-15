package test;

import cn.demo.bean.ShopBean;
import cn.demo.dao.IShopBeanDao;
import cn.demo.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * 测试mybatis的crud操作
 */
public class MybatisTest {

//    private InputStream in;
//    private SqlSession sqlSession;
//    private IShopBeanDao shopBean;
//
//    @Before//用于在测试方法执行之前执行
//    public void init()throws Exception{
//        //1.读取配置文件，生成字节输入流
//        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2.获取SqlSessionFactory
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        //3.获取SqlSession对象
//        sqlSession = factory.openSession();
//        //4.获取dao的代理对象
//        shopBean =  sqlSession.getMapper(IShopBeanDao.class);
//    }
//
//    @After//用于在测试方法执行之后执行
//    public void destroy()throws Exception{
//        //提交事务
//        sqlSession.commit();
//        //6.释放资源
//        sqlSession.close();
//        in.close();
//    }
    private SqlSession sqlSession;
    private IShopBeanDao IshopBean;

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        sqlSession = new SessionFactoryUtils().initFactory();
		IshopBean = sqlSession.getMapper(IShopBeanDao.class);
        //5.执行查询所有方法
        List<ShopBean> shopBeans = IshopBean.getAllList();
        for(ShopBean s : shopBeans){
            System.out.println(s);
        }
        new SessionFactoryUtils().destroyFactory(sqlSession);

    }

//    /**
//     * 测试保存操作
//     */
//    @Test
//    public void testSave(){
//        User user = new User();
//        user.setUserName("modify User property");
//        user.setUserAddress("北京市顺义区");
//        user.setUserSex("男");
//        user.setUserBirthday(new Date());
//        System.out.println("保存操作之前："+user);
//        //5.执行保存方法
//        userDao.saveUser(user);
//
//        System.out.println("保存操作之后："+user);
//    }
//
//    /**
//     * 测试更新操作
//     */
//    @Test
//    public void testUpdate(){
//        User user = new User();
//        user.setUserId(50);
//        user.setUserName("mybastis update user");
//        user.setUserAddress("北京市顺义区");
//        user.setUserSex("女");
//        user.setUserBirthday(new Date());
//
//        //5.执行保存方法
//        userDao.updateUser(user);
//    }
//
    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){
        //5.执行删除方法
        IshopBean.deleteShopBean(8);
    }
//
//    /**
//     * 测试删除操作
//     */
    @Test
    public void testFindOne(){
        //5.执行查询一个方法
        ShopBean  user = IshopBean.getShopById(2);
        System.out.println(user);
    }
//
//    /**
//     * 测试模糊查询操作
//     */
//    @Test
//    public void testFindByName(){
//        //5.执行查询一个方法
//        List<User> users = userDao.findByName("%王%");
////        List<User> users = userDao.findByName("王");
//        for(User user : users){
//            System.out.println(user);
//        }
//    }
//
//    /**
//     * 测试查询总记录条数
//     */
//    @Test
//    public void testFindTotal(){
//        //5.执行查询一个方法
//        int count = userDao.findTotal();
//        System.out.println(count);
//    }
//
//
//    /**
//     * 测试使用QueryVo作为查询条件
//     */
//    @Test
//    public void testFindByVo(){
//        QueryVo vo = new QueryVo();
//        User user = new User();
//        user.setUserName("%王%");
//        vo.setUser(user);
//        //5.执行查询一个方法
//        List<User> users = userDao.findUserByVo(vo);
//        for(User u : users){
//            System.out.println(u);
//        }
//    }
}
