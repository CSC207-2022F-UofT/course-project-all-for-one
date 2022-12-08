# Project Overview
Our application is a marketplace where users can post their items, buy items posted by other users.
You can run our application by running "Main".

## Important Note
Please create two accounts for the convenience to check all the features. For how to register accounts, please see User
Login Feature and User Register Feature. In the following instructions, we will use User 1 and User 2 to represent the 
two different accounts you registered.

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
This feature allows users to register new accounts. For every new account, the program will automatically add 1000 to 
the balance of the account.

There are two scenarios when you press the "Sign up" button on the register page:
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
- A search box to type in the item you want to search with a "Search" button. (Search Feature)
- A "Recommendation" button. (Recommendation Feature)
- A "User Center" button. (Profile Feature)
- A "Add Post" button. (Post Creation Feature)

For details of each functionality, please see corresponding feature section below. 

## Post Creation Feature

## Search Feature

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

## Post Page
This page contains the details of a post, where users can view the information of a product. 

There are three ways users can access this page: 
- Through search page
- Through recommendation page
- Through post history in user center

When you open a post page, a message board will show up at the same time. Please see Message Board Feature for details
about the message board.

There are two version of post page depending on the user:
1. If the post is created by the user viewing the page, meaning that the viewer is the owner or seller of the post, 
there will only be a "Delete" button, which allow you to delete the post.
2. If the post is not created by the user viewing the page, meaning that the viewer is the potential buyer of the post, 
there will only be a "Buy button", which leads you to the confirm page and allow you to place an order.

- To get the first version:
  
  Create a new post using the "Add Post" button on the main page using User 1 (please see Post Creation Feature 
for details about creating a new post), then search for the post you have just created
  (please see Search Feature for details about how to search a post). Open the post and you should see a post page with
a delete button. If you press the "Delete" button, the post will be removed from the database. You can verify the 
deletion in the post history under the user center in the main page (please see Profile Feature for details about 
the post history).
- To get the second version:
  
  Login to User 2 and Search for the post you just created using User 1. Open the post and you should see a post page with
a buy button. If you press the "Buy" button, a confirm page will show up, where you will be able to place an order. Please
see Trade Feature for details about placing an order.
  


## Message Board Feature
This feature allows users to leave messages for a post. The Post page of a product will be displayed with a MessageBoard 
simultaneously. User can enter their message and press "Post" button to leave a message on the MessageBoard. The message
will be displayed on the Board with the username of who post it in the front of the message.


## Trade Feature
This feature allows users to trade with each other. When you view a post as a potential buyer and press the "Buy" button 
on the post page (please see Post Page for details), a confirm page will show up, where you can review the details of the 
post you are trying to buy and input the shipment information. Note that if you have previously set a name, phone number,
and address in the profile of the account under user center in the main page (please see Profile Feature for details 
about the profile), the shipment information will automatically be input on the confirm page, with the option to edit them.

There are two scenarios when you press the pay button on the confirm page:
1. The buyer have insufficient balance to make the purchase. A message "Insufficient Balance" will show up.
2. The buyer have sufficient balance to make the purchase. A message "Order confirmed at time(the current time)" will
show up.

- To get the first scenario:

  Login as User 1 and create a post with a price over 1000 (please see Post Creation Feature
for details about creating a new post), then terminate the program and login to User 2 and Search for the post you just created using User 1. 
Open the post and buy it, then the confirm page will show up. After you input the shipment information and press the "Pay"
button, you should see the message informing insufficient balance.
- To get the first scenario:

  Login as User 1 and create a post with a price with small values(please see Post Creation Feature
  for details about creating a new post), then terminate the program and login to User 2 and Search for the post you just created using User 1.
  Open the post and buy it, then the confirm page will show up. After you input the shipment information and press the "Pay"
  button, you should see the message informing order placed.

Note that if the order is successfully placed, the post will be automatically deleted, and you should see the order in purchase
history under user center in the main page (please see Profile Feature for details about the purchase history). At the same
time you should see a change in balance in wallet under user center in the main page (please see Profile Feature for dtails
about the wallet).
## Profile Feature
This feature allows user to view and edit basic information and store some necessary information to trade. When user buy some things, the name, the 
address and the phone stored in the profile will automatically fill with the confirm order page with the option to modify.
Note that, In order to guarantee username is unique. The username can’t be modified. The username is fixed with the same username when 
you register a new account.

You can access the profile in User Center page. The profile will show in this page within a textarea. When you register, the profile is initialized to empty,
and you can press "edit/create" button in the User Center page. It will pop out a new page, the edit page. You can edit or create your profile
in this page. After you modifying the profile, pressing the button "save". All the change will be save. THe edit page will dispose and pop back to 
the User Center Page.
