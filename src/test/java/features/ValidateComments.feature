Feature: Validate Comments


  Scenario Outline: Validate emails format for specific user
    Given user search for "<username>" to get his id using getUsersAPI
    When  search for all posts written with this user using getPostsAPI
    Then user get all posts comments and Validate each email

    Examples:
      | username |
      | Delphine |


  Scenario Outline: Check if the user search for invalid userId mustn't get any users
    Given user search with invalid "userId" "<userIdValue>"
    When user hit "getPostsAPI" get http request
    Then response will be empty

    Examples:
      | userIdValue |
      | Nora        |
      |             |

  Scenario Outline: Check if the user search for invalid postId mustn't get any comments
    Given user search with invalid "postId" "<postIdValue>"
    When user hit "getCommentsAPI" get http request
    Then response will be empty

    Examples:
      | postIdValue |
      | 98898       |
      |             |







