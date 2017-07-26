<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta charset="utf-8" />
        <title>Test2.SiteSonny</title>
        <p>
        	<form action="http://localhost:8080/projet/formulaire/accueilform.php">
        	<input type="submit" name="submit5" value="Retour à l'accueil">
        	</input>
        	</form>
        </p>

        <h1>Vous pouvez sur cette page , supprimer des formulaires </h1>
    </head>
    <body>
    	<h2>Sélectionner le formulaire à supprimer</h2>
    	<form method="POST">
    		</br >
    		<p><strong>Cocher le formulaire à supprimer</strong></p>
    		<ul>
    			<?php $bdd = new PDO('mysql:host=127.0.0.1;dbname=bddform','root','');
   				 $fichier = $bdd->query('SELECT DISTINCT Nom FROM questions ');
				 while($donnees = $fichier->fetch()){ ?>
     			<li><input type="radio" name="supp" value=<?php echo '"'.$donnees['Nom'].'"'; ?> ><?php echo $donnees['Nom']; ?></input></li><?php 
			 	}
			 	?>
			 </ul>

			<input type="submit" name="submit" value="Supprimer et sauvegarder">
			</input>
			</form>
			<?php
			if (isset($_POST['submit']) and isset($_POST['supp'])) {
			$ins=$bdd->query('DELETE FROM `questions` WHERE `Nom`="'.$_POST['supp'].'"');
			header('Location:http://localhost:8080/projet/formulaire/accueilform.php');
			}
			?>
	</body>
</html>
