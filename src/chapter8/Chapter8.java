package chapter8;

public class Chapter8 {
	/* General Tips: 
	 * 1) Ask "who, what, when, where, why, how" (to find functionality to add).
	 * 2) Use multiple classes. Mention we can add getters/setters vs. making everything public.
	 * 3) Use inheritance, abstract functions/classes, polymorphism if possible.
	 * 4) Use HashMaps wherever there's a lot of data. (see 8.5, 8.7) 
	 * 	  	- Write "add" and "remove" for our HashMaps (for example, can create addUser(User user) for client to easily add a user to HashMap)
	 */
	
	// 8.1 - Blackjack (See my implementation)
	
	/* 8.2 - Call Center
	 * 
	 * 1) Create as many classes as possible to show OOP Principles: 
	 *    abstract Employee class (with Respondent, Manager, Director as subclasses), Call, and CallCenter as classes.
	 * 2) Use 3 Queues. 1 for each Call "rank"
	 */
	
	/* 8.3 - Jukebox
	 * 
	 * 1) Possible Classes: CD, Song, Playlist, Queue, User, Artist, PlayerControls, Display
	 * 2) Actions: Queue CD, Queue Song, Queue Artist, Play next song, Remove Song.
	 */
	
	/* 8.4 - Parking Lot
	 * 
	 * 1) Make abstract class Vehicle. Have Motorcycle, Car, Bus be subclasses of Vehicle. Also create ParkingSpot, ParkingLot classes.
	 * 2) ParkingLot has data: levels[], availableSpots, 
	 *                methods: parkVehicle(Vehicle v), removeVehicle(Vehicle v), availbleSpots()
	 */
	
	/* 8.5 - Online Reader System
	 * 
	 * 1) The OnlineReaderSystem class can have classes: Library, User Manager, Display
	 * 2) Books: Hashed by ID: HashMap<Integer, Book> to hash ID to actual book. Can also hash the ID to the # of copies we have.
	 * 3) Users: Hashed by ID: HashMap<Integer, User> usersByID. Have "add" and "remove" functions for the private HashMap.
	 */
	
	/* 8.6 - Jigsaw Puzzle
	 * 
	 * 1) 3 Classes - Puzzle, Piece (which has 4 Edges), Edge (which can be "inner", "outer", or "flat").
	 * 2) Book's solution is overly complex. I would be able to solve this with my own algorithm: 
	 * 		- Split Pieces into corner, edge, and center pieces. Then can simply loop through 2D array and brute-force pieces until it works.
	 * 		- Putting Edges into lists of "inner", "outer", or "flat" will enable us to only try pieces with proper edge configurations..
	 */
	
	/* 8.7 - Chat Server
	 * 
	 * Class: Conversation (with subclasses GroupChat and PrivateChat). User. AddRequest.
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
	 * "Tough problems to solve": Security, out-of-sync data / conflicting information.   
	 */
	
	/* 8.8 - Othello
	 * 
	 * Classes - Board, Player, Piece. I could have a separate "Game" class like the book, but a Game is basically just a Board.
	 */
	
	/* 8.9 - In-memory File System
	 * 
	 * 		- Have abstract class "Entry", where "File" and "Directory" are subclasses. Entry will have useful fields like:
	 * 				- long      created, lastUpdated, lastAccessed
	 * 				- String    name
	 * 				- Directory parent
	 * 		- and methods like
	 * 				- getFullPath();
	 * 		- have "Directory" have an ArrayList<Entry> (alternatively have ArrayList<Directory> and ArrayList<File>)
	 */
	
	// 8.10 - Hash table with chaining (See my implementation)
}
