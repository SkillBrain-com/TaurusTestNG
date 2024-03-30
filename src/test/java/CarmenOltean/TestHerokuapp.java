package CarmenOltean;

import org.openqa.selenium.WebDriver;
import org.skillbrain.BasePageObject;

import java.io.IOException;

public class TestHerokuapp {

    public static void main(String[] args) throws IOException {
        org.skillbrain.BasePageObject bpo = new BasePageObject();
        WebDriver chromeDriver = bpo.getChromeDriver();
        HerokuappPageObject hkapp = new HerokuappPageObject(chromeDriver);
        try{
            hkapp.langOnHerokuapp();
            hkapp.dynamicTable();
            hkapp.getTableTitle();
            hkapp.getTableId();
            hkapp.getTableHeader();
            hkapp.testDynamicTable();
            hkapp.refreshTable();
            hkapp.tableContent();
            hkapp.getTableId();
            hkapp.getTableTitle();



    }
        catch(Exception e){
            bpo.takeScreenshot(chromeDriver);
            e.printStackTrace();
        }
        finally {
            chromeDriver.quit();
        }
        }
}
