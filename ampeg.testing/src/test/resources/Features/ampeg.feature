#Author: trevor.kleinstuber@gmail.com
#Date 11 January 2023

Feature: Browse Ampeg
  I want be able to view various things on ampeg.com
   
  #DEPRECATED FEATURE
  #FR-001 As a user I can view artist endorsement for a specific product
  @fr-001
  Scenario: View specific endorsements
    Given user is on a home page
    When user opens an individual amp product
    Then user will see artists endorsement
    
    
  #FR-002 As a user I can view specifications for individual products
  @fr-002
  Scenario: View specifications for individual products
    Given user is on a home page
    When user opens heritage category
    And user opens an individual amp product, 50th Anniversary SVT
    Then user will see product specifications
    
    
  #FR-003 As a user I can find product dealers for individual products
  @fr-003
  Scenario: Find product dealers
    Given user is on a home page
    When user opens heritage category
    And user clicks Find a Dealer
    And user clicks Buy Now
    Then user will see a list of dealers for that product
    
    
  #FR-004 As a user I can view, in one location, all artists that endorse Ampeg products
  @fr-004
  Scenario: View all endorsing artists
    Given user is on a home page
    When user clicks on Artists
    Then user will see the list of artists
    
    
  #FR-005 As a user I can view items in my Shopping Cart
  #@fr-005
  #Scenario: View Shopping Carrt
    #Given user is on a home page
    #When user clicks on shopping cart symbol
    #Then user will see their cart with items in it

