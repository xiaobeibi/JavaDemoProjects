import com.ecjtu.entity.AdoptAnimal;
import com.ecjtu.entity.Pet;
import com.ecjtu.entity.Users;
import com.ecjtu.mapper.AdoptAnimalMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-21 23:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:Spring-dao.xml", "classpath:Spring-service.xml" })
public class AdoptAnimalTest {

    @Autowired
    private AdoptAnimalMapper adoptAnimalMapper;

    @Test
    public void select(){
        List<AdoptAnimal> adoptAnimals = adoptAnimalMapper.getAdoptAnimals();
        System.out.println(adoptAnimals);
    }

    @Test
    public void select1(){
        List<AdoptAnimal> byState = adoptAnimalMapper.findByState(1);
        for(AdoptAnimal a:byState){
            System.out.println(a);
        }

    }

    @Test
    public void insert(){
        Users users = new Users();
        users.setId(9);
        Pet pet=new Pet();
        pet.setId(9);
        adoptAnimalMapper.addAdoptAnimal(new AdoptAnimal(new Date(),1,pet,users));
    }

    @Test
    public void update(){
        Users users = new Users();
        users.setId(9);
        Pet pet=new Pet();
        pet.setId(1);
        adoptAnimalMapper.updateAdoptAnimal(new AdoptAnimal(10,new Date(),1,pet,users));
    }

    @Test
    public void delet(){
        int i = adoptAnimalMapper.deleteAdoptAnimal(10);
        System.out.println(i);
    }

    @Test
    public void tiem(){
       AdoptAnimal animal=new AdoptAnimal();
       SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(new Date());
        System.out.println(animal);
    }

}
