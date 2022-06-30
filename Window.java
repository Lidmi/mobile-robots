

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame {
    JButton pusk;
    JComboBox cathegory,end,start;
    JLabel start_label,end_label, cath_label;
    Boolean push=false;
    int[] info=new int[3];
    public Window(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        start_label = new JLabel("Введите начальную вершину");
        end_label = new JLabel("Введите конечную вершину");
        cath_label = new JLabel("Введите категорию изделия");
        String[] items0 = {
                "склад заготовок",
                "склад готовой продукции",
                "стационарный робот №1",
                "стационарный робот №2"
        };
        start= new JComboBox(items0);
        String[] items1 = {
                "категория А (легковесная)",
                "категория В (средне весовая)",
                "категория С (тяжеловесная)"
        };
        cathegory = new JComboBox(items1);
        String[] items2 = {
                "склад заготовок",
                "склад готовой продукции",
                "стационарный робот №1",
                "стационарный робот №2"
        };
        end=new JComboBox(items2);
        pusk= new JButton("Отправить запрос");
        JPanel contents = new JPanel(new GridLayout(7,1));
        contents.add(start_label);
        contents.add(start);
        contents.add(end_label);
        contents.add(end);
        contents.add(cath_label);
        contents.add(cathegory);
        contents.add(pusk);
        add(contents, BorderLayout.SOUTH);
        pusk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                String item_start = (String)start.getSelectedItem();
                if (item_start.equals("склад заготовок")){
                    info[0]=0;
                }else if (item_start.equals("склад готовой продукции")){
                    info[0]=1;
                }else if (item_start.equals("стационарный робот №1")) {
                    info[0] = 2;
                }else if(item_start.equals("стационарный робот №2")){
                    info[0] = 3;
                }


                String item_end = (String)end.getSelectedItem();
                if (item_end.equals("склад заготовок")){
                    info[1]=0;
                }else if (item_end.equals("склад готовой продукции")){
                    info[1]=1;
                }else if (item_end.equals("стационарный робот №1")) {
                    info[1] = 2;
                }else if(item_end.equals("стационарный робот №2")){
                    info[1] = 3;
                    }

                String item_cath = (String)cathegory.getSelectedItem();
                if (item_cath.equals("категория А (легковесная)")){
                    info[2]=1;
                }else if (item_cath.equals("категория В (средне весовая)")){
                    info[2]=2;
                }else if (item_cath.equals("категория С (тяжеловесная)")){
                    info[2]=3;}
                push=true;
            }
            });
    }
    public int[] getInfo(){
        push=false;
        return info;
    }
}
