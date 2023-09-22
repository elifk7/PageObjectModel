package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class temaCurs22 extends BaseTest {

    @Test
    public void verificare() throws InterruptedException {

        app.menu.navigateTo(app.menu.singleAuthorLink);

        List<String> procenteCitite = app.singleAuthor.getPercentage();

        List<String> procenteComp = new ArrayList<>(Arrays.asList("95%", "75%", "82%"));

        for(String el: procenteCitite)
            System.out.println(el);

        //Arrays.equals(procenteCitite, procenteComp);

    }
}
