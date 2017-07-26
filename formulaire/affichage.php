<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta charset="utf-8" />
        <title>Test2.SiteSonny</title>
        <h1>Voilà le formulaire sélectionné : </h1>
<!-- ajouter le nom du formulaire -->
         
    	
    <?php $bdd = new PDO('mysql:host=127.0.0.1;dbname=bddform','root','');
    $int = $bdd->query('SELECT * FROM questions WHERE Nom="'.$_GET['name'].'"');

			 while($donnees = $int->fetch()){ ?>
			 	<ul>
				<li> Question :  <?php echo $donnees['question']; ?> </li> 
			 	<li> Reponse :  <?php echo $donnees['reponse']; ?> </li>
                <li> description :  <?php echo $donnees['description']; ?> </li>
				</ul>
				<?php
				
			}
			?>
    
    </head>
    <body>
