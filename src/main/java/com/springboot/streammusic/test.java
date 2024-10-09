package com.springboot.streammusic;

public class test {

    public static void main(String[] args) {


Cat cat = new Cat();
Animal animal1 = cat;
Animal animal2 = (Animal) cat;
Animal animal3 = new Cat();

Animal animalx = new Cat();

cat.meow();
cat.eat();


    }

}
