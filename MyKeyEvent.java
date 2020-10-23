 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyKeyHandle extends JFrame implements KeyListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextArea text = new JTextArea();
    public MyKeyHandle(){
        super.setTitle("Welcome！");
        JScrollPane scr=new JScrollPane(text);
        scr.setBounds(5, 5, 300, 200);
        super.add(scr);
        text.addKeyListener(this);
        super.setSize(310,210);
        super.setVisible(true);
        super.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent arg0){
                System.exit(1);
            }
        });
    }
    @Override
    public void keyTyped(KeyEvent e) {
        text.append("输入的内容是:"+e.getKeyChar()+"\n");
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        text.append("键盘“"+KeyEvent.getKeyText(e.getKeyCode())+"”键按下\n"); 
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        text.append("键盘“"+KeyEvent.getKeyText(e.getKeyCode())+"”键松开\n");
    }
}
public class MyKeyEvent {
    public static void main(String[] args) {
        
        new MyKeyHandle();
    }
}