# Project Overview
Our application is a marketplace where users can post their items, buy items posted by other users.
You can run our application by running "Main".

## Recommendation Feature
This feature will give recommendation to users based on their purchase history. 
There are three scenarios when you press the "Recommendation" button on the main page (page after login):
1. The user has bought nothing, so a message "Please use more to have recommendation!" will show up.
2. The user has bought some items that altogether there are at least three different tags 
(but since we make the decision that tags don't appear in the purchase history page, you need to check orders.csv, which is the database that stores every purchase). 
The application will select out three tags that have the highest frequency in the user's purchase history 
and search in the post database (posts.csv) to see if there is any post has any one of the three tags.
If there are no items in the post database containing one of the three tags, a message "There is no recommendation for you now!" will show up.
3. If there are items in the post database containing one of the three tags, a new window with a list of items will show up.

- To get the first scenario:

    Login an account that has just been created by signing up and press "Recommendation" on the main page. You will get a message saying "Please use more to have recommendation!"

- To get the second scenario:
    
    Still use the account you just logged in and call it User 1. 
Press "add post" button on the main page and enter anything you want as detail except for tags and remember the title of the post.
For the tags, come up with three different tags (e.g. "a", "b", "c") enter one tag at a time and each time press the "add tag" button (you need to press "add tag" three times).
Close the main page. Restart the application.
Create another account. Call it User 2. Log in User 2 and search the title of the post you just created and buy the item. 
Then in the main page, press "Recommendation". You should see a message saying "There is no recommendation for you now!" 
since there is no posts in the database that is in sale and contain the tags you just used for creating the post (you just bought the only item in the database).

- To get the third scenario:

    Close the main page. Restart the application. Log in User 1 and create another post with three tags you have used. Close the main page. Log in User 2 and press "Recommendation".
You should see the post you just created.