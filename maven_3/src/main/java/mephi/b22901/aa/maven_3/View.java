/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.aa.maven_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private DefaultListModel<String> hereticListModel;
    private JList<String> hereticList;
    private JButton addButton;
    private JButton viewButton;

    public View() {
        setTitle("Розыск еретиков");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
     

        hereticListModel = new DefaultListModel<>();
        hereticList = new JList<>(hereticListModel);
        add(new JScrollPane(hereticList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Добавить объект розыска");
        viewButton = new JButton("Просмотреть информацию");
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addHeretic(String heretic) {
        hereticListModel.addElement(heretic);
    }

    public String getSelectedHeretic() {
        return hereticList.getSelectedValue();
    }

    public void addAddHereticListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addViewHereticListener(ActionListener listener) {
        viewButton.addActionListener(listener);
    }
}

