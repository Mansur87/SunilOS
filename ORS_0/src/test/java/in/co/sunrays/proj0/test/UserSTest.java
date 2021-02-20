package in.co.sunrays.proj0.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import in.co.sunrays.proj0.dao.UserDAOHibImpl;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.UserServiceInt;
import in.co.sunrays.proj0.service.UserServiceSpringImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class UserSTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	UserServiceInt usi;
	@Test
	public void  test(){
		
		UserDTO dto=new UserDTO();
		dto.setFirstName("Mansur");
		dto.setLastName("Shaikh");
		dto.setRoleId(1);
		
	try{
long pk=usi.add(dto);
		System.out.println("SuccesssFul Add" +pk);
		
	}catch(Exception e){
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	}
}