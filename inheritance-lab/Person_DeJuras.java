package parent_class;

public class Person{
	
	//attributes:
	String name;
	String occupation;
	int age;
	
	//constructor
	
	public Person() {
		name = "Willj";
		occupation = "Student";
		age = 0;
	}
	
	//behavior methods
	public void role(){
		System.out.println( name + " is " + age + "and he is a " + occupation);
	}
	public void task(){ // can be overriden
		System.out.println(name + " is Studying.");
	}
}