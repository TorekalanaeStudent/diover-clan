package parent_class;

public class Person_DeJuras{
	
	//attributes:
	protected String name;
	protected String occupation;
	protected int age;

	//default constructor
	public Person_DeJuras() {
		name = "Willj";
		occupation = "Student";
		age = 67;
	}
	
	//constructor//
	
	public Person_DeJuras(String name, String occupation, int age) {
		this.name = name;
		this.occupation = occupation;
		this.age = age;
	}

	//getters
	public String getName(){
		return name;
	}
	public String getOcc(){
		return occupation;
	}
	public int getAge(){
		return age;
	}

	//setters
	public void setName(String name){
		this.name = name;
	}
	public void setOcc(String occupation){
		this.occupation = occupation;
	}
	public void setAge(int age){
		this.age = age;
	}

	//behavior methods
	public void role(){ 
		System.out.println( name + " is " + age + " and he is a " + occupation + ".");
	}
	public void task(){ // can be overriden
		System.out.println(name + " is Studying.");
	}
	public void validID(){
		System.out.println("================================");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Occupation: " + occupation);
		System.out.println("================================");
	}
}
