package com.itbulls.learnit.javacore.patterns.creational.abstractfactory.example2;

public class ElfSquadronFactory extends SquadronFactory {
	public Mage createMage() {
		return new ElfMage();
	}

	public Archer createArcher() {
		return new ElfArcher();
	}

	public Warrior createWarrior() {
		return new ElfWarrior();
	}
	

}
