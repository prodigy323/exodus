package com.prodigy.exodus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Human {
    public String name;
    public Puppy puppy;

    public Human(String name) {
        this.name = name;
    }

    public void buyPuppy(String name){
        puppy = Puppy.createPuppy(name, this);
    }

    public void walkWithPuppy() {
        puppy.goOnWalk(15);
    }

    public static void main(String[] args) {
        Human john = new Human("John");
        john.buyPuppy("Gatsby");
        john.puppy.performPuppyTasks();
        john.walkWithPuppy();
    }

    public void isSoHappy() {
    	log.info("Yay!");
    }
}
