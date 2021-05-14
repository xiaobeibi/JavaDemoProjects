import com.ecjtu.entity.Users;
import com.ecjtu.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-21 23:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:Spring-dao.xml", "classpath:Spring-service.xml" })
public class UserTest {


    @Autowired
    private UsersMapper usersMapper;


    @Test
    public void select(){
        List<Users> users = usersMapper.getUsers();
        for(Users u:users){
            System.out.println(u);
        }
    }

    @Test
    public void select1(){
        Users users=new Users();
        users.setUserName("张三丰");
        users.setPassword("zsf123");
        Users user = usersMapper.loginUser(users);
        System.out.println(user);
    }
}
