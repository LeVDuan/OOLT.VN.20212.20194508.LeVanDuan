/* 
- Solve the first-degree equation with one variable
- Solve the system of first-degree equations with two variables
- Solve the second-degree equation with one variable
*/

import javax.swing.JOptionPane;

public class lab01HomeWork {
    public static void main(String[] args) {
        String menu = "1.Solve the first-degree equation with one variable\n2.Solve the system of first-degree equations with two variables\n3.Solve the second-degree equation with one variable\n4.Exit";

        String choice = "";
        double a, b, result = 0; // for first-degree equation
        do{
            choice = JOptionPane.showInputDialog(menu);
            switch (choice) {
                case "1":
                    a = Double.parseDouble(JOptionPane.showInputDialog("ax + b = 0\nEnter a: ")) ;
                    b = Double.parseDouble(JOptionPane.showInputDialog("ax + b = 0\nEnter b: ")) ;
                    if (a == 0) {
                        JOptionPane.showMessageDialog(null,"Error: a = 0!");
                    }
                    else {
                        result = -b/a;
                        JOptionPane.showMessageDialog(null,"x = " + result);
                    }
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    break;
            }
        } while (!choice.equals("4"));
        

        System.exit(0);
    }
}