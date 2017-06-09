
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainVue extends Application {
	public static CSVDecoder CSVCac;
	public static CSVDecoder CSVArm;
	public static CSVDecoder CSVObj;
	public static File cac;
	public static File arm;
	public static File obj;
	static int debug=0;
	static Personnage Perso = new Personnage();
	static int persoS=0;
	static Label listcac=new Label("");
	static Label listarm=new Label("");
	static Label listo=new Label("");
	static Label viep=new Label("Vie Perso");
    static Label viem=new Label("Vie Poutch");
    static int idx=0;
    static int idx1=0;
    static 	Label l7=new Label();
    static Personnage monstre1=new Personnage();

	static int debug2=0;
	public void start(Stage stage) {
		final AnchorPane anchorPane = new AnchorPane(); 
    	anchorPane.setPrefSize(1050, 623);
    	
    	 final URL resource = getClass().getResource("./epicmusic.mp3");
    	 final Media media = new Media(resource.toString());
    	 final MediaPlayer mediaPlayer = new MediaPlayer(media);
    	 mediaPlayer.play();
        
        //AnchorPane.setTopAnchor(button, 10.0); 
        //AnchorPane.setLeftAnchor(button, 30.0); 
        //AnchorPane.setRightAnchor(button, 65.0); 
        //AnchorPane.setLeftAnchor(region, 10.0); 
        //AnchorPane.setBottomAnchor(region, 10.0); 
        
       // region.setStyle("-fx-background-color: gold; -fx-border-color: goldenrod;
        anchorPane.setStyle("-fx-background-image: url('./fond.png');-fx-background-position: center center; -fx-background-repeat: stretch;");
       
        ArrayList<Cac> listCAC = new ArrayList();
		ArrayList<Armure> listARMURE = new ArrayList();
		ArrayList<Objet> listObjet = new ArrayList();
        Image fond = new Image(Main.class.getResourceAsStream("./fond.png"));
        ImageView imvFond = new ImageView(fond);
        
        Image fond1 = new Image(Main.class.getResourceAsStream("./fond1.png"));
        ImageView imvFond1 = new ImageView(fond1);
        Image fond2 = new Image(Main.class.getResourceAsStream("./fond2.png"));
        ImageView imvFond2 = new ImageView(fond2);
        
        Image parchemin = new Image(Main.class.getResourceAsStream("./parchemin.png"));
        ImageView imvParchemin = new ImageView(parchemin);
        imvParchemin.setFitHeight(600);
        imvParchemin.setFitWidth(500);
        imvParchemin.setPreserveRatio(true);
        
        Image imageJouer = new Image(Main.class.getResourceAsStream("./jouer.png"));
        ImageView imvJouer = new ImageView(imageJouer);
        imvJouer.setFitHeight(200);
        imvJouer.setFitWidth(175);
        imvJouer.setPreserveRatio(true);
        imvJouer.setLayoutX(450);
        imvJouer.setLayoutY(200);
        
        Image imageCampagne = new Image("./campagne.png", 200, 40, false, false);
        ImageView imvCampagne = new ImageView(imageCampagne);
        Image image1vs1 = new Image("./1vs1.png", 200, 40, false, false);
        ImageView imv1vs1 = new ImageView(image1vs1);
        Image imagePoutch = new Image("./poutch.png", 200, 40, false, false);
        ImageView imvPoutch = new ImageView(imagePoutch);
        Image imagePunching = new Image("./punching.png", 145, 500, false, false);
        ImageView imvPunching = new ImageView(imagePunching);
        Image image1vs1Epee = new Image("./1vs1epees.png", 200, 200, false, false);
        ImageView imvEpee = new ImageView(image1vs1Epee);
        Image imageCarte = new Image("./carte.jpg", 200, 200, false, false);
        ImageView imvCarte = new ImageView(imageCarte);
        
        Image imageGuerrier = new Image("./guerrier.png", 200, 40, false, false);
        ImageView imvGuerrier = new ImageView(imageGuerrier);
        Image imageMage = new Image("./mage.png", 200, 40, false, false);
        ImageView imvMage = new ImageView(imageMage);
        Image imageArcher = new Image("./archer.png", 200, 40, false, false);
        ImageView imvArcher = new ImageView(imageArcher);
        Image imagePersoGuerrier = new Image("./guerrierPerso.png", 147, 174, false, false);
        ImageView imvPersoGuerrier = new ImageView(imagePersoGuerrier);
        Image imagePersoMage = new Image("./magePerso.png", 153, 186, false, false);
        ImageView imvPersoMage = new ImageView(imagePersoMage);
        Image imagePersoArcher = new Image("./archerPerso.png", 169, 197, false, false);
        ImageView imvPersoArcher = new ImageView(imagePersoArcher);
        
        Image imagePlaque = new Image("./plaque.png", 1070, 190, false, false);
        ImageView imvPlaque1 = new ImageView(imagePlaque);
        ImageView imvPlaque2 = new ImageView(imagePlaque);
        
        
        Image imageFombasiette = new Image("./fombassiette.png", 370, 355, false, false);
        ImageView imvFombasiette = new ImageView(imageFombasiette);
 
        Image imageGobtout = new Image("./gobtout.png", 370, 355, false, false);
        ImageView imvGobtout = new ImageView(imageGobtout);

        Image imageGobelindisquette = new Image("./gobelindisquette.png", 374, 368, false, false);
        ImageView imvGobelindisquette = new ImageView(imageGobelindisquette);

        
        
        Image imageRegles = new Image(Main.class.getResourceAsStream("./regles.png"));
        ImageView imvRegles = new ImageView(imageRegles);
        imvRegles.setFitHeight(200);
        imvRegles.setFitWidth(175);
        imvRegles.setPreserveRatio(true);
        imvRegles.setLayoutX(450);
        imvRegles.setLayoutY(300);
        
        Image imageFleche = new Image("./fleche.png", 20, 20, false, false);
        ImageView imvFleche1 = new ImageView(imageFleche);
        ImageView imvFleche2 = new ImageView(imageFleche);
        ImageView imvFleche3 = new ImageView(imageFleche);
        ImageView imvFleche4 = new ImageView(imageFleche);
        ImageView imvFleche5 = new ImageView(imageFleche);
        
        Image imagePrecedent = new Image("./precedent.png", 100, 100, false, false);
        ImageView imagePrecedent1 = new ImageView(imagePrecedent);
        ImageView imagePrecedent2 = new ImageView(imagePrecedent);
        ImageView imagePrecedent3 = new ImageView(imagePrecedent);
     
        Image imageCredits = new Image(Main.class.getResourceAsStream("./credits.png"));
        ImageView imvCredits = new ImageView(imageCredits);
        imvCredits.setFitHeight(200);
        imvCredits.setFitWidth(175);
        imvCredits.setPreserveRatio(true);
        imvCredits.setLayoutX(450);
        imvCredits.setLayoutY(400);
        
        
        //-------------------------------Controlleurs---------------------------------------
        imvJouer.setOnMouseClicked((MouseEvent event) -> {// jouer menu principale
            System.out.println("Jouer !");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            imagePrecedent1.setLayoutX(900);
            imagePrecedent1.setLayoutY(470);
            imvCampagne.setLayoutX(50);
            imvCampagne.setLayoutY(500);
            imv1vs1.setLayoutX(350);
            imv1vs1.setLayoutY(500);
            imvPoutch.setLayoutX(650);
            imvPoutch.setLayoutY(500);
            imvPunching.setLayoutX(675);
            imvPunching.setLayoutY(0);
            imvEpee.setLayoutX(350);
            imvEpee.setLayoutY(200);
            imvCarte.setLayoutX(50);
            imvCarte.setLayoutY(200);
            
            anchorPane.getChildren().setAll(imvFond1,imagePrecedent1,imvCampagne,imv1vs1,imvPoutch,imvPunching,imvEpee,imvCarte);
            
        });
        
        imvCampagne.setOnMouseClicked((MouseEvent event) -> {
        	launchStuff(listCAC,listARMURE,listObjet,monstre1, stage);// dans menu jouer
        	campagne(listCAC, listARMURE, listObjet, stage);
        	debug=2;
        	/*
        	imvFond2.setLayoutX(0);
            imvFond2.setLayoutY(0);
            imagePrecedent3.setLayoutX(900);
            imagePrecedent3.setLayoutY(470);
            imvGuerrier.setLayoutX(50);
            imvGuerrier.setLayoutY(500);
            imvMage.setLayoutX(350);
            imvMage.setLayoutY(500);
            imvArcher.setLayoutX(650);
            imvArcher.setLayoutY(500);
            imvPersoArcher.setLayoutX(660);
            imvPersoArcher.setLayoutY(300);
            imvPersoMage.setLayoutX(350);
            imvPersoMage.setLayoutY(300);
            imvPersoGuerrier.setLayoutX(80);
            imvPersoGuerrier.setLayoutY(300);
            debug=2;
            int rdm = (int) (1 + Math.random() * (4 - 1 + 1));
    		
    		switch(rdm){
    			case 1 :
    				monstre1 = new GobelinDisquetteur();
    				System.out.println("\n Attention un Gobelin Disquetteur apparaît !!");
    				
    				break;
    			case 2 : 
    				monstre1 = new GobTout();
    				System.out.println("\n Attention un Gob'Tout apparaît !!");
    				break;
    			case 3 : 
    				monstre1 = new GobalElite();
    				System.out.println("\n Attention un Gobal Elite apparaît !!");
    				break;
    			case 4 : 
    				monstre1 = new PunchlinoGob();
    				System.out.println("\n Attention un Punchlino Gob apparaît !!");
    				break;
    		}
			launchStuff(listCAC,listARMURE,listObjet,monstre1, stage);
			
            anchorPane.getChildren().setAll(imvFond2,imagePrecedent3,imvPersoArcher,imvPersoMage,imvPersoGuerrier,imvGuerrier,imvMage,imvArcher);
            */
        });
        
        imv1vs1.setOnMouseClicked((MouseEvent event) -> {// dans menu jouer.
            System.out.println("1vs1 !");
        });
          

        imvPoutch.setOnMouseClicked((MouseEvent event) -> {// lancement poutch
            System.out.println("Poutch !");
            imvFond2.setLayoutX(0);
            imvFond2.setLayoutY(0);
            imagePrecedent3.setLayoutX(900);
            imagePrecedent3.setLayoutY(470);
            imvGuerrier.setLayoutX(50);
            imvGuerrier.setLayoutY(500);
            imvMage.setLayoutX(350);
            imvMage.setLayoutY(500);
            imvArcher.setLayoutX(650);
            imvArcher.setLayoutY(500);
            imvPersoArcher.setLayoutX(660);
            imvPersoArcher.setLayoutY(300);
            imvPersoMage.setLayoutX(350);
            imvPersoMage.setLayoutY(300);
            imvPersoGuerrier.setLayoutX(80);
            imvPersoGuerrier.setLayoutY(300);
            
			launchStuff(listCAC,listARMURE,listObjet,monstre1, stage);
			
            anchorPane.getChildren().setAll(imvFond2,imagePrecedent3,imvPersoArcher,imvPersoMage,imvPersoGuerrier,imvGuerrier,imvMage,imvArcher);
            
        });
        
        imvArcher.setOnMouseClicked((MouseEvent event) -> {
        	
        	
        	Perso = new Archer();
        	Sort g1 = new Vampiro();
			Sort g2 = new DernierCoup();
			Sort g3 = new Parade();
			Perso.addSort(g1);
			Perso.addSort(g2);
			Perso.addSort(g3);
			Perso.setNom("Aventurier");

			
            launchMagasin(listCAC, listARMURE, listObjet,Perso, monstre1, stage, 2);
            System.out.println("Combat !");
          
            
            
            
            
        });
        imvMage.setOnMouseClicked((MouseEvent event) -> {
        	
        	
        	Perso = new Mage();
        	Sort g1 = new Vampiro();
			Sort g2 = new DernierCoup();
			Sort g3 = new Parade();
			Perso.addSort(g1);
			Perso.addSort(g2);
			Perso.addSort(g3);
			Perso.setNom("Aventurier");

			
            launchMagasin(listCAC, listARMURE, listObjet,Perso, monstre1, stage, 2);
            System.out.println("Combat !");
           
            
            
             });
        imvGuerrier.setOnMouseClicked((MouseEvent event) -> {
        	Perso = new Guerrier();
			Sort g1 = new Vampiro();
			Sort g2 = new DernierCoup();
			Sort g3 = new Parade();
			Perso.addSort(g1);
			Perso.addSort(g2);
			Perso.addSort(g3);
			Perso.setNom("Aventurier");
			
            System.out.println("Combat !");

            launchMagasin(listCAC, listARMURE, listObjet,Perso, monstre1, stage, 1);
            
        });
        imvRegles.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("Regles !");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            
            Label label=new Label("R�gles");
            label.setFont(new Font("Arial", 30));
            label.setLayoutX(500);
            label.setLayoutY(120);
            
            GridPane gridpane = new GridPane();
            Label label1=new Label("1. Le choix des classes.");
            label1.setFont(new Font("Arial", 20));
            gridpane.add(label1, 1, 1);
            gridpane.add(imvFleche1, 3, 1);
            Label label2=new Label("2. Comment fonctionne l'�choppe ?");
            label2.setFont(new Font("Arial", 20));
            gridpane.add(label2, 1, 2);
            gridpane.add(imvFleche2, 3, 2); 
            Label label3=new Label("3. Le syst�me de combat.");
            label3.setFont(new Font("Arial", 20));
            gridpane.add(label3, 1, 3);
            gridpane.add(imvFleche3, 3, 3);
            Label label4=new Label("4. Quels sont les sorts ?");
            label4.setFont(new Font("Arial", 20));
            gridpane.add(label4, 1, 4);
            gridpane.add(imvFleche4, 3, 4);
            Label label5=new Label("5. Informations sur le mode solo.");
            label5.setFont(new Font("Arial", 20));
            gridpane.add(label5, 1, 5);
            gridpane.add(imvFleche5, 3, 5); 
           
            
            imvParchemin.setLayoutX(300);
            imvParchemin.setLayoutY(10);
            gridpane.setLayoutX(350);
            gridpane.setLayoutY(150);
            gridpane.setHgap(15);
            gridpane.setVgap(30);
            imagePrecedent1.setLayoutX(900);
            imagePrecedent1.setLayoutY(470);
            
            anchorPane.getChildren().setAll(imvFond1,imvParchemin,gridpane,label,imagePrecedent1);
            
            
        });
        
        imvCredits.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("Credits !");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            imvParchemin.setLayoutX(300);
            imvParchemin.setLayoutY(10);
            imagePrecedent1.setLayoutX(900);
            imagePrecedent1.setLayoutY(470);
            
            Label label=new Label("\nLeicht Th�o\nBaillet Thomas\nDos Santos Oliveira Stephane\nKarboubi Ahmed\nSkywand Dylan\nRichard Rouckmoutte\n\nProjet agile Nerd's Battle\nDUT Informatique IUT A Lille 1\nPromotion d�cal� 2016/2017");
            label.setFont(new Font("Arial", 24));
            label.setLayoutX(385);
            label.setLayoutY(120);
            
            anchorPane.getChildren().setAll(imvFond1,imvParchemin,label,imagePrecedent1);
        });
        
       
        
        imvFleche1.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("1. Le choix des classes.");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            imvParchemin.setLayoutX(300);
            imvParchemin.setLayoutY(10);
            
            Label label=new Label("Le choix de sa classe :\n\nChaque joueur choisit son combattant, guerrier\n (fort en attaque physique), mage (fort en\n attaque sp�) ou archer (attaque physique\n moyenne dot�e d�une bonne esquive et d�une\n grande vitesse).\n\n");
            label.setFont(new Font("Arial", 15));
            label.setLayoutX(375);
            label.setLayoutY(120);
            
            imagePrecedent2.setLayoutX(900);
            imagePrecedent2.setLayoutY(470);
            
            anchorPane.getChildren().setAll(imvFond1,imvParchemin,label,imagePrecedent2);
        });
        
        imvFleche2.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("2. Comment fonctionne l'�choppe ?");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            imvParchemin.setLayoutX(300);
            imvParchemin.setLayoutY(10);
            
            Label label=new Label("L��choppe :\n\nUne fois votre personnage choisi vous aurez \nle choix de passer � l��choppe pour acheter \ndes �quipements et des consommables qui modifieront\n vos caract�ristiques.\nEn mode PVP, chaque joueur se verra attribu� \nune somme fixe de 5000 pi�ces d�or pour s��quiper.\nEn mode PVE, le joueur devra gagner ses\npi�ces d�or lui m�me en progressant � travers \nle monde de GitTeub et en tuant des ennemis.\n\n");
			label.setFont(new Font("Arial", 15));
            label.setLayoutX(365);
            label.setLayoutY(120);
            
            imagePrecedent2.setLayoutX(900);
            imagePrecedent2.setLayoutY(470);
            
            anchorPane.getChildren().setAll(imvFond1,imvParchemin,label,imagePrecedent2);
        });
        
        imvFleche3.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("3. Le syst�me de combat.");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            imvParchemin.setLayoutX(300);
            imvParchemin.setLayoutY(10);
            
            Label label=new Label("Les combats :\n\nUne fois votre classe choisie et votre �quipement\n achet� le combat commence. Vous aurez � \nchaque tour le choix entre 5 Actions parmi \nlesquels on retrouve une attaque au corps � \ncorps, 3 sorts de classe dont 1 sort ultime \nainsi que la possibilit� d�utiliser un consommable\nsur soi ou sur l�adversaire.\nLe combat est termin� quand les points de \nvie de votre personnage ou ceux de l�adversaire \ntombent � z�ro.\n\n");
			label.setFont(new Font("Arial", 15));
            label.setLayoutX(375);
            label.setLayoutY(120);
            
            imagePrecedent2.setLayoutX(900);
            imagePrecedent2.setLayoutY(470);
            
            anchorPane.getChildren().setAll(imvFond1,imvParchemin,label,imagePrecedent2);
        });
        
        imvFleche4.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("4. Quels sont les sorts ?");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            imvParchemin.setLayoutX(300);
            imvParchemin.setLayoutY(10);
            
            Label label=new Label("Les sorts de classe :\n\nGuerrier :\nSort 1: Vampiro -> Vol X% de vie en fonction des d�g�ts inflig�s\n� l�adversaire.\nSort 2: FINISH HIM -> Si l�ennemi � moins de 20% de ses points \nde vie maximum vous avez 50% de chance le tuer en un coup.\nSort Ultime: Bouclier de feu -> Pare la prochaine attaque.\n\nMage :\nSort 1: Heal -> R�g�n�re un % de PV en fonction des PV max.\nSort 2: Nuage l�tal -> Inflige X d�g�ts � l�adversaire pendant X tours.\nSort Ultime : Foudrix -> �tourdit l�ennemi pendant 3 tours, \nl'emp�chant alors d�effectuer des actions.\n\nArcher :\nSort1 : Multi-shot -> Tire X fl�ches.\nSort 2: Fl�che empoisonn�e -> Inflige X d�g�ts par tour pendant \nX tours et emp�che l�utilisation des soins.\nSort Ultime: Doge -> Augmente l�esquive de 30 de fa�on \npermanente.\n\nA noter que les sorts Ultimes ne sont utilisables qu'une seule \nfois par combat.\n");
			label.setFont(new Font("Arial", 12));
            label.setLayoutX(375);
            label.setLayoutY(120);
            
            imagePrecedent2.setLayoutX(900);
            imagePrecedent2.setLayoutY(470);
            
            anchorPane.getChildren().setAll(imvFond1,imvParchemin,label,imagePrecedent2);
        });
        
        imvFleche5.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("5. Informations sur le mode solo.");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            imvParchemin.setLayoutX(300);
            imvParchemin.setLayoutY(10);
            
            Label label=new Label("\nMode solo :\n\nDans ce mode vous affronterez des mob jusqu�� \natteindre le boss final.\nA chaque combat remport� vous gagnerez une \nsomme d�argent vous permettant d�am�liorer vos \ncaract�ristiques en achetant des �quipements � \nl��choppe qui sera disponible � chaque d�but \nde combat.\n\nAttention le mode solo est punitif, la moindre mort \nvous fera recommencer de z�ro.\n\n\nBonne chance et amusez vous bien !");
			label.setFont(new Font("Arial", 15));
            label.setLayoutX(375);
            label.setLayoutY(120);
            
            imagePrecedent2.setLayoutX(900);
            imagePrecedent2.setLayoutY(470);
            
            anchorPane.getChildren().setAll(imvFond1,imvParchemin,label,imagePrecedent2);
        });
        
        
        imagePrecedent1.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("Retour vers le menu principal");
            start(stage);
        });
        imagePrecedent2.setOnMouseClicked((MouseEvent event) -> {// menu regles 
            System.out.println("Retour vers le menu principal");
            
            System.out.println("Regles !");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            
            Label label=new Label("R�gles");
            label.setFont(new Font("Arial", 30));
            label.setLayoutX(500);
            label.setLayoutY(120);
            
            GridPane gridpane = new GridPane();
            Label label1=new Label("1. Le choix des classes.");
            label1.setFont(new Font("Arial", 20));
            gridpane.add(label1, 1, 1);
            gridpane.add(imvFleche1, 3, 1);
            Label label2=new Label("2. Comment fonctionne l'�choppe ?");
            label2.setFont(new Font("Arial", 20));
            gridpane.add(label2, 1, 2);
            gridpane.add(imvFleche2, 3, 2); 
            Label label3=new Label("3. Le syst�me de combat.");
            label3.setFont(new Font("Arial", 20));
            gridpane.add(label3, 1, 3);
            gridpane.add(imvFleche3, 3, 3);
            Label label4=new Label("4. Quels sont les sorts ?");
            label4.setFont(new Font("Arial", 20));
            gridpane.add(label4, 1, 4);
            gridpane.add(imvFleche4, 3, 4);
            Label label5=new Label("5. Informations sur le mode solo.");
            label5.setFont(new Font("Arial", 20));
            gridpane.add(label5, 1, 5);
            gridpane.add(imvFleche5, 3, 5); 
           
            
            imvParchemin.setLayoutX(300);
            imvParchemin.setLayoutY(10);
            gridpane.setLayoutX(350);
            gridpane.setLayoutY(150);
            gridpane.setHgap(15);
            gridpane.setVgap(30);
            imagePrecedent1.setLayoutX(900);
            imagePrecedent1.setLayoutY(470);
            
            anchorPane.getChildren().setAll(imvFond1,imvParchemin,gridpane,label,imagePrecedent1);
           
        });
        
        imagePrecedent3.setOnMouseClicked((MouseEvent event) -> {
        	System.out.println("Jouer !");
            imvFond1.setLayoutX(0);
            imvFond1.setLayoutY(0);
            imagePrecedent1.setLayoutX(900);
            imagePrecedent1.setLayoutY(470);
            imvCampagne.setLayoutX(50);
            imvCampagne.setLayoutY(500);
            imv1vs1.setLayoutX(350);
            imv1vs1.setLayoutY(500);
            imvPoutch.setLayoutX(650);
            imvPoutch.setLayoutY(500);
            imvPunching.setLayoutX(675);
            imvPunching.setLayoutY(0);
            imvEpee.setLayoutX(350);
            imvEpee.setLayoutY(200);
            imvCarte.setLayoutX(50);
            imvCarte.setLayoutY(200);
            
            anchorPane.getChildren().setAll(imvFond1,imagePrecedent1,imvCampagne,imv1vs1,imvPoutch,imvPunching,imvEpee,imvCarte);
           
        });
        
        
        anchorPane.getChildren().setAll(imvJouer,imvRegles,imvCredits); 
        final Scene scene = new Scene(anchorPane, 1050, 623); 
        
        stage.setTitle("Menu"); 
        stage.setScene(scene); 
        stage.setResizable(false);
        stage.show(); 
		
		
		
		
		
		
		/*
		MenuBar menuBar = new MenuBar();
		VBox vbox = new VBox();
		TabPane tabPane=new TabPane();
		menuBar.setUseSystemMenuBar(true);
		
		Menu fileMenu = new Menu("Fichier"); 
		MenuItem importcsv = new MenuItem("Importer une serie depuis un csv");
		MenuItem importweb = new MenuItem("Importer depuis un serveur web");
		fileMenu.getItems().addAll(importcsv, importweb);
		Menu editMenu = new Menu("Edition"); 
		
		Menu helpMenu = new Menu("Aide");
		menuBar.getMenus().setAll(helpMenu);
		Button b1v1=new Button("1V1");
		Button b1vIA=new Button("Campagne");
		Button b1vpoutch=new Button("1VPoutch");
		
		vbox.getChildren().addAll(menuBar, tabPane);
		vbox.getChildren().addAll(b1v1, b1vIA,b1vpoutch);
		//Personnage monstre1=new Personnage();
		ArrayList<Cac> listCAC = new ArrayList();
		ArrayList<Armure> listARMURE = new ArrayList();
		ArrayList<Objet> listObjet = new ArrayList();
		
		
		
		Scene scene = new Scene(vbox, 800, 600);
		b1vpoutch.setOnAction((event) -> {
			Personnage monstre1=new Personnage();
			launchStuff(listCAC,listARMURE,listObjet,monstre1, stage);
			launchSelec(listCAC,listARMURE,listObjet,monstre1,stage);
		});
		b1vIA.setOnAction((event) -> {
			campagne(listCAC, listARMURE, listObjet, stage);
		});
		
		
		stage.setScene(scene);
		stage.show();
		*/
		
		
		
		
	}
	public static void comba(ArrayList<Cac> listCAC, ArrayList<Armure> listARMURE, ArrayList<Objet> listObjet, Stage stage,int idx1,int nbc){
			Pane pane=new Pane();
			VBox vbox = new VBox();
			Label lore=new Label("");
			Label Story=new Label("");
			int cpt=0;
			while(cpt!=nbc){
			Personnage monstre1=new Personnage();
			int rdm = (int) (1 + Math.random() * (4 - 1 + 1));
			
			lore.setText("\n COMBAT "+cpt);
			
			switch(rdm){
				case 1 :
					monstre1 = new GobelinDisquetteur();
					Story.setText("\n Attention un Gobelin Disquetteur apparaît !!");
					
					break;
				case 2 : 
					monstre1 = new GobTout();
					Story.setText("\n Attention un Gob'Tout apparaît !!");
					break;
				case 3 : 
					monstre1 = new GobalElite();
					Story.setText("\n Attention un Gobal Elite apparaît !!");
					break;
				case 4 : 
					monstre1 = new PunchlinoGob();
					Story.setText("\n Attention un Punchlino Gob apparaît !!");
					break;
			}
			/*
			cpt++;
			launchStuff(listCAC,listARMURE, listObjet,monstre1,stage);
			launchSelec(listCAC,listARMURE,listObjet,monstre1, stage);
			*/
			}
			vbox.getChildren().addAll(lore,Story);
			pane.getChildren().addAll(vbox);
			
			
			
			
			
			
			Scene scene = new Scene(pane, 800, 600);
			stage.setScene(scene);
			stage.show();
		}
		
		
		
	public static void campagne(ArrayList<Cac> listCAC, ArrayList<Armure> listARMURE, ArrayList<Objet> listObjet, Stage stage){

		debug2=1;
		// monstre a creer
		Pane pane=new Pane();
		VBox vbox = new VBox();
		Label lore=new Label("Bienvenue dans le mode campagne");
		lore.setTextFill(Color.web("#ffffff"));
		Button blore=new Button("suivant");
		final AnchorPane anchorPane = new AnchorPane(); 
		 Image fond2 = new Image(Main.class.getResourceAsStream("./fond.png"));
	        ImageView imvFond2 = new ImageView(fond2);
	        Image imagePrecedent = new Image("./precedent.png", 100, 100, false, false);
	        ImageView imagePrecedent1 = new ImageView(imagePrecedent);
	        ImageView imagePrecedent2 = new ImageView(imagePrecedent);
	        ImageView imagePrecedent3 = new ImageView(imagePrecedent);
	        anchorPane.setStyle("-fx-background-image: url('./fond.png');-fx-background-position: center center; -fx-background-repeat: stretch;");
	        
	        Image imageGuerrier = new Image("./guerrier.png", 200, 40, false, false);
	        ImageView imvGuerrier = new ImageView(imageGuerrier);
	        Image imageMage = new Image("./mage.png", 200, 40, false, false);
	        ImageView imvMage = new ImageView(imageMage);
	        Image imageArcher = new Image("./archer.png", 200, 40, false, false);
	        ImageView imvArcher = new ImageView(imageArcher);
	        Image imagePersoGuerrier = new Image("./guerrierPerso.png", 147, 174, false, false);
	        ImageView imvPersoGuerrier = new ImageView(imagePersoGuerrier);
	        Image imagePersoMage = new Image("./magePerso.png", 153, 186, false, false);
	        ImageView imvPersoMage = new ImageView(imagePersoMage);
	        Image imagePersoArcher = new Image("./archerPerso.png", 169, 197, false, false);
	        ImageView imvPersoArcher = new ImageView(imagePersoArcher);
	  
		int cpt=0;
		if(idx==1){
			lore.setText("Le GitTeub était une contrée paisible depuis des millénaires.Romain \n"
					+ "des doigts le chasseur équipé de son arc était parti chasser de la femelle avec\n"
					+ " ses amis Murator le guerrier armé de sa grosse épée et de Harry Pot-de-Fleur le\n"
					+ " magicien.Une fois arrivé dans la taverne Murator se lâcha sur la piste de danse \n"
					+ "et impressionna les demoiselles. Rouxi, une magnifique gobelin vînt à lui et ils\n"
					+ " partagèrent un verre ensemble.Soudainement, des gobelins du village débarquèrent\n"
					+ " à la recherche de la bande des 3. Ils leurs reprochaient d’avoir séduit Rouxi la\n"
					+ " fille de leur chef Fombassiette 123 qui était promise au prince du royaume du\n"
					+ " Mortdort.Les gobelins se mirent à saccager la taverne et se ruèrent sur Murator et ses amis…");
			
			
			
		}
		imvFond2.setLayoutX(0);
        imvFond2.setLayoutY(0);
        imagePrecedent3.setLayoutX(900);
        imagePrecedent3.setLayoutY(470);
        imvGuerrier.setLayoutX(50);
        imvGuerrier.setLayoutY(500);
        imvMage.setLayoutX(350);
        imvMage.setLayoutY(500);
        imvArcher.setLayoutX(650);
        imvArcher.setLayoutY(500);
        imvPersoArcher.setLayoutX(660);
        imvPersoArcher.setLayoutY(300);
        imvPersoMage.setLayoutX(350);
        imvPersoMage.setLayoutY(300);
        imvPersoGuerrier.setLayoutX(80);
        imvPersoGuerrier.setLayoutY(300);
		
		
		 
        imvArcher.setOnMouseClicked((MouseEvent event) -> {
        	
        	
        	Perso = new Archer();
        	Sort g1 = new Vampiro();
			Sort g2 = new DernierCoup();
			Sort g3 = new Parade();
			Perso.addSort(g1);
			Perso.addSort(g2);
			Perso.addSort(g3);
			Perso.setNom("Aventurier");

			
           
            debug2=3;
            

            campagne1(listCAC, listARMURE, listObjet, stage, debug2);
            
            
            
            
        });
        imvMage.setOnMouseClicked((MouseEvent event) -> {
        	
        	
        	Perso = new Mage();
        	Sort g1 = new Vampiro();
			Sort g2 = new DernierCoup();
			Sort g3 = new Parade();
			Perso.addSort(g1);
			Perso.addSort(g2);
			Perso.addSort(g3);
			Perso.setNom("Aventurier");

			debug2=2;
            

            campagne1(listCAC, listARMURE, listObjet, stage, debug2);
           
            
            
             });
        imvGuerrier.setOnMouseClicked((MouseEvent event) -> {
        	Perso = new Guerrier();
			Sort g1 = new Vampiro();
			Sort g2 = new DernierCoup();
			Sort g3 = new Parade();
			Perso.addSort(g1);
			Perso.addSort(g2);
			Perso.addSort(g3);
			Perso.setNom("Aventurier");
			debug2=1;
            

            campagne1(listCAC, listARMURE, listObjet, stage, debug2);
            
        });
		
		
		
		
		anchorPane.getChildren().setAll(imvFond2,imagePrecedent3,imvPersoArcher,imvPersoMage,imvPersoGuerrier,imvGuerrier,imvMage,imvArcher);
        
	        final Scene scene = new Scene(anchorPane, 1050, 623); 
	        
	        stage.setTitle("Menu"); 
	        stage.setScene(scene); 
	        stage.setResizable(false);
	        stage.show(); 
		

	}
	public static void campagne1(ArrayList<Cac> listCAC, ArrayList<Armure> listARMURE, ArrayList<Objet> listObjet, Stage stage,int choix){
		final AnchorPane anchorPane = new AnchorPane(); 
		 Image fond2 = new Image(Main.class.getResourceAsStream("./fond1.png"));
	        ImageView imvFond2 = new ImageView(fond2);
	        anchorPane.setStyle("-fx-background-image: url('./fond.png');-fx-background-position: center center; -fx-background-repeat: stretch;");
	        imvFond2.setLayoutX(0);
	        imvFond2.setLayoutY(0);
	        Label lore=new Label("Bienvenue dans le mode campagne");
			Button blore=new Button("suivant");
			lore.setTextFill(Color.web("#ffffff"));
			lore.setLayoutX(250);
	        lore.setLayoutY(50);
	        blore.setLayoutX(450);
	        blore.setLayoutY(450);
			int cpt=0;
			if(idx==1){
				lore.setText("Le GitTeub était une contrée paisible depuis des millénaires.Romain \n"
						+ "des doigts le chasseur équipé de son arc était parti chasser de la femelle avec\n"
						+ " ses amis Murator le guerrier armé de sa grosse épée et de Harry Pot-de-Fleur le\n"
						+ " magicien.Une fois arrivé dans la taverne Murator se lâcha sur la piste de danse \n"
						+ "et impressionna les demoiselles. Rouxi, une magnifique gobelin vînt à lui et ils\n"
						+ " partagèrent un verre ensemble.Soudainement, des gobelins du village débarquèrent\n"
						+ " à la recherche de la bande des 3. Ils leurs reprochaient d’avoir séduit Rouxi la\n"
						+ " fille de leur chef Fombassiette 123 qui était promise au prince du royaume du\n"
						+ " Mortdort.Les gobelins se mirent à saccager la taverne et se ruèrent sur Murator et ses amis…");
				
				
				
			}
			blore.setOnAction((event) -> {
				idx++;
				if(idx==2){
					Personnage monstre1=new GobalElite();
					launchMagasin(listCAC, listARMURE, listObjet,Perso, monstre1, stage, choix);
				}else{
					
				
				campagne1(listCAC, listARMURE, listObjet, stage,choix);
				}
			});
			
			
			anchorPane.getChildren().setAll(imvFond2,lore,blore);
	        
	        final Scene scene = new Scene(anchorPane, 1050, 623); 
	        
	        stage.setTitle("Menu"); 
	        stage.setScene(scene); 
	        stage.setResizable(false);
	        stage.show(); 
	}

	public static void launchStuff(ArrayList<Cac> lc,ArrayList<Armure> la,ArrayList<Objet> lo,Personnage monstre1,Stage stage){
		File test= new File("");
		String t=test.getPath();
		cac=new File(test.getAbsolutePath()+"//rsc//Arme-Feuille1.csv");
		arm=new File(test.getAbsolutePath()+"//rsc//Equipement-Feuille1.csv");
		obj=new File(test.getAbsolutePath()+"//rsc//Consommable-Feuille1.csv");
		CSVCac = new CSVDecoder(cac);
		CSVArm = new CSVDecoder(arm);
		CSVObj = new CSVDecoder(obj);
		try {
			lc.addAll(CSVCac.decodeCac());
			la.addAll(CSVArm.decodeArm());
			lo.addAll(CSVObj.decodeObj());
		} catch (IOException e) {
			System.out.println("Erreure fichier CSV");
			e.printStackTrace();
		}		
		//launchSelec(lc,la,lo,monstre1, stage);
	}
	
