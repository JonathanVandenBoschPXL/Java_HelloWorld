package Prisma.WebTests;

import Prisma.web.pageObjects.AllPages;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OverzichtkinderenTest {

    AllPages pages;

    @BeforeClass
    public void testSetup(){
        pages = new AllPages();
        pages.overzichtkinderen.NavigateToPage();
    }

    @Test
    public void checkIfChildAvailable(){
        pages.overzichtkinderen.childIsVisible();
    }

    @AfterClass
    public void TestTeardown(){
        pages.closeBrowser();
    }




}
