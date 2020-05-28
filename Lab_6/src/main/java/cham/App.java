package cham;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args ) throws IOException {
        // Инициализация файла и проверка
        File file = new File("test.txt");
        if (!file.canRead()) {
            System.out.println("Не известное имя файла");
            return;
        }

        // Получение данных из файла
        FileInputStream fis = new FileInputStream(file);
        String buf = "";
        ArrayList<String> commands = new ArrayList();
        int i = -1;

        while ((i = fis.read()) != -1)
            if (i == '\n') {
                commands.add(buf);
                buf = "";
            }else
                buf += (char)i;

        // Инициализация объекта граффа
        Nodes nodes = new Nodes();

        // Заполнение граффа
        for(String command: commands){
            String[] com = command.split(",");
            nodes.addConnection(com[0], Integer.parseInt(com[1]), com[2]);
        }

        long start;
        long end;

        start = System.nanoTime();
        // Запуск алгоритма с узла А
        nodes.calculate("A");
        end = System.nanoTime();

        // Вывод результата работы алгоритма
        System.out.println(end - start);
        System.out.println(nodes.getWay());
    }
}
