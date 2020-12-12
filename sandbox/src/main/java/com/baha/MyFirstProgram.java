package com.baha;

public class MyFirstProgram {

    public static void main(String[] args) {



        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());


        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника  со сторонами " + r.a + " and " + r.b + " = " + r.area());


    }








}