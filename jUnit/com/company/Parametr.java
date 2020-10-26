package com.company;

import org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Parametr {
    ArrayList<String> fInput;
    ArrayList<String> fExpected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
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
        res2.add("aaaaaauiiiiiiiyyyyyyyyoooooooo");
        res2.add("aaaa");


        return Arrays.asList(new Object[][]{{words1, res1}, {words2, res2}, {words3, null}});
    }

    public Parametr(ArrayList<String> fInput, ArrayList<String> fExpected) {
        this.fInput = fInput;
        this.fExpected = fExpected;
    }

    @Test
    public void process() {
        Assert.assertEquals("Result", this.fExpected, Main.processWords(this.fInput));
    }
}