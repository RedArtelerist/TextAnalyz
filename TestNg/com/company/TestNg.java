package com.company;


import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;

import java.io.IOException;
import java.util.ArrayList;

public class TestNg {
    private String myText;
    @BeforeClass(groups = {"Main"})
    public static void setup() {
        System.out.println("Startup - creating BeforeClass");
    }

    @BeforeMethod(groups = {"Main"})
    public void init() throws IOException {
        System.out.println("startup");
        this.myText = Main.readFromFile("1.txt");
    }

    @AfterClass(groups = {"Main"})
    public static void tearDown() {
        System.out.println("End - creating AfterClass");
    }

    @AfterMethod(groups = {"Main"})
    public void clear() {
        System.out.println("clear");
        myText = "";
    }

    @DataProvider
    public static Object[][] getParameters() {
        ArrayList<String> words1 = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();
        ArrayList<String> words3 = new ArrayList<>();
        ArrayList<String> res1 = new ArrayList<>();
        ArrayList<String> res2 = new ArrayList<>();
        ArrayList<String> res3 = new ArrayList<>();

        words1.add("afjafjkajkf");
        words1.add("you");
        words1.add("ddddddiiioooo");
        words1.add("ooooooooooooos");
        words1.add("aaaaaaaa");
        words1.add("YOU");
        words1.add("a");
        words1.add("A");
        words1.add("aaaa");

        words2.add("YOUUUUUUUUUUUU");
        words2.add("youuuuuuuuuuuu");
        words2.add("a");
        words2.add("oooooAoooooooos");
        words2.add("A");
        words2.add("b");
        words2.add("a");
        words2.add("A");
        words2.add("aaaaaauiiiiiiiyyyyyyyyoooooooooooooooooooooooooooyyyyyyyyyyeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        words2.add("aaaa");


        words3.add("jjksjdjksdjk");
        words3.add("yjjksjdjksdjkou");
        words3.add("ddddddiiioooo");
        words3.add("jjksjfasdjk");
        words3.add("jjksjdjksdjk");
        words3.add("jjksjdjksdjk");
        words3.add("jjkjksdjk");
        words3.add("jdjksdjk");
        words3.add("fkdlkd");

        res1.add("you");
        res1.add("aaaaaaaa");
        res1.add("a");
        res1.add("aaaa");

        res2.add("youuuuuuuuuuuu");
        res2.add("a");
        res2.add("aaaaaauiiiiiiiyyyyyyyyoooooooo");
        res2.add("aaaa");

        return (new Object[][]{{words1, res1}, {words2, res2}, {words3, null}});
    }


    @Test(groups = {"Test2"}, dataProvider = "getParameters")
    public void process(ArrayList<String> input, ArrayList<String> expected) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(expected, Main.processWords(input));
        System.out.println("Parameter Test");
    }

    @Test(groups = {"Test1"})
    public void splitTextTest() throws Exception {
        String text = "how24are;34'you-=my;fri0end";
        ArrayList<String> words = new ArrayList<>();
        words.add("how");
        words.add("are");
        words.add("you");
        words.add("my");
        words.add("fri");
        words.add("end");

        Assert.assertEquals(Main.splitText(text), words);

        System.out.println("splitTextTest");
    }

    @Test(groups = {"Test2"})
    public void onlyLettersTest() throws Exception {
        ArrayList<String> words = new ArrayList<>();
        words.add("how");
        words.add("are");
        words.add("you");
        words.add("my");
        words.add("friend");
        Assert.assertTrue(Main.onlyLetters(words));

        System.out.println("onlyLettersTest");
    }

    @Test(groups = {"Test2"})
    public void notOnlyLettersTest() throws Exception {
        ArrayList<String> words = new ArrayList<>();
        words.add("how");
        words.add("ar3e");
        words.add("you");
        words.add("my");
        words.add("friend");
        Assert.assertFalse(Main.onlyLetters(words));

        System.out.println("notOnlyLettersTest");
    }

    @Test(groups = {"Test1"})
    public void notNullTest() throws Exception {
        Assert.assertNotNull(Main.processWords(Main.splitText(Main.readFromFile("1.txt"))));
        System.out.println("notNullTest");
    }
}
