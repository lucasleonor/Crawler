/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Crawler {

    public static void main(String[] args) throws Exception {
        int game = 220440;
        getGenres(game);
    }
    public static ArrayList<String> getGenres(int game) throws Exception {
        ArrayList<String> genres = new ArrayList<>();
        URL oracle = new URL("http://store.steampowered.com/app/" + game + "/?l=portuguese");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
//        FileInputStream page = new FileInputStream(new File("C://Temp//DmC_ Devil May Cry no Steam.html"));
//        BufferedReader in = new BufferedReader(new InputStreamReader(page));
        String inputLine;
        Boolean find = false;
        while ((inputLine = in.readLine()) != null) {
            if (find == true) {
                find = false;
                genres.add(getGenre(inputLine));
            }
            if (inputLine.contains("\"app_tag\"") && inputLine.contains("display: none;")) {
                find = true;
            }
        }
        in.close();
        return genres;
    }

    public static String getGenre(String line) {
        int i;
        String genre = "";
        for (i = 0; line.charAt(i) == '	'; i++) {
        }
        for (int j = i; j < line.length() && line.charAt(j) != '	'; j++) {
            genre += line.charAt(j);
        }
        System.out.println(genre);
        return genre;
    }

}
