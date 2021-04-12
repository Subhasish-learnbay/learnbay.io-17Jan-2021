package heap.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	class Pair implements Comparable<Pair> {
		String word;
		int count;

		Pair(String word, int count) {
			this.word = word;
			this.count = count;
		}

		public int compareTo(Pair pair) {
			if (this.count > pair.count)
				return 1;
			else if (this.count < pair.count)
				return -1;
			else {
				return this.word.compareTo(pair.word) * -1;
			}
		}
	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> count = new HashMap<>();
		for (String word : words) {
			if (!count.containsKey(word))
				count.put(word, 1);
			else
				count.put(word, count.get(word) + 1);
		}
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry<String, Integer> entry : count.entrySet())
			maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
		List<String> res = new ArrayList<>();
		while (k-- > 0) {
			res.add(maxHeap.poll().word);
		}
		return res;
	}
}
