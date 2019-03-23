# HCI final report
-----
Members: 
* Pham Minh Duc - USTHBI7-040
* Lai Khang Duy - USTHBI7-051
* Nguyen Duc Khai - USTHBI7-085
* Luu Gia An - USTHBI7-003
-----
## I. Product description
* Product name: Discord
* Purpose: a communication application that supports text, voice and video chatting

## II. Requirements
### A. Functional requirements
* Able to create chat rooms and set their privacy setting
* Able to search for chat rooms
* Able to create different text and voice channels in a chat room
* Able to find and add friends
* Able to send direct messages to friends
* Able to make voice calls and video calls in direct messages
* Chat rooms moderator can pin important messages

### B. Non-functional requirements
* Performance: the application must not use too much resources since it has to be run in parallel with games
* Scalability: the application must work well for chat rooms with thousands of users
* Security: the chat log must be secured from eavesdroppers

## III. Personas
|  | University student | Professor | Accountant | Amateur stock trader |
|-------------------------------------------------------------------------------|----------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|
| Picture | ![](https://i.imgur.com/ghJMFab.jpg)| ![](https://i.imgur.com/hJcrZFH.jpg) | ![](https://i.imgur.com/TiCPY2Z.jpg) | ![](https://i.imgur.com/wDzUcaf.jpg)|
| Name | Huynh Vinh Nam | Le Huu Ton | Trinh Thi Thu Trang | Le Nguyen Khoi |
| Age | 21 | 50 | 27 | 20 |
| Location | Vietnam | Vietnam-French | Vietnam | Vietnam |
| Social life | He lives with his family in Thanh Cong Street. He is very passionate about games | He is married and lives with his family in Hanoi. He often has meeting with his colleagues in French.He plays games in his free time | She is single and lives with her roomate in Hoang Quoc Viet Street. She doesn’t play game but she is a member of different online communities | He is living in a rented house in Hanoi. He plays games and chat with his friends playing the same game a lot |
| Work life | He is a 3rd year university student and is preparing for his internship | He is a professor specialized in Machine Learning | She works as accountant in University of Science and Technology | He is a 3rd university student and is actively involved in the stock trading world |
| Discord use case | Expert gamer who often chat voice with his teammates in game using discord | A busy professor who want to have occasional meetings with his colleagues. He often uses discord to have a meeting with his colleagues | When she visit some online forums, she found out that many of them have a dedicated discord server. She starts using discord to communicate with them | Expert gamer who is recommended using discord by his foreign friends. |
| Computer experience | Experienced user | Expert user | Novice user | Experienced user |
| Gaming experience | 15 years | 1-2 years | None |  |
| Currently joining a community | Yes | No | Yes | Yes |
| Devices owned | MSI gaming laptop, Samsung phone | Acer notebook, Iphone | Macbook, Iphone | Acer |
| Time spent gaming per week | 14-16 hours | 8-10 hours | None | 18-20 hours |
| Time gaming WITH FRIENDS per week | 5-6 hours | 1-2 hours | None | 12-15 hours |
| Time chatting with friends/co-workers per week | 12-14 hours | 20-25 hours | 15-18 hours | 9-10 hours |
| Time chatting with anonymous users on the Internet who have the same interest | 2-3 hours | 5-6 hours | 4-5 hours | 2-3 hours |
| Frequency of chatting per week | Everyday | Everyday | Everyday | Everyday |

## IV. Scenarios
### A. Scenario 1
* Task: Communicate in-game with friends 
* Persona: Le Nguyen Khoi
* User group: Gamers
* Date: February 2019
* Background: 
    Discord is a proprietary freeware VoIP application and digital distribution platform designed for video gaming communities, that specializes in text, image, video and audio communication between users in a chat channel. 
* Scenario:
    Khoi is an Amatuer stock trader who love playing video games with his friends. Finding it too hard for him to communicate through texting, he decided to find an application that supports voice chatting. Then he came across Discord.
    
    On an Saturday night, Khoi is sitting in front of his computer. His friends invite him to play a match of Dota. He asks to join their Discord server, and they send him an invite link. He has about 5 minutes before his game starts. Very quickly, he clicks on the link, which makes the application automatically open. After entering his credentials, he finds himself already in the right chat room. Finally he joins the voice chat channel in which his friends are already in, and then alt-tabbed back to the game.

### B. Scenario 2
* Task: Conduct an online meeting
* Persona: Le Huu Ton
* User group: Workers
* Date: November 2018

* Background:
    Discord is a voice and text chat application that runs on most popular platforms. It also has a web application so that users don't need to download anything. Although its main target are the gamers, companies can also use them to host video conferences. 

* Scenario:
    Ton is a professor at USTH, working in the ICT department. On every Friday, the department conduct a meeting to discuss research plans. Because he usually goes to France for business trips, the meetings have to be online.
    
    In the past, they had been using Skype to conduct the meetings. However, the recent meetings have been very troublesome due to various problems: sound & video interruptions, participants randomly disconnecting, high latency,... Ton then decides to find another application, and his son recommends her Discord. He visits the Discord website, presses sign up and then fills his informations to create an account. Then he proceeds to login, created a chat room and sent an invite link to his colleagues.


## V. Usability & experience goals
### A. Usability goals
* **Effective to use**
    We aim to create an intuitive user interface so that user with different experience and background can immediately accomplish their task
* **Have good utilities**
    * The software focus heavily on user interface such that it is easy to find and chat with your friends and your communities
    * We promise to make the voice chat low on computational power so that you have the best gaming experience

### B. User Experience goal
* **Enjoyable**
    We hope that anyone who use discord can quickly and easily communicate with their friends, their loved ones and their communities and have a wonderful experience
* **Helpful**
    The application is available on multiple platform (Mac, Windows, Linux, Android, IOS). No matter what users use, they can always connect with their friends and communities.

## VI. Prototype 1
### A. Images
![Startup screen](https://i.imgur.com/saoDor8.png)
![Home screen](https://i.imgur.com/J4uI0np.png)
![Chat room screen](https://i.imgur.com/uRKSErl.png)
![Search dialog](https://i.imgur.com/UWqcoqj.png)

### B. Short description of the UI
The first prototype was just a quick sketch that we created using Adobe XD. The two main screens are the home screen and the chat room screen:
* Home screen: the only notable thing is the menu of chat rooms on the left, from which the user can join different chat rooms that he/she belong to. Clicking on the search bar makes the search dialog pop up.
* Chat room screen: the left menu next to the chat room menu allows users to switch between different text/voice channels. The chat window is in the center, and the right menu shows the room participants.

### C. Evaluation: User testing
For the first prototype, we simply asked 4 random users to explore our UI and think out loud. Here are their feedbacks for first prototype:
1. Lack of online/offline status indicators
2. It is hard to recognize the Discord icon as the "Return to Home screen" button
3. Confusion between chat rooms' icons and friends' avatars
4. There are troubles to read some texts due to theirs colors (this happened because of the projector's display)


## VII. Prototype 2
### A. Images
![Home Screen](https://i.imgur.com/z8ikerQ.png)
![Chat room screen](https://i.imgur.com/cr0LixB.png)
![Direct message screen](https://i.imgur.com/q4ZRwbu.png)

### B. Improvements
* Functional additions: 
    * Users can add friends
    * Users can send direct message to friends
* UI additions:
    * Add online/offline indicators: avatar + green dot for online users and grey avatar for offline users
    * Add a "Home" text hint under the Discord icon
    
### C. Evaluation: Focus group
For evaluating this prototype, we conduct a **focus group**. We presented our prototype in front of the whole class, and everyone was allowed to give opinions. The feedbacks are as follow:
1. It is better to have "Online friends" tab to be the default active tab
2. Redundant “Add friend” button next to “Find your friend” search box, since there are already add buttons next to each other users’ names
3. The search bar (next to the HOME icon) should have its placeholder changed to something more general
4. The menus for chat rooms and direct messages can be merged in order to avoid confusion
5. The search dialog blocks everything else from view

## VIII. Prototype 3
### A. Images
![Home Screen (Add friend tab)](https://i.imgur.com/4TPMTli.png)
![Home Screen (Online friend tab)](https://i.imgur.com/FR1bbYt.png)
![Search autocomplete](https://i.imgur.com/23RU0Ez.png)
![Utilities options](https://i.imgur.com/o1b0hMm.png)
![Chat room screen](https://i.imgur.com/1LRTr08.png)
![Joining a voice channel](https://i.imgur.com/B2qnsNr.png)
![Joining a text channel](https://i.imgur.com/7yVa420.png)


### B. Improvements
* UI Changes:
    * Merging the Direct Message session with the Chat room session
    * Remove the big blue "Add friend" buttons
    * Change the placeholder of the search
    * Make the Online tab to be activate by default 
    * Change the color of #Text channel and #Voice channel for better recognition
* Functional additions:
    * Search now has autocomplete
    * When joining a text channel or a voice channel, user's avatar will be shown to be just below the respective channel
 
### C. Evaluation: 
#### 1. Heuristic evaluation 
We found out that the application did not adhere to some of the design principles
* **Recognition rather than recall**: the option to add friends should be highlighted if a user is a new user - **Severity level 3**
* **Consistency**: "Server" and "Chat room" are used interchangeably, use "Chat room" as the offcial one - **Severity level 2**
* **Clearly marked exit**: A "back" button should be implemented - **Severity level 3**
* **Simple and natural language**: The placeholder "Find your friend" is somewhat incorrect. This should be changed - **Severity level 1**
* **Functional and UI problems**:
    * The columns in friends screen are not properly spaced
    * No buttons to video and voice call when in direct message
    * User avatars’ are small
    * Login dialog is not centered in the screen

#### 2. Predictive evaluation: KLM
* Task: visit a specific chat room, assuming that user has already logged in and is currently in the home screen

* Prototype 2:

    | Description | Operation | Time |
    |------------------------------------------------------------|--------------------|---------------|
    | Move mouse to the chat room menu's scroll bar | P[scroll bar] | 1.1 |
    | Click on the scroll bar | K[mouse] | 0.2 |
    | Drag the scroll bar until the user see the right chat room | P[drag scroll bar] | 1.1 |
    | Release mouse from the scroll bar | K[mouse] | 0.2 |
    | Move mouse to the chat room's icon | P[chat room icon] | 1.1 |
    | Click on the chat room's icon | K[mouse] | 0.2 |
    |  | Total | 3.9 |

* Prototype 3: 

    | Description | Operation | Time |
    |------------------------------------------------------------|--------------------|---------------|
    | Move mouse to the search bar | P[search bar] | 1.1 |
    | Click on the search bar | K[mouse] | 0.2 |
    | Home on keyboard | H[keyboard] | 0.4 |
    | Type in the name of the chat room | K * n | 0.2 * n |
    | Press enter | K[enter] | 0.2 |
    |  | Total | 1.9 + 0.2 * n |

* Conclusion: although the total time of Prototype 3 is not a constant, we believe that it is more convenient when the user has numerous different chat rooms

## IX. Prototype 4
### A. Images
![Chat room](https://i.imgur.com/4jWk4hf.png)
![Direct message](https://i.imgur.com/CUB3CDG.png)
![Joining Voice channel](https://i.imgur.com/LImZo8J.png)

### B. Improvements
* UI changes: adding avatar for user
### C. Evaluation: 
#### 1. User testing
This time, we defined some specific tasks and observe how users execute them. We asked 4 people to do the testing for us:
* Le Phuong Linh (Student in Foreign Trade university)
* Nguyen Ngoc Trung (Student in USTH)
* Lai Khang Duy (Gaming gear store owner)
* Nguyen Duc Khai (Phd student in USTH)
##### Task 1: Find a direct conversation that is not visible in direct conversation session because the user has many conversations
User | Method used | Time completed (seconds) | Errors | Number of helps |
------------ | ------------- | ------------- | ------------- | -------------
Le Phuong Linh  | Rolling down the direct conversation menu | 3.97 | 0 | 0 | 
Nguyen Ngoc Trung | Use the search tool | 1.92 | 0 | 0 |
Lai Khang Duy | Use the all friends tab | 2.12 | 0 | 0 |
Nguyen Duc Khai | Rolling down the direct conversation menu| 5.4 | 1 | 0 |

##### Task 2: Join a voice channel in a chat room
User | Method used | Time completed (seconds) | Errors | Number of helps |
------------ | ------------- | ------------- | ------------- | -------------
Le Phuong Linh  | <ul> <li> Join a chat room and by using the searching tool</li> <li> Click on the chat channel</li>  </ul>  | 4.23 | 0 | 0 | 
Nguyen Ngoc Trung | <ul> <li> Join a chat room by clicking on a chatroom on the chat room session</li> <li> Click on the chat channel</li>  </ul> | 1.2 | 0 | 0 |
Lai Khang Duy | <ul> <li> Join a chat room by clicking on a chatroom on the chat room session</li> <li> Click on the chat channel</li>  </ul> | 1.42 | 0 | 0 |
Nguyen Duc Khai | <ul> <li> Join a chat room by clicking on a chatroom on the chat room session</li> <li> Click on the chat channel</li>  </ul>| 1.38 | 0 | 0 |
##### Task 3: Send a picture to one of your friends
User | Method used | Time completed (seconds) | Errors | Number of helps |
------------ | ------------- | ------------- | ------------- | -------------
Le Phuong Linh  | <ul> <li> Click on a direct message </li> <li> Click on the picture icon (need help)</li>  </ul> | 6.22 | 0 | 1 | 
Nguyen Ngoc Trung | <ul> <li> Click on a direct message </li> <li> Click on the picture icon </li>  </ul> | 1.79 | 0 | 0 |
Lai Khang Duy | <ul> <li> Click on a friend avatar in "All Friends" tab </li> <li> Click on the picture icon </li>  </ul> | 2.44 | 0 | 0 |
Nguyen Duc Khai | <ul> <li> Click on a direct message </li> <li> Click on the picture icon </li>  </ul>| 2.31 | 0 | 0 |

#### 2. Questionaires results
|  | I found the application to be simple | I could use it without having to learn anything new | I found various functions were well integrated   | I would imagine my friend would learn to use Discord easily  | I find it easy to create a chat room | I found Discord had no effect on game's performance  | How likely are you to recommend Discord to others?  |
|---------|--------------------------------------|-----------------------------------------------------|--------------------------------------------------|--------------------------------------------------------------|--------------------------------------|------------------------------------------------------|-----------------------------------------------------|
| User 1 | 3 | 3 | 4 | 4 | 4 | 4 | 4 |
| User 2 | 4 | 3 | 4 | 4 | 3 | 4 | 4 |
| User 3 | 2 | 1 | 2 | 3 | 2 | 3 | 2 |
| User 4 | 4 | 3 | 3 | 4 | 4 | 3 | 4 |
| User 5 | 4 | 4 | 4 | 3 | 4 | 3 | 4 |
| Average | 3.4 | 2.8 | 3.4 | 3.6 | 3.4 | 3.4 | 3.6 |


## X. Heuristic evaluation for another group (Restaurant suggesting application)
Three members from our group performed heuristic evaluation for this application and found out that it violated some of the heuristic principles. 

Here is a short summary of our feedbacks, each feedback is associated with a severity level:
* Consistency:
  * Price range is shown in the restaurant list screen, but not in the restaurant detail screen - **Severity level 3**
* Efficiency of use:
  * The filter list is too long, should be segmented into different catogeries - **Severity level 3**
  * The time and date selectors in the book table screen is very tedious to use, definitely need redesign - **Severity level 4**
* Other comments on functions and UI:
  * The ingredients section in the restaurant detail is presented as a paragraph, hard to read - **Severity level 2**
  * The "Order" button is a little bit hard to recognize - **Severity level 2**
  * In the restaurant detail screen, the restaurant menu should be shown before the customers' reviews - **Severity level 1**
 
