package com.jeuv1;

import java.util.TimerTask;


public class Chrono extends TimerTask {
	double ms;
	double s;
	double min;
	    int countdown = 100;

	    public void run() {
	        countdown = countdown - 1;
	        System.out.println(countdown);
	        //label.setText(countdown +"second's left");
	    }


    
}
