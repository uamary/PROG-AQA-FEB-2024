package org.prog.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


//TODO: Catch parent exceptions (EXception / Throwable)
//TODO: Catch specific exception
//TODO: Convert FileNotFoundException into Throwable in readFile3
//TODO: Process Throwable in readFile1
public class ExceptionsDemo {

    public static void main(String[] args) {
        readFile1();

        try {
            zero(6, 8);
        } catch (ArithmeticException ae) {
            System.out.println("/ 0 is not allowed");
        }

        try {
            zero(6, 0);
        } catch (ArithmeticException ae) {
            System.out.println("/ 0 is not allowed");
        }

        arr(7, 9);

        arr(7, 4);

        try {
            createFile();
        } catch (RuntimeException e){
            System.out.println("block catch");
        }

    }

    public static void zero(int a, int b) {
        System.out.println("result = " + a / b);
    }

    public static void arr(int i, int j) {
        try {
            int[] arr = new int[i];
            System.out.println("arr[" + j + "] = " + arr[j]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("try another index");
        }
    }

    public static void createFile() {
        File newFile = new File("test_folder/folder/file.txt");
        try {
            newFile.createNewFile();
            System.out.println("file was successfully created");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void readFile1() {
        try {
            readFile2();
            System.out.println("block try");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("block catch");
        }
    }

    public static void readFile2() throws Throwable {
        readFile3();
    }

    public static void readFile3() throws Throwable {
        try {
            readFile4();
        } catch (FileNotFoundException e) {
            throw new Throwable(e);
        }
    }

    public static void readFile4() throws FileNotFoundException {
    }

    public static void readFile5() throws FileNotFoundException {
        File f = new File("abc.txt");
        FileReader fileReader = new FileReader(f);
        f.setReadable(true);
    }
}
