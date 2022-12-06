# Project Overview
Our application is a marketplace where users can post their items, buy items posted by other users.
You can run our application by running "Main".

## User Login Feature
This feature allows users to login to existing accounts.

This is the first page of the program. If this is the first time running the program, you will need to register a new 
account by pressing the "Sign Up" button on the login page. This button will lead you to the register page where you 
can create a new account. Please see User Register Feature for details about the register page.

There are three scenarios when you press the "Login" button on the login page after inputting the username and password: 
1. The user have not registered an account, or the username input does not match with the username registered. A message 
"Your username does not exist" will show up.
2. The user input the correct username, but the password input does not match with the password registered. A message 
"Your username or password is not valid" will show up.
3. The user input the correct username and password which match with the ones registered. A new window main page will 
will show up.

- To get the first scenario:

  Leave the two boxes blank or input a random username and password and press login.

- To get the second scenario:

  Input the correct username you registered but a wrong password and press login.

- To get the third scenario:

  Input the correct username and password you registered and press login.

## User Register Feature
This feature allows users to register new accounts.

There are two scenarios whe you press the "Sign up" button on the register page:
1. The two password does not match. A message "Passwords don't match" will show up.
2. The two password match. A message "username(the username you chose) created" will show up.

- To get the first scenario:
  
  Input two different passwords.
- To get the second scenario:

  Input a username and two identical passwords. By pressing the "OK" button on the message, the login page will show up 
again where you can login to the account you have just registered, or register another account. Please see User Login 
Feature for details about the login page.

## Main Page
This is the page where users can access all the functionalities of the program. It contains:
- A search box to type in the item you want to search with a "Search" button. 
- A "Recommendation" button. 
- A "User Center" button. 
- A "Add Post" button. 

For details of each functionality, please see corresponding feature section below. 

## Recommendation Feature
This feature will give recommendation to users based on their purchase history. 

There are three scenarios when you press the "Recommendation" button on the main page:
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