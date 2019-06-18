ReadMe
Lab1:
The index of the optionSet and option are staring from 0.
For example, the user want to get the optionSet "color" which is in the index 0 of the array.
User will enter 1 to access it.
But for now, the user still need to enter 0 to access it because it is not necessary to interact with real user yet.
Lab2:
For catch exceptions in FileIO, it asks user to input the correct line again if there is error in the line. 
Since the size of array is limited, it cannot expand. When using try/catch, the size of optionSet and size of option has to be same number as original.
User has to enter the correct sizes to void the exception that not in AutoException.

Lab2:
For testing exception in ProxyAutomobile.java, the working example is for testing updateOptionSetName.
The program will be execute one. First, it will try to run all method in the main, then fix the errors and 
execute method again.
If update file failed, it will display a message and user could run program again and fix the error.
The user must enter the correct optionSet name like "Color" to successfully update the name.
The program could not clear the errors that found in proxyAuto so it need to manually delete the errorFile.dat
after execute once.

Lab3:
Using array list to manage the option set and options and using linked hash map to manage cars. 

Lab4:
Adding the editInterface so I can control what user accesses the data.
Synchronized the methods in the HelperEidit class.
Muli threading so the program could run fast when there are muli users. 
The drive tests the methods by non-synchronized, and synchronized.
Lab5:
Using server communicate with client. 
Parse properties object to new automobile object.
Server could accept string buffer or properties object and create an automobile. Then save it into LikedHashMap.
Client upload different types of files. After receive the automobile that client asks for, it will ask user to choice the options.
Usage: use ip address of the computer and an available port to create the socket that connect server and client. 
Start client first, and we could start muli clients. 