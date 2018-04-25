package com.triangle.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.triangle.domain.RelationshipVO;

public class CollabFilter {

	private int i;
	private List data;
	private String user_id;
	private String webtoon;
	private int k;
	private List<List<String>> dataset;
	private Map<String, Map> uu_dataset;
	private Map<String, Map> ii_dataset;
	private int datasize;
	
	public CollabFilter(){
		
	}
	
	public CollabFilter(List list, String user_id, String webtoon, int k){
		this.data = list;
		this.user_id = user_id;
		this.webtoon = webtoon;
		this.k = k;
		this.dataset = null;
		this.uu_dataset = null;
		this.ii_dataset = null;
		this.datasize = list.size();
	}
	
	public void initialize(){
		this.dataset = this.load_dataset();
		this.uu_dataset = this.load_uu_dataset();
		this.ii_dataset = this.load_ii_dataset();
	}
	
	public double pearson_correlation(String user1, String user2){
		double result = 0;
		Map<String, Integer> user1_data = this.uu_dataset.get(user1);
		Map<String, Integer> user2_data = this.uu_dataset.get(user2);
		double rx_avg = this.user_average_rating(user1_data);
		double ry_avg = this.user_average_rating(user2_data);
		List<String> sxy = this.common_items(user1_data, user2_data);
		double top_result = 0.0;
		double bottom_left_result = 0.0;
		double bottom_right_result = 0.0;
		
		for(String item : sxy){ 
			double rxs = (double) user1_data.get(item);
			double rys = (double) user2_data.get(item);
			top_result += (rxs-rx_avg) * (rys-ry_avg);
			bottom_left_result += Math.pow((rxs - rx_avg), 2);
			bottom_right_result += Math.pow((rys - ry_avg), 2);
		}
		bottom_left_result = Math.sqrt(bottom_left_result);
		bottom_right_result = Math.sqrt(bottom_right_result);
		
		if(bottom_left_result * bottom_right_result == 0){
			result = 0;
		} else{
			result = top_result/(bottom_left_result * bottom_right_result);
		}
			
		return result;
		
	}
	
	public double user_average_rating(Map user_data){
		double avg_rating = 0.0;
		int size = user_data.size();
		Collection values = user_data.values();
		Iterator it = values.iterator();
		while(it.hasNext()){
			avg_rating += (Integer) it.next();
		}
		avg_rating /= size * 1.0;
		return avg_rating;
	}
	
	public List<String> common_items(Map user1_data, Map user2_data){
		List<String> result = new ArrayList();
		
		List<String> ht1 = new ArrayList();
		Collection values1 = user1_data.keySet();
		Iterator<String> it1 = values1.iterator();
		while(it1.hasNext()){
			ht1.add(it1.next());
		}
		
		List<String> ht2 = new ArrayList();
		Collection values2 = user2_data.keySet();
		Iterator<String> it2 = values2.iterator();
		while(it2.hasNext()){
			ht2.add(it2.next());
		}
		
		for(String item1 : ht1){
			for(String item2 : ht2){
				if(item1.equals(item2)){
					result.add(item1);
				}
			}
		}
		return result;
	}
	
	public List k_nearest_neighbors(String user, int k){
		List neighbors = new ArrayList();
		List result = new ArrayList();
		
		for(String o : this.uu_dataset.keySet()){
			List list = new ArrayList();
			if(o.equals(user)) continue;
			double upc = this.pearson_correlation(user, o);
			list.add(o);
			list.add(upc);
			neighbors.add(list);
		}
		List sorted_neighbors = neighbors;
		
		for(i=0; i<k; i++){
			if (i >= sorted_neighbors.size()){
				break;
			}
			result.add(sorted_neighbors.get(i));
		}
		return result;
	}
	
	public List compare(List neighbors){
		String temp = (String) neighbors.get(0);
		neighbors.add(0, neighbors.get(1));
		neighbors.add(1, temp);
		return neighbors;
	}
	
	public double predict(String item, List<List> k_nearest_neighbors){
		List<List> valid_neighbors = this.check_neighbors_validation(item, k_nearest_neighbors);
		if(valid_neighbors.size() == 0){
			return 0.0;
		}
		double top_result = 0.0;
		double bottom_result = 0.0;
	
		for(List neighbor : valid_neighbors){
			String neighbor_id = (String) neighbor.get(0);
			double neighbor_similarity = (double) neighbor.get(1);
			int rating = (int) this.uu_dataset.get(neighbor_id).get(item);
			top_result += neighbor_similarity * rating;
			bottom_result += neighbor_similarity;			
		}
		
		double result = top_result/bottom_result;
		return result;
	}
	
	public List check_neighbors_validation(String item, List<List> k_nearest_neighbors){
		List result = new ArrayList();
		for(List neighbor : k_nearest_neighbors){
			String neighbor_id = (String) neighbor.get(0);
			if(this.uu_dataset.get(neighbor_id).keySet().contains(item)){
				result.add(neighbor);				
			}
		}
		return result;
	}
	
	public List<List<String>> load_dataset(){
		dataset = new ArrayList<List<String>>();
		for(i=0; i<this.datasize; i++){
			RelationshipVO voList = (RelationshipVO) this.data.get(i);
			List tempList = new ArrayList<String>();
			tempList.add(voList.getUserId());
			tempList.add(voList.getRating());
			tempList.add(voList.getWebtoonId());
			dataset.add(tempList);
		}
		
		return dataset;
	}
	
	public Map<String, Map> load_uu_dataset(){
		uu_dataset = new HashMap<String, Map>();
		for(i=0; i<this.datasize; i++){
			RelationshipVO voList = (RelationshipVO) this.data.get(i);
			
			if(!uu_dataset.containsKey(voList.getUserId())){
				uu_dataset.put(voList.getUserId(), new HashMap());
			} else {
				uu_dataset.get(voList.getUserId()).put(voList.getWebtoonId(), voList.getRating());
			}
		}
		return uu_dataset;
	}
	
	public Map load_ii_dataset(){
		ii_dataset = new HashMap();
		for(i=0; i<this.datasize; i++){
			RelationshipVO voList = (RelationshipVO) this.data.get(i);
			
			if(!ii_dataset.containsKey(voList.getWebtoonId())){
				ii_dataset.put(voList.getWebtoonId(), new HashMap());
			} else {
				ii_dataset.get(voList.getWebtoonId()).put(voList.getUserId(), voList.getRating());
			}
		}
		return ii_dataset;
	}
	
	public void display(List<List> k_nearest_neighbors, double prediction){
		for(List neighbor : k_nearest_neighbors){
			System.out.println(neighbor.get(0) + "-" + neighbor.get(1));
		}
		System.out.println(prediction);
	}

}
