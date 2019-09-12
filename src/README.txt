COL106 Assignment 3 README
Rohit Agarwal
2018EE10494

In this assignment we had to make a student database by use of hash tables. We made two implementations of the hash table - double hashing and separate chaining using Binary Search Trees.

Pair class:
It stores the key. It has two member variables - first and second to store the first and second name. It has a compareTo method which returns the comparison value of first variales of two pairs. (the first variable class also extends the Comparable class)
It also has a toString method where it returns the concatenation of first.toString() and second.toString().

Entry Class:
It has two variables which store an object and its key. It is entity which is stored in the array in the Double Hashing Hash Table and in the nodes of BST in SCBST.



Double Hashing:-
I maintain two arrays in my table- one stores the objects and other is a array of booleans of same size as table size which tells whether that index of table ever contained a now deleted object or not.
The second array is named 'check'. The second array helps in keeping the amorized time complexity for finding an element constant as now when searching through the table for an object with a given key, if we stumble upon an index at which the array of objects is empty and it never ever contained any value, we can be sure that the object is not present in the table and stop our search right there without checking further.
The reasoning behind this is that if the object would have been present, and it has not been found till now, then it must have gone through this index too, but we see that this index is empty and something was never deleted from it, means it was never reached by an object with the given key.
In contrast, if we do not mark indexes from which something was deleted, we would have to iterate through full table to be sure that the index in not present.
The worst case complexity remains same in both cases i.e. of order n, where n is the table size, which occurs when the object is found at the nth index, or when it is not present but all the null indexes were marked as their object been deleted.

insert():
The function searches through the table using hash values as indices to find the first empty place and goes ahead to check whether or not an object with same key already exists or not.
It also maintains a count which is incremented everytime a new hash value is calculated till the first empty place is found.
If the function finds an entry with same key already inserted, then it returns -1 (in which case E gets printed).
Else, it adds the object at the first empty position it found and returns the value of count.
The amortized time complexity of inserting is of constant order and worst case complexity is of order n, where n is the table size.

update():
It searches through the table till it is found and then updates the object stored to the given object.
It also maintains a count which is incremented everytime a new hash value is calculated.
If the object is not found then it returns -1 which leads to E being printed to console.
If object is found then it replaces that object with the new one and returns count.
The amortized time complexity of this is of constant order and worst case is of order n, where n is the table size.

delete():
It searches the key in the table and after finding the object, it deletes it by setting value at that index as null.
It also maintains a count which is incremented everytime a new hash value is calculated and is returned if object was found.
It also sets the value at index in check array as true indicating that this index had its value deleted.
It object is not found it returns -1 which leads to E being printed on the console.
The amortized time complexity of this is of constant order and worst case is of order n, where n is the table size.

getIndex() function:
A self introduced function which basically contains code to search for a given key and return the index where it is stored.
If it is not found then still an int is returned but this value is checked by the caller to see if the key searched is present at that the returned index or not.
It follows the searching method given above.
The amortized time complexity of inserting is of constant order and worst case complexity is of order n, where n is the table size.

contains():
It calls the getIndex function to get an index and checks whether an object with the given key is present at the index or not. Returns true or false accordingly.
It has the same time complexity as the getIndex function. The amortized time complexity of this is of constant order and worst case is of order n, where n is the table size.

get():
It calls the getIndex function to get an index and checks whether an object with the given key is present at the index or not. If true, returns the object stored at the index, else throws NotFoundException.
It has the same time complexity as the getIndex function. The amortized time complexity of this is of constant order and worst case is of order n, where n is the table size.

address():
It calls the getIndex function to get an index and checks whether an object with the given key is present at the index or not. If true, returns the index, else throws NotFoundException.
It has the same time complexity as the getIndex function. The amortized time complexity of this is of constant order and worst case is of order n, where n is the table size.



Separate Chaining:-
I made a new class that implementing BST with add, insert, update, delete, contains, get and address functions.
The SC class (the class implementing SCBST) maintains an array of BSTs.
The functions in the class defining the SCBST Hash table implementation simply calls the corresponding method of the BST stored at the index returned by the Hash function and return the values returned by the BST function (or throw exception if required).

