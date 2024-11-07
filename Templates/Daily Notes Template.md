# Good morning NK!
### Today is {{Date: dddd, MM-DD-YYYY}}
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
<%*
const searchTerm = "- [ ]"; // This is the syntax for unchecked to-dos in Obsidian
const files = app.vault.getMarkdownFiles();
let todos = [];

for (const file of files) {
    const content = await app.vault.cachedRead(file);
    
    // Find all lines with unchecked to-dos
    const matches = content.match(/^ *- \[ \] .+/gm);
    
    if (matches) {
        todos.push(`#### ${file.basename}`);
        todos.push(...matches);
    }
}

if (todos.length > 0) {
    tR += `### Current To-Dos:\n` + todos.join("\n");
} else {
    tR += "No current to-dos found.";
}
%>

Good luck out there! Remember to eat, sleep, and stay hydrated :D

<%*
const fortunesFile = tp.file.find_tfile("fortunes");
const fortunesContent = await app.vault.read(fortunesFile);
const fortunesArray = fortunesContent.split("%").map(fortune => fortune.trim()).filter(fortune => fortune);
const randomFortune = fortunesArray[Math.floor(Math.random() * fortunesArray.length)];
tR += `Quote of the Day:\n> ${randomFortune}`;
%>