public static void launchSelec(ArrayList lcac,ArrayList larm,ArrayList<Objet> listObjet, Personnage monstre1,Stage stage){
		
		if (persoS==0){
		Pane pane=new Pane();
		VBox vbox1 = new VBox();	
		VBox vbox2 = new VBox();
		HBox hbox1=new HBox();
		Label l1=new Label("");
		Label type=new Label("");
		ChoiceBox<String> cb = new ChoiceBox<String>(FXCollections.observableArrayList("Guerrier", "Mage", "Archer"));
		Button valider=new Button("VALIDER");
		cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
	        public void changed(ObservableValue<? extends String> observable,
	                            String oldValue, String newValue) {
	            System.out.println("Value is: "+newValue);
	            if(newValue.equals("Guerrier")){
	            	l1.setText("VOICIE UN GUERRIER");
	            	type.setText("Guerrier");
	            }
	            if(newValue.equals("Mage")){
	            	l1.setText("VOICIE UN Mage");
	            	type.setText("Mage");
	            }
	            if(newValue.equals("Archer")){
	            	l1.setText("VOICIE UN Archer");
	            	type.setText("Archer");
	            }
	        }
	    });
		valider.setOnAction((event) -> {
			if(type.getText().equals("Guerrier")){
				Perso = new Guerrier();
				Sort g1 = new Vampiro();
				Sort g2 = new DernierCoup();
				Sort g3 = new Parade();
				Perso.addSort(g1);
				Perso.addSort(g2);
				Perso.addSort(g3);
				Perso.setNom("Aventurier");
				System.out.println("Guerrier choisi.");
			}else if(type.getText().equals("Mage")){
				System.out.println("Mage choisi.");
				Perso = new Mage();
				Perso.setNom("Aventurier");
			}else if(type.getText().equals("Mage")){
				System.out.println("Archer choisi.");
				Perso = new Archer();
				Perso.setNom("Aventurier");
			}
			else{
				l1.setText("Choissez un personnage");
			}
			System.out.println(Perso.toString());
			persoS=1;
				//launchMagasin(lcac,larm,listObjet,Perso,monstre1, stage);
		
			
			
		});
		vbox1.getChildren().addAll(cb,l1,valider);
		hbox1.getChildren().addAll(vbox1, vbox2);
		pane.getChildren().addAll(hbox1);
		
		Scene scene = new Scene(pane, 800, 600);
		stage.setScene(scene);
		stage.show();
		}else{
			//launchMagasin(lcac,larm,listObjet,Perso,monstre1, stage);
		}

		
		
		}


