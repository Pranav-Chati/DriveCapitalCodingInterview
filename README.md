# Drive Capital Coding Interview
## Testing My Submission
In order to test my submission, you would need to first download the repository onto their computer. There are two ways to do this:
1) Clone the repository by getting the HTTPS link of the github
2) Downloading a zip file of the program and then extract contents in your desired folder

Once you have the program locally, open it in Eclipse or an IDE of your choice that can run Java files. Once the program is opening up on your choice of IDE,
run the program by inputting the file to be analyzed. The file that needs to be analyzed will either be in your data folder of the project OR you could put your own file address.

There are a few test files to test various solutions, but please feel free to create another test case of your choice. Please read below to show certain assumptions of the code.

## Approaching the Problem
I thought of using a public class that contains information about the employees the company has and the partner relationships with certain employees. This allows to easily figure out which partner had the strongest relationship and which employees were in the company itself. I used an arraylist to keep track of all the partners names, a map of comapnies where the key was the company name(String) and the value be the associated company class(Company), and then a map of employees where the key was the employee name(String) and the value was the company name(String).

I parsed through each line of the input text file, and then took the first word of each line to see what command was being ran. I made sure to uppercase all of the letters when testing the commands just in case a typo was made with the commands. Each switch case for the various commands have specific statements that run. Overall, there are quite a few while and for statements that get ran.

The  while loop to parse through the text file runs in O(n). While using the .split method runs in O(n) time, that time can be amoritzed to be O(1) since the length of the line will always be four to five words (assuming the company does not have a ridiculously large name). However, my initial program ran in O(n^2) because the last for loop that outputs everything to the console runs a method that also runs a for loop. A solution to this that I implemenetd is to keep a variable that has the strongest partner relationship that gets adjusted when the contact command is called.

## Assumptions
1) The employee and partner names are each one word which consis of the upper and lowercase characters A thru z. i.e. "James" is one word
2) Company names can be any size of words. i.e. the company "Urban Outfitters", "Kentucky Fried Chicken", "ACME" are all possibilities
3) The declarations are done before. i.e. an individual can't type "Contact Molly Chris coffee" if Molly or Chris has not been declared as an employee or partner, respectively
4) Company names are globally unique

Some possible flaws:
1) My solution does not save the name of a company in the Company object but uses the map to figure out the name

Possible Boundary Cases:
- Entering a wrong command (i.e. "Software Engineer")
- Entering an extra white space after each text

## Clearing up any confusions
In the sample text, the partner labeled was mark, but at the bottom it was Molly. I believe Molly and Mark are suppose to be the same people, if not, Molly was not properly declared as a partner.


## More in depth approach
Initially when taking a look at the problem, the first two issues that came into mind were:
1) how to segment the file
2) how to keep track of interactions between all of the people

Parsing the file could be done using the BufferedReader class that java libraries had. With this class, you could read an entire line manipulate it in whatever fashion. I manipulated the line by placing all the words into an array by using the .split() method. Since I know the file needs to be formatted correctly, I know the very first index of the near word array will be the initial command ("Partner", "Employee", etc.). Using this array of commands, I was able to easily call upon the employees Name, the partners name, and etc. It all depended on the specific command that was being ran.

For the second problem of keeping track of all the interactions, I initially thought of creating two public classes: a partner class and a company class.
- The company class would have a private string company name variable, a private sequence of strings that contains all of the employees associated with the company.
- The partner class would just have a String as a name and an amount of connections represented as an integer.

After further investigation, I realized the partner class isn’t really a feasible option since counting the connections in a partner class would just count an overall number of companies they are linked too rather than the individual companies. I switched over to a map in the company class that has a string datatype as a key (which was the PartnerName) and then an integer with the number of occurrences. An issue that may arise is handling if a partner has multiple contacts. To resolve an issue like that an if statement would need to be created which checks if a partner is already contained. If it is, then remove that partner which would return the value. Then, increment the value by one. Finally, place the Key and Value pair back into the map with the updated connections. 

Another issue that needs to be addressed if I have just a Map with a PartnerName and their COnnections, it hides the information corresponding to how the partner knows the company (aka the employee). I solved this by having a Queue of type String as the value of each Key. That way whenever a new employee was added to a preexisting partner, I would simply added the EmployeeName and the ContactType to the Queue. I don't need to worry about removing the key and value pair since Queue's are mutable and I can change them with just a reference. This explained more below.


Another problem that was run into was how to properly write the code for the employee command. There are three cases:
- The best case is that the <employeeName> and <companyName> are both one word
- The middle case is that one of the types (<employeeName> or <companyName>) are one word
- The worst case is that the <employeeName> and <companyName> are both an infinite number of words.

For this scope of the problem, I am assuming that the <employeeName>  and the <partnerName> will be one word and that the <companyName> can be as many words. This means that the <companyName> can be 1 or more words. One word means like "James" or "Mark." Two words means like "James McArthur."

The hardest functionality to figure out was how to create an interaction between the Partner and the company. When I initially had a partner class, I thought of having a number of occurrences, but that may have been really difficult and bad practice. I shouldn't two classes that depend on each other since if one class breaks, then the other can respond in an infinite number of ways. I decided the best option would be to maintain a list of partners that are connected with the company in the company class itself. I did this with a map that uses a string datatype as the key but a Queue<String> as the value. The Queue<String> will contain information about the employee and the mode of contact the specific partner has with the company. A problem that arose from this was, how do you tell if an employee is from a certain company in the main method? Since it is given that the employee names are globally unique, I created a map of String Keys and Pairs in the main method where the Key was the EmployeeName and the Pair was the company Name. What this allows me to do is when given an EmployeeName, I can find the companyName by getting the value of the key. After getting the company name, I can then use the Map<String, Company> and find the Company class associated with the speific company name. From there, I manipulate the Map associated with Partner and Company interactions.
