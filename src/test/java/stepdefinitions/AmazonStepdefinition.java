package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import ultilities.ConfigReader;
import ultilities.Driver;
import ultilities.ReusableMethods;

public class AmazonStepdefinition {
    AmazonPage amazonPage= new AmazonPage();
    @Given("Kullanici Amazon anasayfaya gider")
    public void kullaniciAmazonAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }

    @Then("arama kutusuna Nutella yazdirir ve enter tusuna basar")
    public void aramaKutusunaNutellaYazdirirVeEnterTusunaBasar() {
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }

    @And("arama sonuclarinin Nutella icerdigini test eder")
    public void aramaSonuclarininNutellaIcerdiginiTestEder() {
        String expectedIcerik="Nutella";
        String actualAramaSonucYazisi= amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));
    }



    @And("{int} saniye bekler")
    public void saniyeBekler(int beklenenSaniye ) {
        ReusableMethods.bekle(beklenenSaniye);

    }

    @When("arama kutusuna Java yazar ve enter tusuna basar")
    public void aramaKutusunaJavaYazarVeEnterTusunaBasar() {
        amazonPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
    }


    @Given("kullanici amazon anasayfaya gider")
    public void kullanici_amazon_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    }
    @Then("amazon arama kutusuna Java yazip aratir")
    public void amazon_arama_kutusuna_java_yazip_aratir() {
        amazonPage.aramaKutusu.sendKeys("Java"+Keys.ENTER);

    }
    @When("arama sonuclarinin Java icerdigini test eder")
    public void arama_sonuclarinin_java_icerdigini_test_eder() {
        String expectedeIcerik="Java";
        String ActualIcerik=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(ActualIcerik.contains(expectedeIcerik));

    }
    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @Then("amazon arama kutusuna apple yazip aratir")
    public void amazonAramaKutusunaAppleYazipAratir() {
        amazonPage.aramaKutusu.sendKeys("Apple"+Keys.ENTER);

    }

    @When("arama sonuclarinin apple icerdigini test eder")
    public void aramaSonuclarininAppleIcerdiginiTestEder() {
        String expectedIcerik="Apple";
        String actualIcerik= amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
