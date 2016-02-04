package com.zilabr.particlecollisionsimulation;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zilvinas on 2015-12-02.
 */
public class TestCases {

    public static ArrayList<Particle> testCase1(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        result.add(new Particle(600.f,360.f,2000.f,0.f,100.f,100.f));
        return result;
    }

    public static ArrayList<Particle> testCase2(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        result.add(new Particle(400.f,360.f,500.f,0.f,100.f,50.f));
        result.add(new Particle(800.f,360.f,0.f,0.f,100.f,50.f));
        return result;
    }

    public static ArrayList<Particle> testCase3(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        result.add(new Particle(200.f,360.f,0.f,0.f,100.f,50.f));
        result.add(new Particle(300.f,360.f,0.f,0.f,100.f,50.f));
        result.add(new Particle(400.f,360.f,0,0.f,100.f,50.f));
        result.add(new Particle(500.f,360.f,0.f,0.f,100.f,50.f));
        result.add(new Particle(600.f,360.f,0.f,0.f,100.f,50.f));
        result.add(new Particle(700.f,360.f,0.f,0.f,100.f,50.f));
        result.add(new Particle(900.f,360.f,500.f,0.f,100.f,50.f));
        return result;
    }

    public static ArrayList<Particle> testCase4(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        result.add(new Particle(600.f,360.f,300.f,0.f,1.f,2.f));
        result.add(new Particle(700.f,360.f,300.f,0.f,1.f,2.f));
        result.add(new Particle(800.f,360.f,300.f,0.f,1.f,2.f));
        result.add(new Particle(900.f,360.f,300.f,0.f,1.f,2.f));
        result.add(new Particle(100.f,300.f,300.f,0.f,10.f,50.f));
        result.add(new Particle(1280-100.f,300.f,-300.f,0.f,10.f,50.f));
        result.add(new Particle(640.f,640.f,0.f,300.f,10.f,20.f));
        result.add(new Particle(900.f,640.f,500f,-500f,10.f,40.f));
        return result;
    }

    public static ArrayList<Particle> testCase5(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        for(int i=0;i<1280;i+=100){
            for(int j=0;j<720;j+= 100){
                result.add(new Particle(i,j,200.f,-200.f,10.f,10));
            }
        }
        return result;
    }

    public static ArrayList<Particle> testCase6(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        Vector2 startingPos = new Vector2(640.f+320.f,360.f);
        result.add(new Particle(160.f,360.f,900.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x,startingPos.y,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+40,startingPos.y-20.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+40,startingPos.y+20.f,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+80,startingPos.y+40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+80,startingPos.y-40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+80,startingPos.y,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+120,startingPos.y-60.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+120,startingPos.y+60.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+120,startingPos.y-20.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+120,startingPos.y+20.f,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+160,startingPos.y-80.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+160,startingPos.y-40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+160,startingPos.y,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+160,startingPos.y+40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+160,startingPos.y+80.f,0.f,0.f,10.f,20.f));
        return result;
    }

    public static ArrayList<Particle> testCase7(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        Vector2 startingPos = new Vector2(640.f+320.f,360.f);
        result.add(new Particle(160.f,360.f,600.f,0.f,100.f,200.f));

        result.add(new Particle(startingPos.x,startingPos.y,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+40,startingPos.y-20.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+40,startingPos.y+20.f,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+80,startingPos.y+40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+80,startingPos.y-40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+80,startingPos.y,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+120,startingPos.y-60.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+120,startingPos.y+60.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+120,startingPos.y-20.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+120,startingPos.y+20.f,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+160,startingPos.y-80.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+160,startingPos.y-40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+160,startingPos.y,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+160,startingPos.y+40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+160,startingPos.y+80.f,0.f,0.f,10.f,20.f));
        return result;
    }

    //Biliardo stalas simuliacija, kamuoliukai labai arti vienas kito
    public static ArrayList<Particle> testCase8(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        Vector2 startingPos = new Vector2(640.f+320.f,360.f);
        result.add(new Particle(160.f,360.f,700.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x,startingPos.y,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+35,startingPos.y-20.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+35,startingPos.y+20.f,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+70,startingPos.y+40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+70,startingPos.y-40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+70,startingPos.y,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+105,startingPos.y-60.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+105,startingPos.y+60.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+105,startingPos.y-20.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+105,startingPos.y+20.f,0.f,0.f,10.f,20.f));

        result.add(new Particle(startingPos.x+140,startingPos.y-80.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+140,startingPos.y-40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+140,startingPos.y,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+140,startingPos.y+40.f,0.f,0.f,10.f,20.f));
        result.add(new Particle(startingPos.x+140,startingPos.y+80.f,0.f,0.f,10.f,20.f));
        return result;
    }

    public static ArrayList<Particle> testCase9(){
        ArrayList<Particle> result = new ArrayList<Particle>();

        for(int i=0;i<1280;i+=50){
            for(int j=30;j<720;j+= 50){
                result.add(new Particle(i,j,100.f,0.f,10.f,10.f));
            }
        }

        return result;
    }

    public static ArrayList<Particle> testCase10(){
        ArrayList<Particle> result = new ArrayList<Particle>();

        for(int i=5;i<1280;i+=50){
            for(int j=30;j<720;j+= 50){
                result.add(new Particle(i,j,50.f,50.f,10.f,10.f));
            }
        }


        return result;
    }

    public static ArrayList<Particle> testCase11(){
        ArrayList<Particle> result = new ArrayList<Particle>();

        for(int i=5;i<1280;i+=50){
            for(int j=30;j<720;j+= 50){
                Vector2 velocityVector = new Vector2(640.f-i,360.f-j);
                velocityVector = velocityVector.nor();
                result.add(new Particle(i,j,velocityVector.x*50.f,velocityVector.y*50.f,10.f,10.f));
            }
        }
        return result;
    }

    /* Proof of Brownian motion. */
    public static ArrayList<Particle> testCase12(){
        ArrayList<Particle> result = new ArrayList<Particle>();
        Random rand = new Random();

        result.add(new Particle(640.f,360.f,0.f,0.f,100.f,150.f));

        for(int i=10;i<1280;i+=20){
            for(int j=20;j<720;j+= 20){
                if((i <= 640-200 || i >= 640+200) || (j <= 360-200 || j >= 360+200)){
                    Vector2 velocityVector = new Vector2((rand.nextBoolean() ? 1 : -1) * rand.nextFloat(),(rand.nextBoolean() ? 1 : -1)* rand.nextFloat());
                    velocityVector = velocityVector.nor();
                    result.add(new Particle(i,j,velocityVector.x*45.f,velocityVector.y*45.f,10.f,5.f));
                }
            }
        }
        return result;
    }
}
