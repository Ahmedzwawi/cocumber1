Feature: Page de paiement

  Scenario: Accès au formulaire de paiement
    Given je suis sur "https://www.saucedemo.com/"
    When je saisis le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur le bouton "login-button"
    And jajoute un produit au panier
    And je vais sur la page du panier
    When je clique sur le bouton du panier "Checkout"
    Then je suis redirige vers le formulaire de paiement

  Scenario: Saisie des informations client
    Given je suis sur "https://www.saucedemo.com/"
    When je saisis le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur le bouton "login-button"
    And jajoute un produit au panier
    And je clique sur le bouton de la cart "cart"
    When je clique sur le bouton du panier "Checkout"
    When je saisis les informations client:
      | prénom  | nom     | code postal |
      | Ahmed   | Testeur | 75000       |
    #  When je clique sur le bouton "Continue" je passe a la page de payement

    Then je suis redirigé à la page de confirmation

# Scenario: Validation d'une commande
#     Given je suis sur "https://www.saucedemo.com/"
#     When je saisis le username "standard_user"
#     And je saisi le password "secret_sauce"
#     And je clique sur le bouton "login-button"
#     And jajoute un produit au panier
#     And je clique sur le bouton de la cart "cart"
#     When je clique sur le bouton du panier "Checkout"
#     When je saisis les informations client:
#       | prénom  | nom     | code postal |
#       | Ahmed   | Testeur | 75000       |
#     When je clique sur le bouton "Continue" je passe a la page de payement
#     And je suis redirigé à la page de confirmation
#     And je verifie que lapercu est correct
#     And je clique sur le bouton "Finish" pour valider la commande
#     Then je devrais voir un message de succes de commande
