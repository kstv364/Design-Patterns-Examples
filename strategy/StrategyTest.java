package practice.strategy;


interface IQuack{
	void quack();
}


interface IFly{
	void fly();
}



class NoFly implements IFly{
	public void fly(){
		System.out.println("No FLy");
	}
}


class StraightFly implements IFly{
	public void fly(){
		System.out.println("Straight FLy");
	}
}

class NoQuack implements IQuack{
	public void quack() {
		System.out.println("No Quack");		
	}
}

class SimpleQuack implements IQuack{
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("Simple Quack");
	}
}
class Duck{
	
	IQuack quackBehaviour;
	IFly flyBehaviour;
	Duck(IQuack qb, IFly fb){
		quackBehaviour = qb;
		flyBehaviour = fb;
	}
	public void quack(){
		quackBehaviour.quack();
	}
	
	public void fly(){
		flyBehaviour.fly();
	}
}


public class StrategyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck d1 = new Duck(new SimpleQuack(), new StraightFly());
		d1.quack();
		d1.fly();
		/*
		MAIN IDEA IS TO ENCAPSULATE BEHAVIOURS IN SEPARATE CLASSES
		KEEP BEHAVIOURS AS VARIABLES OF TYPE INTERFACE
		*/
		
		// CLIENT DOES NOT NEED TO CHANGE IF BEHAVIOUR IMPLEMENTATION CHANGES OR IS UPDATED
		
		/* OUTPUT
		Simple Quack
		Straight FLy
		*/
		
	}

}
