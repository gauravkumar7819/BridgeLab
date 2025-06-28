import java.util.ArrayList;

public class MovieTime {
	ArrayList<String> movie;
	ArrayList<String> time;
	public MovieTime() {
		movie=new ArrayList<String>(); 
		time=new ArrayList<String>();
		
	}
public void addMovie(String name,String movieTime) {
	movie.add(name);
	time.add(movieTime);
	System.out.println("Added movie "+name +" on "+ movieTime);

}
 private void search(String name) {
	 boolean b=false;
	 for(int i=0;i<movie.size();i++) {
		 if(movie.get(i).equals(name)) {
			 b=true;
			 System.out.println("YES "+movie.get(i)+" movie is founded on "+ time.get(i));
		 }
		 
	 }
	
	if(b==false) {
		System.out.println("Movie not found");
	}
	

}
	
public void showAllMovies(){
	for(int i=0;i<movie.size();i++) {
		System.out.println(movie.get(i));
		 
	 }
	
	
}
public static void main(String[] args) {
	MovieTime m=new MovieTime();
	m.addMovie("Shershah", "10:10");
	m.addMovie("Bhagi", "10:00");

	m.addMovie("time", "12:10");

	m.addMovie("Hare Krishna", "01:10");

	m.showAllMovies();
	m.search("time");
	
}
}
