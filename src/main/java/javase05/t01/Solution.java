package javase05.t01;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Scanner;

/**
 * Задание 1. Обработка исключительных ситуаций
 * Разработать приложение, позволяющее просматривать файлы и каталоги файловой системы, а также создавать и удалять текстовые файлы.
 * Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.
 * Требуется определить исключения для каждого слоя приложения и корректно их обработать.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("Available commands 'ls', 'cd', 'cat', 'rm', 'touch', 'write'(to file)");

        rootDirectory();

        Path path = null;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            String[] cmdArgs = s.split(" ");
            String cmdArgs1;
            String cmdArgs2;
            if (cmdArgs.length > 2 || cmdArgs.length < 1) {
                System.out.println("Incorrect num of args");
            } else {
                cmdArgs1 = cmdArgs[0];
                cmdArgs2 = cmdArgs.length == 1 ? null : cmdArgs[1];

                switch (cmdArgs1) {
                    case "ls": {
                        list(path, cmdArgs2);
                    }
                    break;
                    case "cd": {
                        if (isArg2(cmdArgs2)) break;
                        path = getPath(path, cmdArgs2);
                        if (path == null) {
                            System.out.println("No such file or directory!");
                        } else if (cmdArgs2.equals("..")) {
                            path.getParent();
                        } else {
                            if (!Files.isDirectory(path)) {
                                System.out.println("File " + path + " is not a directory!");
                                path = path.getParent();
                            }
                        }
                    }
                    break;
                    case "cat": {
                        if (isArg2(cmdArgs2)) break;
                        path = getPath(path, cmdArgs2);
                        if (path == null) {
                            System.out.println("No such file or directory!");
                        } else if (Files.isDirectory(path)) {
                            System.out.println("File " + path + " is a directory!");
                        } else if (Files.isReadable(path)) {
                            try {
                                System.out.println(new String(Files.readAllBytes(path)));
                                path = path.getParent();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                    case "rm": {
                        if (isArg2(cmdArgs2)) break;
                        path = getPath(path, cmdArgs2);
                        if (Files.isRegularFile(path)) {
                            path.toFile().delete();
                            path = path.getParent();
                        }
                    }
                    break;
                    case "touch": {
                        if (isArg2(cmdArgs2)) break;
                        path = getPath(path, cmdArgs2);

                        Path file = path.resolve(cmdArgs2);
                        if (Files.exists(file)) {
                            System.out.println("File already exist");
                        } else {
                            try {
                                file.toFile().createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                    case "write": {
                        if (isArg2(cmdArgs2)) break;
                        path = getPath(path, cmdArgs2);

                        if (Files.isRegularFile(path) && Files.isReadable(path)) {
                            OpenOption openOption = StandardOpenOption.APPEND;
                            if (path.toFile().length() > 0) {
                                System.out.println("Enter 'R' to rewrite file or 'A' to append; Else by default it will append.");
                                if (scanner.nextLine().equals("R")) {
                                    openOption = StandardOpenOption.TRUNCATE_EXISTING;
                                }
                            }
                            Charset charset = Charset.forName("utf-8");
                            String text = scanner.nextLine();
                            System.out.println("Enter text you want to add to the file " + path);
                            try (BufferedWriter writer = Files.newBufferedWriter(path, charset, openOption)) {
                                writer.write(text, 0, text.length());
                                path = path.getParent();

                            } catch (IOException x) {
                                System.err.format("IOException: %s%n", x);
                            }
                        }
                    }
                    break;
                    case "exit": {
                        System.out.println("Good Bye!");
                        return;
                    }
                    default: {
                        System.out.println("Incorrect or unsupportable command: " + s);
                    }
                }

                if (path != null) {
                    System.out.println("Current directory: " + path);

                } else {
                    System.out.println("Current directory: ");
                    rootDirectory();
                }
            }
        }
    }

    private static boolean isArg2(String cmdArgs2) {
        if (cmdArgs2 == null) {
            System.out.println("Incorrect num of args");
            return true;
        }
        return false;
    }

    private static void rootDirectory() {
        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name : dirs) {
            System.err.println(name);
        }
    }

    private static Path getPath(Path path, String s) {
        Path tmp;
        if (path == null) {
            tmp = Paths.get(s);
        } else {
            tmp = path.resolve(s);
        }

        if (Files.exists(tmp)) {
            path = tmp.normalize();
        }
        return path;
    }

    private static void list(Path path, String dirName) {
        if (path == null) {
            return;
        } else if (dirName != null) {
            path = path.resolve(dirName);
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path file : stream) {
                System.out.println((file.toFile().isDirectory() ? "d " : "- ") + file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }
}