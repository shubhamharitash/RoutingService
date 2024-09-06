package com.spring.practiceSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RoutingService {
    String defaultPath;
    Map<String,String> routeFuncMap;
    Map<String,String> regexPattern;

    public RoutingService(String defaultPath) {
        this.defaultPath = defaultPath;
        this.routeFuncMap = new ConcurrentHashMap<>();
        this.regexPattern=new ConcurrentHashMap<>();
    }


   public String invokeFunc(String path){

 if(routeFuncMap.containsKey(path)) {
           return routeFuncMap.get(path);
       }else {
   //regex search
     String regexout="";
           String [] inputPath=path.split("/");

           for (String regex:regexPattern.keySet()) {
               String [] regexPath=regex.split("/");
               if (regexPath.length==inputPath.length){
                   for (int i=0;i<regexPath.length;i++){
                       if (!regexPath[i].equals("*") && !regexPath[i].equals(inputPath[i])) {
                               System.out.println(regexPath[i]+"    "+inputPath[i]);
                               return defaultPath;
                           }
                       }

                   regexout= regexPattern.get(regex);
               }else
                   regexout= defaultPath;

           }

         return   regexout;

       }

       return defaultPath;

    }


    public void putPath(String key,String value){
        routeFuncMap.put(key,value);
    }

    public void putRegexPattern(String regex,String value){
       regexPattern.put(regex,value);
    }




}
