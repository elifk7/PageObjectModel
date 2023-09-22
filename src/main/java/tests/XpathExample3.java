package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.MenuPage;
import utils.BaseTest;

public class XpathExample3 extends BaseTest{
	
	@Test
	public void xpathExamaple() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		MenuPage menu =  new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		//-->//bdi[contains(text(), '20.55')]
		//-->//span[@class='price']/span[bdi='$14.99']
		
		//scroll down 1200
		jse.executeScript("window.scrollBy(0,1200)");
		
		WebElement price14_99 = driver.findElement
				(By.xpath("//span[@class='price']/span[bdi='$14.99']"));
		//scroll to element
		//jse.executeScript("arguments[0].scrollIntoView()", price14_99);
		
		jse.executeScript
			("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", price14_99);

		
		//--> //bdi[contains(text(), '10.35')]/../../../del/child::*/bdi
		//   .. --> merge inapoi un nivel (urca pe parinte) 
		
		WebElement price11_50 = driver.findElement
				(By.xpath("//bdi[contains(text(), '10.35')]/../../../del/child::*/bdi"));
		jse.executeScript
		("arguments[0].setAttribute('style', 'background: orange;border:4px solid blue')", price11_50);

		//--> (//span[@class='price']/span[bdi='$10.20'])[2]/../../div
		/* 1. plec de la elementul --> //span[@class='price']
		 * 2. cobor pe copilul lui <span> --> //span[@class='price']/span
		 * 3. de la span, fac o referinta catre copilul lui span <bdi> si valoarea
		 * acestui copil --> //span[@class='price']/span[bdi='$10.20']
		 * 4. pentru ca acum gasesc 5 elemente su vreau specific elementul numarul 2
		 * aleg sa folosesc index -->(//span[@class='price']/span[bdi='$10.20'])[2]
		 * 5. dupa ce m-am oprit pe elementul 2 cu index, urc cu .. doua niveluri mai sus
		 * adica pe doi parinti -->(//span[@class='price']/span[bdi='$10.20'])[2]/../..
		 * 6. de la ultimul parinte cobor pe copilul <div> -->(//span[@class='price']/span[bdi='$10.20'])[2]/../../div
		 * 
		 */
		
		//-->(//span[@class='price']/span[bdi='$10.20'])[2]/../preceding-sibling::div[@class='star-rating']
		/* 1. plec de la elementul --> //span[@class='price']
		 * 2. cobor pe copilul lui <span> --> //span[@class='price']/span
		 * 3. de la span, fac o referinta catre copilul lui span <bdi> si valoarea
		 * acestui copil --> //span[@class='price']/span[bdi='$10.20']
		 * 4. pentru ca acum gasesc 5 elemente su vreau specific elementul numarul 2
		 * aleg sa folosesc index -->(//span[@class='price']/span[bdi='$10.20'])[2]
		 * 5. urc cu ..  un nivel mai sus unde gasesc o relatie de rudenie de tip siblings
		 * -->(//span[@class='price']/span[bdi='$10.20'])[2]/..
		 * 6. pentru ca vreau sa iau fratele/sora de deaspura elementului unde ma aflu,
		 * aleg sa urc cu preceding-sibling pe element
		 * -->(//span[@class='price']/span[bdi='$10.20'])[2]/../preceding-sibling::div[@class='star-rating']
		 */
		
		
		//in shop paginele de jos de sub carti 1-2
		
		//xpath--> //ul/li[*>1]
		//Xpath--> //*[self::span or self::a][contains(@class, 'page-numbers') and not(contains(text(), '1') or contains(text(), '→'))]
		//xpath--> //*[text()=2]
		
		/* Gaseste toate paginile care au valoarea mai mare ca 1 (*>1)indiferent de tag-name-ul lor (*)
		 * 
		 * 
		 */
		//--> //*[contains(@class, 'page-numbers') and not(contains(text(), '1'))]
		
		
	}

}
