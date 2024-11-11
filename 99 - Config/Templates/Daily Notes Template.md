# Good morning NK!
### Today's #DailyNote is for {{Date: dddd, MM-DD-YYYY}}

<<[[<%tp.date.now("MM-DD-YYYY", "P-1D") %>]] <<
\>>[[<%tp.date.now("MM-DD-YYYY", "P+1D")%>]]>>

------------
<%*
// Script to read the day's classes defined in "99 - Config/Classes", and create a new file for each based on the given template in "99 - Config/Templates".

const file = tp.file.find_tfile("Classes");
const content = await app.vault.read(file);
const sem = "06 - Fall '24"; // Change this for a new semester!

// Get the current day name.
const day = tp.date.now("dddd"); // "dddd" returns the full name of the day.

// Updated regex to capture all lines under the day's heading until the next heading or the end of the file.
const regex = new RegExp(`## ${day}\\n((?:- .+\\n?)*)`, "m");
const match = content.match(regex);

if (match) {
    const classes = match[1].trim().split("\n").map(line => line.replace("- ", ""));
    tR += `### ${day}'s Classes\n`;
    
    for (const className of classes) {
        const newFileName = `${sem}/${className}/Day X Lecture Notes`;
        const templatePath = `99 - Config/Templates/${className}_Template`; // Adjust this to the path of your template.
        
        // Create a new note for each class using the template path as the first argument
        
		await tp.file.create_new(tp.file.find_tfile(templatePath), newFileName, false)

        
        // Link to the newly created file
        tR += `- [${className}](${newFileName})\n`;
    }
} else {
    tR += "No classes scheduled for today.";
}
%>


------------
<%*
//script to gather and display all unchecked todos

const searchTerm = "- [ ]"; // This is the syntax for unchecked to-dos in Obsidian
const files = app.vault.getMarkdownFiles();
let todos = [];

// Specify the folder to exclude (e.g., "Archived/")
const excludeFolder = "01 - DailyNotes";

for (const file of files) {
    // Skip files in the specified folder
    if (file.path.startsWith(excludeFolder)) continue;

    const content = await app.vault.cachedRead(file);

    // Find all lines with unchecked to-dos
    const matches = content.match(/^ *- \[ \] .+/gm);
    
    if (matches) {
        todos.push(`#### [[${file.basename}]]`);
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
//script to read a random fortune defined in "99 - Config/fortunes". Note the delineator is "%".

const fortunesFile = tp.file.find_tfile("fortunes");
const fortunesContent = await app.vault.read(fortunesFile);
const fortunesArray = fortunesContent.split("%").map(fortune => fortune.trim()).filter(fortune => fortune);
const randomFortune = fortunesArray[Math.floor(Math.random() * fortunesArray.length)];
tR += `### Quote of the Day:\n\n ${randomFortune}`;
%>

-------
Good luck out there! Remember to eat, sleep, and stay hydrated :D
Today's lecture notes are linked below!