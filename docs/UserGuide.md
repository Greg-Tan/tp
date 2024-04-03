1---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# InsureBook User Guide

InsureBook is a **desktop app for insurance agents to manage potential and existing clients' personal and policy details.** The app has a Graphical User Interface (GUI), but most user interactions occur via a Command Line Interface (CLI). If you can type fast, InsureBook can get your client management tasks done faster than traditional GUI apps!

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

*The InsureBook .jar file is not available for download yet. These instructions will be applicable when it is released in the future.*

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `InsureBook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

3. Copy the file to the folder you want to use as the _home folder_ for InsureBook.

4. Open a command terminal and `cd` into the folder you put the jar file in. Alternatively, <br>**[Windows]** right-click anywhere in the display pane's background, then click "Open in Terminal":

   <img src="images/OpenInTerminal.png" alt="Open in Terminal" width="483" height="275"/>

**[macOS]** right click on the _home folder_ and click "New Terminal at Folder":

   <img src="images/NewTerminal.png" alt="New Terminal at Folder" width="498" height="450"/>

5. Type `java -jar insurebook.jar` to run the application.<br>
   A GUI similar to the one below should appear in a few seconds. Note that the app contains some pre-loaded sample data.<br>
   ![Ui](images/Ui.png)

6. Type your command into the user input box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all clients.

   * `add n/John Doe p/98765432 e/johnd@example.com a/123 John Street m/2024-08-02 10:00` : Adds a contact named `John Doe` to your InsureBook.

   * `delete 3` : Deletes the 3rd client shown in the current list.

   * `clear` : Deletes all clients.

   * `exit` : Exits the app.

7. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help : `help`
Shows the link to the User Guide and Command Summary of InsureBook.

Format: `help`

### Adding a client : `add`

Adds a client, together with their name, phone number, email, address and meeting date and time into InsureBook.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS m/MEETING_DATE MEETING_TIME [t/TAG]...`

<div style="border: 1px solid #007bff; background-color: #cce5ff; padding: 10px; border-radius: 5px;">
    <span style="font-size: 20px; color: #007bff;">&#x1F4A1;</span> <strong>Tip:</strong>
    Meeting field input cannot be a date and time in the past! 
</div>
<br/>
<div style="border: 1px solid #007bff; background-color: #cce5ff; padding: 10px; border-radius: 5px;">
    <span style="font-size: 20px; color: #007bff;">&#x1F4A1;</span> <strong>Tip:</strong>
    It is optional for the client to have tags. A client can have any number of tags (including 0).
</div>

Examples:
* `add n/Jenny Chen p/91234567 e/jenjenc@gmail.com a/688, Yio Chu Kang Ave 5, #04-25 m/2024-10-12 14:00`
* `add n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 m/2024-07-12 12:00 t/friends`
* `add n/Jack Daniel p/91118932 e/jackys@hotmail.com a/291, Woodlands Dr 89, #08-56 m/2025-02-20 10:00 t/acquaintence t/schoolmate`

### Listing all clients : `list`

Shows a list of all clients in InsureBook.

Format: `list`

### Editing a client : `edit`

Edits an existing client in InsureBook.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [m/MEETING_DATE MEETING_TIME] [t/TAG]...`

* Edits the client at the specified INDEX. The index refers to the index number shown in the displayed client list. The index must be a positive integer 1, 2, 3, …​
* At least one of the [optional] fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the client will be removed i.e adding of tags is not cumulative.
* You can remove all the client’s tags by typing t/ without specifying any tags after it.

Examples:
* `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st client to be `91234567` and `johndoe@example.com` respectively.
* `edit 2 n/Jinny Tan t/friends` Edits the name of the 2nd client to be `Jinny Tan` and overrides existing tags with the `friends` tag.
* `edit 4 n/Betsy Crower t/` Edits the name of the 4th client to be `Betsy Crower` and clears all existing tags.

### Locating clients by name : `find`

Finds clients whose names contain any of the input keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Both full and partial words will be matched e.g. `Han` will match `Hans`
* Clients matching at least one keyword will be returned (i.e. `OR` search). e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:

`find Joh` returns `Johnny Daniels` and `John Doe`
`find alex david` returns `Alex Yeoh`, `David Li`

### Deleting a client : `delete`

Removes an existing client based on their index from InsureBook.

Format: `delete INDEX`

* Deletes the client at the specified `INDEX`.
* The index refers to the index number shown in the current displayed client list.
* The index **must be a positive integer between the numeric range of contacts in the address book.**

Examples:
* `list` followed by `delete 2` deletes the 2nd client displayed in InsureBook.
* `find Betsy` followed by `delete 1` deletes the 1st client in the results of the find command.

### View a client's complete profile : `view`

Expands a client's profile such that the user can see all policies and policy details.

Format: `view INDEX`

Examples:
* `view 1` will show all policies and policy details of the 1st client displayed in InsureBook.
* `find Bern` followed by `view 2` will show all policies and policy details of the 2nd client in the results of the find command.

### Adding a new policy to a client : `addPolicy`

Adds a new insurance policy to a specific client.

Format: `addPolicy INDEX pol/POLICY`

* Adds a policy to the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer between the numeric range of contacts in the address book.**
* `POLICY` is the name of the policy to be added

Examples:
* `addPolicy 1 pol/SuperSaver type/CI polnum/39376234 pterm/ANNUALLY prem/3000 b/100000`

### Deleting an existing policy from a client : `delPolicy`

### Locating clients via Policy Name : `findPolicy`

### View the lists of meetings for this week : `meetings`

Opens a new window containing a list of all meetings for this week, in chronological order. <br>
Meetings are considered to be scheduled for the current week if they are within the same Monday to Sunday block: <br>
e.g. If today is Tuesday (2nd April), then meetings scheduled from Monday (1st April) to Sunday (7th April) will be displayed.

<img src="images/SameWeekCalendar.png" alt="SameWeekCalendar" width="467" height="326"/>

Meetings will be displayed as: "Number | < Meeting Date & Time > with: < Client Name >". The meetings window can be closed by simply pressing 'Esc' on your keyboard.

<img src="images/MeetingsWindow.png" alt="MeetingsWindow" width="467" height="326"/>

Format: `meetings`

### Clearing all client entries : `clear`

Clears all client entries from InsureBook.

Format:`clear`

### Exiting InsureBook : `exit`

Exits Insurebook and closes the application window.

Format:`exit`

#### Saving data in InsureBook

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous InsureBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action     | Format, Examples
-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Add**    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear**  | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find**   | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List**   | `list`
**AddPolicy** | `addPolicy i/INDEX n/POLICY`<br> e.g., `addPolicy i/4 n/SuperSaver`
**Help**   | `help`
**Exit**   | `exit`
**Meetings** | `meetings`