private static void launchMagasin(ArrayList lcac,ArrayList larm,ArrayList<Objet> listObjet ,Personnage perso,Personnage monstre,Stage stage,int test) {
	
	Pane pane=new Pane();
	VBox vbox1 = new VBox();	
	VBox vbox2 = new VBox();
	HBox hbox1=new HBox();
	Label l1=new Label("Vous avez "+ Perso.getGold()+" golds");
	Label type=new Label("");
	
	
	final AnchorPane anchorPane = new AnchorPane(); 
	 Image fond3 = new Image(Main.class.getResourceAsStream("./taverne1.png"));
      ImageView imvFond3 = new ImageView(fond3);
      
      
      Image imagebtnEpee = new Image("./cac.png", 250, 175, false, false);
      ImageView imvbtnEpe = new ImageView(imagebtnEpee);
      Image imagebtnPotions = new Image("./consommables.png", 250, 175, false, false);
      ImageView imvbtnPotions = new ImageView(imagebtnPotions);
      Image imagebtnArmure = new Image("./armures.png", 250, 175, false, false);
      ImageView imvbtnArmures = new ImageView(imagebtnArmure);   
      
      
      imvFond3.setLayoutX(0);
      imvFond3.setLayoutY(0);
      
  
      
      imvbtnEpe.setLayoutX(700);
      imvbtnEpe.setLayoutY(150);
      imvbtnPotions.setLayoutX(400);
      imvbtnPotions.setLayoutY(150);
      imvbtnArmures.setLayoutX(100);
      imvbtnArmures.setLayoutY(150);
      
      
	ObservableList<String>  data = FXCollections.observableArrayList();
	Label inv=new Label("Voicie Votre Inventaire:");
	ComboBox<String> combo;
	ChoiceBox<String> cb = new ChoiceBox<String>(FXCollections.observableArrayList("CaC", "Armure", "Objets"));
	ChoiceBox<String> cb1 =new ChoiceBox<String>(FXCollections.observableArrayList());
	Button valider=new Button("VALIDER");
	Button go=new Button("PARTIR A L'AVENTURE");
	cb1.setLayoutX(350);
	cb1.setLayoutY(350);
	valider.setLayoutX(200);
	valider.setLayoutY(450);
	go.setLayoutX(650);
	go.setLayoutY(450);
	imvbtnEpe.setOnMouseClicked((MouseEvent event) -> {
		cb1.getItems().clear();
		type.setText("cac");
		System.out.println("test");
		for(int o=0;o<lcac.size();o++){
    		cb1.getItems().add(lcac.get(o).toString());
    		
    	}
    });
	imvbtnPotions.setOnMouseClicked((MouseEvent event) -> {
		cb1.getItems().clear();
		type.setText("Objets");
		for(int o=0;o<listObjet.size();o++){
    		cb1.getItems().add(listObjet.get(o).toString());
    	}
    });
	imvbtnArmures.setOnMouseClicked((MouseEvent event) -> {
		cb1.getItems().clear();
		type.setText("Armure");
		for(int o=0;o<larm.size();o++){
    		cb1.getItems().add(larm.get(o).toString());
    	}
    });
	
	
	
	
	
	cb.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        public void changed(ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
            System.out.println("Value is: "+newValue);
            
            cb1.getItems().clear();
            if(newValue.equals("CaC")){
            	type.setText("cac");
            	for(int o=0;o<lcac.size();o++){
            		cb1.getItems().add(lcac.get(o).toString());
            		
            	}
            }
            if(newValue.equals("Armure")){
            	type.setText("Armure");
            	for(int o=0;o<larm.size();o++){
            		cb1.getItems().add(larm.get(o).toString());
            	}
            }
            if(newValue.equals("Objets")){
            	type.setText("Objets");
            	for(int o=0;o<listObjet.size();o++){
            		cb1.getItems().add(listObjet.get(o).toString());
            	}
            }
        }
    });
	valider.setOnAction((event) -> {
		if(type.getText().equals("cac")){
			Perso.setCac((Cac) lcac.get(cb1.getSelectionModel().getSelectedIndex()));
			Perso.setGold(Perso.getGold()-Perso.getCac().getPrix());
			System.out.println("Vous avez choisi "+Perso.getCac().getNom());
			
			listcac.setText(lcac.get(cb1.getSelectionModel().getSelectedIndex()).toString());
			launchMagasin(lcac,larm,listObjet,Perso,monstre, stage,test);
		}
		else if(type.getText().equals("Armure")){
			Perso.setArmure((Armure)larm.get(cb1.getSelectionModel().getSelectedIndex()));
			Perso.setGold(Perso.getGold()-Perso.getArmure().getPrix());
			System.out.println("Vous avez choisi "+Perso.getArmure().getNom());
			listarm.setText(larm.get(cb1.getSelectionModel().getSelectedIndex()).toString());
			launchMagasin(lcac,larm,listObjet,Perso,monstre, stage,test);
		}
		else if(type.getText().equals("Objets")){
			Perso.setObjet((Objet) listObjet.get(cb1.getSelectionModel().getSelectedIndex()));
			Perso.setGold(Perso.getGold()-Perso.getObjet().getPrix());
			System.out.println("Vous avez choisi "+Perso.getObjet().getNom());
			listo.setText(listObjet.get(cb1.getSelectionModel().getSelectedIndex()).toString());
			launchMagasin(lcac,larm,listObjet,Perso,monstre, stage,test);
		}
		else{
			System.out.println("Choisissez une option disponible.");
		}
		
	});
	go.setOnAction((event) -> {
		if(debug==0){
		Poutch poutch=new Poutch();
			test(lcac,Perso, stage,0, poutch,test);
		//launch1vPoutch(lcac,Perso, stage);
		}else{
			
			testIA(lcac,Perso, stage,0, monstre,test);
		}
		
	});
	
	anchorPane.getChildren().setAll(imvFond3,imvbtnEpe,imvbtnPotions,imvbtnArmures,go,valider,cb1);
	 final Scene scene = new Scene(anchorPane, 1050, 623); 
     
     stage.setTitle("Menu"); 
     stage.setScene(scene); 
     stage.setResizable(false);
     stage.show(); 
	
	
}
public static void testIA(ArrayList lcac,Personnage perso,Stage stage,int tour,Personnage poutch,int test){
	Pane pane=new Pane();
	VBox vbox1 = new VBox();
	Label story=new Label();
	Label log=new Label();
	Label l1=new Label();

	Label l3=new Label();
	Label l4=new Label();
	Label l5=new Label();
	Label l6=new Label();

	Label l8=new Label();
	Button valider=new Button("valider");
	
	double degats;
	final AnchorPane anchorPane = new AnchorPane(); 
	
	Image fond1 = new Image(Main.class.getResourceAsStream("./fond1.png"));
    ImageView imvFond1 = new ImageView(fond1);
	story.setLayoutX(10);
	story.setLayoutY(450);
	log.setLayoutX(10);
	log.setLayoutY(465);
	l1.setLayoutX(10);
	l1.setLayoutY(500);
	l3.setLayoutX(10);
	l3.setLayoutY(515);
	l4.setLayoutX(10);
	l4.setLayoutY(530);
	l5.setLayoutX(10);
	l5.setLayoutY(545);
	l6.setLayoutX(10);
	l6.setLayoutY(560);
	l8.setLayoutX(10);
	l8.setLayoutY(570);
	valider.setLayoutX(10);
	valider.setLayoutY(590);
	l7.setLayoutX(10);
	l7.setLayoutY(580);
	story.setTextFill(Color.web("#ffffff"));
	log.setTextFill(Color.web("#ffffff"));
	l1.setTextFill(Color.web("#ffffff"));
	l3.setTextFill(Color.web("#ffffff"));
	l4.setTextFill(Color.web("#ffffff"));
	l5.setTextFill(Color.web("#ffffff"));
	l6.setTextFill(Color.web("#ffffff"));
	l8.setTextFill(Color.web("#ffffff"));
	l7.setTextFill(Color.web("#ffffff"));
	l7.setTextFill(Color.web("#ffffff"));
	
	imvFond1.setLayoutX(0);
    imvFond1.setLayoutY(0);
    Image imageGuerrier = new Image("./guerrier.png", 200, 40, false, false);
    ImageView imvGuerrier = new ImageView(imageGuerrier);
    Image imageMage = new Image("./mage.png", 200, 40, false, false);
    ImageView imvMage = new ImageView(imageMage);
    Image imageArcher = new Image("./archer.png", 200, 40, false, false);
    ImageView imvArcher = new ImageView(imageArcher);
    Image imagePersoGuerrier = new Image("./guerrierPerso.png", 147, 174, false, false);
    ImageView imvPersoGuerrier = new ImageView(imagePersoGuerrier);
    Image imagePersoMage = new Image("./magePerso.png", 153, 186, false, false);
    ImageView imvPersoMage = new ImageView(imagePersoMage);
    Image imagePersoArcher = new Image("./archerPerso.png", 169, 197, false, false);
    ImageView imvPersoArcher = new ImageView(imagePersoArcher);
    Image imagePlaque = new Image("./plaque.png", 1070, 190, false, false);
    ImageView imvPlaque1 = new ImageView(imagePlaque);
    ImageView imvPlaque2 = new ImageView(imagePlaque);
    anchorPane.setPrefSize(1050, 623);
    
    Image imageFombasiette = new Image("./fombassiette.png", 370, 355, false, false);
    ImageView imvFombasiette = new ImageView(imageFombasiette);
 
   if(test==1){
    imvPersoArcher.setLayoutX(30);
    imvPersoArcher.setLayoutY(230);
    imvPersoMage.setLayoutX(30);
    imvPersoMage.setLayoutY(30);
    imvPersoGuerrier.setLayoutX(200);
    imvPersoGuerrier.setLayoutY(100);
    imvPlaque1.setLayoutX(0);
    imvPlaque1.setLayoutY(440);
    imvFombasiette.setLayoutX(600);
    imvFombasiette.setLayoutY(40);
    
   }else if(test==2){
	   imvFond1.setLayoutX(0);
       imvFond1.setLayoutY(0);
    
      
       imvPersoArcher.setLayoutX(30);
       imvPersoArcher.setLayoutY(30);
       imvPersoMage.setLayoutX(200);
       imvPersoMage.setLayoutY(100);
       imvPersoGuerrier.setLayoutX(30);
       imvPersoGuerrier.setLayoutY(230);
       imvPlaque1.setLayoutX(0);
       imvPlaque1.setLayoutY(440);
       imvFombasiette.setLayoutX(600);
       imvFombasiette.setLayoutY(40);
   }else if(test==3){
	   imvFond1.setLayoutX(0);
       imvFond1.setLayoutY(0);
    
      
       imvPersoArcher.setLayoutX(200);
       imvPersoArcher.setLayoutY(100);
       imvPersoMage.setLayoutX(30);
       imvPersoMage.setLayoutY(30);
       imvPersoGuerrier.setLayoutX(30);
       imvPersoGuerrier.setLayoutY(230);
       imvPlaque1.setLayoutX(0);
       imvPlaque1.setLayoutY(440);
       imvFombasiette.setLayoutX(600);
       imvFombasiette.setLayoutY(40);
	   
	   
   }
	
	

	Dot dot= new Dot(Perso,poutch);
	if(!Perso.isDead() && !poutch.isDead()){
		Perso.appliqueEffetPositif();
		Perso.appliqueEffetNegatif();
		poutch.appliqueEffetPositif();
		poutch.appliqueEffetNegatif();
		viem.setText(String.valueOf(poutch.getVita()));
		viep.setText(String.valueOf(Perso.getVita()));
		if(Perso.isDead()){
			story.setText("Vous etes mort !(malus)");
			
		}
		if(tour==1){
			story.setText("Le combat commence ! Tour 1");
		}else{
			story.setText("Le combat continu, tour "+tour);
		}
		log.setText("Vitalité Perso:"+Perso.getVita()+"pv  |"+poutch.getNom()+" "+poutch.getVita()+"pv÷\n"
				+ "Selectionnez votre action:");
		l1.setText("	1. "+Perso.getCac().toString2());
		l3.setText("	2. "+Perso.getListSorts().get(0).getNom()+": "+Perso.getListSorts().get(0).getDescription());
		l4.setText("	3. "+Perso.getListSorts().get(1).getNom()+": "+Perso.getListSorts().get(1).getDescription());
		l5.setText("	4. "+Perso.getListSorts().get(2).getNom()+": "+Perso.getListSorts().get(2).getDescription());
		l6.setText("	5. "+Perso.getObjet().getNom());
		l1.setOnMouseClicked((event) -> {
			idx1=1;
			l1.setTextFill(Color.web("#cc0000"));
		});
		l3.setOnMouseClicked((event) -> {
			idx1=2;
			l3.setTextFill(Color.web("#cc0000"));
		});
		l4.setOnMouseClicked((event) -> {
			idx1=3;
			l4.setTextFill(Color.web("#cc0000"));
		});
		l5.setOnMouseClicked((event) -> {
			idx1=4;
			l5.setTextFill(Color.web("#cc0000"));
		});
		l6.setOnMouseClicked((event) -> {
			idx1=5;
			l6.setTextFill(Color.web("#cc0000"));
		});
	
	
	//launch1vPoutch(lcac,Perso, stage);
	}
	
	
	if(Perso.getVitesse()>poutch.getVitesse()){
	valider.setOnAction((event) -> {
		int tours=tour+1;
		vPoutch(lcac,Perso, stage,tours, idx1, poutch, dot,test);
		if(poutch.getCac().getType().equals("physique")){
			double degatss = poutch.infligeDegatCac() - Perso.getDef();
			if(degatss>0){
				Perso.subitDegat(degatss);
				
			}else{
				
			}
		}else if(poutch.getCac().getType().equals("special")){
			double degatss = poutch.infligeDegatCacSpe() - Perso.getDefspe();
			if(degatss>0){
				Perso.subitDegat(degatss);
				
			}else{
				l7.setText("Perso  ne subit aucun degats");
			}
		}
	});
	}else if (poutch.getVitesse()>Perso.getVitesse()){
		// Jeux de l'ia
		valider.setOnAction((event) -> {
			int tours=tour+1;
			if(poutch.getCac().getType().equals("physique")){
				double degatss = poutch.infligeDegatCac() - Perso.getDef();
				if(degatss>0){
					Perso.subitDegat(degatss);
					
				}else{
					
				}
			}else if(poutch.getCac().getType().equals("special")){
				double degatss = poutch.infligeDegatCacSpe() - Perso.getDefspe();
				if(degatss>0){
					Perso.subitDegat(degatss);
					
				}else{
					l7.setText("Perso  ne subit aucun degats");
				}
			}
			vPoutch(lcac,Perso, stage,tours, idx1, poutch, dot,test);
		});
	}
		
		
		

	if(Perso.getVita()<=0){
		story.setText("Vous avez perdu...");
	} else{
		story.setText("Vous avez vaincu ce Poutch!");
	}
	anchorPane.getChildren().setAll(imvFond1,imvPersoArcher,imvPersoMage,imvPersoGuerrier,imvPlaque1,imvFombasiette,story,log,l1,l3,l4,l5,l6,l8,valider,l7);
	final Scene scene = new Scene(anchorPane, 1050, 623); 

	stage.setScene(scene);
	stage.show();
	
}




