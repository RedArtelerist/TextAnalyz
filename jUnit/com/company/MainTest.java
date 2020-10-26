package com.company;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class MainTest {
    private String myText;
    @BeforeClass
    public static void setup() {
        System.out.println("Startup - creating BeforeClass");
    }

    @Before
    public void init() throws IOException {
        System.out.println("startup");
        this.myText = Main.readFromFile("1.txt");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("End - creating AfterClass");
    }

    @After
    public void clear() {
        System.out.println("clear");
        myText = "";
    }

    @Test
    public void splitTextTest() throws Exception {
        String text = "how24are;34'you-=my;fri0end";
        ArrayList<String> words = new ArrayList<>();
        words.add("how");
        words.add("are");
        words.add("you");
        words.add("my");
        words.add("fri");
        words.add("end");

        assertEquals(Main.splitText(text), words);
    }

    @Test
    public void onlyLettersTest() throws Exception {
        ArrayList<String> words = new ArrayList<>();
        words.add("how");
        words.add("are");
        words.add("you");
        words.add("my");
        words.add("friend");
        assertTrue(Main.onlyLetters(words));
    }

    @Test
    public void notOnlyLettersTest() throws Exception {
        ArrayList<String> words = new ArrayList<>();
        words.add("how");
        words.add("ar3e");
        words.add("you");
        words.add("my");
        words.add("friend");
        assertFalse(Main.onlyLetters(words));
    }

    @Test
    public void notNullTest() throws Exception {
        assertNotNull(Main.processWords(Main.splitText(myText)));
    }

    @Test
    public void hamcrestNotEmptyTest() throws Exception {
        ArrayList<String> res = Main.processWords(Main.splitText(myText));
        assertThat(res, not(empty()));
    }

    @Test
    public void hamcrestHasItemTest() throws Exception {
        ArrayList<String> res = Main.processWords(Main.splitText(myText));
        assertThat(res, hasItem("you"));
    }
}