import static org.junit.Assert.*;
import model.DBUtil;

import org.junit.Test;


public class DBTests {

	@Test
	public void getUserTest() {
		System.out.println("Tests if the database gets the user");
		DBUtil user = new DBUtil();
		assertNotNull(user.getUser("meenu"));
	}
	
	@Test
	public void getPurchaseditem() {
		System.out.println("Tests if the database gets the user");
		DBUtil user = new DBUtil();
		assertNotNull(user.getProductList("meenu"));
	}
	
	@Test
	public void getPurchaseditem2() {
		System.out.println("Tests if the database gets the user");
		DBUtil user = new DBUtil();
		assertNull(user.getProductList("him"));
	}
	
	
	@Test
	public void getPurchaseditem2() {
		System.out.println("Tests if the database gets the user");
		DBUtil user = new DBUtil();
		assertNotNull(user.getProductList("meenu"));
	}
	

}
