Feature: Book Library Management

  Scenario: Add a category and a book, then fetch the book by category
    Given I have a category named "History"
    When I add this category via API
    Then the category should be created successfully

    Given I have a book named "The guys of Rangoon" by author "Khat Zaw" with ISBN "0001" in category "History"
    When I add this book via API
    Then the book should be created successfully

    When I fetch books for category "History"
    Then I should receive a list containing "The guys of Rangoon"