package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import controller.LandBattleChess;

public class LandBattleChessTests {
LandBattleChess lbc   = new LandBattleChess(1, 2000);
	
	private static final String[] validArgs1   = { "--go", "1", "--time/move", "2s"};
	private static final String[] validArgs2   = { "--go", "2", "--time/move", "1.2s"};
	private static final String[] validArgs3   = { "--go", "1", "--time/move", "2000ms"};
	private static final String[] validArgs4   = { "--go", "2", "--time/move", "2000.0ms"};
	
	private static String seconds1 = "2s";
	private static String seconds2 = "2.0s";
	private static String seconds3 = "2000ms";
	private static String seconds4 = "2000.0ms";
	
	/** Test method to test the getMillisections method **/
	@Test
	public void testGetMilliseconds() throws NoSuchMethodException, 
                InvocationTargetException, IllegalAccessException{	
		//testing of the getMilliseconds() method
	    Method getMilli = LandBattleChess.class.
	    		getDeclaredMethod("getMilliseconds", String.class);
	    getMilli.setAccessible(true);
	    
	    int milliTest1 =  (Integer) getMilli.invoke(lbc, seconds1);
	    int milliTest2 =  (Integer) getMilli.invoke(lbc, seconds2);
	    int milliTest3 =  (Integer) getMilli.invoke(lbc, seconds3);
	    int milliTest4 =  (Integer) getMilli.invoke(lbc, seconds4);
	    
	    assertTrue(milliTest1 == 2000);
	    assertTrue(milliTest2 == 2000);
	    assertTrue(milliTest3 == 2000);
	    assertTrue(milliTest4 == 2000);
	}
	
	
	/** method to test the validateArguments method **/
	@Test
	public void testValidateArguments() throws NoSuchMethodException, 
                InvocationTargetException, IllegalAccessException{		
		
		//reflection used to invoke the private validateArguments() method
  		Method validateArgs   = LandBattleChess.class.
  				getDeclaredMethod("validateArguments", new Class[]{String[].class});
	    validateArgs.setAccessible(true);
	    
	    boolean valArgsTest1 =  (Boolean) validateArgs.invoke(lbc, new Object[]{validArgs1});    
	    boolean valArgsTest2 =  (Boolean) validateArgs.invoke(lbc, new Object[]{validArgs2});
	    boolean valArgsTest3 =  (Boolean) validateArgs.invoke(lbc, new Object[]{validArgs3});
	    boolean valArgsTest4 =  (Boolean) validateArgs.invoke(lbc, new Object[]{validArgs4});
	    
	    assertEquals(valArgsTest1, true);
	    assertEquals(valArgsTest2, true);
	    assertEquals(valArgsTest3, true);
	    assertEquals(valArgsTest4, true);
	    
	           
	}
	

}
