// Charger les secteurs au démarrage de la page
$(document).ready(function () {
   $(".secteur-liste").on('click', chargerRayons);
});


// Fonction pour charger les rayons en fonction du secteur sélectionné
function chargerRayons() {
   var numSecteur = $(this).data("codesecteur");
   $.ajax({
      url: "/rayons/" + numSecteur,
      method: "get",
      success: function (rayons) {
         $('#rayons').empty();
         let chaine = '<h2>Les rayons</h2><ul>';
         rayons.forEach(function (rayon) {
            chaine += `<li onclick="chargerEmployesDansRayon(${rayon.numR})">${rayon.nomR}</li>`;
         });
         chaine += '</ul>';
         $('#rayons').append(chaine);
      },
      error: function () {
         alert('Erreur de chargement des rayons');
      }
   });
}

// Fonction pour charger les employés travaillant dans le rayon sélectionné
function chargerEmployesDansRayon(numRayon) {
   $.ajax({
      url: "/employes?rayon=" + numRayon,
      method: "get",
      success: function (employes) {
         $('#travailleurs-rayon').empty();
         let chaine = '<h2>Les employés qui travaillent dans le rayon choisi</h2><ul>';
         employes.forEach(function (employe) {
            chaine += `<li onclick="afficherFormulaire(${employe.numE})">${employe.prenomE} (Âge: ${employe.age})</li>`;
         });
         chaine += '</ul>';
         $('#travailleurs-rayon').append(chaine);
         chargerTotalHeures(numRayon);
         chargerTousLesEmployes();
      },
      error: function () {
         alert('Erreur de chargement des employés');
      }
   });
}

// Fonction pour charger tous les employés (non associés à un rayon spécifique)
function chargerTousLesEmployes() {
   $.ajax({
      url: "/employes",
      method: "get",
      success: function (employes) {
         $('#employes').empty();
         let chaine = '<h2>Tous les employés</h2><ul>';
         employes.forEach(function (employe) {
            chaine += `<li>${employe.prenomE} (Âge: ${employe.age})</li>`;
         });
         chaine += '</ul>';
         $('#employes').append(chaine);
      },
      error: function () {
         alert('Erreur de chargement de tous les employés');
      }
   });
}

// Fonction pour charger le total des heures travaillées dans un secteur
function chargerTotalHeures(numRayon) {
   $.ajax({
      url: "/travaux/total-heures?rayon=" + numRayon,
      method: "get",
      success: function (data) {
         $('#total-heures').empty();
         let chaine = `<h2>Total d'heures des travailleurs dans le secteur sélectionné</h2><p>${data.totalHeures} heures</p>`;
         $('#total-heures').append(chaine);
      },
      error: function () {
         alert('Erreur de chargement du total des heures');
      }
   });
}

// Fonction pour afficher le formulaire de saisie d'heures pour un employé
function afficherFormulaire(numEmploye) {
   $('#formulaire-ajout').empty();
   let chaine = `
        <h2>Formulaire pour ajouter des heures de travail</h2>
        <form id="ajoutHeuresForm" onsubmit="ajouterHeures(event, ${numEmploye})">
            <label for="date">Date :</label>
            <input type="date" id="date" name="date" class="form-control" required>
            <label for="heures">Heures travaillées :</label>
            <input type="number" id="heures" name="heures" class="form-control" required>
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </form>
    `;
   $('#formulaire-ajout').append(chaine);
}

// Fonction pour ajouter des heures de travail pour un employé
function ajouterHeures(event, numEmploye) {
   event.preventDefault();
   let formData = {
      codeE: numEmploye,
      date: $('#date').val(),
      temps: $('#heures').val()
   };
   $.ajax({
      url: "/travaux/ajouter",
      method: "post",
      contentType: "application/json",
      data: JSON.stringify(formData),
      success: function () {
         alert('Heures ajoutées avec succès');
         chargerEmployesDansRayon(numEmploye); // Recharger les employés du rayon
      },
      error: function () {
         alert('Erreur lors de l\'ajout des heures');
      }
   });
}
