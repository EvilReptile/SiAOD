import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JButton calculate;
    private JButton clean;
    private int size;
    private JPanel mapPanel;
    private Algorithm algorithm;

    public GUI(int size, Algorithm algorithm){
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
        GridBagLayout gbLayout = new GridBagLayout();
        GridBagConstraints gbConstraints = new GridBagConstraints();
        gbConstraints.fill = GridBagConstraints.BOTH;
        gbConstraints.weightx = 1;
        gbConstraints.weighty = 1;
        gbConstraints.insets.set(0, 0, 1, 1);

        mapPanel = new JPanel(gbLayout);
        mapPanel.setBackground(Color.GRAY);
        final JMap[][] map = new JMap[size][size];

        JMapListener mapHandler = new JMapListener();

        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                map[x][y] = new JMap();
                gbConstraints.gridx = x;
                gbConstraints.gridy = y;

                gbLayout.setConstraints(map[x][y], gbConstraints);

                mapPanel.add(map[x][y]);
                map[x][y].addMouseListener(mapHandler);

                if(x == 1 && y == size - 2)
                    map[x][y].setStart();
                else if(x == size - 2 && y == 1)
                    map[x][y].setEnd();
            }
        }

        calculate = new JButton("Calculate");
        calculate.setBackground(Color.GRAY);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                long start, end;
                start = System.nanoTime();
                algorithm.findPath(new Location(1, size - 2), new Location(size - 2, 1), map);
                end = System.nanoTime();

                System.out.println("Время выполнения " + algorithm.toString() + " равно " + (end - start)/1000);
            }
        });

        clean = new JButton("Clean");
        clean.setBackground(Color.GRAY);

        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int x = 0; x < size; x++) {
                    for (int y = 0; y < size; y++) {
                        if (!((y == size - 2 && x == 1) || (y == 1 && x == size - 2)))
                            map[x][y].clean();
                    }
                }
                algorithm.clean();
            }
        });
    }

    private void showGUI(){
        add(mapPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(calculate, BorderLayout.WEST);
        panel.add(clean, BorderLayout.EAST);
        add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new GUI(30, new AStar());
        new GUI(30, new FourBeam());
    }
}
