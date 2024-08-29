Midterm review
 
------------------------------------------------------------------------------  
The basis of comp sci is controlled access – someone is authorized to take actions on something  
We need to be sure who the someone is

- ID
- Authentication

And give them appropriate access: access control
 
Access Control  
The process of granting or denying specific requests to

1. Obtain and use info and related info and computing services
2. Entering specific physical facilities (federal buildings, etc)    

Definitions  
Access Controls:  
Sec features that control how users and systems comm and interact with other systems and resources  
Access  
The flow of info between a subject and resource  
Subject  
An active entity that requests access to a resource or the data within a resource. Ex. User, program, process, etc.  
Objects  
Things on which an action can be performed, such as files, tables, and users  
Resource  
An entity that contains the information. Ex Computer databse, file, program, printer, etc.
 
CIA Triad  
Access controls give orgs the ability to control, restrict, monitor, and protect resource availability, integrity, and confidentiality
 
**Challenges**

- Various types of users need different levels of access
- Resources have different classification levels
- Diverse ID data must be kept on diff types of users
- The corporate environment is continually changing
 
Principles of least privilege  
If nothing has been specifically configured for an individual, the user should not be able to access that resource (Default no access)
 
Separation of duties  
Separating any conflicting areas of responsibility so as to reduce opportunities for unauthorized or unintentional modification or misuse of organizational assets and/or info
 
NEED TO KNOW: Based on the concept that individuals should be given access only to the info that they absolutely require in order to perform their job duties
 
Identification  
Describes a method of ensuring that a subject is who they claim to be

- A username or account #

Authentication  
The method of proving an ID

- Password, passphrase, PIN

Authorization  
The method of controlling the access of objects by the subject

- A user cannot delete a particular file after logging into the system
 
You MUST have this 3 step process to let a subject access an object
 
ID Management  
Management of the ID life cycle of entities during which:

- The ID is established
    
    - A name / # is associated to the subject
    - The ID is re-established: a new/ additional name/# is connected to the subject
- The ID is described
    
    - 1 or more attributes which are applicable to this particular subject or object may be assigned to the ID
    - The ID is newly described: 1 or more attributes which are applicable to this particular subject or object may be changed
- The ID is destroyed
 
ID Component Requirements  
When issuing IDs to users, ensure that:

- Each value is unique for user accountability
- A standard naming scheme is followed
- Values should be non-descriptive of the user's position or task (cs-admin is BAD)
- Values should NOT be shared
- A name or card # are examples of identifiers
 
Types of authentication

- Something you know
    
    - Passwords!
- Something you have
    
    - Devices or cat cards
- Something you are
    
    - Biometrics
 
Multi-Factor Authentication  
Auth with 2+ factors to achieve auth  
Adds additional security layer  
Unless all login items are obtained unauthorized access is prohibited

- Typically, a combination of Know and Have/Are
    
    - Password + auth app
    - Pin + RFID
    - Password + CAC
    - Password + texted code
    - Pin + fingerprint
- Auth to withdraw money
    
    - Have debit card
    - Know your PIN number
 
Popular auth apps/devices

- Google authenticator
- Microsoft authenticator
- Yubico's yubikey
- Duo security
 
Misuse of Auth

- Chances of adversary getting a pin number, fingerprint, RFID is good
- Chances of 2+ auth mechanisms is very low
 
-------------------------------------------------------------------------------------------------------
 
**Something you Know**

- Pins
    
    - 4+ #s
    - Passwords and passphrases
    - SSN
    - Patterns
- Least expensive, least secure
 
**Something you Have**

- A physical object to authenticate
    
    - Access card
    - Static/dynamic tokens
    - RSA secureID tokens
    - Smart Cards
    - RFID badges
    - SMS/Text
    - Auth apps
- Expensive, secure
 
**Something you Are**

- Verifies an individual's ID by analyzing a unique personal attribute or behavior
- Static biometrics
    
    - Fingerprints
    - Facial recognition
    - Iris scans
    - Hand geometry
    - Signature
- Dynamic biometrics
    
    - Voice recognition
    - Gait patterns
    - Typing patterns
      
    
 
----------------------------------------------------------------------------------------------------
 
Paper Systems and Digital Certificates

- Paper systems
- Digital Certificates (ex. SSL certificates)
    
    - Utilizes the Public Key Infrastructure
        
        - Supports encryption keys
    - Enables safe internet communication
      
    
 
Types of biometric system  
Fingerprint  
Uses ridge endings, bifurcation exhibited by the friction edges and some minutiae of the finger  
Palm scan  
Uses the creases, ridges, and grooves that are unique in each individual's palm  
Hand geometry  
Uses the shape (length, width) of a person's hand and fingers  
Retina scan  
Uses blood vessel pattern of the retina on the backside of the eyeball  
Iris scan  
Uses colored portion of the eye that surrounds the pupil. The iris has unique patterns, rifts, colors, rings, coronas, and furrows  
Keyboard dynamics  
Uses electrical signals generated while the user types in the keys (passphrase) on the keyboard  
Facial scan  
Based on the different bone structures, nose ridges, eye widths, forehead sizes and chin shapes of the face  
Hand topography  
Uses different peaks, valleys, overall shape and curvature of the hand
   

Iris Recognition

- Pattern in colored part of eye
- Uses a camera
- Very low false acceptance rates (FARs)
- Very expensive

Face Recognition

