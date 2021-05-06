package com.itbulls.learnit.javacore.patterns.creational.abstractfactory.example2;

public class Demo {

	private SquadronFactory factory;
	
	private Mage mage;
	private Archer archer;
	private Warrior warrior;

	public Demo(SquadronFactory factory) {
		this.factory = factory;
	}

	public static void main(String[] args) {
		SquadronFactory factory = new ElfSquadronFactory();
		Demo client = new Demo(factory);
		
		client.createSquadron(factory);
		client.createSquadron();

	}

	private void createSquadron(SquadronFactory factory) {
		this.mage = factory.createMage();
		this.archer = factory.createArcher();
		this.warrior = factory.createWarrior();
	}
	
	// Just another version - without arguments, because we injected factory
	private void createSquadron() {
		this.mage = this.factory.createMage();
		this.archer = this.factory.createArcher();
		this.warrior = this.factory.createWarrior();
	}
	
	public void setFactory(SquadronFactory factory) {
		this.factory = factory;
	}

}
