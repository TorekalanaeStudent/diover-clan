package component_class;

public class Sweat_DeJuras{

// attributes

    private String smell;
    private String bodyPart;
    private boolean isSweating;

// default constructor
public Sweat_DeJuras(){
    smell = "Odorless";
    bodyPart = "Head";
    isSweating = true ;
}

// parameterized constructor
    public Sweat_DeJuras(String smell, String bodyPart, boolean isSweating){
        this.smell = smell;
        this.bodyPart = bodyPart;
        this.isSweating = isSweating;

    }

// setters

    public void setSmell(String smell){
        this.smell = smell;
    }

    public void setBody(String bodyPart){
        this.bodyPart = bodyPart;
    }

    public void setSweating(boolean isSweating){
        this.isSweating = isSweating;
    }

// getters

    public String getSmell(){
        return smell;
    }

    public String getBody(){
        return bodyPart;
    }

    public boolean getSweating(){
        return isSweating;
    }

//behaviors

public void sweating(){
    if (isSweating == true){
        System.out.println("You are sweating from the " + bodyPart + ".");
    }else
        System.out.println("You are not sweating.");
}

public void smells(){ // can be overridden
    if (smell == null){
        System.out.println("Invalid Smell");
    }else
        System.out.println("You smell " + smell + " today!");
    }
}