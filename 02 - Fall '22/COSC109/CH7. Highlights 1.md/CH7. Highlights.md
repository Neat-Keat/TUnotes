Pp.674-779

**HIGHLIGHTS**

- WWW and HTML
- HTML basics and tech behind client/server networks
- How to create and manage project files and website assets
- How to research, plan, design, produce, upload, and test basic websites
- Separate meaning from presentation and accessibility
 
**HOW THE WEB WORKS**
 
WWW /= Internet

- Web is a part of the internet
- WWW invented by Tim Berners-Lee
    
    - “global network of networks through which computers communicate by sending information in packets. Each network consists of computers connected by cables or wireless links.”

Computers communicate thru various network protocols  
Internet includes email, the Web, File Transfer Protocol, and others
 
Sputnik > ARPA > ARPANET > Internet  
￼Tim Berners-Lee proposed linking documents thru hypertext  
This turned into the WWW, which includes HTML, URL, and Web Browsers  
1st web server on 12/25/1990
 
World Wide Web Consortium (W3C) created in 1994
 
**DEMISTIFYING CODE**
 
Web pages are built on HTML  
This focuses on HTML5, and some of HTML4.01
 
HTML5 has built in support to play media files  
HTML5 frees devs from relying on JavaScript and Flash  
HTML5 supports many HTML4.01 standards
 
Dreamweaver, WordPress, Blogger, and Wix all do the same thing  
What-You-See-Is-What-You-Get (WYSIWYG) editing functions
 
HTML has limitations  
Understand them so WYSIWYG editors are easier  
WYSIWYG isnt always efficient/precise
 
CSS is better when in a separate file from HTML  
Good web devs use HTML to label pieces of docs according to their functions and uses CSS to control visuals and behaviors
 
<b></b> IS NOT THE SAME AS <strong></strong>  
Both bold text, but strong changes how TTS software reads it
 
Same with <i><i/> and <em></em>
 
Basic HTML TAGS

- <div>
- <p>
    
    - <h1>
    - <h2>
    - <h3>
    - <h4>
    - <h5>
    - <h6>
- <ul>
- <ol>
- <dl>
- <li>
- <dt>
- <dd>
- <table>
- <caption>
- <thead>
- <tfoot>
- <tbody>
- <tr>
- <td>
- <a>
- <img>
- <em>
- <strong>
- <style>￼

HTML DOCS ARE DIVIDED LIKE THIS:

- Declarations
- Head
- Body
 
Nest your tags
 
_Block-level elements_ deal with more info and start on new lines

- Paragraphs
- Lists
- List items

_Inline elements_ control small chunks of info, and are used w/in a block

- Strong tags
 
You can nest some BL in BL, any I in BL, but NO BL in I
 
HTML wont put in extra spaces without commands  
HTML generally isnt case sensitive  
Using lowercase is best bc:  
Easier to read  
Exceptions exist  
Most devs use lowercase  
Preps you to branch out to case sensitive coding lands
 
Special characters are always declared starting with an "&"  
Over 2200 lol
 
**BROWSERS**  
Code is sometimes interpreted differently in different browsers  
Code is sometimes interpreted differently in different browser versions  
Code is sometimes interpreted differently in OSes
 
Some browsers don’t follow W3C standards and require special programming  
IE 6 LMFAO
 
Most graphical browsers rely on plug ins for non HTML content  
Video, Flash, Acrobat, MS Word files
 
Don’t rely too heavily on plug ins when designing a site lol
 
HTML makes lots of plug ins obsolete
 
Some text-based browsers are still around  
Lynx and Bobcat
 
**THE NETWORK**
 
Theres HTTP, HTTPS, FTP, RTSP
 
The end of a URL, like .com, is a Top-Level Domain (TLD)  
The part between www and com is called the second-level domain  
Some orgs may use 3rd and 4th level domains  
www is a local host name
 
>go to domain name registry service  
>see a funny name is available  
>license the name for a year  
>rent a server  
>new owner of [www.fuckgingers.com](http://www.fuckgingers.com) B)
 
**PLANNING SITE STRUCTURE AND NAVIGATION**
 
Make files locally, transfer to server  
Gives you a preview  
You have backups locally
 
**DEFINING A SITE AND THE "ROOT FOLDER"**
 
Root folder contains all subsequent files
 
Youll publish with FTP  
Know the FTP server name
 
File Naming Conventions  
Index.html = main page  
Use EITHER .htm OR .html, but not both in the same project  
Name everything .jpg instead of .jpeg  
Keep file names lowercase  
Don’t use spaces  
They get replaced with %20 in URLS  
If you NEED to, use underscores instead  
Only use letters, numbers, underscores, or hyphens  
Don’t use non-english letters  
Don’t use periods, they're there to separate name from extension
 
**ESTABLISHING A HIERARCHY**

- Home
- Main Pages
- Content Pages
 
3 click rule
 
**MAINTAINING SITE UNIFORMITY AND CONSISTENCY**
 
Repeating components should stay in the same spot
 
Make everything user-centered from the start
 
**CREATING AND MANAGING HYPERLINKS**
 
**LINKING WITHIN THE WEBSITE**
 
Links work by using anchor elements (<a></a>) with a hypertext reference attribute (href)
 
Relative vs absolute URL  
Relative is within the same site  
Absolute is to another site, includes protocol
 
Linking images requires:  
Src  
Width  
Height  
Alt
 
**BUILDING TABLES**
 
<caption>: title for whole table  
<thead>: labels for columns  
<tfoot>: optional for a footer  
<tbody>: cells in the body  
<tr>: table rows  
<th>: table headers  
<td>: table data
 
**CSS**  
4 ways to implement style choices:  
Standard HTML in the body  
Inline style tags in the body  
Style tag in the head of a page (internal style sheet)  
External style sheet (CSS) (best option)
 
You can have multiple style sheets and select when to use what
 
**CHARACTERISTICS OF APPEARANCE**  
Margins  
Background and Text Colors  
Font Type and Style  
Absolute Sizes (1-7)  
Relative Sizes  
Link Characteristics  
Unvisited a:link  
Hover a:hover  
Active a:active  
Visited a:visited
 
**CHECKING YOUR CODE AND COMPATIBILITY**  
[http://validator.w3.org](http://validator.w3.org)  
[http://jigsaw.w3.org/css-validator](http://jigsaw.w3.org/css-validator)  
[http://wave.webaim.org](http://wave.webaim.org)
 
Make sites accessible lol  
Alt text  
Tab order

![hrtl Figure 7.10 A hierarchical site map. ](Exported%20image%2020240525202902-0.png) ![header: logo 8 site title nav footer main: page title & content aside: pictures :igure 7.11 Elements on the page. ](Exported%20image%2020240525202902-1.png) ![Urt&edLÉt 1<116 dub RerderdLits UrcrÉedLÉt •teml •tem2 •tem3 List 1<11 b 24'li> k'li> List l.iteml litem2 3. item) Descripticn Le: Destipti:n IX: term I defirâon I term 2 defirâon2 term 3 defiràon3 Figure 7.12 The three types Of lists. ](Exported%20image%2020240525202902-2.png)