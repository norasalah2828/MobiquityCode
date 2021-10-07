Feature: Validate Comments

  Scenario Outline: Validate emails format for specific user
    Given user search for "<username>" to get his id using getUsersAPI
    When  search for all posts written with this user using getPostsAPI
    Then user get all posts comments and Validate each email

    Examples:
      | username |
      | Delphine |
      | Nora     |
      |          |

  Scenario Outline: Check if the user search for invalid postId mustn't get any comments
    Given user search for comments with invalid "<postId>"
    When user hit get http request
    Then response will be empty

    Examples:
      | postId |
      | 98898  |
      |        |
      | 83     |








