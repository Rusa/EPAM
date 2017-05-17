package javase02.t06;

import javase02.t07.NSubmarineAnnotation;

/**
 * Created by rusamaha on 5/13/17.
 */

//Разработайте класс АтомнаяЛодка, создайте внутренний класс – ДвигательДляАтомнойЛодки. Создайте объект АтомнаяЛодка и “запустите его в плавание”.


@NSubmarineAnnotation(nameOfAuthor = "Rusamaha")
public class NuclearSubmarine {
    private EngineForNuclearSubmarine engine;

    public NuclearSubmarine() {
        this.engine = new EngineForNuclearSubmarine();
    }
    /**
     *  Inner class EngineForNuclearSubmarine
     */
    private final class EngineForNuclearSubmarine {
        /**
         *  Start engine access only from NuclearSubmarine class
         */
        void startEngine() {
            System.out.println("Engine started");
        }

        /**
         *  Stop engine access only from NuclearSubmarine class
         */
        void stopEngine() {
            System.out.println("Engine stop");
        }
    }

    public void moveForward () {
        System.out.println("Move Forward");
    }

    public void moveBackward () {
        System.out.println("Move Backward");
    }

    public void GoToSailing() {
        engine.startEngine();
        moveForward();
        System.out.println("Nuclear Submarine moving ");
    }
}
