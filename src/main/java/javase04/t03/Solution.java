package javase04.t03;

import java.io.*;

/**
 * Задание 3. Работа с байтовыми и символьными потоками ввода-вывода
 * Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8.
 * Прочитайте информацию из файла и перепишите ее в файл в кодировкой utf-16.
 *
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.utf8To16v1("fileUTF8.txt", "fileUTF16.txt");  /// Variant 1
        sol.utf8To16v2("fileUTF8.txt", "fileUTF16.txt");  /// Variant 2
    }

    public void utf8To16v2(String srcFile, String dstFile) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        try (FileInputStream fileInputStream = new FileInputStream(new File(classLoader.getResource("javase04/t03/" + srcFile).getFile()));
             FileOutputStream fileOutputStream = new FileOutputStream("out/v2" + dstFile);
        ) {
            int len = fileInputStream.available();
            byte[] bytes = new byte[len];
            fileInputStream.read(bytes);

            String str = new String(bytes, 0, len, "UTF-8");
            byte[] outBytes = str.getBytes("UTF-16");

            fileOutputStream.write(outBytes);
        }
    }

    public void utf8To16v1(String srcFile, String dstFile) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        try (Reader fileInputStream = new InputStreamReader(new FileInputStream(new File(classLoader.getResource("javase04/t03/" + srcFile).getFile())), "UTF-8");
             Writer fileOutputStream = new OutputStreamWriter(new FileOutputStream("out/v3" + dstFile), "UTF-16");
        ) {
            while (fileInputStream.ready()) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }
        }
    }
}

