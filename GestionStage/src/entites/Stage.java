
package entites;




public class Stage {

  //les attributs
    private int id_stage;
    private int id_user;
    private String sujet;
    private String description;
    private Branche branche;
    private String date_creation;

    
    //1er constructeur
    public Stage() {
    }
     
    //2eme constructeur

    public Stage(int id_stage, String sujet, String description, Branche branche) {
        this.id_stage = id_stage;
        this.sujet = sujet;
        this.description = description;
        this.branche = branche;
    }

    public Stage(int id_stage) {
        this.id_stage = id_stage;
    }
    
    //3eme constructeur

    public Stage(int id_stage, int id_user) {
        this.id_stage = id_stage;
        this.id_user = id_user;
    }
    
    //4eme constructeur 

    public Stage(int id_stage, int id_user, String sujet, String description) {
        this.id_stage = id_stage;
        this.id_user = id_user;
        this.sujet = sujet;
        this.description = description;
    }
    
     //5eme constructeur 

    public Stage(int id_stage, int id_user, String sujet, String description, Branche branche) {
        this.id_stage = id_stage;
        this.id_user = id_user;
        this.sujet = sujet;
        this.description = description;
        this.branche = branche;
    }
    
     
    
     
     //les getters 
    public int getId_stage() {
        return id_stage;
    }

    public String getSujet() {
        return sujet;
    }

     public String getDate_creation() {
        return date_creation;
    }
     public int getId_user() {
        return id_user;
    }

    public Branche getBranche() {
        return branche;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
    //les setters 
    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public void setId_stage(int id_stage) {
        this.id_stage = id_stage;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setBranche(Branche branche) {
        this.branche = branche;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    
      //la methode toString 

    @Override
    public String toString() {
        return "Stage{" + "id_stage=" + id_stage + ", id_user=" + id_user + 
               ", sujet=" + sujet + ", description=" + description 
                + ", branche=" + branche + ", date_creation=" + date_creation + '}';
    }
    
    
      
  
}

