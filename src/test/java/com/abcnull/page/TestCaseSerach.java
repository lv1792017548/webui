package com.abcnull.page;

import com.abcnull.common.PageCommon;
import com.abcnull.data.BaiduData;
import com.abcnull.locator.BaiduLocator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
public class TestCaseSerach extends PageCommon {
    public TestCaseSerach(WebDriver driver) {
        super(driver);
    }

    public boolean search(String aaa){
        log.info("搜索");
        // 百度搜索框搜索数据
        WebElement webElement =  sendInput(BaiduLocator.SEARCH_INPUT, aaa);
        log.info("输入框的值："+webElement.getAttribute("value"));
        // 点击搜索按钮
        clickButton(BaiduLocator.SEARCH_BUTTON);


        /*
         * redisUtil 工具类是对 jedis 的一层封装，其中已设置了所有键值对有效时间
         * redisUtil 来存取键值对，放在一个线程中被别的类使用到
         * redisUtil 存取键值对设置了键值过期时限，这个时限在 properties 文件中已配置
         * 若想自己设置时限可以直接使用 jedis 而不使用 redisUtil，如下所示：
         */
//        redisUtil.setKey("a", "1");
//        System.out.println("redis 中的值为：" + redisUtil.getKey("a"));

        /*
        jedis.set("a", "1");
        // 设置键值过期时间 600 s
        jedis.expire("a", 600);
        */

        // 返回是否进入指定页面
        return ifTitleContains(aaa);
    }
//    public WebElement locateElement(By locator) {
//        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//    }
    public boolean clickFunction(String aaa) throws InterruptedException {
        WebElement locateElement =locateElement(BaiduLocator.SEARCH_href);

        String url1 = locateElement.getAttribute("href");
        log.info("url1"+url1);
        locateElement.click();
//        ((JavascriptExecutor)driver).executeScript("window.open('"+url1+"')");
//        Thread.sleep(5000);
        //  clickButton(BaiduLocator.SEARCH_BUTTON_BY_CSS_SELECOER);
        return ifTitleContains(aaa);
    }


}
