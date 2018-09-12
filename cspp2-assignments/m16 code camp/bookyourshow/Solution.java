import java.util.Scanner;
import java.util.Arrays;
class Show {
	private String moviename;
	private String showdate;
	private String[] seats;

	public Show (String mvenam, String showdat, String[] seats1) {
		this.moviename = mvenam;
		this.showdate = showdat;
		this.seats = seats1;
	}
	public String getMoviename() {
		return this.moviename;
	}
	public String getShowdate() {
		return this.showdate;
	}
	public String[] getSeats() {
		return this.seats;
	}
	public String printExceptTickets() {
		String s = "";
		s += moviename + "," + showdate;
		return s;
	}
	public String toString() {
		String s = "";
		s += moviename + "," + showdate + ",";
		s += Arrays.toString(seats).replace(", ",",");
		return s;
	}
}

class Patron {
	private String patronname;
	private String mobilenum;
	private String[] bookedseats;

	public Patron (String name, String phnnum, String[] booked) {
		this.patronname = name;
		this.mobilenum = phnnum;
		this.bookedseats = booked;
	}
	public String getPatronname() {
		return this.patronname;
	}
	public String getMobilenum() {
		return this.mobilenum;
	}
	public String[] getBookedseats() {
		return this.bookedseats;
	}
	public String toString() {
		String s = "";
		return s;
	}
}

/**
 * Class for book your show.
 */
class BookYourShow {
	Show[] shows;
	Patron[] patrons;
	/**
	 * showsize description.
	 */
	private int showsize;
	/**
	 * patronsize description.
	 */
	private int patronsize;

	/**
	 * Constructs the object.
	 */
	BookYourShow() {
		shows = new Show[10];
		patrons = new Patron[10];
		showsize = 0;
		patronsize = 0;
	}
	/**
	 * showresize method.
	 */
	public void showresize() {
        shows = Arrays.copyOf(shows, shows.length * 2);
    }
    /**
     * patronresize method.
     */
    public void patronresize() {
        patrons = Arrays.copyOf(patrons, patrons.length * 2);
    }
	/**
	 * Adds a show.
	 *
	 * @param      nshow  The nshow
	 */
	public void addAShow(final Show nshow) {
		if (showsize == shows.length) {
			showresize();
		}
		shows[showsize++] = nshow;
	}

	/**
	 * Adds a patron.
	 *
	 * @param      npatron  The n patron
	 */
	public void addAPatron(final Patron npatron) {
		if (patronsize == patrons.length) {
			patronresize();
		}
		patrons[patronsize++] = npatron;
	}
	/**
	 * Gets a show.
	 *
	 * @param      moviename  The moviename
	 * @param      showdate   The showdate
	 *
	 * @return     A show.
	 */
	public Show getAShow(final String moviename, final String showdate) {
		for (int i = 0; i < showsize; i++) {
			if (shows[i].getMoviename().equals(moviename)
				&& shows[i].getShowdate().equals(showdate)) {
				return shows[i];
			}
		}
		return null;
	}
	/**
	 * bookAShow method.
	 *
	 * @param      moviename  The moviename
	 * @param      showdate   The showdate
	 * @param      p          { parameter_description }
	 */
	public void bookAShow(final String moviename,
		final String showdate, final Patron p) {
		addAPatron(p);
		Show availableshow = getAShow(moviename, showdate);
		if (availableshow != null) {
			String[] seats = availableshow.getSeats();
			String[] bookedseats = p.getBookedseats();
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < bookedseats.length; j++) {
					if (seats[i].equals(bookedseats[j])
						&& !seats[i].equals("N/A")) {
						seats[i] = "N/A";
					}
				}
			}
		} else {
			System.out.println("No show");
		}
	}
	/**
	 * printTickets method.
	 *
	 * @param      moviename  The moviename
	 * @param      showdate   The showdate
	 * @param      mobilenum  The mobilenum
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String printTickets(final String moviename,
		final String showdate, final String mobilenum) {
		Show show = getAShow(moviename, showdate);
		String str = "Invalid";
		if (show != null) {
			str = "No show";
			for (int j = 0; j < patronsize; j++) {
				str = "Invalid";
				if (patrons[j].getMobilenum().
					equals(mobilenum)) {
					str = mobilenum + " "
					+ moviename + " " + showdate;
					return str;
				}
			}
		}
		return str;
	}
	/**
	 * Shows all method.
	 */
	public void showAll() {
		for (int i = 0; i < showsize; i++) {
			System.out.println(shows[i]);
		}
	}
}
/**
 * class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1], seats));
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show.printExceptTickets());
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                System.out.println(bys.printTickets(
                	check[1], tokens[1], tokens[2]));
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
