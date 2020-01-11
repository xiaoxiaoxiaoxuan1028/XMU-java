import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//完成单选的实现
class MyRadio {
    private String imRed ="C:\\Users\\Apple\\Desktop\\codes\\java\\190625\\src\\Red.jpg";
    private String imYellow = "C:\\Users\\Apple\\Desktop\\codes\\java\\190625\\src\\Yellow.jpg";
    private String imGreen ="C:\\Users\\Apple\\Desktop\\codes\\java\\190625\\src\\Green.jpg";
    //设置一窗体
    private JFrame frame = new JFrame("单选按钮");
    //获取窗体容器
    private Container cont = frame.getContentPane();
    //定义三个窗体按钮
    private JRadioButton jradio1 = new JRadioButton("红灯");
    private JRadioButton jradio2 = new JRadioButton("黄灯");
    private JRadioButton jradio3 = new JRadioButton("绿灯");
    //定义一个面板
    private JPanel pan = new JPanel();
    public MyRadio() {
        //设置边框显示条
        pan.setBorder(BorderFactory.createTitledBorder("红绿灯："));
        //定义排版样式
        pan.setLayout(new GridLayout(1, 3));
        //面板中加入两个单选按钮
        pan.add(this.jradio1);
        pan.add(this.jradio2);
        pan.add(this.jradio3);
        //定义按钮组
        ButtonGroup group=new ButtonGroup();
        //把单选按钮添加到按钮组中，这样只能选组中的一个按钮，真正实现单选
        group.add(jradio1);
        group.add(jradio2);
        group.add(jradio3);
        //单选按钮设置监听器
        jradio1.addItemListener(new MyItemListener());
        jradio2.addItemListener(new MyItemListener());
        jradio3.addItemListener(new MyItemListener());

        cont.add(pan);
        this.frame.setSize(400, 200);
        this.frame.setVisible(true);
        //监听窗体关闭事件
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent obj) {
                System.exit(1);
            }
        });
    }

    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            JRadioButton btn = (JRadioButton) e.getSource();//发生Event的源头
            int state = e.getStateChange();
            switch (state) {
                case ItemEvent.SELECTED:
                    //System.out.println(btn.getText() + "被选中");
                    break;
                case ItemEvent.DESELECTED:
                    //System.out.println(btn.getText() + "取消");
                    break;
            }
        }
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == jradio1) {
            jradio1.setIcon(new ImageIcon(imRed));
            jradio2.setIcon(null);
            jradio3.setIcon(null);
        } else  if (e.getSource() == jradio2){
            jradio2.setIcon(new ImageIcon(imYellow));
            jradio1.setIcon(null);
            jradio3.setIcon(null);
        }
        else {
            jradio3.setIcon(new ImageIcon(imGreen));
            jradio1.setIcon(null);
            jradio2.setIcon(null);
        }

    }
}

public class TrafficLights {
    public static void main(String args[]) {
        new MyRadio();
    }
}
