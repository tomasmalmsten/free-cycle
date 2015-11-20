Feature: A user can add a product e would like to give away. The
user should be able to describe the product and provide images. E
should also be able to add information about where the product is located.

Scenario: A user adds a book e would like to give away.
  Given a user adds a books title and author
  And a description
  And the address, phone number and e-mail address to contact the user
  When the user sends the request to the server
  Then the data is collected and saved in the system
