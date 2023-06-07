package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {


    /**
     * Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     * Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
     * XML filer file gruplama, paralel, ve farklı tesleri koordine edip birarada çalıştırmak için kullanılır.
     */

    @Test(dataProvider ="datalarim" )
    void UserNameTest(String userAdi){
        System.out.println("userAdi = " + userAdi);
    }
    // yukarıdaki test, aynı FOR gibi 4 kere çalışacak.

    @DataProvider // bu metoda dataprovider görevi verildi. (data lar burada, test yukarıda)
    Object[] datalarim() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
                         // String ve int i ayrı ayrı yazmama gerek kalmadan OBJECT yazıyorum.
    {
        Object[] userlar={"Nurhayat","Alper","Uğur","Hakan"};

        return userlar;
    }

    /*********************************/

    @Test(dataProvider ="datalarim1" )
    void UserNameTest1(int id){
        System.out.println("userAdi = " + id);
    }

    @DataProvider // bu metoda dataprovider görevi verildi.
    Object[] datalarim1() // DataProvider olarak kullanılcak metodun tipi Object olmak zorunda.
    {
        Object[] userlar={1,2,3,4};

        return userlar;
    }
}
/*
userAdi = Nurhayat
userAdi = Alper
userAdi = Uğur
userAdi = Hakan
userAdi = 1
userAdi = 2
userAdi = 3
userAdi = 4
*/
