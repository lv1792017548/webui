package com.abcnull.testcase;

import com.abcnull.base.BaseTest;
import com.abcnull.page.BaiduPage;
import com.abcnull.page.TestCaseSerach;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 百度页面测试用例
 *
 * @author abcnull
 * @version 1.0.0
 * @date 2020/1/28
 */
public class TestCase extends BaseTest {
    /**
     * 百度页面对象
     */
    private TestCaseSerach baiduPage;

    @Test(description = "百度首页_搜索测试", priority = 1)
    public void testSearch() throws InterruptedException {
        // 初始化百度页面
        baiduPage = new TestCaseSerach(driver);
        // 进入百度首页
        baiduPage.jumpPage("https://www.baidu.com");
        // 百度页面搜索检测;
        boolean a =baiduPage.search("平安");
       // baiduPage.
        if (a){System.out.println("已经进入页面");}

        Thread.sleep(3000);
        boolean b =  baiduPage.clickFunction("平安_百度搜索");
        Assert.assertEquals(true,b);
    }
}
