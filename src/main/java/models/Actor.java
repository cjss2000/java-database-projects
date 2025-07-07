package models;

public class Actor {

    private int actorId;
    private String actorName;
    private String actorGender;
    private int actorBirthYear;

    public Actor(int actorId, String actorName, String actorGender, int actorBirthYear){
        this.actorId = actorId;
        this.actorName = actorName;
        this.actorGender = actorGender;
        this.actorBirthYear = actorBirthYear;
    }


    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorGender() {
        return actorGender;
    }

    public void setActorGender(String actorGender) {
        this.actorGender = actorGender;
    }

    public int getActorBirthYear() {
        return actorBirthYear;
    }

    public void setActorBirthYear(int actorBirthYear) {
        this.actorBirthYear = actorBirthYear;
    }

   @Override
    public String toString(){
        return "Actor Id:" + getActorId() + "actor's name: " + getActorName() + "actors gendor: " + getActorGender() + "Actors YOB" + getActorBirthYear();
   }





}
