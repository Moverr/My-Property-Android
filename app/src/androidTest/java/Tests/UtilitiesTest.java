package Tests;

/**
 * Created by Mover on 9/17/2017.
 */

import org.junit.Test;
import static org.junit.Assert.*;

import myproperty.codemovers.myproperty.core.util.Utilities;
public class UtilitiesTest {

    String WRONGEMAIL="", GOODEMAIL="";
    @Test
    public void testWrongEmail(){

        WRONGEMAIL = "email";

        Boolean actual = Utilities.CheckEmailCheckEmail(WRONGEMAIL);
        Boolean expected = false;
        assertEquals("Test Reesult",actual,expected);
    }


    @Test
    public void testGoodEmail(){
        GOODEMAIL = "goodemail@gmail.com";
        Boolean actual = Utilities.CheckEmailCheckEmail(GOODEMAIL);
        Boolean expected = true;
        assertEquals("Test Reesult",actual,expected);
    }




}
