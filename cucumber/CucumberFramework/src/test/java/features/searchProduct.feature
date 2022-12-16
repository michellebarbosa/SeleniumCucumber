Feature: Title of your feature
  I want to use this template for my feature file
  
Scenario: To check if the output from Product search and Deals page are the same
  Given User is on GreenCart Landing Page 
  When User searched with Shortname "Tom" and extracted actual name of product
  Then User searched for "Tom" shortname in offers page
  And validate product name in offers page matches with Landing Page
