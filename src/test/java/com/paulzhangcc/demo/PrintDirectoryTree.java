package com.paulzhangcc.demo;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author paul
 * @date 2017/12/27
 */
public class PrintDirectoryTree {
    public static void main(String[] args) {
        print("",new File("C:\\pengrun\\work\\dubbostudy\\demo\\src\\main"));
    }
    private static void print(String prefix,File file){
        File[] subFiles = file.listFiles(new FilenameFilter(){

            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".java") ||name.endsWith("DAO.xml") ) {
                    return false;
                }
                return true;
            }
        });
        prefix = prefix +"++";
        for (File subFile : subFiles){

            if (subFile.isDirectory()){
                System.out.println(prefix.replaceAll("\\+","-")+subFile.getName());
            }else {
                System.out.println(prefix+subFile.getName());
            }

            if (subFile.isDirectory()){
                print(prefix,subFile);
            }
        }
    }
}
