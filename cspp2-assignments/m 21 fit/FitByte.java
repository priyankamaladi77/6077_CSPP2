import java.util.Scanner;
import java.util.Arrays;

class Foodlog {
	private String foodname;
	private double foodquantity;
	private String ftime;
	private String fdate;

	Foodlog() {

	}

	Foodlog(final String fname, final double fquantity,
		final String ftme, final String date) {
		this.foodname = fname;
		this.foodquantity = fquantity;
		this.ftime = ftme;
		this.fdate = date;
	}

	public String getFoodname() {
		return this.foodname;
	}

	public double getFoodquantity() {
		return this.foodquantity;
	}

	public String getFtime() {
		return this.ftime;
	}

	public String getFdate() {
		return this.fdate;
	}

	public void setFoodname(final String name) {
		foodname = name;
	}

	public void setFoodquantity(final double quantity) {
		foodquantity = quantity;
	}

	public void setFtime(final String time) {
		ftime = time;
	}

	public String toString() {
		String s = "Food" + "\n";
		s += "Date : " + fdate + "\n";
		s += "Time : " + ftime + "\n";
		s += "Name : " + foodname + "\n";
		s += "Quantity : " + foodquantity;
		return s;
	}
}
class Waterlog {
	private double waterqunatity;
	private String waterdtime;

	Waterlog() {

	}

	Waterlog(final double wqunatity, final String watdate) {
		this.waterqunatity = wqunatity;
		this.waterdtime = watdate;
	}

	public double getWaterQuantity() {
		return this.waterqunatity;
	}

	public String getWaterDTime() {
		return this.waterdtime;
	}

	public void setWaterQuantity(final double water) {
		waterqunatity = water;
	}

	public void setWaterDTime(final String wdtime) {
		waterdtime = wdtime;
	}
	public String toString() {
		String s = "Water" + "\n";
		s += "Date : " + waterdtime + "\n";
		s += "Quantity : " + waterqunatity + "\n";
		return s;
	}
}
class Activitylog {
	private String actname;
	private String actdate;
	private String actstarttime;
	private String actendtime;
	private String notes;

	Activitylog() {

	}

	Activitylog(final String aname, final String adate, final String astrtime,
		final String aentime, final String note) {
		this.actname = aname;
		this.actdate = adate;
		this.actstarttime = astrtime;
		this.actendtime = aentime;
		this.notes = note;
	}

	public String getActName() {
		return this.actname;
	}

	public String getActDate() {
		return this.actdate;
	}

	public String getActStartTime() {
		return this.actstarttime;
	}

	public String getActEndTime() {
		return this.actendtime;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setActName(final String anme) {
		actname = anme;
	}

	public void setActDate(final String adte) {
		actdate = adte;
	}

	public void setActStartTime(final String astime) {
		actstarttime = astime;
	}

	public void setActEndTime(final String aetime) {
		actendtime = aetime;
	}

	public String toString() {
		String s = "PhysicalActivity" + "\n";
		s += "Name : " + actname + "\n";
		s += "Notes : " + notes + "\n";
		s += "Date : " + actdate + "\n";
		s += "Starttime : " + actstarttime + "\n";
		s += "Endtime : " + actendtime;
		return s;
	}
}
class Sleeplog {
	private String sleepdate;
	private String dtstrtime;
	private String dtendtime;

	Sleeplog() {

	}

	Sleeplog(final String sdate, final String dstime, final String detime) {
		this.sleepdate = sdate;
		this.dtstrtime = dstime;
		this.dtendtime = detime;
	}

	public String getSleepdate() {
		return this.sleepdate;
	}

	public String getDtStrTime() {
		return this.dtstrtime;
	}

	public String getDtEndTime() {
		return this.dtendtime;
	}

	public void setDtStrTime(final String dtstime) {
		dtstrtime = dtstime;
	}

	public void setDtEndTime(final String dtetime) {
		dtendtime = dtetime;
	}
	public String toString() {
		String s = "Sleep" + "\n";
		s += "Date : " + sleepdate + "\n";
		s += "Starttime : " + dtstrtime + "\n";
		s += "Endtime : " + dtendtime;
		return s;
	}
}
class Weightlog {
	private String weight;
	private String fat;
	private String wdate;
	private String wtime;

	Weightlog() {

	}

	Weightlog(final String weigh, final String fatt,
		final String date, final String time) {
		this.weight = weigh;
		this.fat = fatt;
		this.wdate = date;
		this.wtime = time;
	}

	public String getWeight() {
		return this.weight;
	}

	public String getFat() {
		return this.fat;
	}

	public String getWDate() {
		return this.wdate;
	}

	public String getWTime() {
		return this.wtime;
	}
	public void setWeight(final String weig) {
		weight = weig;
	}

	public void setFat(final String fatty) {
		fat = fatty;
	}

