package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testSuggestPassword1() {

        

        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1998,2000));
        
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<String> str = new ArrayList<String>(Arrays.asList("batu","ulucay"));
        char a = '!';

        assertEquals("1998batu1!", App.suggestPassword(arr1, arr2, str, a).get(0));
        assertEquals("1998ulucay1!", App.suggestPassword(arr1, arr2, str, a).get(1));
        assertEquals("2000batu1!", App.suggestPassword(arr1, arr2, str, a).get(2));
        assertEquals("2000ulucay1!", App.suggestPassword(arr1, arr2, str, a).get(3));
    }
    
    public void testSuggestPassword2() {

     

        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,2));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<String> str = new ArrayList<String>(Arrays.asList("batu","ulucay"));
        char a = '!';

        assertNotNull(App.suggestPassword(arr1, arr2, str, a));
    }

    public void testSuggestPassword3() {

       

        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<String> str = new ArrayList<String>(Arrays.asList("batu","ulucay"));
        char a = '!';

        assertNotNull(App.suggestPassword(arr1, arr2, str, a));

    }

    public void testSuggestPassword4() {

    

        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<String> str = new ArrayList<String>(Arrays.asList("batu","ulucay"));
        char a = '!';

        boolean boo=false;

        if(App.suggestPassword(arr1, arr2, str, a).size() == arr1.size()*arr2.size()*str.size())
            boo=true;

        assertTrue(boo);

    }

    public void testSuggestPassword5(){

      

        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<String> str = new ArrayList<String>(Arrays.asList("batu","ulucay"));
        char a = '!';

       

        ArrayList<String> obj = App.suggestPassword(arr1, arr2, str, a);
           

        assertNotSame(obj, App.suggestPassword(arr1, arr2, str, a));

    }

}
