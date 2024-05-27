package Practice;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class XFileRWDemo extends JFrame implements ActionListener {
    JTextArea tarea;
    JButton loadbtn, savebtn;
    JFileChooser fchooser;

    public XFileRWDemo() {
        super("Lab.X File Reader/Writer");
        tarea = new JTextArea(10, 50);
        tarea.setBackground(new Color(220, 255, 255));
        tarea.setMargin(new Insets(5,5,5,5)); //awt

        JScrollPane spane = new JScrollPane(tarea);
        getContentPane().add(spane, "Center");

        JPanel pan = new JPanel();

        loadbtn = new JButton("Load");
        loadbtn.addActionListener(this);
        pan.add(loadbtn);

        savebtn = new JButton("Save");
        savebtn.addActionListener(this);
        pan.add(savebtn);

        getContentPane().add(pan, "South");

        setSize(500, 400); setVisible(true);

    }
    public static void main (String[] args) {
        new XFileRWDemo();
    }
    public void actionPerformed(ActionEvent e) {


        FileNameExtensionFilter fxfilter = new FileNameExtensionFilter("Text Files: txt, java", "txt", "java");
        fchooser = new JFileChooser();

        if (e.getSource() == loadbtn) {
            int fc_result = fchooser.showOpenDialog(tarea);
            if (fc_result == JFileChooser.APPROVE_OPTION) {
                File file = fchooser.getSelectedFile();
                System.out.println("File name: " + file.getName());
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    tarea.setText(""); // clear up
                    String line; // input buffer
                    while ((line = br.readLine()) != null)
                        tarea.append(line + "\n");
                    br.close();
                } catch (IOException ex) {
                }

            }
        } else {
            int fc_result = fchooser.showSaveDialog(tarea);
            if (fc_result == JFileChooser.APPROVE_OPTION) {
                File file = fchooser.getSelectedFile();
                System.out.println("Save File as: " + file.getName());
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write(tarea.getText()); // text from the JTextArea
                    bw.flush();
                    bw.close();
                } catch (IOException ex) {
                }
            }
        }
    }

}