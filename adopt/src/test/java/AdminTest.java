import com.ecjtu.entity.Admin;
import com.ecjtu.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-21 23:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:Spring-dao.xml", "classpath:Spring-service.xml" })
public class AdminTest {

    @Autowired
    private AdminMapper adminMapper;


    @Test
    public void select(){
        List<Admin> admins = adminMapper.getAdmins();
        System.out.println(admins);
    }

    @Test
    public void add(){
//        int i = adminMapper.addAdmin(new Admin("熊四", "121", "111", "19802841023", "234552091@qq.com", new Date(), "男", "1111"));
//        String ste=i>0?"插入成功":"插入失败";
//        System.out.println(ste);
    }

    @Test
    public void delete(){
        int i = adminMapper.deleteAdmin(10);
        System.out.println(i);
    }

    @Test
    public void select1(){

    }

    @Test
    public void select2(){
        Admin admin=adminMapper.findById(1);
        System.out.println(admin);
    }
}
