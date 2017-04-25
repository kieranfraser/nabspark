package main;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class TestNabs {

	static String value = "";
	
	public static void main(String[] args){
		Firebase database = new Firebase("https://nabspark-f2f26.firebaseio.com/");
		database.child("message").addValueEventListener( new ValueEventListener() {
	  		  @Override
	  		  public void onDataChange(DataSnapshot snapshot) {
	  			  if(snapshot.getValue() != null){
	  				  value = (String) snapshot.getValue();
	  				database.child("echo").setValue("Echoed:"+snapshot.getValue());
	  			  }
	  		  }
	  		  @Override public void onCancelled(FirebaseError error) {}
		});
		while(!value.trim().equals("exit"));
		System.exit(0);
		return;
	}
}