Below are the explaination of functions defined in BST class.
Searching algorithm:
A common searching protocol is followed in each function.
It starts at the root of BST and compares the first name stored in given key with the first name stored in the key which is stored in the node. It value is <0, it goes to left, if >0, it goes to right. Then it repeats this process.
If the first name comes out to be the same, it then compares the concatenations of the first and second name and then goes left or right accordingly. If this too matches then we found the object and the search stops.
If it finds that the key value is less/greater than the value of key stored at the current position and the current node has no left/right child, then the search stops with conclusion that the object is not present.
If the root is null, then too it concludes that the object is not present.
This is done iteratively using while(true) loop and break statements.

add():
It searches for the position where the object is to be inserted using the above algorithm. If it finds that an object with the given key is already stored in the BST, then it returns -1 which leads to E being printed to the console.
It also maintains a count which is incremented each time the function reaches a new node and returns it is the object was added successfully.
The average time complexity here is of order log(lambda), where lambda is the load factor. (assuming that the entries are distributed evenly).
The worst case complexity is of order n, where is n the number of entries added in the hash table (occurs when all the entries have same hash value and are inserted in increasing or decreasing order).

update():
Follows the above algorithm to search for the given key and updates the object if it is found. If it is not found it returns -1 which leads to E being printed to the console.
It also maintains a count which is incremented each time the function reaches a new node and returns it is the object was updated successfully.
The average time complexity here is of order log(lambda), where lambda is the load factor. (assuming that the entries are distributed evenly).
The worst case complexity is of order n, where is n the number of entries added in the hash table (occurs when all the entries have same hash value and are inserted in increasing or decreasing order).

delete():
Follows the above algorithm to search for the given key but in this case it also stores the parent of the child. If it is not found it returns -1 which leads to E being printed to the console.

If the object is found then it follows the deletion algorithm described below-
Delete algorithm:
If node has no child: set the left or right child of parent null if it is left child or right accordingly.
If node has no child and it is the head: set the head of BST as null.
If node has only one child: copy the value of child into this node and set its child's children as its children.
If node has two children: Find the immediately smallest element by first going to the left and then going to the right till it reaches a node with no right child. This is done while also storing of the parent node of this node. Now copy the value of this node to the node which contains the object to be deleted, we are basically replacing the object to be deleted with the immediately smaller element. Now, we know that the node having the immediately smaller object does not have a right child, so to remove it, we set the left child of this node (if it exists) as the right child its parent node or set it to null it does not have left child too.
This is also done iteratively using while(true) and break statements.

It also maintains a count which is incremented each time the function reaches or promotes a new node and returns it is the object was deleted successfully.

The average time complexity here is of order log(lambda), where lambda is the load factor. (assuming that the entries are distributed evenly).
The worst case complexity is of order n, where is n the number of entries added in the hash table (occurs when all the entries have same hash value and are inserted in increasing or decreasing order).

contains():
Follows the above algorithm to search for the given key and returns true if it found else returns false.
The average time complexity here is of order log(lambda), where lambda is the load factor. (assuming that the entries are distributed evenly).
The worst case complexity is of order n, where is n the number of entries added in the hash table (occurs when all the entries have same hash value and are inserted in increasing or decreasing order).

get():
Follows the above algorithm to search for the given key and returns the object if it found. If it is not found it throws NotFoundException which is catched by the caller which again throws NotFoundException if it is catched.
The average time complexity here is of order log(lambda), where lambda is the load factor. (assuming that the entries are distributed evenly).
The worst case complexity is of order n, where is n the number of entries added in the hash table (occurs when all the entries have same hash value and are inserted in increasing or decreasing order).

address():
It also follows the above searhing algorithm but also maintains a string and appends "L" or "R" whenever it travels to right or left in the tree.
If the object is found then it returns the string else throws NotFoundException which is catched by the caller which again throws NotFoundException if it is catched.
If the string is returned then the caller address function in the SC class appends this string to a string consisting of the hash value of the key followed by a "-".
The average time complexity here is of order log(lambda), where lambda is the load factor. (assuming that the entries are distributed evenly).
The worst case complexity is of order n, where is n the number of entries added in the hash table (occurs when all the entries have same hash value and are inserted in increasing or decreasing order).

Time complexity of my submission is in accordance with theoretical time complexities.

Interesting Findings:
1. DH performs better when load factor is low. Otherwise SCBST is better.
2. The amount of objects SCBST can store is independent of table size on the other hand if we want to add more objects to DH than originally intended we will face a difficulty.
3. Using a prime number for DH table size, ensures that each index is array is visited before they start repeating, which is a result of properties of prime number.