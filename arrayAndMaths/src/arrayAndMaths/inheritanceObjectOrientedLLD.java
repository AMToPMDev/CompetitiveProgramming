package arrayAndMaths;

class Bird{
	int height, weight;
	
	void fly() {
		System.out.println("Wings Flapped");
	}
}

class Eagle extends Bird{
	
	@Override
	void fly() {
		super.fly();
		System.out.println("Eagle takes off");
	}
}

class Pigeon extends Bird{
	
	@Override
	void fly() {
		super.fly();
		System.out.println("Pigeon takes off");
	}
}


public class inheritanceObjectOrientedLLD {
	public static void main(String args[]) {
		Eagle e = new Eagle();
		e.fly();
		
		Pigeon p = new Pigeon();
		p.fly();
	}
}
