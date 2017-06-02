package javase04.t04;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Задание 4. Сериализация
 * Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях (один актер мог сниматься и в нескольких фильмах).
 * Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов, позволять ее модифицировать,
 * а по завершении работы приложения – сохранять (в файл). Для восстановления/сохранения коллекции использовать  сериализацию/десериализацию.
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        String fileName = "src/main/java/javase04/t04/SerializedList";

        List<Movie> movieList = init();
        serializeMovieList(movieList, fileName);

        System.out.println("Movie list: ");
        int count = 0;
        for (Movie movie: movieList){
            System.out.printf("%s) %s \n", ++count, movie.getTitle());
            System.out.println("cast:");
            for (Actor actor: movie.getCast()){
                System.out.println(actor.getName());
            }
        }
        System.out.println("Change Movie Title - 1; Change Actors in movie - 2; Add new movie - 3; Serialize(Save) - 0;");
        Scanner scanner = new Scanner(System.in);
        int v = isNumber(scanner.nextLine());
        switch (v){
            case 1: {
                System.out.println("Enter number of movie which Title you want to change: ");
                int idx = isNumber(scanner.nextLine());
                Movie movie = movieList.get(idx-1);

                System.out.printf("Change current title %s to: \n", movie.getTitle());
                String newTitle = scanner.nextLine();
                movie.setTitle(newTitle);
            }
            break;
            case 2: {
                System.out.println("Enter number of movie you want to change: ");
                int idx = isNumber(scanner.nextLine());
                Movie movie = movieList.get(idx-1);

                System.out.printf("Add or remove actors in movie %s: \n", movie.getTitle());
                System.out.println(movie.getCast().toString());
                System.out.println("Add - 1; Remove - 2");
                if(isNumber(scanner.nextLine()) == 1) {
                    String actor = "";
                    List<Actor> cast = new ArrayList<>();
                    addActors(scanner, actor, cast);
                }
                String newTitle = scanner.nextLine();

            }
            break;
            case 3: {
                System.out.println("Enter Movie Title: ");
                String title = scanner.nextLine();

                String actor = "";
                List<Actor> cast = new ArrayList<>();
                addActors(scanner, actor, cast);
                movieList.add(new Movie(title, cast));
            }
            case -1: {
                System.out.println("Wrong input, allowed only integers");
            }
        }

        System.out.println("");

        serializeMovieList(movieList, fileName);
        movieList = deserializeMovieList(fileName);

        movieList.forEach(movie -> {
            System.out.println("Title: " + movie.getTitle());
        });


    }

    private static void addActors(Scanner scanner, String actor, List<Actor> cast) {
        while (!actor.equals("0")){
            System.out.println("Add actor or 0 to finish adding:");
            actor = scanner.nextLine();
            if(!actor.equals("0")) {
                cast.add(new Actor(actor));
            }
        }
    }

    public static List<Movie> init() throws IOException {
        Actor jDepp = new Actor("Johnny Depp");
        Actor hBCarter = new Actor("Helena Bonham Carter");

        Actor jTravolta = new Actor("John Travolta");
        Actor uThurman = new Actor("Uma Thurman");
        Actor bWillis = new Actor("Bruce Willis");

        Actor kKnightley = new Actor("Keira Knightley");
        Actor tStamp = new Actor("Terence Stamp");

        Actor sLJackson = new Actor("Samuel L. Jackson");
        Actor nPortman = new Actor("Natalie Portman");

        List<Actor> pFictionArr = new ArrayList<>(Arrays.asList(jTravolta, bWillis, uThurman));
        Movie pFiction = new Movie("Pulp Fiction", pFictionArr);

        List<Actor> piratesArr = new ArrayList<>(Arrays.asList(jDepp, kKnightley));
        Movie pirates = new Movie("Pirates of the Caribbean", piratesArr);

        List<Actor> aliceArr = new ArrayList<>(Arrays.asList(jDepp, hBCarter));
        Movie alice = new Movie("Alice in Wonderland", aliceArr);

        List<Actor> corpseBrideArr = new ArrayList<>(Arrays.asList(jDepp, hBCarter));
        Movie corpseBride = new Movie("Corpse Bride", corpseBrideArr);

        List<Actor> starWarsArr = new ArrayList<>(Arrays.asList(nPortman, kKnightley, sLJackson, tStamp));
        Movie starWars = new Movie("Star Wars:Ep I", starWarsArr);
        return new ArrayList<>(Arrays.asList(pFiction, pirates, alice, corpseBride, starWars));
    }

    public static void serializeMovieList(List<Movie> movieList, String filename) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(movieList);
        }
    }

    public static List<Movie> deserializeMovieList(String filename) throws IOException {

        List<Movie> movieList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            while (fis.available()>0){
                movieList = (List<Movie>) ois.readObject();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return movieList;
    }
    public static int isNumber(String s){
        if(Pattern.matches("\\d+", s)) {
            int res = Integer.parseInt(s);
            return res > 0 ? res : -1;
        } else return -1;
    }
}