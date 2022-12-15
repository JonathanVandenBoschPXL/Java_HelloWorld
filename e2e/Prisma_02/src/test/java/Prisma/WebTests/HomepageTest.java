package Prisma.WebTests;

import Prisma.web.pageObjects.AllPages;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomepageTest {

    AllPages pages;

    @BeforeClass
    public void testSetup(){
        pages = new AllPages();
        pages.homepage.NavigateToPage();
    }

    @Test
    public void resize(){
        pages.homepage.resizeHomepage();
    }

    @AfterClass
    public void testTeardown(){
        pages.closeBrowser();
    }

}

