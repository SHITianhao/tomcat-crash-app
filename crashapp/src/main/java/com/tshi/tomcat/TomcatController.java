package com.tshi.tomcat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController()
public class TomcatController {

    public static ArrayList<String> LEAK = new ArrayList<String>();
    private static String FILL_STRING = "XXXXXXXXXX";
    private static int ONE_LOOP = 1250000;
    private static int MAX_LOOP = 20;

    @GetMapping("/hello")
    public String sayHello() {
        long freeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        return "Hello World! Free Memory: " + freeMem + "MB";
    }

    @GetMapping("/leak")
    public void leak() throws Exception {
        System.out.println("\n=================> LEAK: OOM test started..\n");
        for (int outerIterator = 1; outerIterator < MAX_LOOP; outerIterator++) {
            long freeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024);
            System.out.println("Iteration " + outerIterator + " Free Mem: " + freeMem + "MB");
            for(int i = 0; i < ONE_LOOP; i++) {
                LEAK.add(FILL_STRING);
            }
            Thread.sleep(1000);
        }
    }

    @GetMapping("/crash")
    public void crash() throws Exception {
        System.out.println("\n=================> OOM test started..\n");
        ArrayList<String> list = new ArrayList<String>();
        for (int outerIterator = 1; outerIterator < MAX_LOOP; outerIterator++) {
            long freeMem = Runtime.getRuntime().freeMemory() / (1024 * 1024);
            System.out.println("Iteration " + outerIterator + " Free Mem: " + freeMem + "MB");
            for(int i = 0; i < ONE_LOOP; i++) {
                list.add(FILL_STRING);
            }
            Thread.sleep(1000);
        }
    }
}