package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {


    @Test
    void equalsOrnek() // String
    {
        String s1="Merhaba";
        String s2="Merhaba1";

        // Actual (oluşan), Expected(beklenen), Mesaj(opsiyonel)
        Assert.assertEquals(s1,s2, "oluşan la beklenen eşit değil");
        //Assert.assertEquals(driver.getTitle(),"My Account", "Login olamadı"); // aem
    }

    @Test
    void notEqualsOrnek() // String
    {
        String s1="Merhaba";
        String s2="Merhaba1";

        Assert.assertNotEquals(s1,s2, "Oluşan ve Beklenen eşit oldu"); // else , mesaj s1 s2 ye eşitse çıkar
    }

    @Test
    void TrueOrnek() // int
    {
        int s1=55;
        int s2=66;

        Assert.assertTrue(s1 == s2, "Oluşan ve Beklenen eşit olmadı"); // mesajı ELSE durumu gibi düşünü,
                                                                       // beklediğim olmayınca gözükecek
    }

    @Test
    void nullOrnek()
    {
       String s1=null;

        Assert.assertNull(s1, "Oluşan NULL olmadı");
    }

    @Test
    void direkFail()
    {
        int a=55;

        if (a==55) // (hata çıkarmanın şartını yazdım.)
            Assert.fail(); // Assert.fail("hata oluştu")
    }
}
