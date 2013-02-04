import javax.swing.JFrame;

public class theCollegeExperience extends JFrame 
{

    public theCollegeExperience() 
    {
        add(new Board());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setTitle("The College Experience");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new	theCollegeExperience();        
    }
}
