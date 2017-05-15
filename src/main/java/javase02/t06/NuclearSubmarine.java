package javase02.t06;

/**
 * Created by rusamaha on 5/13/17.
 */

//Разработайте класс АтомнаяЛодка, создайте внутренний класс – ДвигательДляАтомнойЛодки. Создайте объект АтомнаяЛодка и “запустите его в плавание”.

public class NuclearSubmarine {
    private final class EngineForNuclearSubmarine {
        void startEngine() {
            System.out.println("Engine started");
        }
    }

    private EngineForNuclearSubmarine engine = new EngineForNuclearSubmarine();

    public void GoToSailing() {
        engine.startEngine();
        System.out.println("Nuclear Submarine moving ");
    }
}
