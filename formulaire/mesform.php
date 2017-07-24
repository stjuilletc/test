<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" type="text/css" href="fermetagueule.css">
        <meta charset="utf-8" />
        <title>Test2.SiteSonny</title>
        <h1>Veuillez sélectionner le formulaire que vous souhaitez ouvrir. </h1>
    </head>
    <body>
    <br/ >
    <ul>
    	<ul>
    		<li><strong>Mes formulaires  :</strong></li>
    	</ul>
    <?php $bdd = new PDO('mysql:host=127.0.0.1;dbname=bddform','root','');
    $fichier = $bdd->query('SELECT DISTINCT Nom FROM questions ');
			 while($donnees = $fichier->fetch()){ ?>
			 	<li> <a href=<?php echo '"affichage.php?name='.$donnees['Nom'].'"'; ?> ><?php echo $donnees['Nom']; ?></a><?php 

			 }
			 ?>
    </ul>
    </body>
</html>    	