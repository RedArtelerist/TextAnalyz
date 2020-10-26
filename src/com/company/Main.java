package com.company;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static ArrayList<String> splitText(String text) {
        ArrayList<String> words = new ArrayList<>();
        String temp = "";

        for(int i = 0; i < text.length(); ++i) {
            if (Character.isLetter(text.charAt(i))) {
                temp = temp + text.charAt(i);
            } else if (temp != "") {
                words.add(temp);
                temp = "";
            }
        }

        if (temp != "") {
        }

        words.add(temp);
        return words;
    }

    public static ArrayList<String> processWords(ArrayList<String> words){
        ArrayList<String> res = new ArrayList<>();

        for(String word : words) {
            if(word.matches("^[aeiouy]+$") && !res.contains(word)) {
                if(word.length() > 30)
                    word = word.substring(0, 30);
                res.add(word);
            }
        }

        if(res.size() == 0)
            return null;

        return res;
    }

    public static boolean onlyLetters(ArrayList<String> words){
        boolean flag = true;
        for(String word : words)
            if (!word.matches("^[a-zA-Z]+$")) {
                flag = false;
                break;
            }
        return flag;
    }

    public static String readFromFile(String file) throws IOException {
        FileReader reader = new FileReader(file);
        int symbol;
        StringBuilder text = new StringBuilder();

        while ((symbol = reader.read()) != -1) {
            text.append((char) symbol);
        }
        reader.close();
        return text.toString();
    }

    public static void main(String[] args) {
        try{
            System.out.print("Enter filename = ");
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();

            if(!filename.contains(".txt"))
               throw new Exception("Error file format");

            //System.out.print(text);

            ArrayList<String> words = splitText(readFromFile(filename));
            System.out.print("Result words: ");
            ArrayList<String> res = processWords(words);

            for(String str : res)
                System.out.print(str + " ");

        }
        catch (Exception ex){
            System.out.println("EXCEPTION: " + ex.getMessage());
        }
    }
}