public static void test(ArrayList lcac,Personnage perso,Stage stage,int tour,Personnage poutch,int test){
	Pane pane=new Pane();
	VBox vbox1 = new VBox();
	Label story=new Label();
	Label log=new Label();
	Label l1=new Label();

	Label l3=new Label();
	Label l4=new Label();
	Label l5=new Label();
	Label l6=new Label();
	final AnchorPane anchorPane = new AnchorPane(); 
	Label l8=new Label();
	Button valider=new Button("valider");
	Image fond1 = new Image(Main.class.getResourceAsStream("./fond1.png"));
    ImageView imvFond1 = new ImageView(fond1);
	story.setLayoutX(10);
	story.setLayoutY(450);
	log.setLayoutX(10);
	log.setLayoutY(465);
	l1.setLayoutX(10);
	l1.setLayoutY(500);
	l3.setLayoutX(10);
	l3.setLayoutY(515);
	l4.setLayoutX(10);
	l4.setLayoutY(530);
	l5.setLayoutX(10);
	l5.setLayoutY(545);
	l6.setLayoutX(10);
	l6.setLayoutY(560);
	l8.setLayoutX(10);
	l8.setLayoutY(570);
	story.setTextFill(Color.web("#ffffff"));
	log.setTextFill(Color.web("#ffffff"));
	l1.setTextFill(Color.web("#ffffff"));
	l3.setTextFill(Color.web("#ffffff"));
	l4.setTextFill(Color.web("#ffffff"));
	l5.setTextFill(Color.web("#ffffff"));
	l6.setTextFill(Color.web("#ffffff"));
	l8.setTextFill(Color.web("#ffffff"));
	valider.setLayoutX(10);
	valider.setLayoutY(600);
	l7.setLayoutX(10);
	l7.setLayoutY(580);
	l7.setTextFill(Color.web("#ffffff"));
	l7.setTextFill(Color.web("#ffffff"));
	double degats;
	
	
	imvFond1.setLayoutX(0);
    imvFond1.setLayoutY(0);
    Image imageGuerrier = new Image("./guerrier.png", 200, 40, false, false);
    ImageView imvGuerrier = new ImageView(imageGuerrier);
    Image imageMage = new Image("./mage.png", 200, 40, false, false);
    ImageView imvMage = new ImageView(imageMage);
    Image imageArcher = new Image("./archer.png", 200, 40, false, false);
    ImageView imvArcher = new ImageView(imageArcher);
    Image imagePersoGuerrier = new Image("./guerrierPerso.png", 147, 174, false, false);
    ImageView imvPersoGuerrier = new ImageView(imagePersoGuerrier);
    Image imagePersoMage = new Image("./magePerso.png", 153, 186, false, false);
    ImageView imvPersoMage = new ImageView(imagePersoMage);
    Image imagePersoArcher = new Image("./archerPerso.png", 169, 197, false, false);
    ImageView imvPersoArcher = new ImageView(imagePersoArcher);
    Image imagePlaque = new Image("./plaque.png", 1070, 190, false, false);
    ImageView imvPlaque1 = new ImageView(imagePlaque);
    ImageView imvPlaque2 = new ImageView(imagePlaque);
    Image imagePoutch = new Image("./poutch.png", 200, 40, false, false);
    ImageView imvPoutch = new ImageView(imagePoutch);
    Image imagePunching = new Image("./punching.png", 145, 500, false, false);
    ImageView imvPunching = new ImageView(imagePunching);
    anchorPane.setPrefSize(1050, 623);
    
    Image imageFombasiette = new Image("./fombassiette.png", 370, 355, false, false);
    ImageView imvFombasiette = new ImageView(imageFombasiette);
 
   if(test==1){
    imvPersoArcher.setLayoutX(30);
    imvPersoArcher.setLayoutY(230);
    imvPersoMage.setLayoutX(30);
    imvPersoMage.setLayoutY(30);
    imvPersoGuerrier.setLayoutX(200);
    imvPersoGuerrier.setLayoutY(100);
    imvPlaque1.setLayoutX(0);
    imvPlaque1.setLayoutY(440);
    imvPunching.setLayoutX(600);
    imvPunching.setLayoutY(0);
    
   }
   if(test==2){
	   imvFond1.setLayoutX(0);
       imvFond1.setLayoutY(0);
    
      
       imvPersoArcher.setLayoutX(30);
       imvPersoArcher.setLayoutY(30);
       imvPersoMage.setLayoutX(200);
       imvPersoMage.setLayoutY(100);
       imvPersoGuerrier.setLayoutX(30);
       imvPersoGuerrier.setLayoutY(230);
       imvPlaque1.setLayoutX(0);
       imvPlaque1.setLayoutY(440);
       imvPunching.setLayoutX(600);
       imvPunching.setLayoutY(0);
   }
   if(test==3){
	   imvFond1.setLayoutX(0);
       imvFond1.setLayoutY(0);
    
      
       imvPersoArcher.setLayoutX(200);
       imvPersoArcher.setLayoutY(100);
       imvPersoMage.setLayoutX(30);
       imvPersoMage.setLayoutY(30);
       imvPersoGuerrier.setLayoutX(30);
       imvPersoGuerrier.setLayoutY(230);
       imvPlaque1.setLayoutX(0);
       imvPlaque1.setLayoutY(440);
       imvPunching.setLayoutX(600);
       imvPunching.setLayoutY(0);
	   
	   
   }
   
   

	
	Dot dot= new Dot(Perso,poutch);
	if(!Perso.isDead() && !poutch.isDead()){
		Perso.appliqueEffetPositif();
		Perso.appliqueEffetNegatif();
		poutch.appliqueEffetPositif();
		poutch.appliqueEffetNegatif();
		viem.setText(String.valueOf(poutch.getVita()));
		viep.setText(String.valueOf(Perso.getVita()));
		if(Perso.isDead()){
			story.setText("Vous etes mort !(malus)");
			
		}
		if(tour==1){
			story.setText("Le combat commence ! Tour 1");
		}else{
			story.setText("Le combat continu, tour "+tour);
		}
		log.setText("Vitalité Perso:"+Perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv÷\n"
				+ "Selectionnez votre action:");
		l1.setText("	1. "+Perso.getCac().toString2());
		l3.setText("	2. "+Perso.getListSorts().get(0).getNom()+": "+Perso.getListSorts().get(0).getDescription());
		l4.setText("	3. "+Perso.getListSorts().get(1).getNom()+": "+Perso.getListSorts().get(1).getDescription());
		l5.setText("	4. "+Perso.getListSorts().get(2).getNom()+": "+Perso.getListSorts().get(2).getDescription());
		l6.setText("	5. "+Perso.getObjet().getNom());
		l1.setOnMouseClicked((event) -> {
			idx1=1;
			l1.setTextFill(Color.web("#cc0000"));
		});
		l3.setOnMouseClicked((event) -> {
			idx1=2;
			l3.setTextFill(Color.web("#cc0000"));
		});
		l4.setOnMouseClicked((event) -> {
			idx1=3;
			l4.setTextFill(Color.web("#cc0000"));
		});
		l5.setOnMouseClicked((event) -> {
			idx1=4;
			l5.setTextFill(Color.web("#cc0000"));
		});
		l6.setOnMouseClicked((event) -> {
			idx1=5;
			l6.setTextFill(Color.web("#cc0000"));
		});
	
		if(Perso.getVita()<=0){
			story.setText("Vous avez perdu...");
		} else{
			story.setText("Vous avez vaincu ce Poutch!");
		}
	//launch1vPoutch(lcac,Perso, stage);
	}
	
	/*
	vbox1.getChildren().addAll(story,log,l1,l3,l4,l5,l6,l7,l8,valider);
	pane.getChildren().addAll(vbox1);
	Scene scene = new Scene(pane, 800, 600);
	stage.setScene(scene);
	stage.show();
	*/
	anchorPane.getChildren().setAll(imvFond1,imvPersoArcher,imvPersoMage,imvPersoGuerrier,imvPlaque1,imvPunching,story,log,l1,l3,l4,l5,l6,l8,valider,l7);
	final Scene scene = new Scene(anchorPane, 1050, 623); 
    
    stage.setTitle("Menu"); 
    stage.setScene(scene); 
    stage.setResizable(false);
    stage.show(); 
	valider.setOnAction((event) -> {
		int tours=tour+1;
		vPoutch(lcac,Perso, stage,tours, idx1, poutch, dot,test);
	});
}


