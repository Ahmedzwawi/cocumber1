Feature: Panier d'achat

  Scenario: Vérification de l'affichage des produits dans le panier
    Given je suis sur "https://www.saucedemo.com/"
    When je saisis le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur le bouton "login-button"
    When jajoute un produit au panier
    And je vais sur la page du panier
    Then le produit ajouté est bien affiché dans le panier
