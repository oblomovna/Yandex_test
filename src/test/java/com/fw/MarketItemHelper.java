package com.fw;

import com.fw.HelperBase;
import com.model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MarketItemHelper extends HelperBase {

    public MarketItemHelper(WebDriver wd) {
        super(wd);
    }

    public void switchToNextTab(){
        List<String> avialabletabs = new ArrayList<>(wd.getWindowHandles());
        if(!avialabletabs.isEmpty()){
            wd.switchTo().window(avialabletabs.get(1));
        }
    }
    public void filterItem(Item item1) {
        click(By.cssSelector("[href*='/catalog--"+ item1.getItemType() +"']"));

        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        type(By.cssSelector("#glpriceform"), item1.getPriceFrom());
        type(By.cssSelector("#glpriceto"), item1.getPriceTo());
        click(By.xpath("//*[text()='"+ item1.getBrand() +"']"));
    }
    public String getItemNameFromListByOrder(int number) {
        return wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet']["+number+"]//h3")).getText();
    }


}
