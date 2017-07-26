<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta charset="utf-8" />
        <title>Test2.SiteSonny</title>
    </head>
        <p>
        <form action="http://localhost:8080/projet/formulaire/accueilform.php">
        <input type="submit" name="submit5" value="Retour à l'accueil">
        </input>
        </p>  
        </form>  
        <h1>Voilà le formulaire sélectionné :<?php echo $_GET['name']; ?> </h1>
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
             $ins=$bdd->query('SELECT * FROM questions WHERE Nom="'.$_GET['name'].'"');
             $note=0;
            while($donnees = $ins->fetch()){
                if($donnees['reponse']==$_POST[$donnees['id']])
                    $note=$note+1;
            }
            echo $note;
        }
            ?>




</body>
