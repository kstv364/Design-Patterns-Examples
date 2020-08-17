package practice.adapter;


interface Target{
	public void request();
}

class Adapter implements Target{
	private Adaptee adaptee;
	
	public Adapter(Adaptee a) {
		adaptee = a;
	}
	public void request(){
		adaptee.order();
	}
	
	void other(){
		System.out.println("Other called");
	}
}


class Adaptee{
	public void order(){
		System.out.println("Order Called");
	}
}

class Client{
	void run(Target t){
		t.request();
	}
}


public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c = new Client();
		Adaptee adaptee = new Adaptee();
		Target adapter = new Adapter(adaptee);
		
		//Client class uses objects with contract Target
		// c.run(adaptee); gives error since adaptee violates contract Target
		
		c.run(adapter); // works
	}

}
