<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" type="text/css" href="fermetagueule.css">
        <meta charset="utf-8" />
        <title>Test2.SiteSonny</title>
    </head>    
        <h1>Voilà le formulaire sélectionné : </h1>
<!-- ajouter le nom du formulaire -->
    <body>     
    	<form method="post">
    <?php $bdd = new PDO('mysql:host=127.0.0.1;dbname=bddform','root','');
    $int = $bdd->query('SELECT * FROM questions WHERE Nom="'.$_GET['name'].'"');

			 while($donnees = $int->fetch()){ ?>
			 	<ul>
				<li> Question :  <?php echo $donnees['question']; ?> </li> 
			 	<li>
                <p>
               
                <label for="reponse">Saisissez la réponse      :</label>
                <?php print('<input type="text" name="'.$donnees['id'].'" id="'.$donnees['id'].'" size="34" maxlength="25">'); ?>    
             </p>
				</ul>
				<?php

				
			}
			?>
            <p><input type="submit" name="submit" value="Confirmer vos réponses"></p>
         
            </form>
            <?php
            if (isset($_POST['submit'])){
             $ins=$bdd->prepare("INSERT INTO `questions`(`Nom`, `question`, `reponse`) VALUES (?,?,?)");
            if (isset($_POST['nom']) and $_POST['nom']!="");
             }
            ?>
</body>
