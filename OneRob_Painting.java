// The API StdDraw.java - for painting graphics

import javax.swing.*;
import java.util.ArrayList;

class OneRob_Painting
{
	public static void paint_canva(){
	double x0, y0, x1, y1, x2, y2;

	double lenghtx_shop = 50.0;
	int kol_line = (int) lenghtx_shop;
	kol_line++;
	StdDraw.setCanvasSize(600, 600);
	StdDraw.setXscale(0.0, lenghtx_shop);
	StdDraw.setYscale(0.0, lenghtx_shop);

	// ?????????? ???????????? ?????
	x0 = 0.0;
	for (int i = 0; i < kol_line; i++)
	{
		x1 = x2 = x0;
		y1 = 0;
		y2 = lenghtx_shop;
		x0 = x0 + 1.0;
		StdDraw.line(x1, y1, x2, y2);
	}

	y0 = 0.0;
	for (int i = 0; i < kol_line; i++)
	{
		y1 = y2 = y0;
		x1 = 0;
		x2 = lenghtx_shop;
		y0 = y0 + 1.0;
		StdDraw.line(x1, y1, x2, y2);
	}


	String text_xy [] = {"10", "20", "30", "40", "50"};
	double dx = 9.5;
	int ind_text_xy = 0;
	do
	{
		StdDraw.text(dx, -1.0, text_xy [ind_text_xy]);
		dx+= 10.0;
		ind_text_xy++;
	} while (dx < 51.0);

	double dy = 9.5;
	ind_text_xy = 0;
	do
	{
		StdDraw.text(-1.0, dy, text_xy [ind_text_xy]);
		dy+= 10.0;
		ind_text_xy++;
	} while (dy < 51.0);
	StdDraw.picture(10, 45, "sklad.png", 8, 8);
	StdDraw.picture(35, 45, "sklad.png", 8, 8);
	StdDraw.picture(10, 4, "robot2.jpg", 8, 8);
	StdDraw.picture(35, 4, "robot2.jpg", 8, 8);
	StdDraw.picture(15, 42, "wall.jpg", 2, 16);
	StdDraw.picture(30, 42, "wall.jpg", 2, 16);
}
        public static int paint (ArrayList<Integer> path, int cathegory, DijkstrasAlgorithm thisthread )
        {
			try{
        	String image="";
				if (cathegory==1){
					image="RobA.jpg";
				}else if (cathegory==2){
					image="RobB.jpg";
				}else if (cathegory==3){
					image="RobC.jpg";
				}

//**************************************************************************************************************
			int amount= path.size();
			for (int current: path){
				int j= path.indexOf(current);
				int next;
				if (j!=-1 && j<amount-1){
					next=path.get(j+1);
				}else{
					break;
				}
				Vertex cur=new Vertex(current);
				Vertex nex=new Vertex(next);

				double currentX=cur.x_of_vertex;
				double currentY=cur.y_of_vertex;
				double nextX=nex.x_of_vertex;
				double nextY=nex.y_of_vertex;

				StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
				Thread.sleep(400);
				StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);

				if (currentX!=nextX && currentY!=nextY) {
					if (currentX<nextX && currentY<nextY){
						while(currentX!=nextX && currentY!=nextY){
						currentX=currentX+1;
						currentY=currentY+1;
						StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
						thisthread.sleep(400);
							StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);}
					}else if(currentX>nextX && currentY<nextY){
						while(currentX!=nextX && currentY!=nextY){
						currentX=currentX-1;
						currentY=currentY+1;
						StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
							thisthread.sleep(400);
							StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);}
					}else if(currentX<nextX && currentY>nextY){
						while(currentX!=nextX && currentY!=nextY){
						currentX=currentX+1;
						currentY=currentY-1;
						StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
							thisthread.sleep(400);
							StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);}
					}else if(currentX>nextX && currentY>nextY){
						while(currentX!=nextX && currentY!=nextY){
						currentX=currentX-1;
						currentY=currentY-1;
						StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
							thisthread.sleep(400);
							StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);}
					}

				}else if (currentX<nextX){
					while(currentX!=nextX){
						currentX=currentX+1;
						StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
						thisthread.sleep(400);
						StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);
					}
				}else if(currentX>nextX){
					while(currentX!=nextX){
						currentX=currentX-1;
						StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
						thisthread.sleep(400);
						StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);
					}
				}else if (currentY<nextY){
					while(currentY!=nextY){
						currentY=currentY+1;
						StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
						thisthread.sleep(400);
						StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);
					}
				}else if(currentY>nextY){
					while(currentY!=nextY){
						currentY=currentY-1;
						StdDraw.picture(currentX, currentY, image, 0.7, 0.7);
						thisthread.sleep(400);
						StdDraw.picture(currentX, currentY, "white.jpg", 0.8, 0.8);
					}
				}
			}
        }catch (InterruptedException e){
				System.out.println("??????");
			}
        	return 1;

	}
}
	
	
	
	

