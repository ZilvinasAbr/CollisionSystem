package com.zilabr.particlecollisionsimulation;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Zilvinas on 2015-11-30.
 */
public class Event implements Comparable{
    private long collisionTime;
    private Particle a,b;
    private int aCollisionCountOnEventCreation;
    private int bCollisionCountOnEventCreation;
    private EventType eventType;

    public Event(long t, Particle a, Particle b, EventType eventTypeParam){
        this.a = a;
        this.b = b;
        eventType = eventTypeParam;
        collisionTime = t;
        if(a != null)
            aCollisionCountOnEventCreation = a.getCollisionCount();
        else
            aCollisionCountOnEventCreation = 0;
        if(b != null)
            bCollisionCountOnEventCreation = b.getCollisionCount();
        else
            bCollisionCountOnEventCreation = 0;
    }

    public EventType getEventType(){
        return eventType;
    }

    /**
     *
     * @return  the time associated with the event
     */
    public long getTime(){
        return collisionTime;
    }

    public Particle getParticle1(){
        return a;
    }

    public Particle getParticle2(){
        return b;
    }

    /**
     *
     * @return true if the event has been invalidated since creation,
     * and false if the event has not been invalidated.
     */
    public boolean wasSuperveningEvent(){
        if(a != null)
            if(aCollisionCountOnEventCreation != a.getCollisionCount())
                return true;
        if(b != null)
            if(bCollisionCountOnEventCreation != b.getCollisionCount())
                return true;
        return false;
    }


    //TODO: different compareTo for Java's and my PriorityQueue Implementations
    @Override
    public int compareTo(Object obj){
        if(collisionTime > ((Event) obj).collisionTime)
            return -1;
        if(collisionTime < ((Event) obj).collisionTime)
            return 1;
        else
            return 0;
    }
}