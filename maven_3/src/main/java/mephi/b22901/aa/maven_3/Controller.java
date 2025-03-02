/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.aa.maven_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;
    private List<Heretic> hereticList;

    public Controller(View view) {
        if (view == null) {
            throw new IllegalArgumentException("MainView не может быть null!");
        }
        this.view = view;
        this.hereticList = new ArrayList<>();

        // Подключаем обработчики кнопок напрямую через методы
        view.addAddHereticListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHeretic();
            }
        });

        view.addViewHereticListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHeretic();
            }
        });
    }

    // Метод для добавления еретика
    public void addHeretic() {
        Heretic heretic = DataGenerator.generateHeretic();
        hereticList.add(heretic);
        view.addHeretic(heretic.toString());
    }

    // Метод для просмотра информации о выбранном еретике
    public void viewHeretic() {
        String selectedHeretic = view.getSelectedHeretic();
        if (selectedHeretic == null) {
            JOptionPane.showMessageDialog(view, "Выберите еретика из списка!", "Ошибка", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (Heretic h : hereticList) {
            if (h.toString().equals(selectedHeretic)) {
                JOptionPane.showMessageDialog(view, "Имя: " + h.getName() +
                        "\nПреступления: " + String.join(", ", h.getCrimes()) +
                        "\nПоследнее появление: " + h.getLastSeenLocation() +
                        "\nID: " + h.getId() +
                        "\nУровень угрозы: " + h.getThreatLevel(), "Информация", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }
}
