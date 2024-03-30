package CarmenOltean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.skillbrain.BasePageObject;

import java.util.List;

public class HerokuappPageObject extends BasePageObject {



    private static final String HEROKUAPP_HOME_PAGE = "https://testpages.eviltester.com/styled/index.html";

    public HerokuappPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public void langOnHerokuapp(){
        driver.get(HEROKUAPP_HOME_PAGE);
    }
    @FindBy(id = "dynamictablestest")
    private WebElement dynamicTablePage;
    public void dynamicTable(){
        dynamicTablePage.click();
    }

    @FindBy(css = "#tablehere table caption")
    private WebElement tableTitle;
    public void getTableTitle(){
        System.out.println("Table title: " + tableTitle.getText());
    }
    @FindBy(css="#tablehere table")
    private WebElement tableId;
    public void getTableId(){
        System.out.println("Table Id: " + tableId.getAttribute("id"));
    }
    public void getTableHeader(){
        List<WebElement> tableRows = driver.findElements(By.cssSelector("#tablehere table tr"));
        WebElement tableHeader = tableRows.get(0);
        List<WebElement> headerColumns = tableHeader.findElements(By.cssSelector("th"));
        System.out.println("First column header: " + headerColumns.get(0).getText());
        System.out.println("Second column header: " + headerColumns.get(1).getText());

    }
    public void testDynamicTable() {
        driver.findElement(By.cssSelector("summary")).click();
        WebElement caption = driver.findElement(By.id("caption"));
        caption.clear();
        caption.sendKeys("New Dynamic Table");
        WebElement tableId = driver.findElement(By.id("tableid"));
        tableId.clear();
        tableId.sendKeys("newTableId");


        WebElement jsondata = driver.findElement(By.id("jsondata"));
        jsondata.clear();
        jsondata.sendKeys("[{\"name\" : \"Andrei\", \"age\" : 30}, {\"name\": \"Maria\", \"age\" : 22}, {\"name\": \"George\", \"age\" : 42},{\"name\": \"Vlad\", \"age\" : 15},{\"name\": \"Marius\", \"age\" : 28}]");
        //System.out.println(jsondata.getAttribute("value"));
    }
public void tableContent(){
        List<WebElement> tableRows = driver.findElements(By.cssSelector("#tablehere table tr"));
        for (int i = 0; i < tableRows.size(); i++) {
            WebElement currentRow = tableRows.get(i) ;
            if (i==0){
                List<WebElement> firstRow = driver.findElements(By.cssSelector("#tablehere table tr"));
                WebElement firstRowColumns = firstRow.get(0);
                List<WebElement> headerColumns = firstRowColumns.findElements(By.cssSelector("th"));
                System.out.println("Element from first row: " + headerColumns.get(0).getText());
                System.out.println("Element from second row: " + headerColumns.get(1).getText());
            }
            else {
                List<WebElement> currentColumn = currentRow.findElements(By.cssSelector("td"));
                System.out.println("Element from row " + (i+1) + " Column 1" + " " + currentColumn.get(0).getText());
                System.out.println("Element from row " + (i+1) + " Column 2" + " " + currentColumn.get(1).getText());
            }
        }



    }

    @FindBy(id = "refreshtable")
    private WebElement refreshButton;
    public void refreshTable(){
        refreshButton.click();
    }





}
