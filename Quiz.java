package quiz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswer[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup group;
    JButton next, submit, help;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    String name;

    public Quiz(String name) {

        this.name = name;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.png"));
        JLabel img = new JLabel(i1);
        img.setBounds(0, 0, 1440, 392);
        add(img);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150,450,50,30);
        question.setFont(new Font("Tahoma",Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Who invented Java Programming Language ?";
        questions[0][1] = "Guido Van Rossum";
        questions[0][2] = "James Gosling";
        questions[0][3] = "Dennis Ritchie";
        questions[0][4] = "Bjarne Stroustrup";

        questions[1][0] = "Which Statement is true about Java ?";
        questions[1][1] = "Java is a Sequence-dependent programming language";
        questions[1][2] = "Java is a Code dependent programming language";
        questions[1][3] = "Java is a Platform dependent programming language";
        questions[1][4] = "Java is a platform-independent programming language";

        questions[2][0] = "Which Component is used to compile, debug and execute the java programs ?";
        questions[2][1] = "JRE";
        questions[2][2] = "JIT";
        questions[2][3] = "JDK";
        questions[2][4] = "JVM";

        questions[3][0] = "Which one of the following is not a java feature ?";
        questions[3][1] = "Object-Oriented";
        questions[3][2] = "Use of pointers";
        questions[3][3] = "portable";
        questions[3][4] = "Dynamic and Extensible";

        questions[4][0] = "Which of these cannot be used for a variable name in java ?";
        questions[4][1] = "Identifier & Keyword";
        questions[4][2] = "Identifier";
        questions[4][3] = "Keyword";
        questions[4][4] = "None";

        questions[5][0] = "what is the Extension of java code file ?";
        questions[5][1] = ".js";
        questions[5][2] = ".txt";
        questions[5][3] = ".class";
        questions[5][4] = ".java";

        questions[6][0] = "Which environment variable is used to set the java path ?";
        questions[6][1] = "MAVEN_path";
        questions[6][2] = "JAVA path";
        questions[6][3] = "JAVA";
        questions[6][4] = "JAVA_HOME";

        questions[7][0] = "Which of the following is not an OOPS concept in java ?";
        questions[7][1] = "Polymorphism";
        questions[7][2] = "Inheritance";
        questions[7][3] = "Compilation";
        questions[7][4] = "Encapsulation";

        questions[8][0] = "What is the Extension of compiled java classes ?";
        questions[8][1] = ".txt";
        questions[8][2] = ".js";
        questions[8][3] = ".class";
        questions[8][4] = ".java";

        questions[9][0] = "Which Exception is thrown when java is out of memeory ?";
        questions[9][1] = "memoryError";
        questions[9][2] = "outOfMemoryError";
        questions[9][3] = "MemoryOutOfBoundsException";
        questions[9][4] = "memoryFullException";
        
        answers[0][1] = "James Gosling";
        answers[1][1] = "Java is a platform-independent programming language";
        answers[2][1] = "JDK";
        answers[3][1] = "Use of Pointers";
        answers[4][1] = "Keyword";
        answers[5][1] = ".java";
        answers[6][1] = "JAVA_HOME";
        answers[7][1] = "Compilation";
        answers[8][1] = ".class";
        answers[9][1] = "outOfMemoryError";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        next = new JButton("Next");
        next.setBounds(700,750,200,30);
        next.setBackground(new Color(22,99,54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1150,750,200,30);
        submit.setBackground(new Color(255,215,0));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        help = new JButton("Help");
        help.setBounds(930,750,200,30);
        help.setBackground(new Color(22,99,54));
        help.setForeground(Color.WHITE);
        help.addActionListener(this);
        add(help);

        start(count);

        setSize(1440, 850);
        setLocation(50, 0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 1;
            if (group.getSelection() == null) {
                useranswer[count][0] = " ";
            } else {
                useranswer[count][0] = group.getSelection().getActionCommand();
            }
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);

        } else if (e.getSource() == help) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            help.setEnabled(false);
        } else if (e.getSource() == submit) {
            ans_given = 1;
            if (group.getSelection() == null) {
                useranswer[count][0] = " ";
            } else {
                useranswer[count][0] = group.getSelection().getActionCommand();
            }
            for (int i=0; i<useranswer.length; i++) {
                if (useranswer[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
        }  
    }
    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left - "+ timer + "seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times Up !!!" , 1100, 500);
        }
        timer--;

        try {
            Thread.sleep(1000);
            repaint();

        } catch(Exception E) {
            E.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (group.getSelection() == null) {
                    useranswer[count][0] = "";
                } else {
                    useranswer[count][0] = group.getSelection().getActionCommand();
                }
                for (int i=0; i<useranswer.length; i++) {
                    if (useranswer[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            }
            else {
                if (group.getSelection() == null) {
                    useranswer[count][0] = " ";
                } else {
                    useranswer[count][0] = group.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }
    public void start(int count) {
        qno.setText(""+ (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        group.clearSelection();
    }
    public static void main(String[] args) {
        new Quiz("User");
    }
}
