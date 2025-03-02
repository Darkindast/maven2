/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mephi.b22901.aa.maven_3;

import javax.swing.SwingUtilities;

/**
 *
 * @author Andrey
 */
public class Maven_3 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            new Controller(view);
            view.setVisible(true);
        });
    }
}