	public void setWDate(final String dt) {
		wdate = dt;
	}

	public String toString() {
		String s = "Weight" + "\n";
		s += "Date : " + wdate + "\n";
		s += "Time : " + wtime + "\n";
		s += "Weight : " + weight + "\n";
		s += "Fat : " + fat;
		return s; 
	}
}
class Fitbyte {
	private List<Foodlog> foodlogs;
	private List<Waterlog> waterlogs;
	private List<Activitylog> activitylogs;
	private List<Sleeplog> sleeplogs;
	private List<Weightlog> weightlogs;

	Fitbyte() {
		this.foodlogs = new List<Foodlog>();
		this.waterlogs = new List<Waterlog>();
		this.activitylogs = new List<Activitylog>();
		this.sleeplogs = new List<Sleeplog>();
		this.weightlogs = new List<Weightlog>();
	}

	public List<Foodlog> getFoodlogs() {
		return this.foodlogs;
	}

	public List<Waterlog> getWaterlogs() {
		return this.waterlogs;
	}

	public List<Activitylog> getActivitylogs() {
		return this.activitylogs;
	}

	public List<Sleeplog> getSleeplogs() {
		return this.sleeplogs;
	}

	public List<Weightlog> getWeightlogs() {
		return this.weightlogs;
	}
	public void addFood(Foodlog food) {
		foodlogs.add(food);
	}

	public void addWater(Waterlog water) {
		waterlogs.add(water);
	}

	public void addSleep(Sleeplog sleep) {
		sleeplogs.add(sleep);
	}

	public void addActivity(Activitylog act) {
		activitylogs.add(act);
	}

	public void addWeight(Weightlog weight) {
		weightlogs.add(weight);
	}

	public void getSummary() {
		System.out.println(getFoodlogs());
		System.out.println(getWaterlogs());
		System.out.println(getActivitylogs());
		System.out.println(getWeightlogs());
		System.out.println(getSleeplogs());
	}

	public void getSummaryDate  (String date) {
		for (int i = 0; i < foodlogs.size(); i++) {
			if (foodlogs.get(i).getFdate().equals(date)) {
				System.out.println(foodlogs.get(i));
			}
		}
		for (int i = 0; i < waterlogs.size(); i++) {
			if (foodlogs.get(i).getFdate().equals(date)) {
				System.out.println(waterlogs.get(i));
			}
		}
		for (int i = 0; i < activitylogs.size(); i++) {
			if (foodlogs.get(i).getFdate().equals(date)) {
				System.out.println(activitylogs.get(i));
			}
		}
		for (int i = 0; i < weightlogs.size(); i++) {
			if (foodlogs.get(i).getFdate().equals(date)) {
				System.out.println(weightlogs.get(i));
			}
		}
		for (int i = 0; i < sleeplogs.size(); i++) {
			if (foodlogs.get(i).getFdate().equals(date)) {
				System.out.println(sleeplogs.get(i));
			}
		}
	}
}

public class FitByte {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Fitbyte fit = new Fitbyte();
		while (scan.hasNext()) {
			String[] line = scan.nextLine().split(" ");
			switch (line[0]) {
				case "Food":
					String[] log = line[1].split(",");
					Foodlog food = new Foodlog(log[0],
						Integer.parseInt(log[1]), log[2], log[3]);
					fit.addFood(food);
				break;
				case "Water":
					log = line[1].split(",");
					Waterlog water = new Waterlog(Integer.parseInt(log[0]), log[1]);
					fit.addWater(water);
				break;
				case "PhysicalActivity":
					log = line[1].split(",");
					Activitylog activity = new Activitylog(log[0], log[1],
						log[2], log[3], log[4]);
					fit.addActivity(activity);
				break;
				case "Sleep":
					log = line[1].split(",");
					Sleeplog sleep = new Sleeplog(log[0], log[1], log[2]);
					fit.addSleep(sleep);
				break;
				case "Weight":
					log = line[1].split(",");
					Weightlog weight = new Weightlog(log[0], log[1], log[2], log[3]);
					fit.addWeight(weight);
				break;
				case "Foodlog":
					System.out.println(fit.getFoodlogs());
				break;
				case "Waterlog":
					System.out.println(fit.getWaterlogs());
				break;
				case "PhysicalActivitylog":
					if (fit.getActivitylogs().size() == 0) {
						System.out.println("None");
					} else {
						System.out.println(fit.getActivitylogs());
					}
				break;
				case "Weightlog":
					System.out.println(fit.getWeightlogs());
				break;
				case "Sleeplog":
					System.out.println(fit.getSleeplogs());
				break;
				case "Summary":
				if (line.length > 1) {
					fit.getSummaryDate(line[1]);
				} else {
					fit.getSummary();
				}
				break;
				default:
				break;
			}
		}
	}
}
