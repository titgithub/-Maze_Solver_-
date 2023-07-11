/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver_project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author mazum
 */
public class MazeSolver extends JFrame {
    private int[][]maze =
            {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,1,1,1,1,1,0,0,0,0,0,1},
                    {1,0,0,1,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,10,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            };
    public List<Integer>path = new ArrayList<>();
    public MazeSolver(){
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //DepthFirst.searchpath(maze,1,1,path)
        DepthFirst.searchpath(maze,1,1,path);
    }
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        for(int i =0; i<maze.length;i++){
            for(int j =0; j<maze[0].length;j++){
                 Color color;
                 switch(maze[i][j]){
                    case 1:color=Color.BLACK;break;
                    case 10:color=Color.BLUE;break;
                    default:color=Color.WHITE;break;
                }
                 g.setColor(color);
                 g.fillRect(30*j,30*i,30,30);
                 g.setColor(Color.BLUE);
                 g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i =0;i<path.size();i+=2){
            int path1 = path.get(i);
            int path2 = path.get(i+1);
            
            System.out.println("X Coordinates " + path1);
            System.out.println("Y Coordinates "+path2);
            g.setColor(Color.YELLOW);
            g.fillRect(30*path1,30*path2,20,20);
            
        }
    }
    public static void main(String[]args){
        MazeSolver view = new MazeSolver();
        view.setVisible(true);
    }
    public class DepthFirst{
        public static boolean searchpath(int[][]maze,int x, int y,List<Integer>path){
            if(maze[y][x]==10){
                path.add(x);
                path.add(y);
                return true;
            }
            if(maze[y][x]==0){
                maze[y][x]=2;
                int dx = -1;
                int dy = 0;
                if(searchpath(maze,x+dx,y+dy,path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
                 dx = 1;
                 dy = 0;
                if(searchpath(maze,x+dx,y+dy,path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
                dx = 0;
                dy = -1;
                if(searchpath(maze,x+dx,y+dy,path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
                dx = 0;
                dy = 1;
                if(searchpath(maze,x+dx,y+dy,path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
            }
            return false;
        }
    }
}
    

    
