
package test;
import entites.Branche;
import entites.Stage;
import services.StageService;
import java.sql.Date;
import java.sql.SQLException;



public class TacheStage {

    
    public static void main(String[] args) throws SQLException {
        Stage stage=new Stage(10,5884,"bon ","bonjourrrrrr",Branche.Business);
        StageService stageService=new StageService();
        
        /*ajouter stage*/
     stageService.ajouterStage(stage);
      
      
      /*modifier stage*/
     // stageService.modifierStage(stage);
     
     
     /*supprimer stage*/
     //stageService.supprimerStage(stage);
     
     
     /*lecture de la liste des stages*/
       //stageService.readAllS();
       
       
        /*trier la liste des stages par date de creation descendante*/
      //stageService.TrierParDateCreation();
      
       /*trier la liste des stages par id_utilisateur ascendante*/
      //stageService.TrierParUsers();
      
      /*trouver un sujet par un id_utilisateur*/
       //stageService.FindStageByUser(7);
      
       /*trouver un sujet par une branche*/
     //stageService.FindStageByBranche("jj");
       
    }
    
}