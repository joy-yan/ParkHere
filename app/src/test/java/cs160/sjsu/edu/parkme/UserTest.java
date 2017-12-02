package cs160.sjsu.edu.parkme;
import static junit.framework.TestCase.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import cs160.sjsu.edu.parkme.model.User;

/**
 * Created by sridi on 11/8/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    // create a mock instance of User
    @Mock
    User myUser;


    // use the instance created with @Mock for testing
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    /* Initialize the User object with parameter values */
    @Before
    public void setup(){
        myUser  = new User("fiveStar123", "John Blake", "1 Washington Sq", "San Jose", "johnBlake@gmail.com",
            "412-091-2341", "/fiveStar123");
    }

    @Test
    public void testGetUIDMethod () {
        assertEquals("fiveStar123", myUser.getUid());

    }

    @Test
    public void testSetUIDMethod(){
        myUser.setUid("distar");
        assertEquals(myUser.getUid(), "distar");

    }
    @Test
    public void testGetNameMethod(){
        assertEquals(myUser.getName(), "John Blake");
    }

    @Test
    public void testSetNameMethod(){
        myUser.setName("Oliver the Octopus");
        assertEquals(myUser.getName(), "Oliver the Octopus");
    }

    @Test
    public void testGetAddressMethod(){
        assertEquals("1 Washington Sq", myUser.getAddress());
    }

    @Test
    public void testSetAddressMethod(){
        myUser.setAddress("1321 San Fernando St");
        assertEquals("1321 San Fernando St", myUser.getAddress());
    }

    @Test
    public void testGetCityMethod(){
        assertEquals("San Jose", myUser.getCity());
    }

    @Test
    public void testSetCityMethod(){
        myUser.setCity("San Francisco");
        assertEquals("San Francisco", myUser.getCity());
    }

    @Test
    public void testGetEmailMethod(){
        assertEquals("johnBlake@gmail.com", myUser.getEmail());
    }

    @Test
    public void testSetEmailMethod(){
        myUser.setEmail("oliver@gmail.com");
        assertEquals("oliver@gmail.com",myUser.getEmail());
    }

    @Test
    public void testGetPhoneMethod(){
        assertEquals("412-091-2341", myUser.getPhone());
    }

    @Test
    public void testSetPhoneMethod(){
        myUser.setPhone("312-221-1234");
        assertEquals("312-221-1234", myUser.getPhone());
    }

    @Test
    public void testGetProfileURIMethod(){
        assertEquals("/fiveStar123", myUser.getProfileURI());
    }

    @Test
    public void testSetProfileURIMethod(){
        myUser.setProfileURI("");
        assertEquals("", myUser.getProfileURI());
    }

}