- Surreptitious ID is possible
- Surreptitious means without the subject's knowledge
- Apple FaceID

Voice Recognition

- High error rate
- Easily deceived by recordings

Recent advances in deep learning and AI helps a lot on biometric authentication
 
Enrollment Scan

- Scan data is variable
- Key features extracted from the scan

Feature comparison

- Later access attempts will be turned into key feature data comparison with the template
 
Is Biometric Auth really secure?
 
Biometric Authentication is usually considered to be more advanced than password or token due to its uniqueness and hardness to replicate  
Advantage:

- Cant be lost, stolen, forgotten, always at hand

Disadvantage:

- Physical characteristic can be variable from day to day or as people age
- Not exact
- False positives
- False negatives

Can you change your fingerprint or face?  
Revocation and reissue is difficult  
Good for physical security, not as useful for online  
Privacy challenges
 
False Acceptance Rates (FARs)

- % of people who are IDd who shouldn’t be
 
False Rejection Rates (FRRs)

- % of people who aren't IDd who should be
 
Which is worse?

- Situation dependent
 
|   |   |   |
|---|---|---|
|Situation|False Acceptance|False REjection|
|ID for comp access|Sec violation|Inconvenience|
|Verification for comp access|Sec violation|Inconvenience|
|Watch list for resource access|Sec violation|Inconvenience|
|Watch list for terrorists|Inconvenience|Sec violation|
 
Errors: when subject is not trying to fool the system  
Deception: when subject is trying to fool the system

- Hide face from cameras for face ID
- Impersonate someone with a gelatin finger

Many biometric methods are highly vulnerable to deception
 
Auth based on something you know

- Sec questions
- Password
    
    - Login to a system, id, and password are required
    - Password examples
        
        - Personal passwords (names, birthday)
        - Dictionary words (password)
        - Simple sentences (ILOVEYOU)
        - 123456, 0000, 1111
        - Aaaaaa, qwerty, asdfgh
        - …
 
Passwords

- The most common form of system ID and auth mechanism
- A password is a protected string of chars that auths an individual
 
Password Management

- Should be properly guaranteed, updated, and kept secret
- Password generators can be used to generate passwords that are uncomplicated, pronounceable, non-dictionary words
- If the user chooses their passwords, the system should enforce certain password requirements like insisting to use special characters, minimum # of characters, case sensitivity, etc.
 
Entropy

- More possible characters = greater cracking time
- 8 chars long
    
    - Only lower alpha = 208,827,064,576 possibilities
    - Upper and lower alpha = 9,682,651,996,416
    - Upper and lower + 0-9: 53,459,728,531,456

Letter and number substitutions don’t increase complexity or increase cracking time any significant amount as most password crackers automatically account for these
 
Common Password Rules (Microsoft)

- Store previous 3 passwords
- Pass age of 90 days
- 6+ characters in length
- Passwords cant contain the username or parts of the users full name
- Passwords must use at least 3 of the 4 char types (upper, lower, nums, special chars)  
Common Password Mistakes

- Reuse old passwords
- Permutations on old passwords
- Write passwords on paper
- Use the same pass across multiple locations
- Question password policies
- Share passwords with others
 
Hard for Humans != hard for computers  
20 years of effort = passwords are hard for humans to remember but easy for computers to guess
 
Attacking passwords  
12 steps

1. No password
2. ID to user ID
3. Is, or is derived from, the user's name
4. Common word list + common names and patterns
5. Contained in a short college dictionary
6. Contained in a complete English word list
7. Contained in common non-English-language dictionaries
8. Contained in a short college dictionary with capitalizations or substitutions
9. Contained in complete English dictionary with caps/subs
10. Contained in common non-English dictionaries...
11. Obtained by brute force, trying all possible combinations of alphabetic characters
12. Obtained by brute force, trying all possible combinations from the character set.
 
Defeating Concealment

- Operating systems usually store passwords in encrypted form (eg. Using 1-way hash function)
- Compromising the id-password list does not mean the attacks have access to the accounts
    
    - When a user creates a password, the OS accepts and immediately conceals it, storing the unreadable version
    - When the user attempts to authenticate, the typed string will be concealed using the same algorithm and compare with the stored one
    - Forgor your password? Only reset. (the systems do not know how to reverse it to get the original password)
    - Wrong passwords attempts, lock the account
 
Good passwords

- Use characters other than AZ, a-z
- Are long
- Avoid actual names or words
- Choose an unlikely password
- Change password regularly
- Don’t write it down
- Don’t tell anyone - Password checkers can be used to check the strength of the password by trying to break into the system
- Passwords should be encrypted and hashed
- Number of logon attempts should be limited
   

Techniques for passwords attack

- Electronic monitoring
    
    - Listening to network traffic to capture info, especially when a user is sending their password to an auth server. The password can be copied and reused by the attacker at another time, which is called a replay attack.
- Access the password file
    
    - Usually done on the auth server. The password file contains many users' passwords and, if compromised, can be the source of a lot of damage. This file should be protected with access control mechanisms and encryption
- Brute force attacks
    
    - Performed with tools that cycle thru many possible character, number, and symbol combinations to uncover a password
- Dictionary attacks
    
    - Files of thousands of words are used to compare to the user's password until a match is found
- Social engineering
    
    - An attacker falsely convinces an individual that they have the necessary authorization to access specific resources
 
Quiz covers up to slide 38?