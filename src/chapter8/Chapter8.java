package chapter8;

public class Chapter8 {
	/* General Tips: 
	 * 1) Ask "who, what, when, where, why, how"
	 * 2) Use multiple classes (maybe with a bunch of getters/setters)
	 * 4) Use inheritance/polymorphism (with Abstract classes) if possible
	 * 5) Use HashMaps wherever there is a lot of data. (see 8.5, 8.7) Write "add" and "remove" for them.
	 * 6) Add as much randomass functionality as possible the way the book does.

	 */
	
	//8.1 --- Implemented Myself
	
	/* 8.2 Tips.
	 * 1) Create as many classes as possible to show OOP Principles: 
	 *    abstract Employee class (with Respondent, Manager, Director as subclasses), Call, and CallCenter as classes.
	 * 2) Use Singleton class for CallCenter.
	 * 3) Used 3 Queues. 1 for each Call "rank"
	 */
	
	/* 8.3 Tips - Jukebox. Tips:
	 * 1) Possible Classes: CD, Song, Playlist, Queue, User, Artist, PlayerControls, Display
	 * 2) Actions: Queue CD, Queue Song, Queue Artist, Play next song, Remove Song. Can have getters/setters for all this.
	 */
	
	/* 8.4 Tips - Parking Lot. Tips:
	 * 1) Make abstract class Vehicle. Have Motorcycle, Car, Bus be subclasses. Also have ParkingSpot as a class.
	 * 2) Parking lot has data: levels[], availableSpots, 
	 *                 methods: parkCar, removeCar, availbleSpots
	 */
	
	/* 8.5 - Online Reader System.
	 * 1) The OnlineReaderSystem class can have classes: Library, User Manager, Display
	 * 2) Books: Hashed by ID: HashMap<Integer, Book> to hash ID to actual book. Another option is to hash the ID to the # of copies we have.
	 * 3) Users: Hashed by ID: HashMap<Integer, User> usersByID. Have "add" and "remove" functions for the private HashMap.
	 */
	
	/* 8.6 - Jigsaw Puzzle
	 * 1) 3 Classes - Puzzle, Piece (which has 4 Edges), Edge (which can be "inner", "outer", or "flat").
	 * 2) Book's solution is overly complex. I would be able to solve this with my own algorithm: 
	 * 		- Split Pieces into corner, edge, and middle piece. Then can simply loop through 2D array and try pieces til it works.
	 * 		- Putting Edges into lists of "inner", "outer", or "flat" may make my code more efficient.
	 */
	
	/* 8.7 - Chat Server. Tips:
	 * Class: Conversation, with subclasses GroupChat and PrivateChat
	 * ----------------------------------- important lesson of when to use ArrayList vs. HashMap
	 * For fast lookup, book used:
	 * 		private HashMap<Integer, User> usersByld;
	 * 		private HashMap<String, User> usersByAccountName;
	 * 		private HashMap<Integer, User> onlineUsers;
	 * 
	 * Uses: HashMap<Integer, PrivateChat> privateChats, 
	 *       HashMap<Integer, AddRequest> receivedAddRequests
	 *       HashMap<Integer, User> contacts
	 *       ...I think using ArrayList instead of HashMap for these may have its own pros/cons. Maybe like this:
	 *       ArrayList<PrivateChat> privateChats
	 *       ArrayList<AddRequest> receivedAddRequests
	 *       ArrayList<User> contacts
	 * "Tough problems to solve": Security, out-of-sync data/conflicting information.   
	 */
	
	/* 8.8 - Othello. Tips:
	 * Classes - Board, Player, Piece. I could have a separate "Game" class like the book, but a Game is basically just a Board.
	 */
	
	/* 8.9 - "In-memory File System"
	 * 		- Have abstract class "Entry", where "File" and "Directory" are subclasses. Entry will have useful fields like:
	 * 				- long created, lastUpdated, lastAccessed
	 * 				- String name
	 * 				- Directory parent
	 * 		- and methods like
	 * 				- getFullPath();
	 * 		- have "Directory" have an ArrayList<Entry> (well maybe can have ArrayList<Directory> and ArrayList<File> instead)
	 */
	
	// 8.10 in Separate File
}
