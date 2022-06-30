import javax.swing.*;
import java.util.ArrayList;

public class Start {
    static MobRob[] all_robots = new MobRob[3];

   static boolean[] check_robots=new boolean[3];
   static ArrayList<Boolean> check_thread=new ArrayList<Boolean>();


    public static int check(int cath){
        int catheg=0;
        for(int i=0;i< all_robots.length;i++){
            if(all_robots[i].cathegory==cath && check_robots[i]){
                catheg=cath;
                check_robots[i]=false;
                System.out.println("занят робот категории "+i);
                break;
            }
        }
if (catheg==0){
        for(int j=0;j< all_robots.length;j++){
            if (all_robots[j].cathegory == cath + 1 && check_robots[j]) {
                catheg = cath + 1;
                check_robots[j]=false;
                System.out.println("занят робот категории "+j);
                break;
                }
            }
}
        return catheg;
    }
    public static void main(String[] args) throws InterruptedException {
        int start;
        int end;
        int cathegory;
        int checked_cath;
        boolean checked;

        ArrayList<DijkstrasAlgorithm> threads=new ArrayList<DijkstrasAlgorithm>();

        all_robots[0] = new MobRob("A");
        all_robots[1] = new MobRob("B");
        all_robots[2] = new MobRob("C");
        check_robots[0]=true;
        check_robots[1]=true;
        check_robots[2]=true;

        OneRob_Painting paint1 = new OneRob_Painting();
        paint1.paint_canva();

        Window wind = new Window();
        wind.setLocationRelativeTo(null);
        wind.setVisible(true);
        wind.pack();
        int[] information;


        while (true) {


            while (wind.push == false) {
                Thread.sleep(300);
            }
            information = wind.getInfo();

            for(int z=0;z<threads.size();z++){
                if (threads.get(z).process==1 && check_thread.get(z)){
                    check_robots[threads.get(z).cathegory-1]=true;
                    check_thread.set(z,false);
                }
            }

            System.out.print(check_robots[0]+" ");
            System.out.print(check_robots[1]+" ");
            System.out.println(check_robots[2]);


            start = information[0];
            end = information[1];
            cathegory = information[2];
            checked_cath=check(cathegory);

            System.out.println("checked_cath= "+checked_cath);
            if(checked_cath==0){
                wind.pusk.setEnabled(false);
                checked=true;
                JOptionPane.showMessageDialog(null,"Все роботы необходимой вам категории заняты. Подождите","Ошибка",JOptionPane.ERROR_MESSAGE);
                while(checked){
                    for(int y=0;y<threads.size();y++){
                        if (threads.get(y).process==1 && check_thread.get(y)){
                            check_robots[threads.get(y).cathegory-1]=true;
                            check_thread.set(y,false);
                        }
                    }
                    checked_cath=check(cathegory);
                    if (checked_cath!=0){
                        checked=false;
                    }
                }
                ArrayList<Integer> thisparents  = new ArrayList<>();
                DijkstrasAlgorithm dij = new DijkstrasAlgorithm(paint1, start, end, checked_cath, thisparents);
                threads.add(dij);
                check_thread.add(true);
                dij.start();
                wind.pusk.setEnabled(true);
            }else{
            ArrayList<Integer> thisparents = new ArrayList<>();
            DijkstrasAlgorithm dij = new DijkstrasAlgorithm(paint1, start, end, checked_cath, thisparents);
            threads.add(dij);
            check_thread.add(true);
            dij.start();
        }
        }
    }
}
