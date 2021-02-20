package com.tests;

import com.model.Item;
import com.fw.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void testItem() throws InterruptedException {
     /*   Перейти на Яндекс Маркет
        Выбрать раздел  Компьютеры
        Выбрать раздел Планшеты
        Зайти в расширенный поиск
        Задать параметр поиска от 20000 до 35000 рублей.
                Выбрать производителя “Apple”
        Применить условия поиска
        Запомнить второй элемент в результатах поиска
        В поисковую строку ввести запомненное значение.
        Найти и проверить, что наименование товара соответствует запомненному значению.
    }*/
        app.mainPage().goToMarket(By.cssSelector("[data-id='market']"));
        app.marketItem().switchToNextTab();
      // pause(2000);
        app.marketHeader().selectComputersDepartment(By.cssSelector("[href*='/catalog--kompiuternaia-tekhnika']"));
        app.marketItem().filterItem(new Item()
                .setItemType("planshety")
                .setPriceFrom("200000")
                .setPriceTo("35000")
                .setBrand("Apple"));
        app.marketHeader().pause(3000);
        String item = app.marketItem().getItemNameFromListByOrder(2);

        System.out.println(item);

       String itemName = app.marketItem().getItemNameFromListByOrder(2);

        app.marketHeader().searchItemFromSearchBox(itemName);
        app.marketItem().pause(3000);
        String foundItemName = app.marketItem().getItemNameFromListByOrder(1);

        Assert.assertEquals(foundItemName,itemName);




 //   public void searchItemFromSearchBox(String itemName){
    //    app.type(By.cssSelector("#header-search"),itemName);
     //   app.goToMarket(By.cssSelector("[type=submit]"));
    }
}
