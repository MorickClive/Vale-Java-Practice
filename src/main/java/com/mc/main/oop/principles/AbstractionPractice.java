package com.mc.main.oop.principles;

import java.util.ArrayList;
import java.util.List;

import com.mc.main.oop.principles.res.abstraction.Bird;
import com.mc.main.oop.principles.res.abstraction.FlyingBird;
import com.mc.main.oop.principles.res.abstraction.Penguin;
import com.mc.main.oop.principles.res.abstraction.Seagul;
import com.mc.main.util.StringConst;

public class AbstractionPractice {
	
	private AbstractionPractice() { super(); }
	
	public static void start() {
		// To investigate abstraction, we will look at the Bird, Seagul & Penguin classes.
		// This will help explain concepts that are a little more theoretical and ground them
		// in a suitable expression.
		
		
		// This is the beginning of an example.
		List<Bird> birdList = new ArrayList<>();

		// Note that we can store both Seaguls AND Penguins
		// In the same List because they share the "abstract" Bird parent.
		birdList.add(new Seagul("Black-Headed Gull"));
		birdList.add(new Seagul("European Herring Gull", true));
		birdList.add(new Seagul("Common Gull"));
		birdList.add(new Seagul("Black-Tailed Gull", true));
		
		birdList.add(new Penguin("Emperor Penguin"));
		birdList.add(new Penguin("Adélie Penguin"));
		birdList.add(new Penguin("Southern Rockhopper Penguin"));
		birdList.add(new Penguin("Fiordland Penguin"));

		
		System.out.format("Birds and their capabilities:\n%s\n", StringConst.DIV);
		FlyingBird flyingBird;
		
		// We can now go through a list of birds and hand them respectively based on their
		// class relationships.
		//
		// HOWEVER - java only knows we are handling Birds, not Penguins, Seaguls
		// or FlyingBirds - this means whilst we can store all child classes
		// our access to the interface for each is limited to what is provided by
		// the Bird class!
		for(Bird bird : birdList) {
			
			// Despite being limited by Birds interface, java will still run
			// child behaviour if the Bird is a specific child instance within the list.
			System.out.println("\t-" + bird.speak());
			
			// However if we wanted to invoke behaviour of Birds with capabilities
			// such as Flying ones, we need to check the instance first.
			// We can then cast that instance to the appropriate interface for access
			// do addition capabilities.
			if(bird instanceof FlyingBird) {
				// Because we've cast bird as a FlyingBird we gain access
				// to its interface - and fly!
				//
				// Even though we are looping through a list of Birds!				
				flyingBird = (FlyingBird) bird; // let's store it for convenience!
				
				if(flyingBird.isFlying()) {
					flyingBird.land();
				} else {
					flyingBird.fly();
				}
				
				System.out.println("\t-" + flyingBird.getSpecies() + (
						flyingBird.isFlying() ? 
						" is now flying high!" :
						" is currently perched on a roof!")
						);				
			}
			System.out.println("");
		}
		
		System.out.println(StringConst.DIV);
	}

}
