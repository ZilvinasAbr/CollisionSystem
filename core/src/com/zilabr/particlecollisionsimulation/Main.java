package com.zilabr.particlecollisionsimulation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.zilabr.particlecollisionsimulation.priorityQueue.PriorityQueueHeapArray;

import java.util.ArrayList;

public class Main extends ApplicationAdapter {
	private SpriteBatch batch;
	private ArrayList<Particle> particles;
	private ShapeRenderer shapeRenderer;

	//TODO: Switch between my implementation of the priority queue with Java's implementation
	private PriorityQueueHeapArray<Event> events;
	//private PriorityQueue<Event> events;

	@Override
	public void create () {
		batch = new SpriteBatch();
		particles = new ArrayList<Particle>();
		shapeRenderer = new ShapeRenderer();

		//TODO: Switch between my implementation of the priority queue with Java's implementation
		events = new PriorityQueueHeapArray<Event>();
		//events = new PriorityQueue<Event>();
		initializeSimulation();
	}

	public void initializeSimulation(){
		particles = TestCases.testCase9();
	}

	public void drawCircles(){
		for(Particle c : particles){
			shapeRenderer.setColor(Color.BLACK);
			shapeRenderer.circle(c.position.x,c.position.y,c.radius);
		}
	}

	public void updateMovement(){
		for(Particle c : particles){
			c.position.x += c.velocity.x * Gdx.graphics.getDeltaTime();
			c.position.y += c.velocity.y * Gdx.graphics.getDeltaTime();
		}
	}

	public void calculateNewEvents(){
		if(particles.size() >= 2){
			for(int i=0;i<particles.size()-1;i++){
				for(int j=i+1;j<particles.size();j++){
					Particle p1 = particles.get(i);
					Particle p2 = particles.get(j);
					long collisionTime = p1.collides(p2);
					if(collisionTime != Long.MAX_VALUE){
						events.add(new Event(TimeUtils.nanoTime()+collisionTime,p1,p2,EventType.P1_WITH_P2));
					}
				}
			}
		}
		for(Particle p : particles){
			long collisionTime1 = p.collidesX();
			long collisionTime2 = p.collidesY();
			if(collisionTime1 != Long.MAX_VALUE)
				events.add(new Event(TimeUtils.nanoTime()+collisionTime1,p,null, EventType.P1_WITH_VERTICAL_WALL));
			if(collisionTime2 != Long.MAX_VALUE)
				events.add(new Event(TimeUtils.nanoTime()+collisionTime2,p,null, EventType.P1_WITH_HORIZONTAL_WALL));
		}
	}

	public void calculateNewEvents(Particle p1, Particle p2, EventType eventType){
		if(eventType == EventType.P1_WITH_P2 || eventType == EventType.P1_WITH_VERTICAL_WALL || eventType == EventType.P1_WITH_HORIZONTAL_WALL){
			for(Particle other : particles){
				if(!p1.equals(other)){
					if(!(p2 != null && p2.equals(other))){
						long collisionTime = p1.collides(other);
						if(collisionTime != Long.MAX_VALUE){
							events.add(new Event(TimeUtils.nanoTime()+collisionTime,p1,other,
									EventType.P1_WITH_P2));
						}
					}

				}
			}
			long collisionTime1 = p1.collidesX();
			long collisionTime2 = p1.collidesY();
			if(collisionTime1 != Long.MAX_VALUE)
				events.add(new Event(TimeUtils.nanoTime()+collisionTime1,p1,null, EventType.P1_WITH_VERTICAL_WALL));
			if(collisionTime2 != Long.MAX_VALUE)
				events.add(new Event(TimeUtils.nanoTime()+collisionTime2,p1,null, EventType.P1_WITH_HORIZONTAL_WALL));
		}
		if(eventType == EventType.P1_WITH_P2 || eventType == EventType.P2_WITH_VERTICAL_WALL || eventType == EventType.P2_WITH_HORIZONTAL_WALL){
			for(Particle other : particles){
				if(!p2.equals(other)){
					if(!(p1 != null && p1.equals(other))){
						long collisionTime = p2.collides(other);
						if(collisionTime != Long.MAX_VALUE){
							events.add(new Event(TimeUtils.nanoTime()+collisionTime,p2,other,
									EventType.P1_WITH_P2));
						}

					}
				}
			}
			long collisionTime1 = p2.collidesX();
			long collisionTime2 = p2.collidesY();
			if(collisionTime1 != Long.MAX_VALUE)
				events.add(new Event(TimeUtils.nanoTime()+collisionTime1,p2,null, EventType.P1_WITH_VERTICAL_WALL));
			if(collisionTime2 != Long.MAX_VALUE)
				events.add(new Event(TimeUtils.nanoTime()+collisionTime2,p2,null, EventType.P1_WITH_HORIZONTAL_WALL));
		}
	}

	public void updateEvents(){
		if(events.peek() == null){
			calculateNewEvents();
		}else{
			while(events.peek() != null && events.peek().getTime() <= TimeUtils.nanoTime()){
				Event nextEvent = events.poll();
				if(!nextEvent.wasSuperveningEvent()){
					Particle p1 = nextEvent.getParticle1();
					Particle p2 = nextEvent.getParticle2();
					EventType eventType = nextEvent.getEventType();
					if(eventType == EventType.P1_WITH_P2){
						p1.bounce(p2);
						calculateNewEvents(p1,p2,eventType);
					}else if(eventType == EventType.P1_WITH_HORIZONTAL_WALL) {
						p1.bounceY();
						calculateNewEvents(p1,p2,eventType);
					}else if(eventType == EventType.P1_WITH_VERTICAL_WALL){
						p1.bounceX();
						calculateNewEvents(p1,p2,eventType);
					}else if(eventType == EventType.P2_WITH_HORIZONTAL_WALL){
						p2.bounceY();
						calculateNewEvents(p1,p2,eventType);
					}else if(eventType == EventType.P2_WITH_VERTICAL_WALL){
						p2.bounceX();
						calculateNewEvents(p1,p2,eventType);
					}
				}
			}
		}
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		updateEvents();
		updateMovement();
		batch.begin();
		batch.end();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		drawCircles();
		shapeRenderer.end();
	}
}
