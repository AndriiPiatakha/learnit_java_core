package com.itbulls.learnit.javacore.multithreading.livelock;

import java.util.concurrent.TimeUnit;

public class LivelockIssueDemo {
	
	public static void main(String[] args) {
		Spouse husband = new Spouse("Igor");
		Spouse wife = new Spouse("Nastia");

		Spoon s = new Spoon(husband);

		new Thread(() -> husband.eatWith(s, wife)).start();
		new Thread(() -> wife.eatWith(s, husband)).start();

	}
	
	static class Spoon {
		private Spouse owner;

		public Spoon(Spouse spouse) {
			owner = spouse;
		}

		public Spouse getOwner() {
			return owner;
		}

		public synchronized void setOwner(Spouse spouse) {
			owner = spouse;
		}

		public synchronized void use() {
			System.out.printf("%s has eaten!", owner.name);
		}
	}

	static class Spouse {
		private String name;
		private boolean isHungry;

		public Spouse(String name) {
			this.name = name;
			this.isHungry = true;
		}

		public String getName() {
			return name;
		}

		public boolean isHungry() {
			return isHungry;
		}

		public void eatWith(Spoon spoon, Spouse spouse) {
			while (isHungry) {
				// Don't have the spoon, so wait patiently for spouse.
				if (spoon.owner != this) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						continue;
					}
					continue;
				}

				// If spouse is hungry, insist upon passing the spoon.
				if (spouse.isHungry()) {
					System.out.printf("%s: You eat first my darling %s!%n", name, spouse.getName());
					spoon.setOwner(spouse);
					continue;
				}

				// Spouse wasn't hungry, so finally eat
				spoon.use();
				isHungry = false;
				System.out.printf("%s: I am stuffed, my darling %s! I'm not hungry anymore%n", name, spouse.getName());
				spoon.setOwner(spouse);
			}
		}
	}
}