public static void vPoutch(ArrayList lcac,Personnage perso,Stage stage,int tours,int idx3,Personnage poutch,Dot dot,int test){
	if(idx3==1){
		if(Perso.getCac().getType().equals("physique")){
			 double degat = Perso.infligeDegatCac() - poutch.getDef();
			if(degat>0){
				poutch.subitDegat(degat);
				l7.setText(poutch.getNom()+"-" + degat + " pv !");
			}else{
				l7.setText(poutch.getNom()+" ne subit aucun degats");
			}
		}else if(Perso.getCac().getType().equals("special")){
			double degat = Perso.infligeDegatCacSpe() - poutch.getDefspe();
			if(degat>0){
				poutch.subitDegat(degat);
				l7.setText(poutch.getNom()+" -" + degat + " pv !");
			}else{
				l7.setText(poutch.getNom()+" ne subit aucun degats");
			}
		}
	}
	if(idx3==2){
		Perso.getListSorts().get(0).getEffect(Perso, poutch, dot);
	}
	if(idx3==3){
		Perso.getListSorts().get(1).getEffect(Perso, poutch, dot);
	}
	if(idx3==4){
		Perso.getListSorts().get(2).getEffect(Perso, poutch, dot);
	}
	if(idx3==5){
		Perso.useObjet();
		Objet objet = new Objet("Vent",0.0,0.0,0.0,0.0,0.0,0.0,0.0, 0);
		Perso.setObjet(objet);
	}
	if(debug==0){
		test(lcac,Perso, stage,tours, poutch,test);
	}else{
	testIA(lcac,Perso, stage,tours, poutch,test);
	}
}


