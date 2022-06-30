

public class Vertex {
    int Name;
    double x_of_vertex;
    double y_of_vertex;
    public Vertex (int name){
        this.Name=name;
        switch (Name) {
            case 0:{
                this.x_of_vertex=(10 - 0.5);
                this.y_of_vertex=(40 - 0.5);
                break;}
            case 1:{
                this.x_of_vertex=(35 - 0.5);
                this.y_of_vertex=(40 - 0.5);
                break;}
            case 2:{
                this.x_of_vertex=(10 - 0.5);
                this.y_of_vertex=(10 - 0.5);
                break;}
            case 3:{
                this.x_of_vertex=(35 - 0.5);
                this.y_of_vertex=(10 - 0.5);
                break;}
            case 4:{
                this.x_of_vertex=(10 - 0.5);
                this.y_of_vertex=(34 - 0.5);
                break;}
            case 5:{
                this.x_of_vertex=(35 - 0.5);
                this.y_of_vertex=(34 - 0.5);
                break;}
        }

    }
    public double get_x(){
        return x_of_vertex;
    }
    public double get_y(){
        return y_of_vertex;
    }
}
