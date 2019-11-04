Feature: Automate End2EndTest for conduit

Scenario: Successful Login with Valid Credentials and create new post and validate the published post.

Given User is on Home Page
When User Navigate to SignIn Page
And User enters valid Email and valid Password
Then Username displayed Successfully
When User Navigate to New Post Page
And User enters Article Title, About, Article and Tags
And clicked to publish Article
And move to logged in username
And select My Articles
And move to publised article
And post comments
Then posted comments displayed Successfully
