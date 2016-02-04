package com.zilabr.particlecollisionsimulation;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zilvinas on 2015-11-30.
 */
public class Particle {
    public Vector2 position;
    public Vector2 velocity;
    public float m;
    public float radius;
    public int collisionsCount;

    public Particle(Vector2 pos, Vector2 vel, float m, float radius){
        position = pos;
        velocity = vel;
        this.m = m;
        this.radius = radius;
        collisionsCount = 0;
    }

    public Particle(float rx, float ry, float vx, float vy,
                    float m, float radius){
        position = new Vector2(rx,ry);
        velocity = new Vector2(vx,vy);
        this.m = m;
        this.radius = radius;
    }

    /**
     *
     * @return time until particle collides with a vertical wall
     */
    public long collidesX(){
        if (velocity.x > 0.f){
            long deltaT = (long) (((Screen.screenWidth-radius-position.x)/velocity.x)*1000000000);
            return deltaT;
        }else if(velocity.x < 0.f){
            long deltaT = (long)(((radius - position.x)/velocity.x)*1000000000);
            return deltaT;
        }else{
            return Long.MAX_VALUE;
        }
    }

    /**
     * Time until particle collides with a horizontal wall
     * @return
     */
    public long collidesY(){
        if (velocity.y > 0.f){
            long deltaT = (long)(((Screen.screenHeight-radius-position.y)/velocity.y)*1000000000);
            return deltaT;
        }else if(velocity.y < 0.f){
            long deltaT = (long)(((radius - position.y)/velocity.y)*1000000000);
            return deltaT;
        }else{
            return Long.MAX_VALUE;
        }
    }


    /**
     * @param b
     * @return the duration of time until the invoking particle collides with
     * particle b, assuming both follow straight-line trajectories. If the two
     * particles never collide, return a negative value.
     */
    public long collides(Particle b){

        float deltaVTimesX = b.velocity.x - velocity.x;
        float deltaVTimesY = b.velocity.y - velocity.y;
        float deltaX = b.position.x - position.x;
        float deltaY = b.position.y - position.y;
        Vector2 deltaR = new Vector2(deltaX, deltaY);
        Vector2 deltaV = new Vector2(deltaVTimesX,deltaVTimesY);
        float deltaRTimesDeltaR = deltaX*deltaX + deltaY*deltaY;
        float deltaVTimesDeltaV = deltaVTimesX*deltaVTimesX +
                deltaVTimesY*deltaVTimesY;
        float deltaVTimesDeltaR = deltaVTimesX*deltaX + deltaVTimesY*deltaY;
        float radiusSquared = (radius + b.radius)*(radius + b.radius);

        float d = deltaVTimesDeltaR*deltaVTimesDeltaR -
                deltaVTimesDeltaV*(deltaRTimesDeltaR - radiusSquared);


        if(deltaVTimesDeltaR >= 0)
            return Long.MAX_VALUE;
        if(d < 0)
            return Long.MAX_VALUE;

        float result = -1*(deltaVTimesDeltaR + (float) Math.sqrt(d))/
                (deltaVTimesDeltaV);
        long deltaT = (long)(result*1000000000);

        return deltaT;
    }

    /**
     * update the invoking particle to simulate it bouncing off a vertical wall
     */
    public void bounceX(){
        velocity.x *= -1;
        collisionsCount++;
    }

    /**
     * update the invoking particle to simulate it bouncing off a horizontal wall
     */
    public void bounceY(){
        velocity.y *= -1;
        collisionsCount++;
    }

    /**
     * update both particles to simulate them bouncing off each other
     * @param b
     */
    public void bounce(Particle b){
        float deltaVTimesX = b.velocity.x - velocity.x;
        float deltaVTimesY = b.velocity.y - velocity.y;
        float deltaX = b.position.x - position.x;
        float deltaY = b.position.y - position.y;
        Vector2 deltaR = new Vector2(deltaX, deltaY);
        Vector2 deltaV = new Vector2(deltaVTimesX,deltaVTimesY);
        float deltaRTimesDeltaR = deltaX*deltaX + deltaY*deltaY;
        float deltaVTimesDeltaV = deltaVTimesX*deltaVTimesX +
                deltaVTimesY*deltaVTimesY;
        float deltaVTimesDeltaR = deltaVTimesX*deltaX + deltaVTimesY*deltaY;
        float radiusSquared = (radius + b.radius)*(radius + b.radius);

        float d = deltaVTimesDeltaR*deltaVTimesDeltaR -
                deltaVTimesDeltaV*(deltaRTimesDeltaR - radiusSquared);



        float J = (2*m*b.m*deltaVTimesDeltaR)/((radius+b.radius)*(m+b.m));
        float Jx = (J*deltaX)/(radius+b.radius);
        float Jy = (J*deltaY)/(radius+b.radius);

        velocity.x = velocity.x + Jx/m;
        b.velocity.x = b.velocity.x - Jx/b.m;
        velocity.y = velocity.y + Jy/m;
        b.velocity.y = b.velocity.y - Jy/b.m;

        collisionsCount++;
        b.collisionsCount++;
    }

    /**
     *
     * @return the total number of collisions involving this particle
     */
    public int getCollisionCount(){
        return collisionsCount;
    }
}