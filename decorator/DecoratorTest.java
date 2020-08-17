package practice.decorator;


interface Beverage{
	public int cost();
	public void description();
}

class Espresso implements Beverage{
	public int cost(){
		return 1;
	}
	public void description(){
		System.out.println("This beverage is " + this.getClass().getSimpleName());
	}
}

class Tea implements Beverage{
	public int cost() {
		return 5;
	}
	
	public void description(){
		System.out.println("This beverage is " + this.getClass().getSimpleName());
	}

}

abstract class ToppingDecorator implements Beverage{
	Beverage beverage;
	public abstract int cost();
	
	public void description() {
		beverage.description();
		System.out.println("With topping " + this.getClass().getSimpleName());
	}
}

class Caramel extends ToppingDecorator{
	public Caramel(Beverage b) {
		beverage = b;
	}
	public int cost() {
		return beverage.cost() + 2;
	}
}

class Elaichi extends ToppingDecorator{
	
	public Elaichi(Beverage b) {
		beverage = b;
	}
	public int cost() {
		return beverage.cost() + 3;
	}
	
}

public class DecoratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beverage b = new Tea();
		System.out.println(b.cost());
		
		// adding elaichi topping
		
		b = new Elaichi(b);
		b.description();
		System.out.println(b.cost());

		
		b = new Caramel(b);
		b.description();
		System.out.println(b.cost());
	}

}

/*
// OUTPUT 
5
This beverage is Tea
With topping Elaichi
8
This beverage is Tea
With topping Elaichi
With topping Caramel
10*/

