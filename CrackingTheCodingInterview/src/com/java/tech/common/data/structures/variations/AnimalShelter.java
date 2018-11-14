package com.java.tech.common.data.structures.variations;

import java.util.LinkedList;

public class AnimalShelter {

	public enum AnimalType {
		DOG("Dog"), CAT("Cat");

		String type;

		private AnimalType(String type) // TODO Enum always have a private constructor
		{
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}

	public class Animal {

		Integer age;
		AnimalType type;

		public Animal(AnimalType type, Integer age) {
			this.type = type;
			this.age = age;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public AnimalType getType() {
			return type;
		}

		public void setType(AnimalType type) {
			this.type = type;
		}

		@Override
		public String toString() {
			String s = "type =" + type.getType() + " age=" + age;
			return s;
		}
	}

	LinkedList<Animal> cats;
	LinkedList<Animal> dogs;

	public AnimalShelter() {
		cats = new LinkedList<>();
		dogs = new LinkedList<>();
	}

	public LinkedList<Animal> getAnimalListByType(AnimalType animalType) {
		if (animalType == AnimalType.CAT) {
			return cats;
		} else {
			return dogs;
		}

	}

	public void enqueue(AnimalType animalType, int age) {
		Animal animal = new Animal(animalType, age);
		LinkedList<Animal> list = getAnimalListByType(animalType);
		list.add(animal);
	}

	public Animal dequeue(AnimalType animalType, int age) {
		LinkedList<Animal> list = getAnimalListByType(animalType);
		Animal animal = list.pop();
		return animal;
	}
}
