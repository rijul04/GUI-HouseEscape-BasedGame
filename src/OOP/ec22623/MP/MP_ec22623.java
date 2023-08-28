package OOP.ec22623.MP;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MP_ec22623 implements Visitor{

    private PrintStream out;
    private Scanner in;
    private int purse;
    private Item[] items;
    private int next;

    private char value;

    private boolean change = false;
    //    private JLabel gold;
    private JLabel gold;
    private JLabel itemShow;

    private JFrame info;
    private JPanel infoPanel;

    private JFrame choiceFrame;
    private JLabel descriptionOfChoice;
    private JPanel panel;
    private JButton button;
    private boolean checker = false;
    private boolean mapChecker = false;
    private JFrame mapFrame;
    private JPanel position0;
    private JPanel position1;
    private JPanel position2;
    private JPanel position3;
    private JPanel position4;
    private JPanel position5;
    private JPanel position6;
    private JLabel room0;
    private JLabel room1;
    private JLabel room2;
    private JLabel room3;
    private JLabel room4;
    private JLabel room5;
    private JLabel room6;
    private boolean first = true;

    private JPanel position;

    private boolean firstPosition = false;

    //    private boolean escaped = false;
    private boolean infoCheck = true;

    private ArrayList<String> list;

    private ArrayList<String> historyList;
    private JFrame historyFrame;
    private JTextArea historyTA;
    private String stringList;

    public static void main (String[]args) {
        House h = new House_ec22623();
        Visitor v = new MP_ec22623(System.out,System.in);
//        Visitor v = new IOVisitor(System.out,System.in);
        Direction d = h.visit(v, Direction.FROM_SOUTH);
    } //added from test


    public MP_ec22623(PrintStream ps, InputStream is) {
        out = ps;
        in = new Scanner(is);
        purse = 0;
        items = new Item[1000];
        next = 0;
        list = new ArrayList<>();
        historyList = new ArrayList<>();
        stringList = "";

        infoMethod();
        map(0);
    }



    private static final char[] yOrN = { 'y', 'n'};



    @Override
    public void tell(String message) {
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.PLAIN_MESSAGE);
        updateInfo();
        history(message);
    }

    @Override
    public char getChoice(String descriptionOfChoices, char[] arrayOfPossibleChoices) {
        if(!checker) {
            char value = guiChoice(descriptionOfChoices, arrayOfPossibleChoices);
            checker = true;
        }
        else {
            char value = updateChoice(descriptionOfChoices, arrayOfPossibleChoices);
        }
//        change = false;
//        JFrame choiceFrame = new JFrame();
//        choiceFrame.setTitle("Choice");
//        choiceFrame.getContentPane().setBackground(Color.cyan);
//        choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        choiceFrame.setSize(800, 600);
//
//        JLabel descriptionOfChoice = new JLabel();
//        descriptionOfChoice.setText(descriptionOfChoices);
//
//        JPanel panel = new JPanel();
//        panel.setBackground(Color.cyan);
//
//
//        for(int i=0; i<arrayOfPossibleChoices.length; i++) {
//            JButton button = new JButton();
//            button.setText(String.valueOf(arrayOfPossibleChoices[i]));
//            button.setVisible(true);
//            int finalI = i;
//            button.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    value = arrayOfPossibleChoices[finalI];
//                    System.out.println(value);
//                    change = true;
//                }
//            });
//
//            panel.add(button);
//        }
//
////        panel.add(itemShow);
////        panel.add(gold);
//        panel.add(descriptionOfChoice);
//        choiceFrame.add(panel);
//        choiceFrame.pack();
//        choiceFrame.setVisible(true);
//
//        while(change == false){
//            try {
//                Thread.sleep(200);
//            } catch(InterruptedException e) {
//            }
//        }
//        choiceFrame.dispose();
        return value;
    }

    public char guiChoice(String descriptionOfChoices, char[] arrayOfPossibleChoices) {

        change = false;
        choiceFrame = new JFrame();
        choiceFrame.setTitle("Choice");
        choiceFrame.getContentPane().setBackground(Color.cyan);
        choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        choiceFrame.setSize(800, 600);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screenSize.width = choiceFrame.getWidth()) + 200;
        int y = (screenSize.height) /2;
        choiceFrame.setLocation(x, y);

        descriptionOfChoice = new JLabel();
        descriptionOfChoice.setText(descriptionOfChoices);

        panel = new JPanel();
        panel.setBackground(Color.cyan);
        history(descriptionOfChoices);


        for(int i=0; i<arrayOfPossibleChoices.length; i++) {
            button = new JButton();
            button.setText(String.valueOf(arrayOfPossibleChoices[i]));
            button.setVisible(true);
//            button.setBackground(Color.red);
            int finalI = i;
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    value = arrayOfPossibleChoices[finalI];
                    change = true;
                }
            });

            panel.add(button);
        }

