package Gun01;

import org.testng.annotations.Test;

public class _01_Giris_Priority_OncelikSirasi {
/*
org.seleniumhq.selenium:selenium-java:4.8.1
org.testng:testng:6.14.3

kütüphanelerini "From Maven" den yükledim. (PC ye manual indirip Java dan tanımlama yapmadık !!!)
*/
    //    public static void main(String[] args) {
//        webSitesiniAc();
//        LoginIsleminiYap();
//        driveriKapat();
//    }

//    @Test JUnit
//    public void Test1(){
//        webSitesiniAc();
//        LoginIsleminiYap();
//        driveriKapat();
//    }

    // Eğer herhangi bir sıralama verilmezse metod isimlerinin alfabetik çalışıyor
    @Test(priority = 1) // Bir önceki JUnit di. Şimdi ise testNG
                        //default 0 : index gibi düşünebiliriz. PRIORITY yazmazsak 0 olarak algılar.
    public void webSitesiniAc(){
        System.out.println("driver tanımlandı ve webSitesiniAcildi");
    }

    @Test(priority = 2)
    public void loginIsleminiYap(){
        System.out.println("LoginTest işlemi yapıldı");
    }

    @Test(priority = 3)
    public void driveriKapat(){
        System.out.println("driver kapatıldı.");
    }
    // PRIORIT ile öncelik sırasına dizdik
}
