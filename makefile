compile:
	javac Bases.java
	javac Node.java
	javac Queue.java
	javac PriorityQueue.java
	javac Item.java
	javac Buyer.java
	javac Seller.java
	javac Assignment2Driver.java

run:
	java assignment3 input.txt

clean:
	rm *.class

handin:	
	@mkdir -p src
	@cp *.java src/
	@zip -r 2018EE10494_assignment3.zip src/
	@base64 2018EE10494_assignment3.zip > 2018EE10494_assignment3.zip.b64
	@rm -rf src
	#@rm $(ENTRY)_assignment2.zip
