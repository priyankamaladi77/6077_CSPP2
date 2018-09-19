import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class User {
	private String username;
	List<String> userfrnds = new List<String>();

	User(final String uname, final String[] ufrnds) {
		this.username = uname;
		for (int i = 0; i < ufrnds.length; i++) {
			userfrnds.add(ufrnds[i]);
		}
	}

	public String getUserName() {
		return this.username;
	}

	public List getUserFrnds() {
		return this.userfrnds;
	}

	public String toString() {
		String s = getUserName() + ": [";
		for (int i = 0; i < getUserFrnds().size() - 1; i++) {
			s += getUserFrnds().get(i) + ", ";
		}
		s += getUserFrnds().get(getUserFrnds().size() - 1) + "]";
		return s;
	}
}

class SocialNetwork {
	List<User> users = new List<User>();

	SocialNetwork() {
	}

	public List<User> getUsers() {
		return this.users;
	}

	// public void addFrnds(User frnds) {
	// 	users.add(frnds);
	// }
	public void addTo(User sn) {
		users.add(sn);
	}

	public void addConnection(String userA, String userB) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userA)) {
				users.get(i).getUserFrnds().add(userB);
			}
		}
	}

	public List getConnections(String userA) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(userA)) {
				return users.get(i).getUserFrnds();
			}
		}
		System.out.println("Not a User in Network");
		return null;
	}

	public List getCommonConnections(String userA, String userB) {
		List<String> common = new List<String>();
		List<String> friendsA = getConnections(userA);
		List<String> friendsB = getConnections(userB);
		if (friendsA != null && friendsB != null) {
			for (int i = 0; i < friendsA.size(); i++) {
				if (friendsB.contains(friendsA.get(i))) {
					common.add(friendsA .get(i));
				}
			}
		}
		return common;
	}

	public String toString() {
		String[] keys = new String[users.size()];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = users.get(i).getUserName();
		}
		Arrays.sort(keys);
		String s = "";
		int i = 0;
		for (i = 0; i < keys.length - 1; i++) {
			s += keys[i] + ": " + getConnections(keys[i]) + ", ";
		}
		s += keys[i] + ": " + getConnections(keys[i]);
		return s;
	}

}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.nextLine().split(" ");
		int b = Integer.parseInt(a[1]);
		SocialNetwork social = new SocialNetwork();
		while(b != 0) {
			String[] line = sc.nextLine().split(" is connected to ");
			String[] list = line[1].replace(".","").split(",");
			social.addTo(new User(line[0], list));
			b -= 1;
		}
		while(sc.hasNext()) {
			String[] method = sc.nextLine().split(" ");
			switch (method[0]) {
				case "addConnection":
					social.addConnection(method[1], method[2]);
				break;
				case "getConnections":
				if (social.getConnections(method[1]) != null) {
					System.out.println(social.getConnections(method[1]));
				}
				break;
				case "getCommonConnections":
				System.out.println(social.getCommonConnections(method[1], method[2]));
				break;
				case "Network":
				System.out.println(social);
				default:
				break;
			}
		}
	}
}