public static void launch1vPoutch(ArrayList lcac,Personnage perso,Stage stage){
	
	Poutch poutch = new Poutch();
	
	
	
	
	
	Dot dot= new Dot(Perso,poutch);
	int tour=1;
	while(!Perso.isDead() && !poutch.isDead()){
		Perso.appliqueEffetPositif();
		Perso.appliqueEffetNegatif();
		poutch.appliqueEffetPositif();
		poutch.appliqueEffetNegatif();
		viem.setText(String.valueOf(poutch.getVita()));
		viep.setText(String.valueOf(Perso.getVita()));
		if(Perso.isDead()){
			System.out.println("Vous etes mort !(malus)");
			break;
		}
		if(tour==1){
			System.out.println("Le combat commence ! Tour 1");
		}else{
			System.out.println("Le combat continu, tour "+tour);
		}
		System.out.println("Vitalité Perso:"+Perso.getVita()+"pv  |  Poutch:"+poutch.getVita()+"pv");
		System.out.println("Selectionnez votre action:");
		System.out.println("	1. "+Perso.getCac().toString2());
		System.out.println("	2. "+Perso.getListSorts().get(0).getNom()+": "+Perso.getListSorts().get(0).getDescription());
		System.out.println("	3. "+Perso.getListSorts().get(1).getNom()+": "+Perso.getListSorts().get(1).getDescription());
		System.out.println("	4. "+Perso.getListSorts().get(2).getNom()+": "+Perso.getListSorts().get(2).getDescription());
		System.out.println("	5. "+Perso.getObjet().getNom());
		String r ="";
		double degats;
		while(r.equals("")){
			Scanner sc = new Scanner(System.in);
			r = sc.nextLine();
			if(r.equals("1")){
				System.out.println("CAC choisi.");
				if(Perso.getCac().getType().equals("physique")){
					degats = Perso.infligeDegatCac() - poutch.getDef();
					if(degats>0){
						poutch.subitDegat(degats);
						System.out.println("Poutch -" + degats + " pv !");
					}else{
						System.out.println("Poutch  ne subit aucun degats");
					}
				}else if(Perso.getCac().getType().equals("special")){
					degats = Perso.infligeDegatCacSpe() - poutch.getDefspe();
					if(degats>0){
						poutch.subitDegat(degats);
						System.out.println("Poutch -" + degats + " pv !");
					}else{
						System.out.println("Poutch  ne subit aucun degats");
					}
				}
			}else if(r.equals("2")){
				Perso.getListSorts().get(0).getEffect(Perso, poutch, dot);
				
			}else if(r.equals("3")){
				Perso.getListSorts().get(1).getEffect(Perso, poutch, dot);

			}else if(r.equals("4")){
				Perso.getListSorts().get(2).getEffect(Perso, poutch, dot);

			}else if(r.equals("5")){
					Perso.useObjet();
					Objet objet = new Objet("Vent",0.0,0.0,0.0,0.0,0.0,0.0,0.0, 0);
					Perso.setObjet(objet);
			}
			else{
				System.out.println("Choisissez une option disponible, 1 ,2, 3, 4 ou 5.");
				r="";
			}
		}
		tour++;
		dot.endRound();
	}
	if(Perso.getVita()<=0){
		System.out.println("Vous avez perdu...");
	} else{
		System.out.println("Vous avez vaincu ce Poutch!");
	}
	
}


	public static void main(String[] args) {
		launch(args);
	}
}
