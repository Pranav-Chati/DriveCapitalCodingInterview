# Drive Capital Coding Interview
## Testing My Submission
In order to test my submission, you would need to first download the repository onto their computer. There are two ways to do this:
1) Clone the repository by getting the HTTPS link of the github
2) Downloading a zip file of the program and then extract contents in your desired folder

Once you have the program locally, open it in Eclipse or an IDE of your choice that can run Java files. Once the program is opening up on your choice of IDE,
run the program by inputting the file to be analyzed. The file that needs to be analyzed will either be in your data folder of the project OR you could put your own file address.

There are a few test files to test various solutions, but please feel free to create another test case of your choice. Please read below to show certain assumptions of the code.

## Approaching the Problem
I thought of using a public class that contains information about the employees the company has, the partner relationships with certain employees, and 


Any assumptions your code makes about the input data or any possible edge cases you may discover
If an instruction is unclear, please reach out or document in the README your interpretation of the discrepancy

## Assumptions
1) The employee and partner names are each one word which consis of the upper and lowercase characters A thru z. i.e. "James" is one word
2) Company names can be any size of words. i.e. the company "Urban Outfitters", "Kentucky Fried Chicken", "ACME" are all possibilities
3) The declarations are done before. i.e. an individual can't type "Contact Molly Chris coffee" if Molly or Chris has not been declared as an employee or partner, respectively

Some possible flaws:
1) My solution does not save the name of a company in the Company object but uses the map to figure out the name

## Clearing up any confusions
In the sample text, the partner labeled was mark, but at the bottom it was Molly. I believe Molly and Mark are suppose to be the same people, if not, Molly was not properly declared as a partner.


## More in depth approach
Initially when taking a look at the problem, the first two issues came into mind
1 - how to segment the file really easily
2 - how to keep track of interactions between all of the people

I initially thought of creating two public classes, a partner class and a company class.
- The company class would have a private string company name variable, a private sequence of strings that contains all of the employees associated with the company.
- The partner class would just have a String as a name and an occurrences

After further investigation, I realized the partner class isn’t really a feasible option since counting the occurrences in a partner class would just count an overall number of companies they are linked too rather than the individual companies. I switched over to a map in the company class that has a string datatype as a key with the PartnerName and then an integer with the number of occurrences. An issue that may arise is handling if a partner has multiple contacts, but an if statement would need to be created for that. Another issue that needs to be addressed is, having just the partnername and their occurrences would hide the link to the company especially if that information wants to be found again.


Another problem that was run into was how to properly write the code for the employee case. There are three cases:
The best case is that the <employeeName> and <companyName> are both one word
The middle case is that one of the types (<employeeName> or <companyName>) are one word
The worst case is that the <employeeName> and <companyName> are both an infinite number of words.

For this scope of the problem, I am assuming that the <employeeName>  and the <partnerName> will be one word and that the <companyName> can be as many words. This means that the <companyName> can be 1 or more words. 

The hardest functionality initially was how to create an interaction between the Partner and the company. When I initially had a partner class, I thought of having a number of occurrences, but that may have been really difficult and bad practice to have classes a Partner Class and Company Class communicate with each other while also communicating with the main java program. I decided the best option would be to maintain a list of partners that are connected with the company in the company class itself. I did this with a map that uses a string datatype as the key but a Queue<String> as the value. The queue will contain information about the employee and the mode of contact the specific partner has with the company. A problem that arose from this was, how do you tell if an employee is from a certain company? Since it is given that the employee names are globally unique, I created a map of String Keys and Pairs where the Key was the EmployeeName and the Pair was the company Name. This map allows me to connect the specific employee to the company and create a partner connection to the company.
