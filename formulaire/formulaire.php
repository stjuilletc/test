<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" type="text/css" href="fermetagueule.css">
        <meta charset="utf-8" />
        <title>Test2.SiteSonny</title>
        <h1>Bienvenue sur notre page de création de formulaire/questionnaire </h1>
    </head>
    <body>
    	<h2>Vous pouvez dès à présent commencer votre formulaire :</h2>
		
    	</br >
    	   	<form method="post">
    		<p>
    			<label for="nom"><strong>Entrer le nom du formulaire</strong></label>
    			<input type="text" name="nom" id="nom" size="30" maxlength="15">
    		</p>
    		</br >
    		<!-- <input type="submit" name="submit1" value="Ajouter une classe"-->
    		</br >
    		<p>
    			<label for="question">Saisissez votre question :</label>
    			<input type="text" name="question1" id="question1" size="30" maxlength="85">
    		</p>
    		<p>
    			<label for="reponse">Saisissez la réponse      :</label>
    			<input type="text" name="reponse1" id="reponse1" size="34" maxlength="25">
    		</p>
    		</br >
    		<p>
    			<label for="question">Saisissez votre question :</label>
    			<input type="text" name="question2" id="question2" size="30" maxlength="85">
    		</p>
    		<p>
    			<label for="reponse">Saisissez la réponse      :</label>
    			<input type="text" name="reponse2" id="reponse2" size="34" maxlength="25">
    		</p>
    		</br >
    		<p>
    			<label for="question">Saisissez votre question :</label>
    			<input type="text" name="question3" id="question3" size="30" maxlength="85">
    		</p>
    		<p>
    			<label for="reponse">Saisissez la réponse      :</label>
    			<input type="text" name="reponse3" id="reponse3" size="34" maxlength="25">
    		</p>
    		</br >
    		<p>
    			<label for="question">Saisissez votre question :</label>
    			<input type="text" name="question4" id="question4" size="30" maxlength="85">
    		</p>
    		<p>
    			<label for="reponse">Saisissez la réponse      :</label>
    			<input type="text" name="reponse4" id="reponse4" size="34" maxlength="25">
    		</p>
    		</br >
    		<p>
    			<label for="question">Saisissez votre question :</label>
    			<input type="text" name="question5" id="question5" size="30" maxlength="85">
    		</p>
    		<p>
    			<label for="reponse">Saisissez la réponse      :</label>
    			<input type="text" name="reponse5" id="reponse5" size="34" maxlength="25">
    		</p>
    		<?php $bdd = new PDO('mysql:host=127.0.0.1;dbname=bddform','root','');

    		if (isset($_POST['submit2'])) {	
    			$ins=$bdd->prepare("INSERT INTO `questions`(`Nom`, `question`, `reponse`) VALUES (?,?,?)");
    			if (isset($_POST['nom']) and $_POST['nom']!=""){

    				if(isset($_POST['question1']) and isset($_POST['reponse1']) and $_POST['reponse1']!="" and $_POST['question1']!=""){
    					$ins->execute(array($_POST['nom'],$_POST['question1'],$_POST['reponse1']));

    				}

    				if(isset($_POST['question2']) and isset($_POST['reponse2']) and $_POST['reponse2']!="" and $_POST['question2']!=""){
    					$ins->execute(array($_POST['nom'],$_POST['question2'],$_POST['reponse2']));

    				}

    				if(isset($_POST['question3']) and isset($_POST['reponse3']) and $_POST['reponse3']!="" and $_POST['question3']!=""){
    					$ins->execute(array($_POST['nom'],$_POST['question3'],$_POST['reponse3']));

    				}

    				if(isset($_POST['question4']) and isset($_POST['reponse4']) and $_POST['reponse4']!="" and $_POST['question4']!=""){
    					$ins->execute(array($_POST['nom'],$_POST['question4'],$_POST['reponse4']));

    				}
    				if(isset($_POST['question5']) and isset($_POST['reponse5']) and $_POST['reponse5']!="" and $_POST['question5']!=""){
    					$ins->execute(array($_POST['nom'],$_POST['question5'],$_POST['reponse5']));

    				}
    			} 
				
				
    		}

   		 ?>
		 
    		
    		<input type="submit" name="submit2" value="Sauvegarder et envoyer">
				
			</input>
			</form>
			<p>
				
					<form action="http://localhost:8080/projet/formulaire/accueilform.php">
					<input type="submit" name="submit5" value="Retour à l'accueil">
				</input>
				</form>
			</p>
			<input type="button" onclick="location.href='http://google.com';" value="Go to Google" />
			

    </body>
	
	
    	
	
</html>
