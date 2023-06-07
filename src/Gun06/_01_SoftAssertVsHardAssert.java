package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVsHardAssert {


    @Test
    void hardAssert()
    {
        String s1="Merhaba";

        System.out.println("Hard assert öncesi");
        Assert.assertEquals("Merhaba123", s1, "Oluşan la beklene  eşit değil."); // test kırılıyor
        System.out.println("Hard assert sonrası");
    }

    @Test
    void softAssert()
    {
       String strHomePage="www.facebook.com/homepage";
       String strCartPage="www.facebook.com/cartpage";
       String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert(); // bekletmeli assert gibi

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage); // true
        System.out.println("soft Assert 1");

        _softAssert.assertEquals("www.facebook.com/profile", strCartPage);  // false
        System.out.println("soft Assert 2");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount); // false
        System.out.println("soft Assert 3");

        _softAssert.assertAll();   // bütün assert sonuçlarını işleme koyuyor.
        System.out.println("soft AssertAll : aktfilik sonrası");
        // bu bölüm assertAll dan sonra olduğu ve öncesinde hata oluştuğu için ekrana çıkamayacak
    }
}
/*
soft Assert 1
soft Assert 2
soft Assert 3

java.lang.AssertionError: The following asserts failed:
	expected [www.facebook.com/cartpage]        but found [www.facebook.com/profile],
	expected [www.facebook.com/editaccountpage] but found [www.facebook.com/settings]
*/














