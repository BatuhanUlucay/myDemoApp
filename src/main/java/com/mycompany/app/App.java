package com.mycompany.app;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{




    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    public static ArrayList<String> suggestPassword(ArrayList<Integer> array1, ArrayList<Integer> array2, ArrayList<String> str, char a){

        if(array1.size()==0 || array2.size()==0 || str.size()==0 ){
            System.out.println("parameters cannot be empty!");
            
            return null;
        }

        ArrayList<String> suggested = new ArrayList<String>();

        for(int i=0;i<array1.size();i++){
            for(int j=0;j<str.size();j++){
                for(int k=0;k<array2.size();k++){
                    suggested.add(array1.get(i) + str.get(j) + array2.get(k) + a);
                }
            }
        }

        return suggested;

    }

}
