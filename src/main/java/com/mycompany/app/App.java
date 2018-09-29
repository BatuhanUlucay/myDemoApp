package com.mycompany.app;
import java.util.*;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{




    public static void main( String[] args )
    {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          ArrayList<Integer> inputList1 = new ArrayList<>();
          if(input1.equals("")){

            inputList1.add(0);
          }

          else{
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            while (sc1.hasNext())
            {
              int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
              inputList1.add(value);
            }
                sc1.close();
          }
          
          //System.out.println(inputList1);

          String input2 = req.queryParams("input2");
          ArrayList<Integer> inputList2 = new ArrayList<>();
          if(input2.equals("")){

            inputList2.add(0);
          }

          else{
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc2.useDelimiter("[;\r\n]+");
            while (sc2.hasNext())
            {
              int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
              inputList2.add(value);
            }
                sc2.close();
          }

          String input3 = req.queryParams("input3");
          ArrayList<String> inputList3 = new ArrayList<>();
          if(input3.equals("")){

            inputList2.add(null);
          }

          else{
            java.util.Scanner sc3 = new java.util.Scanner(input3);
            sc3.useDelimiter("[;\r\n]+");
            while (sc3.hasNext())
            {
              String value = (sc3.nextLine().replaceAll("\\s",""));
              inputList3.add(value);
            }
                sc3.close();
          }

          String input4 = req.queryParams("input4").replaceAll("\\s","");
          char inputChar;

          if(input4.equals("")){
                inputChar = ' ';

          }

          else{
            java.util.Scanner sc4 = new Scanner(input4);
            sc4.useDelimiter("[;\r\n]+");
            inputChar = sc4.next().charAt(0);
            sc4.close();
          }

          ArrayList<String> result = App.suggestPassword(inputList1, inputList2, inputList3, inputChar);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
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
