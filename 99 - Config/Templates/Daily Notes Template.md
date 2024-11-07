# Good morning NK!
### Today's #DailyNote is for {{Date: dddd, MM-DD-YYYY}}
<<<<<<< HEAD
No classes scheduled for today.
------------
### Current To-Dos
#### 11-07-2024
- [ ] COSC350 research proposal 11/10
- [ ] MATH330 HW 11/13 
- [ ] Cosc435 work on project (ongoing)
- [ ] Memorize OL packet
- [ ] COSC435 Assignment 6 11/24
- [ ] study for MATH330 quiz (ch8,9)
#### 11-06-2024
- [ ] COSC350 research proposal 11/10
- [ ] MATH330 HW 11/13 
- [ ] Cosc435 work on project (ongoing)
- [ ] Memorize OL packet
- [ ] COSC435 Assignment 6 11/24
- [ ] study for MATH330 quiz (ch8,9)
#### Tasks
- [ ] COSC350 research proposal 11/10
- [ ] MATH330 HW 11/13 
- [ ] Cosc435 work on project (ongoing)
- [ ] Memorize OL packet
- [ ] COSC435 Assignment 6 11/24
- [ ] study for MATH330 quiz (ch8,9)

----------
### Quote of the Day:

 I never thought that I'd see the day where Netscape is free software and
X11 is proprietary.  We live in interesting times.
	-- Matt Kimball <mkimball@xmission.com>
=======
<%*
const file = tp.file.find_tfile("Classes");
const content = await app.vault.read(file);

// Get the current day name
const day = tp.date.now("dddd"); // "dddd" returns the full name of the day

// Updated regex to capture all lines under the day's heading until the next heading or the end of the file
const regex = new RegExp(`## ${day}\\n((?:- .+\\n?)*)`, "m");
const match = content.match(regex);

if (match) {
    const classes = match[1].trim();
    tR += `### ${day}'s Classes\n${classes}`;
} else {
    tR += "No classes scheduled for today.";
}
%>
------------
<%*
const searchTerm = "- [ ]"; // This is the syntax for unchecked to-dos in Obsidian
const files = app.vault.getMarkdownFiles();
let todos = [];

// Specify the folder to exclude (e.g., "Archived/")
const excludeFolder = "DailyNotes/";

for (const file of files) {
    // Skip files in the specified folder
    if (file.path.startsWith(excludeFolder)) continue;

    const content = await app.vault.cachedRead(file);

    // Find all lines with unchecked to-dos
    const matches = content.match(/^ *- \[ \] .+/gm);
    
    if (matches) {
        todos.push(`#### ${file.basename}`);
        todos.push(...matches);
    }
}

if (todos.length > 0) {
    tR += `### Current To-Dos\n` + todos.join("\n");
} else {
    tR += "No current to-dos found.";
}
%>

----------
<%*
const fortunesFile = tp.file.find_tfile("fortunes");
const fortunesContent = await app.vault.read(fortunesFile);
const fortunesArray = fortunesContent.split("%").map(fortune => fortune.trim()).filter(fortune => fortune);
const randomFortune = fortunesArray[Math.floor(Math.random() * fortunesArray.length)];
tR += `### Quote of the Day:\n\n ${randomFortune}`;
%>
>>>>>>> 2d4638f7d6963f0df6851b641b0dc4adb2afa20e

-------

Good luck out there! Remember to eat, sleep, and stay hydrated :D
Today's lecture notes are linked below!