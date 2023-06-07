package Gun01;

import org.testng.annotations.*;

/*
        @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)
           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak
        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)
     */
public class _02_Annotations { // Dipnotlar
    @BeforeClass  // -> Her metoddan önce çalışır
    public void beforeClass(){
        System.out.println("before class çalıştı");
    }

    @AfterClass  // -> Her metoddan sonra çalışır
    public void afterClass(){
        System.out.println("after class çalıştı");
    }

    @BeforeMethod  // -> Her metoddan önce çalışır
    public void beforeMethod(){
        System.out.println("beforeMethod çalıştı");
    }

    @AfterMethod  // -> Her metoddan sonra çalışır
    public void afterMethod(){
        System.out.println("afterMethod çalıştı");
    }

    @Test  // test metodu
    public void test1(){
        System.out.println("test 1 çalıştı");
    }

    @Test // test metodu
    public void test2(){
        System.out.println("test 2 çalıştı");
    }
/*
before class çalıştı

beforeMethod çalıştı
test 1 çalıştı
afterMethod çalıştı

beforeMethod çalıştı
test 2 çalıştı
afterMethod çalıştı

after class çalıştı
*/
}