//        panel.add(itemShow);
//        panel.add(gold);
        panel.add(descriptionOfChoice);
        choiceFrame.add(panel);
        choiceFrame.pack();
        choiceFrame.setVisible(true);

        while(change == false){
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
//        choiceFrame.dispose();
        return value;
    }
    public char updateChoice(String descriptionOfChoices, char[] arrayOfPossibleChoices) {
        change = false;
        panel.removeAll();

//        for (Component c : panel.getComponents()) {
//            if (c instanceof JButton) {
//                panel.remove(c); // remove buttons only
//            }
//        }

        descriptionOfChoice.setText(descriptionOfChoices);
        history(descriptionOfChoices);

        for(int i=0; i<arrayOfPossibleChoices.length; i++) {
            button = new JButton();
            button.setText(String.valueOf(arrayOfPossibleChoices[i]));
            button.setVisible(true);
            int finalI = i;
            panel.repaint();
            panel.revalidate();
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    value = arrayOfPossibleChoices[finalI];
                    change = true;
                }
            });

            panel.add(button);
            panel.add(descriptionOfChoice);
        }

//        panel.add(itemShow);
//        panel.add(gold);

        while(change == false){
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
            }
        }
//        panel.repaint();
//        panel.revalidate();
//        choiceFrame.dispose();
        return value;
    }

    @Override
    public boolean giveItem(Item x) {

        for (int i=0;i<next;i++) tell(items[i] + ", ");
        tell("You are being offered: "+x.name);
//        out.println("You are being offered: "+x.name);
        if (next >= items.length) {
            tell("But you have no space and must decline.");
//            out.println("But you have no space and must decline.");
            return false;
        }
        if (getChoice("Do you accept (y/n)?", yOrN) == 'y') {
            items[next] = x;
            list.add(x.toRead());
            next++;
            updateInfo();
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean hasIdenticalItem(Item x) {
        for (int i=0; i<next;i++)
            if (x == items[i])
                return true;
        return false;
    }

    @Override
    public boolean hasEqualItem(Item x) {
        for (int i=0; i<next;i++)
            if (x.equals(items[i]))
                return true;
        return false;
    }

    @Override
    public void giveGold(int n) {
        tell("You are given "+n+" gold pieces.");
        purse += n;
        tell("You now have "+purse+" pieces of gold.");
        updateInfo();
    }

    @Override
    public int takeGold(int n) {
        if (n<0) {
            tell("A scammer tried to put you in debt to the tune off "+(-n)+"pieces of gold,");
            tell("but you didn't fall for it and returned the 'loan'.");

            return 0;
        }

        int t = 0;
        if (n > purse) t = purse;
        else t = n;

        tell(t+" pieces of gold are taken from you.");
        purse -= t;
        tell("You now have "+purse+" pieces of gold.");
        updateInfo();
        return t;
    }
    public String showItems() {
        String list = "";

        if(items[0] == null) {
            String nothing = "[Nothing]";
            return nothing;
        }
        else {
            for (int i = 0; i < items.length; i++) {
                while (items[i] != null) {

                    list = list + " " + items[i].toRead();
                    return list;
                }

            }
            return list;
        }
    }

//    public ArrayList<String> showItems() {
//        ArrayList<String> list = new ArrayList<>();
//
//        if(items[0] == null) {
//            ArrayList<String> nothing = new ArrayList<>();
//            nothing.add("[Nothing");
//        }
//        else {
//            for(int i=0; i<items.length; i++) {
//                while(items[i] != null) {
//                    list.add(i, String.valueOf(items[i]));
//                }
//            }
//            return list;
//        }
//
//
//        return list;
//    }

    public void infoMethod() {

        info = new JFrame();
        info.setTitle("Info");
        info.getContentPane().setBackground(Color.cyan);
        info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        info.setSize(240, 240);
        info.setResizable(false);
        info.setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (info.getWidth() / 2);
        int y = (info.getHeight() - 20);

        info.setLocation(x, y);

        JPanel redPanel1 = new JPanel();
        redPanel1.setBackground(Color.RED);
        redPanel1.setPreferredSize(new Dimension(240, 10));

        JPanel redPanel2 = new JPanel();
        redPanel2.setBackground(Color.RED);
        redPanel2.setPreferredSize(new Dimension(240, 10));

        JPanel redPanel3 = new JPanel();
        redPanel3.setBackground(Color.RED);
        redPanel3.setPreferredSize(new Dimension(10, 240));

        JPanel redPanel4 = new JPanel();
        redPanel4.setBackground(Color.RED);
        redPanel4.setPreferredSize(new Dimension(10, 240));

        infoPanel = new JPanel();
        infoPanel.setBackground(Color.cyan);

        infoPanel.setPreferredSize(new Dimension(120, 120));
//        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
        infoPanel.setLayout(new GridLayout(2, 1));

        Border border = BorderFactory.createLineBorder(Color.white, 4); //creates border

        gold = new JLabel();
        gold.setText("Amount of gold: " + purse);
        gold.setVisible(true);
        gold.setForeground(Color.red);
        gold.setBorder(border); //sets the border as the label border
        gold.setFont(new Font("Serif", Font.BOLD, 14));


        itemShow = new JLabel();
//            String list = "";
//            for(int i=0; i<items.length; i++) {
//                while (items[i] != null) {
//                    list = list + ", " + items[i];
//                }
//            }
        itemShow.setText("Item list: " + list);
        itemShow.setForeground(Color.blue);
        itemShow.setVisible(true);
        itemShow.setBorder(border); //sets the border as the label border
        itemShow.setFont(new Font("Serif", Font.BOLD, 14));


        infoPanel.add(gold);
        infoPanel.add(itemShow);
        infoPanel.setVisible(true);
        info.add(redPanel1, BorderLayout.NORTH);
        info.add(redPanel2, BorderLayout.SOUTH);
        info.add(redPanel3, BorderLayout.WEST);
        info.add(redPanel4, BorderLayout.EAST);
        info.add(infoPanel, BorderLayout.CENTER);
        info.pack();
        info.setVisible(true);
    }

    public void updateInfo() {
        gold.setText("Amount of gold: " + purse);
        itemShow.setText("Item list: " + list);

        // revalidate JPanel
//        infoPanel.revalidate();
        infoPanel.repaint();
        infoPanel.revalidate();

    }


    public void map(int num) {

        if(!mapChecker) {

            mapChecker = true;

            mapFrame = new JFrame();
            mapFrame.setTitle("Map");
            mapFrame.setSize(400, 400);
            mapFrame.setResizable(true);
            mapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mapFrame.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // Set the location of the frame to be in the center of the screen
//            int x = (screenSize.width - mapFrame.getWidth()) / 2;
//            int y = (screenSize.height - mapFrame.getHeight()) / 2;
            int x = (screenSize.width / 4);
            int y = (screenSize.height / 20);
            mapFrame.setLocation(x, y);


            position0 = new JPanel();
            position0.setPreferredSize(new Dimension(100, 100));
            c.gridx = 1;
            c.gridy = 2;
            mapFrame.add(position0, c);


            position1 = new JPanel();
            position1.setPreferredSize(new Dimension(100, 100));
            c.gridx = 0;
            c.gridy = 2;
            mapFrame.add(position1, c);
            position1.setSize(200, 100);


            position2 = new JPanel();
            position2.setPreferredSize(new Dimension(100, 100));
            c.gridx = 2;
            c.gridy = 2;
            mapFrame.add(position2, c);
            position2.setSize(200, 100);


            position3 = new JPanel();
            position3.setPreferredSize(new Dimension(100, 100));
            c.gridx = 0;
            c.gridy = 1;
            mapFrame.add(position3, c);
            position3.setSize(200, 100);


            position4 = new JPanel();
            position4.setPreferredSize(new Dimension(100, 100));
            c.gridx = 2;
            c.gridy = 1;
            mapFrame.add(position4, c);
            position4.setSize(200, 100);


            position5 = new JPanel();
            position5.setPreferredSize(new Dimension(100, 100));
            c.gridx = 1;
            c.gridy = 0;
            mapFrame.add(position5, c);
            position5.setSize(200, 100);


            position6 = new JPanel();
            position6.setPreferredSize(new Dimension(100, 100));
            c.gridx = 1;
            c.gridy = 1;
            mapFrame.add(position6, c);
            position6.setSize(200, 100);



            Border border = BorderFactory.createLineBorder(Color.black, 2); //creates border#


            //        position0.setBorder(border);
            room0 = new JLabel();
            position0.add(room0);
            room0.setText("Corridor");
            room0.setForeground(Color.red);
            room0.setVisible(true);

            position1.setBorder(border);
            room1 = new JLabel();
            position1.add(room1);
            room1.setText("Room 1");
            room1.setForeground(Color.red);
            room1.setVisible(true);

            position2.setBorder(border);
            room2 = new JLabel();
            position2.add(room2);
            room2.setText("Room 2");
            room2.setForeground(Color.red);
            room2.setVisible(true);

            position3.setBorder(border);
            room3 = new JLabel();
            position3.add(room3);
            room3.setText("Room 3");
            room3.setForeground(Color.red);
            room3.setVisible(true);

            position4.setBorder(border);
            room4 = new JLabel();
            position4.add(room4);
            room4.setText("Room 4");
            room4.setForeground(Color.red);
            room4.setVisible(true);

            position5.setBorder(border);
            room5 = new JLabel();
            position5.add(room5);
            room5.setText("Room 5");
            room5.setForeground(Color.red);
            room5.setVisible(true);

//        position6.setBorder(border);
            room6 = new JLabel();
            position6.add(room6);
            room6.setText("Corridor");
            room6.setForeground(Color.red);
            room6.setVisible(true);
            room6.setBackground(Color.cyan);


            mapFrame.setVisible(true);
        }
        else{
            if(firstPosition) {
                JPanel[] positions = {position0, position1, position2, position3, position4, position5, position6};
                for(int i=0; i<positions.length; i++) {
                    positions[i].remove(position);
                }
            }
            firstPosition = true;
            updateMap(num);
        }

    }

    public void updateMap(int num) {

        if(num == 0) {

            position = new JPanel();
            position.setPreferredSize(new Dimension(10, 10));
            position.setBackground(Color.cyan);
            position0.add(position);
            position0.setLayout(null);
            position.setBounds(45, 45, 10, 10);

        }
        else if(num == 1) {
            position = new JPanel();
            position.setPreferredSize(new Dimension(10, 10));
            position.setBackground(Color.cyan);
            position1.add(position);
            position1.setLayout(null);
            position.setBounds(45, 45, 10, 10);
        }
        else if(num == 2) {
            position = new JPanel();
            position.setPreferredSize(new Dimension(10, 10));
            position.setBackground(Color.cyan);
            position2.add(position);
            position2.setLayout(null);
            position.setBounds(45, 45, 10, 10);
        }
        else if(num == 3) {
            position = new JPanel();
            position.setPreferredSize(new Dimension(10, 10));
            position.setBackground(Color.cyan);
            position3.add(position);
            position3.setLayout(null);
            position.setBounds(45, 45, 10, 10);
        }
        else if(num == 4) {
            position = new JPanel();
            position.setPreferredSize(new Dimension(10, 10));
            position.setBackground(Color.cyan);
            position4.add(position);
            position4.setLayout(null);
            position.setBounds(45, 45, 10, 10);
        }
        else if(num == 5) {
            position = new JPanel();
            position.setPreferredSize(new Dimension(10, 10));
            position.setBackground(Color.cyan);
            position5.add(position);
            position5.setLayout(null);
            position.setBounds(45, 45, 10, 10);
        }
        else if(num == 6) {
            position = new JPanel();
            position.setPreferredSize(new Dimension(10, 10));
            position.setBackground(Color.cyan);
            position6.add(position);
            position6.setLayout(null);
            position.setBounds(45, 45, 10, 10);
        }
        mapFrame.repaint();
        mapFrame.revalidate();
    }

    //    public Collection<String> history(String message) {
//
//        historyList.add(message);
//        JTextArea historyTA = new JTextArea();
//
//        if(first) {
//            historyFrame = new JFrame();
//            historyFrame.setTitle("History");
//            historyFrame.setSize(400, 600);
//            historyFrame.setResizable(false);
//            historyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
////            JLabel historyLabel = new JLabel();
//
////            historyLabel.setText(String.valueOf(historyList));
//            historyTA.setText(String.valueOf(historyList));
//        }
//        else {
//            historyTA.setText(String.valueOf(historyList));
//            historyFrame.repaint();
//            historyFrame.revalidate();
//        }
//
//        return historyList;
//    }
    public void history(String message) {

        historyList.add(message);

        if(first) {
            historyFrame = new JFrame();
            historyFrame.setTitle("History");
            historyFrame.setSize(400, 600);
            historyFrame.setResizable(false);
            historyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            int x = (screenSize.width) / 2 ;
            int y = (screenSize.height - historyFrame.getHeight()) / 2;
            historyFrame.setLocation(x, y);

//            JLabel historyLabel = new JLabel();
            historyTA = new JTextArea();
//            historyLabel.setText(String.valueOf(historyList));
            historyTA.setLineWrap(true);
            historyTA.setWrapStyleWord(true);
            historyTA.setText(message + "\n");

            JScrollPane scrollPane = new JScrollPane(historyTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            historyTA.setEditable(false);

//            historyFrame.add(historyTA);
            historyFrame.add(scrollPane);
            historyFrame.setVisible(true);
            first = false;
        }
        else {
//        historyTA.setText("");
            String stringList1 = "";
            for(int i = 0; i < historyList.size(); i++) {
                stringList1 = stringList1 +  "\n" + historyList.get(i);
            }
            historyTA.setText(stringList1);
            historyTA.setCaretPosition(historyTA.getDocument().getLength());
            historyFrame.repaint();
            historyFrame.revalidate();
        }

    }

    public void leave() {
        info.dispose();
        historyFrame.dispose();
        mapFrame.dispose();
        choiceFrame.dispose();
    }

}

