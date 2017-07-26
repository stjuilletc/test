<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="CSSsite1.css" />
        <title>Test1.SiteSonny</title>
    </head>
    <body>
          <form method="POST">
           <p>Sivir possède un skin : </p>
            	<input type="radio" name="Sivir" value="Enfers">Des Enfers</input>
           	 	<input type="radio" name="Sivir" value="Neige"> Des Neiges</input>
           	 	<input type="radio" name="Sivir" value="SKT">SKT1 Telecom</input>
           	 	<input type="radio" name="Sivir" value="Pentakill">Pentakill</input>

           <br><p>Le E spell de Syndra a pour nom :</p>
            	<input type="radio" name="Syndra" value="Q">Dark Sphere </input>
            	<input type="radio" name="Syndra" value="R">Unleashed Power </input>
              	<input type="radio" name="Syndra" value="Z">Force of will</input>
              	<input type="radio" name="Syndra" value="E">Scatter the weak </input>
  
           <br><p>Au rang 5 , le Q spell d'Irelia coûte :</p>
              	<input type="radio" name="Irelia" value="1">55 pts de mana</input>
             	<input type="radio" name="Irelia" value="2">70 pts de mana</input>
              	<input type="radio" name="Irelia" value="3">65 pts de mana</input>
              	<input type="radio" name="Irelia" value="4">75 pts de mana</input>

           <br><p>L'item "Wit's End" coûte :</p>
              	<input type="radio" name="WI" value="1">2650 PO</input>
             	<input type="radio" name="WI" value="2">2475 PO</input>
              	<input type="radio" name="WI" value="3">2500 PO</input>
             	<input type="radio" name="WI" value="4">2450 PO</input>

           <br><p>La maîtrise "Insight" réduit le délai devos sorts d'invocateur de :</p>
              	<input type="radio" name="IN" value="1">15 % </input>
           	  	<input type="radio" name="IN" value="2">10 % </input>
              	<input type="radio" name="IN" value="3">12 % </input>
          	  	<input type="radio" name="IN" value="4">17 % </input>

          	 <br><p>Le Skin "Worldbreaker Trundle" coûte :</p>
          	    <input type="radio" name="WT" value="1">975 rp</input>
             	<input type="radio" name="WT" value="2">1350 rp</input>
             	<input type="radio" name="WT" value="3">750 rp</input>
          	  	<input type="radio" name="WT" value="4">Sa coûte cher frère!</input>

          	  	<br><input type="submit" name="submit">

          </form>
          <?php
          if (isset($_POST['submit'])) {
          	$note=0;
          	if(isset($_POST['Sivir'])){
          		if ($_POST['Sivir']=='Neige') {
          			$note=$note+1;
          		}
          	}
          	if (isset($_POST['Syndra'])) {
          		if ($_POST['Syndra']=='E') {
          			$note=$note+1;
          			# code...
          		}
          		# code...
          	}
          	if (isset($_POST['Irelia'])) {
          		if ($_POST['Irelia']=='2') {
          			$note=$note+1;
          			# code...
          		}
          		# code...
          	}
          	if (isset($_POST['WI'])) {
          		if ($_POST['WI']=='3') {
          			$note=$note+1;

          			# code...
          		}
          		# code...
          	}
          	if (isset($_POST['IN'])) {
          		if ($_POST['IN']=='1') {
          			$note=$note+1;
          			# code...
          		}
          		# code...
          	}
          	if (isset($_POST['WT'])) {
          		if ($_POST['WT']=='3') {
          			$note=$note+1;
          			# code...
          		}
          		# code...
          	}

          	echo $note;

          	
          	# code...
          }
          ?>





         <br> <footer>
            <i><b>Site crée par Sonny GRISORIO</b></i>
            <p>N'hésitez pas a me suivre sur les différents réseaux sociaux tel que </p>
            <p><a href="https://fr-fr.facebook.com/" title="Merci !" target="_blank"><img src="fb%20icon.png" width="50" height="50"/></a>                                                 
            <a href="https://twitter.com/?lang=fr" title="Merci !" target="_blank"><img src="twitter.png" width="50" height="50"/></a>
            <a href="https://www.instagram.com/?hl=fr" title="Merci !" target="_blank"><img src="insta.jpg " width="50" height="50"/></a></p>
            
        </footer>
    </body>
</html>