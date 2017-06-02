package javase04.t04;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

        List<Movie> deserializedMovieList = deserializeMovieList(fileName);

        for (Movie movie: deserializedMovieList){
            System.out.printf("<<< Movie: %s >>> \n", movie.getTitle());
            for (Actor actor: movie.getCast()){
                System.out.println(actor.getName() +" " + actor.hashCode());
            }
        }
//        System.out.println("Add movie - 1; Delete movie - 2; Change Movie Title - 3; Change Actors in movie - 4; Chan Serialize(Save) - 0;");
//        Scanner scanner = new Scanner(System.in);
//        int v = scanner.nextInt();
//
//
//
//        System.out.println("");

        serializeMovieList(deserializedMovieList, fileName);
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
        List<Movie> movieList = new ArrayList<>(Arrays.asList(pFiction, pirates, alice, corpseBride, starWars));

//

        return movieList;
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
}
