package com.oppo.open.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
     public String sayWhat;
     public String toWho;
     public DemoService(String sayWhat, String toWho){
         this.sayWhat = sayWhat;
         this.toWho = toWho;
     }
     public String say(){
       return this.sayWhat + "!  " + toWho;
     }
 }