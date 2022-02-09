package com.Helping.Santa.demo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Helping.Santa.demo.beans.SantaBean;
import com.Helping.Santa.demo.beans.SantaResponse;

@Service
public class HelpingSantaService {

	static final int MAX = 100000;
	static int[] storeMaxVal = new int[MAX + 1];

	static List<Integer> response = new LinkedList<Integer>();

	static int findMinNumSum(int hood_capacity, int present_weights[], int length) {
		if (hood_capacity == 0) {
			storeMaxVal[0] = 0;
			return 0;
		}
		if (storeMaxVal[hood_capacity] != -1)
			return storeMaxVal[hood_capacity];

		int ret = Integer.MAX_VALUE;

		for (int i = 0; i < length; i++) {
			if (present_weights[i] <= hood_capacity) {
				int x = findMinNumSum(hood_capacity - present_weights[i], present_weights, length);

				if (x != Integer.MAX_VALUE)
					ret = Math.min(ret, 1 + x);
			}
		}
		storeMaxVal[hood_capacity] = ret;
		return ret;
	}
	static void findPossibleComb(int hood_capacity, int present_weights[], int length) {
		if (hood_capacity == 0) {
			for (int it : response) {
				System.out.print(it + " ");
			}
			return;
		}

		for (int i = 0; i < length; i++) {
			if (hood_capacity - present_weights[i] >= 0 && storeMaxVal[hood_capacity - present_weights[i]] + 1 == storeMaxVal[hood_capacity]) {
				response.add(present_weights[i]);

				findPossibleComb(hood_capacity - present_weights[i], present_weights, length);
				break;
			}
		}
	}
	
	static void findMinComb(int hood_capacity, int present_weights[], int length) {
		for (int i = 0; i < storeMaxVal.length; i++)
			storeMaxVal[i] = -1;

		int isPossible = findMinNumSum(hood_capacity, present_weights, length);

		if (isPossible == Integer.MAX_VALUE) {
			System.out.print("-1");
		}
		else {
			findPossibleComb(hood_capacity, present_weights, length);
		}
	}

	public SantaResponse performSanta(SantaBean santaBean) {

		SantaResponse santaResponse = new SantaResponse();

		int hood_capacity = santaBean.getHood_capacity();
		int[] present_weights = santaBean.getPresent_weights();
		int length = present_weights.length;

		findMinComb(hood_capacity, present_weights, length);

		santaResponse.setSantaList(response);

		return santaResponse;

	}

}
