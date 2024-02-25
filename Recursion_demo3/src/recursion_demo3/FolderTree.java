/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion_demo3;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author NC
 */
public class FolderTree {

    public static void main(String[] args) {
        String path;
        int prefix = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the path of a folder:");
        path = sc.nextLine();
        File f = new File(path);
        if (f.exists()) {
            print(f, prefix);
        }
    }

    public static int compare(File f1, File f2) {
        int diff;
        if (f1.isDirectory() && f2.isFile()) {
            diff = -1;
        } else if (f1.isFile() && f2.isDirectory()) {
            diff = 1;
        } else {
            String f1Name = f1.getName().toUpperCase();
            String f2Name = f2.getName().toUpperCase();
            diff = f1Name.compareTo(f2Name);
        }
        return diff;
    }

    public static void sort(File[] list) {
        int n = list.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                int d = compare(list[j], list[j - 1]);
                if (d < 0) {
                    File t = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = t;
                }
            }
        }
    }

//    public static void print(File f, int prefix) {
//        if (prefix > 0) {
//            for (int i = 1; i <= prefix; i++) {
//                System.out.print("  "); // Two spaces per level of indentation
//            }
//            System.out.print("|_");
//        }
//        System.out.println(f.getName());
//
//        if (f.isDirectory()) {
//            File[] children = f.listFiles();
//            sort(children);
//            for (File child : children) {
//                print(child, prefix + 1); // Increase the indentation level
//            }
//        }
//    }
    public static void print(File f, int prefix) {
        if (prefix > 0) {
            for (int i = 1; i <= prefix; i++) {
                System.out.print("| ");
            }
            System.out.print("|_");
        }
        System.out.println(f.getName());

        if (f.isDirectory()) {
            File[] children = f.listFiles();
            sort(children);
            for (File child : children) {
                print(child, prefix + 1);
            }
        }
    }

}
