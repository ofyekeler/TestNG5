package Gun03;

import org.testng.annotations.Test;

public class _01_Dependency_Bagimlilik { // (Bağımlılık)
    // arabanın hareketi : start, drive, park, stop hareket sırası
    // Birisinin çalışmasını, diğerinin çalışmasına bağlama.

    @Test
    void startCar(){
        System.out.println("startCar");
        //Assert.fail();   ->  Bu hatayı çıkardığımızda diğer testleri IGNORE oldu.
    }
    @Test(dependsOnMethods = {"startCar"})// bu testin çalışması, startCar ın hatasız çalışmasına bağımlı
    void driveCar(){
        System.out.println("driveCar");
    }
    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar() {
        System.out.println("parkCar");
    }
    // alwaysRun = true bağımlılıkları var (parkCar) ama hata çıkarsa da yine çalıştır.
    // alwaysRun, genelde STOP özelliklerinde kullanılır.
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
    void stopCar(){
        System.out.println("stopCar");
    }
    // aynı seviyedeki testleri için priority verilebilir.
    /* bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
       1 üste kadar otomatik çağırıp çalışabilir.
       Yani kendinden önce 2 tane bağımlı varsa önce onları çalışır, sonra kendisi çalışır. */
}