package cham;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JButton calculate;
    private JButton clean;
    private int size;
    private JPanel mapPanel;
    private Algorithm algorithm;

    public App(int size, Algorithm algorithm){
        this.size = size;
        this.algorithm = algorithm;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(algorithm.toString());
        initialGUI();
        showGUI();
        pack();
        setVisible(true);
    }

    private void initialGUI(){
        // Инициализация правил составления поля
        GridBagLayout gbLayout = new GridBagLayout();
        GridBagConstraints gbConstraints = new GridBagConstraints();
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.weightx = 1;
        gbConstraints.weighty = 1;
        gbConstraints.insets.set(0, 0, 1, 1);

        // Инициализация панели с полем
        mapPanel = new JPanel(gbLayout);
        mapPanel.setBackground(Color.GRAY);
        final JMap[][] map = new JMap[size][size];

        // Инициализация класса обработки нажатия мыши
        JMapListener mapHandler = new JMapListener();

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                // Создание новой ячейки
                map[x][y] = new JMap();
                gbConstraints.gridx = x;
                gbConstraints.gridy = y;

                // Добавление ячейки в правило
                gbLayout.setConstraints(map[x][y], gbConstraints);

                // Добавление ячейки в панель
                mapPanel.add(map[x][y]);
                map[x][y].addMouseListener(mapHandler);

                // Проверка на начальную и конечную точки маршрута
                if(y == size / 2)
                    if(x == 1)
                        map[x][y].setStart();
                    else if(x == size - 2)
                        map[x][y].setEnd();


            }
        }

        // Инициализация кнопки просчета маршрута
        calculate = new JButton("Calculate");
        calculate.setBackground(Color.GRAY);

        // Обработка нажатия на кнопку
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                long start, end;
                start = System.nanoTime();
                algorithm.findPath(new Location(1, size / 2), new Location(size - 2, size / 2), map);
                end = System.nanoTime();

                System.out.println("Время выполнения " + algorithm.toString() + " равно " + (end - start)/1000);
            }
        });

        // Инициализация кнопки очистки карты
        clean = new JButton("Clean");
        clean.setBackground(Color.GRAY);

        // Обработка нажатия на кнопку
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int x = 0; x < size; x++) {
                    for (int y = 0; y < size; y++) {
                        if (!(y == size / 2 && (x == 1 || x == size - 2)))
                            map[x][y].clean();
                    }
                }
                algorithm.clean();
            }
        });
    }

    private void showGUI(){
        // Добавление поля
        add(mapPanel, BorderLayout.CENTER);

        // Добавление клавиш
        JPanel panel = new JPanel();
        panel.add(calculate, BorderLayout.WEST);
        panel.add(clean, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);
    }

    // Запуск приложения
    public static void main(String[] args) {
        new App(30, new AStar());
        new App(30, new RayAlgorithm());
    }
}
