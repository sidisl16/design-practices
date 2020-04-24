package com.deisgn.practice.problem.solving.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumPlatforms {

	// This problem uses logic of merge overlapping problem
	public static void solution(List<Schedule> schedules) {

		int no_of_platform = 0;

		// Sort all the schedules based on the arrival time
		Collections.sort(schedules, new Comparator<Schedule>() {

			@Override
			public int compare(Schedule o1, Schedule o2) {
				return Integer.compare(o1.getArrival(), o2.getArrival());
			}
			
		});

		for (int i = 0; i < schedules.size() - 1; i++) {
			if (schedules.get(i).getDeparture() >= schedules.get(i + 1).getArrival()) {
				no_of_platform++;
			}
		}

		// If no overlapping means atleast one platform for trains
		System.out.println(no_of_platform == 0 ? 1 : no_of_platform);
	}

	public static void main(String[] args) {

		List<Schedule> schedules = new ArrayList<>();
		schedules.add(new Schedule(900, 910));
		schedules.add(new Schedule(940, 1200));
		schedules.add(new Schedule(950, 1120));
		schedules.add(new Schedule(1100, 1130));
		schedules.add(new Schedule(1500, 1900));
		schedules.add(new Schedule(1800, 2000));

		solution(schedules);// 3

		List<Schedule> schedules1 = new ArrayList<>();
		schedules.add(new Schedule(900, 1000));
		schedules.add(new Schedule(1100, 1200));
		schedules.add(new Schedule(1235, 1240));

		solution(schedules1);// 1
	}
}

class Schedule {

	private int arrival;
	private int departure;

	public Schedule(int arrival, int departure) {
		this.arrival = arrival;
		this.departure = departure;
	}

	public int getArrival() {
		return arrival;
	}

	public int getDeparture() {
		return departure;
	}
}