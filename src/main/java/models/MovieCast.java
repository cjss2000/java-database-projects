package models;

public class MovieCast {

    private String role;

    private String getRole(){
        return this.role;
    }

    private void setRole(String role){
        this.role = role;
    }
   public MovieCast(String role){
        this.role = role;
    }

    @Override
    public String toString(){
        return "Role: " + getRole();
    }

}
