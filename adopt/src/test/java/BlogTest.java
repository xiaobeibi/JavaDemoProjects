import com.ecjtu.entity.Blog;
import com.ecjtu.mapper.BlogMapper;
import com.ecjtu.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-20 15:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:Spring-dao.xml", "classpath:Spring-service.xml" })
public class BlogTest {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogMapper blogMapper;
    @Test
    public void findById(){
        List<Blog> blogs = blogService.getBlogs();
        for (Blog b:blogs){
            System.out.println(b);
        }
    }


    @Test
    public void select(){
        Blog byId = blogService.findById(1);
        System.out.println(byId);
    }
}
